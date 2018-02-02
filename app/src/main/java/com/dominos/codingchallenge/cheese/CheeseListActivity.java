package com.dominos.codingchallenge.cheese;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.dominos.codingchallenge.cheese.Constants.RESULT_KEY;

public class CheeseListActivity extends AppCompatActivity {

    private TextView mTextView;
    private ListView listView;
    private IntentFilter mIntentFilter;
    private ArrayAdapter arrayAdapter;
    private String str;
    private FragmentManager fragmentManager;
    private ArrayList<String> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = new ArrayList<>();
        mIntentFilter = new IntentFilter("com.sean.RESULT");
        mTextView = findViewById(R.id.textView);
       Intent serviceIntent = new Intent(this, LoadingService.class);
        startService(serviceIntent);


        //TODO: 1. This activity should show a fragment with the sorted list of cheeses.
    }

    private ArrayList<String> getListOfCheeses() {
        ResourceLoader resourceLoader = new ResourceLoader();
        CheeseManager cheeseManager = new CheeseManager(resourceLoader);
        return cheeseManager.getSortedCheeseListFromAssets(this);

    }
    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras != null) {

                result = extras.getStringArrayList(RESULT_KEY);


                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                CheeseListFragment cheeseListFragment = new CheeseListFragment();

                fragmentManager = getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(RESULT_KEY,result);
                cheeseListFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .add(android.R.id.content,cheeseListFragment,"Sean")
                        .commit();

                Log.e("OUTPUT IN ACTIVITY",result.toString());
            }
        }
    };

    @Override
    protected void onPause() {
        unregisterReceiver(mReceiver);
        super.onPause();
    }
}
