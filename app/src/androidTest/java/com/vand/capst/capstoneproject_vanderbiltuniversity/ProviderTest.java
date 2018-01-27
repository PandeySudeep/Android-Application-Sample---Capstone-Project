package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Sudeep.Pandey on 1/27/2018.
 */
@RunWith(AndroidJUnit4.class)
public class ProviderTest extends ProviderTestCase2<MyContentProvider> {

    ContentProvider provider;
    private ContentResolver contentResolver;

    public ProviderTest(){
        //super(MyContentProvider.class,LocationContract.CONTENT_AUTHORITY);
        super(MyContentProvider.class,"vand.capst.myprovider");
    }

    //private ContentResolver contentResolver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        contentResolver = this.getMockContentResolver();
    }

    //@Test(expected = UnsupportedOperationException.class)
    @Test
    public void insertThrowsException() throws Exception{

        provider = getProvider();

        //Uri uri = LocationContract.LocationEntry.CONTENT_URI;
        //provider.insert(uri,new ContentValues());
        //assertTrue(provider==null);
        //assertTrue(contentResolver!=null);

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

        //provider=getProvider();
        //provider.onCreate();
        //assertEquals(new DBHelper(provider.getContext()).getDatabaseName(),"google_place_db");
        //assertEquals(provider.getContext(),null);
        // new DBHelper(RuntimeEnvironment.application);
        Uri uri = LocationContract.LocationEntry.CONTENT_URI;
        //int check = provider.bulkInsert(Uri.parse("content://vand.capst.myprovider/location_table/1"),cvsArray);
        //int check = provider.bulkInsert(uri,cvsArray);
        //int check = getMockContentResolver().bulkInsert(uri,cvsArray);
        //assertEquals(check,2);

        //assertEquals(check,0);

    }






}
