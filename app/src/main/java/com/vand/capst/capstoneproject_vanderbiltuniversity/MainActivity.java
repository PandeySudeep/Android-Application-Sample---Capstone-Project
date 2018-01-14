package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Binder;


public class MainActivity extends Activity {

    private boolean mBound=false;
    private WebService ws;
    private Context ctx = this;
    //public ContentResolver cr = this.getContentResolver();
    //private String requestUrl;

    //public static Context context = this.getContext();
    //public Context context = this;
    private BroadcastReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (mBound) {
                    //Get user selection and devise request URL.
                    //String requestUrl=null;
                    //String placetype="placeholder";
                    String requestUrl="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+getLatitude()+","+getLongitude()+"&radius=500&type=restaurant&key=YOUR_API_KEY";
                    button.setEnabled(false);
                    button.setText("processing");
                    ws.execute(requestUrl,getInterest());

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
            }
        });

    }

    @Override
    protected void onStart(){

        super.onStart();
        // Bind to LocalService
        Intent intent = new Intent(this, WebService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(
                "capstone.project.action.PERSIST_COMPLETE");

        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                //extract our message from intent
                //String msg_for_me = intent.getStringExtra("some_msg");
                //log our message value
                //Log.i("InchooTutorial", msg_for_me);
                Button mybutton = findViewById(R.id.button2);
                mybutton.setEnabled(true);

            }
        };
        //registering our receiver
        this.registerReceiver(mReceiver, intentFilter);
    }

    @Override
    public void onPause(){
        super.onPause();
        this.unregisterReceiver(this.mReceiver);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
        mBound = false;
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder b) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            WebService.LocalBinder binder = (WebService.LocalBinder) b;
            ws = binder.getService();
            mBound = true;
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

        if (getSite()=="Statue of Liberty"){
            return -33.8670522;
        }else{
            return 0.0;
        }
    }
    private double getLongitude(){

        if(getSite()=="Statue of Liberty"){
            return 151.1957362;
        }else{
            return 0.0;
        }
    }
}
