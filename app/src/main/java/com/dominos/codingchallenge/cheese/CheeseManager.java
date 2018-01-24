package com.dominos.codingchallenge.cheese;

import android.content.Context;

import java.util.ArrayList;

public class CheeseManager {

    private ResourceLoader mResourceLoader;

    public CheeseManager(ResourceLoader resourceLoader) {
        mResourceLoader = resourceLoader;
    }

    /**
     * Retrieves the sorted list of the cheeses.
     * @param context the Android context.
     * @return the sorted list of cheeses.
     */
    public ArrayList<String> getSortedCheeseListFromAssets(Context context) {
        // load from assets
        ArrayList<String> cheeseList = mResourceLoader.loadFileFromAssets(context, "cheese_list.json");

        // Sort the list here

        return cheeseList;
    }

    /**
     * Retrieves the sorted list of the cheeses from the web.
     * @param context the Android context.
     * @return the sorted list of cheeses.
     */
    public ArrayList<String> getSortedCheeseListFromServer(Context context) {
        // Make server request and load from cheese list
        return null;
    }

    /**
     * Provides a filtered list of cheeses containing the given name
     * @param context the Android context.
     * @param name the name to filter
     * @return the list of filtered cheeses
     */
    public ArrayList<String> filterByName(Context context , String name){
        // search the matching cheese names
        return null;
    }
}
