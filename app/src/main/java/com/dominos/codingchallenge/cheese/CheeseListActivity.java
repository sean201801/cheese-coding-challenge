package com.dominos.codingchallenge.cheese;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class CheeseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the sorted list and pass it to the CheeseListFragment to display

        //TODO: 1. This activity should show a fragment with the sorted list of cheeses.
    }

    private ArrayList<String> getListOfCheeses() {
        ResourceLoader resourceLoader = new ResourceLoader();
        CheeseManager cheeseManager = new CheeseManager(resourceLoader);
        return cheeseManager.getSortedCheeseListFromAssets(this);
    }
}
