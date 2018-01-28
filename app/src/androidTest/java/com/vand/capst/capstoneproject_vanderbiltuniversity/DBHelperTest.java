package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by Sudeep.Pandey on 1/27/2018.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class DBHelperTest {

    DBHelper helper;
    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();
    }

    @After
    public void tearDown(){
        helper.close();

    }

    @Test
    public void testSQLiteOpenHelperInitiation() throws Exception{
        helper = new DBHelper(instrumentationCtx);
        assertEquals(helper.getDatabaseName(),"google_place_db");
    }

   // @Test
    //public void onUpgradeImpliesVersionChange() throws Exception {
      //  helper = new DBHelper(instrumentationCtx);
        //SQLiteDatabase db = helper.getWritableDatabase();
        //helper.onUpgrade(db, 1, 2);
        //assertTrue(db.getVersion()==1);
        //Cursor cursor = db.rawQuery("Select * from location_table", null);
        //assertTrue(cursor.getCount() == 0);
    //}
}
