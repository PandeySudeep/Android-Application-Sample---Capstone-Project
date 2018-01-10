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

        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        //manipulate UI by enabling 'View Results' button
        //goAsync()

    }

    /**
     * Factory method that returns an implicit intent that
     * launches the DownloadReceiver.
     *
     **/
    public static Intent makePersistCompleteIntent() {
        // Create an implicit intent that launches the DownloadReceiver.
        return new Intent(MyReceiver.ACTION_PERSIST_COMPLETE);
                //.putExtra("URI", pathToImageFile.toString());
    }
}
