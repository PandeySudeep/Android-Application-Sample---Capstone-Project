package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class WebService extends Service {

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
    private RequestQueue mRequestQueue;
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

    public void execute(final String URL){
        mServiceHandler.post(new Runnable(){
           public void run() {

               //TODO - get request parameters from the intent and send GET request. Use content provider to insert into SQLlite.
                //RequestQueue mRequestQueue;
                Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);
                Network network = new BasicNetwork(new HurlStack());
                mRequestQueue=new RequestQueue(cache,network);
                mRequestQueue.start();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,URL,null,new Response.Listener<JSONObject>(){
                    public void onResponse(JSONObject response){
                     //handle response on UI thread..
                    }
                },new Response.ErrorListener(){
                    public void onErrorResponse(VolleyError error){
                     //handle error on UI thread..
                    }
                });

                jsonObjectRequest.setTag("MyTag");
                mRequestQueue.add(jsonObjectRequest);

                Handler UI_Handler = new Handler(Looper.getMainLooper());
                UI_Handler.post(new Runnable(){
                   public void run(){
                       ////send data back to UI thread with information whether another request can be made for additional data.
                   }
                });
           }
        });
    }
    public void onDestroy(){
        //cancel pending web service request..
        if(mRequestQueue != null){
            mRequestQueue.cancelAll("MyTag");
        }
    }
}
