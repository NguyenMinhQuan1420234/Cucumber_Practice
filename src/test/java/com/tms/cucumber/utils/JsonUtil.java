package com.tms.cucumber.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonUtil {

    public static JsonObject readJsonFile(String filePath) {
//        Convert JSON File to Java JsonObject
        Type jsonObjectType = new TypeToken<JsonObject>() {}.getType();
        JsonObject jsonObject;
        Gson gson = new Gson();
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new FileReader(filePath));
            jsonObject = gson.fromJson(jsonReader, jsonObjectType);
        } catch (Exception e) {
            throw new ParsingJsonException("Can't parsing file to jsonObject", e);
        }
        return jsonObject;
    }

    public static JsonReader loadJsonfile (String nameOfJsonTestData) throws FileNotFoundException {
        String filepath = System.getProperty("DATA_PATH") + nameOfJsonTestData;
        JsonReader reader = new JsonReader(new FileReader(filepath));
        return reader;
    }

    public static <T> T convertToJsonObject (String nameJsonFile, Class<T> kclass) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.loadJsonfile(nameJsonFile);
        Gson gson = new Gson();
        T object = gson.fromJson(reader, kclass);
        return object;
    }

}
