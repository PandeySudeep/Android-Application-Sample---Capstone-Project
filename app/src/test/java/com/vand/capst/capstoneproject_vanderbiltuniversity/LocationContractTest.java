package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sudeep.Pandey on 1/25/2018.
 */
@RunWith(RobolectricTestRunner.class)
public class LocationContractTest {


    private LocationContract contract;

    @Before
    public void setUp(){
        contract  = new LocationContract();
    }

    @Test
    public void buildUriReturnsCorrectly() throws Exception{

        LocationContract.LocationEntry locationEntry = new LocationContract.LocationEntry();
        Uri uri = locationEntry.buildUri(1L);
        String uriString = uri.toString();
        assertEquals(uriString,("content://vand.capst.myprovider/location_table/1"));

    }
}