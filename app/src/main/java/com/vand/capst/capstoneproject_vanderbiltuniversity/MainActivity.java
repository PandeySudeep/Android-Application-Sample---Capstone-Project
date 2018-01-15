package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Binder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    private boolean mBound=false;
    private WebService ws;
    private Context ctx = this;

    private BroadcastReceiver mReceiver;
    protected final String TAG =
            getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        Log.d(TAG, "onCreate(): MainActivity initiated");

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (mBound) {

                    String requestUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+getLatitude()+","+getLongitude()+"&radius=500&type=restaurant&key=AIzaSyDo7-hsZ6-c5YaxfB8R906UFjkOE20K3yA";
                    button.setEnabled(false);
                    button.setText("thank you..");
                    ws.execute(requestUrl,getInterest());
                    Log.d(TAG, "Find button clicked: Web Service request made");

                    //Toast.makeText(ctx, "just called execute()" , Toast.LENGTH_SHORT).show();
                }

            }
        });

        final Button resultButton = findViewById(R.id.button2);
        resultButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //preExecute()
                //update the button text as 'processing...' and disable the button
                //AsyncTask to retrieve cursor from database. doInBackground()[AsyncTask]

                //create Webresponse[] with Webresponse objects. ->doInBackground()
                //postExecute() [AsyncTask]
                //create intent holding Webresponse[]..
                //startActivity(intent) -> ResultView
                Log.d(TAG, "View Results - button clicked: GetWebResponse AsyncTask called..");
                new GetWebResponses().execute();

            }
        });

    }

    @Override
    protected void onStart(){

        super.onStart();
        // Bind to LocalService
        Intent intent = new Intent(this, WebService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "onStart(): bindService() called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(
                "capstone.project.action.PERSIST_COMPLETE");

        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                Button mybutton = findViewById(R.id.button2);
                mybutton.setEnabled(true);

            }
        };
        //registering our receiver
        this.registerReceiver(this.mReceiver, intentFilter);
        Log.d(TAG, "onResume(): Registered Broadcast Receiver");
    }

    @Override
    public void onPause(){
        super.onPause();
        this.unregisterReceiver(this.mReceiver);
        Log.d(TAG, "onPause(): Unregistered Broadcast Receiver");
    }
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
        mBound = false;
        Log.d(TAG, "onStop(): Service Unbound");
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder b) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            WebService.LocalBinder binder = (WebService.LocalBinder) b;
            ws = binder.getService();
            mBound = true;
            Log.d(TAG, "onStart(): Bound Service Connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    private void initializeViews(){

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.popular_points, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.interests, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        findViewById(R.id.button2).setEnabled(false);
    }

    private String getSite(){

        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        return text;
    }
    private String getInterest(){

        Spinner mySpinner=(Spinner) findViewById(R.id.spinner2);
        String text = mySpinner.getSelectedItem().toString();
        return text;
    }
    private double getLatitude(){

        double latitude=0.0;
        if (getSite()=="Statue of Liberty"){
            return 40.689249;
        }else if (getSite()=="Empire State"){
            return 40.748817;
        }else if(getSite()=="Brooklyn Bridge"){
            return 40.757715;
        }else if(getSite()=="Times Square"){
            return 40.758896;
        }
        else if(getSite()=="Rockefeller Center"){
            return 40.75874;
        }else if(getSite()=="World Trade Center"){
            return 40.711801;
        }else if(getSite()=="Madison Square Garden"){
            return 40.750298;
        }
        else if(getSite()=="Roosevelt Island"){
            return 38.895073;
        }
        return latitude;
    }
    private double getLongitude(){

        double longitude=0.0;
        if(getSite()=="Statue of Liberty"){
            return -74.044500;
        }else if(getSite()=="Empire State"){
            return -73.985428;
        }else if(getSite()=="Brooklyn Bridge"){
            return -73.98152829999998;
        }else if(getSite()=="Times Square"){
            return  -73.985130;
        }else if(getSite()=="Rockefeller Center"){
            return -73.978674;
        }else if(getSite()=="World Trade Center"){
            return -74.013120;
        }else if(getSite()=="Madison Square Garden"){
            return  -73.993324;
        }else if(getSite()=="Roosevelt Island"){
            return -77.061859;
        }
        return longitude;
    }

    //private class GetWebResponses extends AsyncTask<Void,Void,List<String>>{
      private class GetWebResponses extends AsyncTask<Void,Void,Void>{

        //Webresponse[] googleServiceResponses=null;

       /* protected void preExecute(){

            Log.d(TAG, "AsyncTask(GetWebResponse) preExecute(): disable the button");
            Button viewButton = findViewById(R.id.button2);
            viewButton.setEnabled(false);
        }*/
        protected Void doInBackground(Void...params){

            Log.d(TAG, "AsyncTask(GetWebResponse) doInBackground(): disable the button");
            Button viewButton = findViewById(R.id.button2);
            viewButton.setEnabled(false);
            Log.d(TAG, "AsyncTask(GetWebResponse).doInBackground: database cursor desired.");
            List<String> collect = new ArrayList<String>();
            SQLiteDatabase dbase = new DBHelper(MainActivity.this).getReadableDatabase();
            Cursor resultSet = dbase.rawQuery("Select place_name from location_table",null);
            while(resultSet.moveToNext()){

                collect.add(resultSet.getString(0));

            }
            Log.d(TAG, "AsyncTask(GetWebResponse).doInBackground: data from database achieved.");
            dbase.close();
           // return Arrays.asList(collect);
            //String[] googleServiceResponses = new Webresponse[collect.size()];
            //return collect;
            String[] responseArray = new String[collect.size()];
            collect.toArray(responseArray);
            Intent intent = new Intent(MainActivity.this,ResultView.class);
            intent.putExtra("responseArray",responseArray);
            startActivity(intent);
            return null;
        }
       /* protected void postExecute(List<String> responseStrings){
            String[] responseArray = new String[responseStrings.size()];
            responseStrings.toArray(responseArray);
            Intent intent = new Intent(MainActivity.this,ResultView.class);
            intent.putExtra("responseArray",responseArray);
            startActivity(intent);
        }*/
    }
}
