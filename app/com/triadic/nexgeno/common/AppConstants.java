package com.triadic.nexgeno.common;

import com.triadic.nexgeno.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psramkumar on 10/5/2014.
 */
public final class AppConstants {

    public static Map<String, String> modelNameMap = new HashMap<String, String>(){{
        put(User.modelName, User.modelName);
    }};

    public static Map<String, String> errorResponse = new HashMap<String, String>(){{
        put("status", "Error");
        put("message", "No Response");
        put("code", "10101");
    }};
}
