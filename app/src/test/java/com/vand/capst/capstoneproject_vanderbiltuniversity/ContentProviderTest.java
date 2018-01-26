package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowContentResolver;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

import android.net.Uri;

import static android.provider.BlockedNumberContract.AUTHORITY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by Sudeep.Pandey on 1/26/2018.
 */

@RunWith(RobolectricTestRunner.class)
//@Config(manifest = Config.NONE)
public class ContentProviderTest {


    //@Mock
    //UriMatcher matcher;

    MyContentProvider provider;

    private static final String AUTHORITY = "vand.capst.myprovider";
    @Before
    public void setUp(){
        //provider = new MyContentProvider();
        provider = Robolectric.setupContentProvider(MyContentProvider.class);
        //when(matcher.match(mock(Uri.class))).thenReturn(100);

        //provider.onCreate();
        //ContentResolver resolver = RuntimeEnvironment.application.getContentResolver();
        //ShadowContentResolver shadowResolver = Shadows.shadowOf(resolver);
       // provider.onCreate();
        //shadowResolver.registerProvider(
               // "vand.capst.myprovider", provider
        //);
    }

    @Test
    public void onCreateLifecycleStageTest() throws Exception{
        provider.onCreate();
        assertNotNull(provider);
        assertEquals(new DBHelper(provider.getContext()).getDatabaseName(),"google_place_db");
        //assertEquals(Shadows.shadowOf(new SQLiteDatabase()).getpath());

    }

    @Test
    public void getTypeWorksCorrectly() throws Exception{

        String str = provider.getType(Uri.parse("content://vand.capst.myprovider/location_table/1"));
        assertEquals(str,"caps.android.cursor.item/vand.capst.myprovider/location_table");

        //String str2 = provider.getType(Uri.parse("content://vand.capst.myprovider/location_table/2"));
        //assertEquals(str,"caps.android.cursor.item/vand.capst.myprovider/location_table");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void insertThrowsException() throws Exception{

        Uri uri = LocationContract.LocationEntry.CONTENT_URI;
        provider.insert(uri,new ContentValues());


    }

    @Test
    public void bulkInsertWorksCorrectly() throws Exception{

        ContentValues[] cvsArray = new ContentValues[2];
        ContentValues cVals = new ContentValues();
        cVals.put(LocationContract.LocationEntry.COLUMN_INFO1,"Cranberry");
        cVals.put(LocationContract.LocationEntry.COLUMN_INFO2,"City");

        ContentValues cVals2 = new ContentValues();
        cVals2.put(LocationContract.LocationEntry.COLUMN_INFO1,"demoplace");
        cVals2.put(LocationContract.LocationEntry.COLUMN_INFO2,"demotype");

        cvsArray[0]=cVals;
        cvsArray[1]=cVals2;

        //provider.onCreate();
        //assertEquals(new DBHelper(provider.getContext()).getDatabaseName(),"google_place_db");
        //assertEquals(provider.getContext(),null);
       // new DBHelper(RuntimeEnvironment.application);
        Uri uri = LocationContract.LocationEntry.CONTENT_URI;
       //int check = provider.bulkInsert(Uri.parse("content://vand.capst.myprovider/location_table/1"),cvsArray);
        int check = provider.bulkInsert(uri,cvsArray);
        assertEquals(check,2);

       //assertEquals(check,0);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteWorksCorrectly() throws Exception{

        int del = provider.delete(Uri.parse("content://vand.capst.myprovider/location_table/1"),"place_name",new String[]{"test"});
        //assertEquals(del,0);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void updateWorksCorrectly() throws Exception{

        Uri uri = LocationContract.LocationEntry.CONTENT_URI;
        provider.update(uri,new ContentValues(),"place_name",new String[]{"Cranberry"});
        //int del = provider.delete(Uri.parse("content://vand.capst.myprovider/location_table/1"),"place_name",new String[]{"test"});
        //assertEquals(del,0);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void queryThrowsException() throws Exception{

        Uri uri = LocationContract.LocationEntry.CONTENT_URI;
        provider.query(uri,null,"place_name",new String[]{"Cranberry"},"DESC");

        //int del = provider.delete(Uri.parse("content://vand.capst.myprovider/location_table/1"),"place_name",new String[]{"test"});
        //assertEquals(del,0);

    }
}
