package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;

public class WebService extends Service {

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final IBinder binder = new LocalBinder();

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
    }
    public WebService() {}

    @Override
    public void onCreate(){
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return binder;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public class LocalBinder extends Binder {
        WebService getService() {
            // Return this instance of LocalService so clients can call public methods
            return WebService.this;
        }
    }

    public void execute(String URL){
        mServiceHandler.post(new Runnable(){
           public void run() {
            //TODO - get request parameters from the intent and send GET request. Use content provider to insert into SQLlite.

                Handler UI_Handler = new Handler(Looper.getMainLooper());
                UI_Handler.post(new Runnable(){
                   public void run(){
                       ////send data back to UI thread with information whether another request can be made for additional data.
                   }
                });
           }
        });
    }
}
