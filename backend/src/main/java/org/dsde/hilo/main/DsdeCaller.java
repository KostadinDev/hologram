package org.dsde.hilo.main;

import com.google.gson.Gson;
import org.dsde.hilo.common.Helper;
import org.dsde.hilo.connector.NetClient;
import org.dsde.hilo.json.Credential;
import org.dsde.hilo.common.Constants;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.dsde.hilo.common.Constants.CONTENTTYPEFORM;
import static org.dsde.hilo.common.Constants.CONTENTTYPEJSON;

public class DsdeCaller {
    //static String username="DseeLab_78H_V2_78000955";
    // static String password="82808797";
    //static String username="kostadindev";
    //static String password="DMjk2tKE";
    static String username = "csedviz@hawaii.edu";
    static String password = "bambam50$";

    private static void bootDevice() throws UnsupportedEncodingException {
        String json = null;
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        Gson gson = new Gson();
        json = gson.toJson(credential);
        NetClient netClient = new NetClient();
        System.out.println("url = " + Constants.BASEURL + Constants.TOKEN);
        System.out.println("json = " + json);
        String result = netClient.callpost(Constants.BASEURL + Constants.TOKEN, json, null, CONTENTTYPEJSON);
        System.out.println("result = " + result);
        String token = Helper.getToken(result);
        System.out.println("token = " + token);
        // DEVICE ID: 65157
        // BOOT OPERATION: 2
        Map<String, Integer> formParams = new HashMap<String, Integer>() {{
//            put("operation", 2);
//            put("deviceIds", 65157);
//            //put("deviceIds", 66640);
            put("operation", 2);
            put("deviceIds", 65157);
        }};
        String paramsString = Helper.getDataString(formParams);
        System.out.println("url = " + Constants.BASEURL + Constants.TASK);
        result = netClient.callpost(Constants.BASEURL + Constants.TASK, paramsString, token, CONTENTTYPEFORM);
        System.out.println("result2 = " + result);
    }

    private static void stopDevice() throws UnsupportedEncodingException {
        String json = null;
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        Gson gson = new Gson();
        json = gson.toJson(credential);
        NetClient netClient = new NetClient();
        System.out.println("url = " + Constants.BASEURL + Constants.TOKEN);
        System.out.println("json = " + json);
        String result = netClient.callpost(Constants.BASEURL + Constants.TOKEN, json, null, CONTENTTYPEJSON);
        System.out.println("result = " + result);
        String token = Helper.getToken(result);
        System.out.println("token = " + token);
        Map<String, Integer> formParams = new HashMap<String, Integer>() {{
            put("operation", 3);
            put("deviceIds", 65157);
            //put("deviceIds", 66640);
        }};
        String paramsString = Helper.getDataString(formParams);
        System.out.println("url = " + Constants.BASEURL + Constants.TASK);
        result = netClient.callpost(Constants.BASEURL + Constants.TASK, paramsString, token, CONTENTTYPEFORM);


        System.out.println("result2 = " + result);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //bootDevice();
        //stopDevice();

    }

}
