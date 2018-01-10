package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";
    public static String ACTION_PERSIST_COMPLETE =
            "capstone.project.action.PERSIST_COMPLETE";

    @Override
    public void onReceive(Context context, Intent intent) {


        //manipulate UI by turning on the visibility of 'View Results' button as well as the preceding textView.
        //goAsync()

    }

}
