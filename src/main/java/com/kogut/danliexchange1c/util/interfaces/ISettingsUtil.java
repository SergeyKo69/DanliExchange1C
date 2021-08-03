package com.kogut.danliexchange1c.util.interfaces;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;

/**
 * @author S.Kogut on 03.08.2021
 */
public interface ISettingsUtil {

    HashMap<String,String> getSettings(ClientDBEnum clientDB);

    HttpHeaders createHeaders(String username, String password);

}
