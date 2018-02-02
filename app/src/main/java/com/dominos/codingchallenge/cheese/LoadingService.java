package com.dominos.codingchallenge.cheese;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

import static com.dominos.codingchallenge.cheese.Constants.RESULT_KEY;

/**
 * Created by shuangzhecheng on 2/2/18.
 */

public class LoadingService extends Service {
    private String LOG_TAG = null;
    private ArrayList<String> output;
    private ResourceLoader loader;

    @Override
    public void onCreate() {
        super.onCreate();
        LOG_TAG = this.getClass().getSimpleName();
        Log.i(LOG_TAG, "In onCreate");
        output = new ArrayList<String>();
        loader = new ResourceLoader();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        output = loader.loadFileFromAssets(this,"infos");
        Log.e("LIST", output.toString());

        Intent broadcastIntent = new Intent("com.sean.RESULT");
        broadcastIntent.putStringArrayListExtra(RESULT_KEY,output);
        sendBroadcast(broadcastIntent);
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "In onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

