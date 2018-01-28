package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowBinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sudeep.Pandey on 1/24/2018.
 */
@RunWith(RobolectricTestRunner.class)
public class WebServiceTest {

    private WebService service;

    @Before
    public void setUp(){
        service = Robolectric.setupService(WebService.class);
        //service=new WebService();

    }

   /* @Test
    public void testServiceBinding() throws Exception {
        //Context context = new MainActivity();
        Context context = Robolectric.buildActivity(MainActivity.class).get();
        Intent serviceIntent = new Intent(context, WebService.class);
        serviceIntent.setClassName(context,
                MainActivity.class.getSimpleName());
        boolean ok = context.bindService(serviceIntent, conn,
                Context.BIND_AUTO_CREATE);
        assertTrue(ok);
        //Thread.sleep(10); // Perhaps we dont need?
        assertNotNull(binder);
    }
*/

   @Test
   public void onBindReturnsIBinder() throws Exception{

       IBinder b = service.onBind(new Intent());
       //assertTrue(b.equals(bindr));
       assertNotNull(b);
       //assertEquals(b.getClass().getName(),"WebService.LocalBinder");
       assertTrue(b instanceof IBinder);
       assertTrue(b instanceof WebService.LocalBinder);

   }

   @Test
    public void onCreateReturnsHandlerThread() throws Exception{

       //service.onCreate();
       //assertTrue(Thread.activeCount()==4);
       assertTrue(service !=null);

   }









//    private class LocalBinder extends Binder {
        //WebService getService() {
            // Return this instance of LocalService so clients can call public methods
            //return service;
        //}
    //}

    //private IBinder bindr = new LocalBinder();





    //private IBinder binder;
}
