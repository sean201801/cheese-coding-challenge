package com.dominos.codingchallenge.cheese;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResourceLoader {

    /**
     * Loads a file containing a JSON String array from the assets.
     * @param context the Android context.
     * @param filename the filename to load.
     * @return the list of strings.
     */
    public ArrayList<String> loadFileFromAssets(Context context, @NonNull String filename) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        try {
            InputStream inputStream = context.getAssets().open(filename);
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            ArrayList<String> output = new Gson().fromJson(reader, listType);
            reader.close();
            return output;
        } catch (Exception e) {
            // NOP
        }
        return null;
    }
}
