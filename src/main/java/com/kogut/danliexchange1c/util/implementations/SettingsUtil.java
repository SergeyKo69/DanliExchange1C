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

    @Value("${path.ka1.client}")
    private String pathKa1Client;

    @Value("${path.ka1.groupLib}")
    private String pathKa1GroupLib;

    @Value("${path.ka1.bankBill}")
    private String pathKa1BankBill;

    @Value("${path.ka1.agreement}")
    private String pathKa1Agreement;

    @Value("${path.ka1.price}")
    private String pathKa1Price;

    @Value("${path.ka1.store}")
    private String pathKa1Store;

    @Value("${path.ka1.invoiceIssued}")
    private String pathKa1InvoiceIssued;

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

    @Value("${path.ka2.client}")
    private String pathKa2Client;

    @Value("${path.ka2.groupLib}")
    private String pathKa2GroupLib;

    @Value("${path.ka2.bankBill}")
    private String pathKa2BankBill;

    @Value("${path.ka2.agreement}")
    private String pathKa2Agreement;

    @Value("${path.ka2.price}")
    private String pathKa2Price;

    @Value("${path.ka2.store}")
    private String pathKa2Store;

    @Value("${path.ka2.invoiceIssued}")
    private String pathKa2InvoiceIssued;


    @Override
    public HashMap<String, String> getSettings(ClientDBEnum clientDB) {
        HashMap<String,String> settings = new HashMap<>();
        if (clientDB == ClientDBEnum.KA1) {
            settings.put("address", addressKa2);
            settings.put("path", pathKa2);
            settings.put("pathProject", pathKa2Project);
            settings.put("pathDeliveryAddress", pathKa2DeliveryAddress);
            settings.put("pathClient", pathKa2Client);
            settings.put("pathGroupLib", pathKa2GroupLib);
            settings.put("pathBankBill", pathKa2BankBill);
            settings.put("pathAgreement", pathKa2Agreement);
            settings.put("pathPrice", pathKa2Price);
            settings.put("pathStore", pathKa2Store);
            settings.put("pathInvoiceIssued", pathKa2InvoiceIssued);
            settings.put("userName", userNameKa2);
            settings.put("password", passwordKa2);
        } else {
            settings.put("address", addressKa1);
            settings.put("path", pathKa1);
            settings.put("pathProject", pathKa1Project);
            settings.put("pathDeliveryAddress", pathKa1DeliveryAddress);
            settings.put("pathClient", pathKa1Client);
            settings.put("pathGroupLib", pathKa1GroupLib);
            settings.put("pathBankBill", pathKa1BankBill);
            settings.put("pathAgreement", pathKa1Agreement);
            settings.put("pathPrice", pathKa1Price);
            settings.put("pathStore", pathKa1Store);
            settings.put("pathInvoiceIssued", pathKa1InvoiceIssued);
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
