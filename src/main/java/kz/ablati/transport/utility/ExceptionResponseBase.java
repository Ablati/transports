package kz.ablati.transport.utility;

import java.util.HashMap;
import java.util.Map;

public class ExceptionResponseBase {

    public static Map<String, Object> create(String message, int code){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("status", code);
        return response;
    }
}
