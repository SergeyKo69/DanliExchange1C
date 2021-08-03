package com.kogut.danliexchange1c.util.implementations;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class SettingsUtil implements ISettingsUtil {

    @Value("${address.ka1}")
    private String addressKa1;

    @Value("${path.ka1.invoice}")
    private String pathKa1;

    @Value("${path.ka1.project}")
    private String pathKa1Project;

    @Value("${path.ka1.deliveryAddress}")
    private String pathKa1DeliveryAddress;

    @Value("${username.ka1}")
    private String userNameKa1;

    @Value("${password.ka1}")
    private String passwordKa1;

    @Value("${address.ka2}")
    private String addressKa2;

    @Value("${username.ka2}")
    private String userNameKa2;

    @Value("${password.ka2}")
    private String passwordKa2;

    @Value("${path.ka2.invoice}")
    private String pathKa2;

    @Value("${path.ka2.project}")
    private String pathKa2Project;

    @Value("${path.ka2.deliveryAddress}")
    private String pathKa2DeliveryAddress;


    @Override
    public HashMap<String, String> getSettings(ClientDBEnum clientDB) {
        HashMap<String,String> settings = new HashMap<>();
        if (clientDB == ClientDBEnum.KA1) {
            settings.put("address", addressKa2);
            settings.put("path", pathKa2);
            settings.put("pathProject", pathKa2Project);
            settings.put("pathDeliveryAddress", pathKa2DeliveryAddress);
            settings.put("userName", userNameKa2);
            settings.put("password", passwordKa2);
        } else {
            settings.put("address", addressKa1);
            settings.put("path", pathKa1);
            settings.put("pathProject", pathKa1Project);
            settings.put("pathDeliveryAddress", pathKa1DeliveryAddress);
            settings.put("userName", userNameKa1);
            settings.put("password", passwordKa1);
        }
        return settings;
    }

    @Override
    public HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.US_ASCII) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set("Content-Type", MediaType.APPLICATION_JSON.toString());
        }};
    }
}
