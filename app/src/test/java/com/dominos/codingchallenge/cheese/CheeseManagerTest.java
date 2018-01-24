package com.dominos.codingchallenge.cheese;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Libin
 */
public class CheeseManagerTest {

    @Test
    public void getSortedCheeseListFromAssets() throws Exception {
        //TODO: 3. Create Unit test for the CheeseManager.getSortedCheeseListFromAssets() method.
    }

    @Test
    public void filterByName() throws Exception {
        //TODO: 4. Create Unit test for the CheeseManager.filterByName() method.
    }

    /**
     * Retrieves a test list of cheeses.
     * @param testInstance the test instance.
     * @return the list of cheeses.
     */
    public static ArrayList<String> getCheeseList(Object testInstance) {
        String fromFile = getStringFromFile(testInstance, "cheese_list.json");
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(fromFile , listType);
    }

    /**
     * Retrieves a requested resource file as a string for a test.
     * @param test The test class instance.
     * @param fileName The requested file name.
     * @return a String content from the requested file.
     */
    public static String getStringFromFile(Object test, String fileName) {
        StringBuilder output = new StringBuilder();
        try {
            InputStream inputStream = test.getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = r.readLine()) != null) {
                output.append(line).append('\n');
            }
        } catch (IOException e) {
            //NOP
        }
        return output.toString();
    }

}
