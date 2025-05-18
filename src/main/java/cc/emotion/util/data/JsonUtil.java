package cc.emotion.util.data;

import com.google.gson.Gson;

import java.util.HashMap;

public class JsonUtil {
    public static HashMap<?, ?> stringToHashMap(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, HashMap.class);
    }
}
