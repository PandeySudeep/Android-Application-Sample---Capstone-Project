package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ContentResolver;
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
import org.robolectric.shadows.ShadowContentResolver;

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
public class ContentProviderTest {


    //@Mock
    //UriMatcher matcher;

    MyContentProvider provider;

    private static final String AUTHORITY = "vand.capst.myprovider";
    @Before
    public void setUp(){
        provider = new MyContentProvider();
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
        //provider.onCreate();
        assertNotNull(provider);
        assertEquals(new DBHelper(provider.getContext()).getDatabaseName(),"google_place_db");
        //assertEquals(Shadows.shadowOf(new SQLiteDatabase()).getpath());

    }

    @Test
    public void getTypeWorksCorrectly() throws Exception{

        String str = provider.getType(Uri.parse("content://vand.capst.myprovider/location_table/1"));
        assertEquals(str,"caps.android.cursor.item/vand.capst.myprovider/location_table");
    }

    @Test
    public void insertWorksCorrectly() throws Exception{

    }
}
