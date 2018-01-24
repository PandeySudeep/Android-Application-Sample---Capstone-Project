package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
//import org.robolectric.RuntimeEnvironment;
//import org.robolectric.annotation.Config;
//import org.robolectric.TestRunners;

//import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sudeep.Pandey on 1/24/2018.
 */
@RunWith(RobolectricTestRunner.class)
//@RunWith(TestRunners.MultiApiWithDefaults.class)
//@Config(constants=BuildConfig.class)
public class DBHelperTest {

    //private TestOpenHelper helper;
    private DBHelper helper;
    Context ctx = Robolectric.buildActivity(MainActivity.class).get();

    public static boolean onCreateCalled=false;
    public static boolean onUpgradeCalled=false;
    public static boolean onOpenCalled=false;


    @Before
    public void setUp() throws Exception{
        //helper = new DBHelper(ctx,ctx.getCacheDir()+File.separator+"google_place_db",null,1);
        helper = new DBHelper(ctx);
    }

    @After
    public void tearDown(){
        helper.close();
    }

    @Test
    public void testInitialGetReadableDatabase() throws Exception {
        SQLiteDatabase database = helper.getReadableDatabase();
        //assertInitialDB(database, helper);
        //assertDatabaseOpened(database, helper);
        //assertTrue(helper.onCreateCalled);
        assertNotNull(database);
        assertTrue(database.isOpen());
        //assertTrue(helper.onOpenCalled);
        // assertFalse(helper.onUpgradeCalled);
    }

    @Test
    public void testSubsequentGetReadableDatabase() throws Exception {
        helper.getReadableDatabase();
        helper.close();
        SQLiteDatabase database = helper.getReadableDatabase();

        //assertSubsequentDB(database, helper);
         //assertDatabaseOpened(database, helper);
        assertNotNull(database);
        assertTrue(database.isOpen());
         //assertFalse(helper.onCreateCalled);
    }

    @Test
    public void testSameDBInstanceSubsequentGetReadableDatabase() throws Exception {
        SQLiteDatabase db1 = helper.getReadableDatabase();
        SQLiteDatabase db2 = helper.getReadableDatabase();

        assertTrue(db1==db2);
    }


    //private static void assertInitialDB(SQLiteDatabase database, TestOpenHelper helper) {
       // assertDatabaseOpened(database, helper);
       // assertTrue(helper.onCreateCalled);
    //}

   // private static void assertSubsequentDB(SQLiteDatabase database, DBHelper helper) {
       // assertDatabaseOpened(database, helper);
        //assertFalse(helper.onCreateCalled);
    //}

    //private static void assertDatabaseOpened(SQLiteDatabase database, DBHelper helper) {
        //assertNotNull(database);
        //assertTrue(database.isOpen());
        //assertTrue(helper.onOpenCalled);
       // assertFalse(helper.onUpgradeCalled);
    //}

   /* private static class TestOpenHelper extends DBHelper {
        //public boolean onCreateCalled;
        //public boolean onUpgradeCalled;
        //public boolean onOpenCalled;

        public TestOpenHelper(Context context) {
            super(context);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            onCreateCalled = true;
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            onUpgradeCalled = true;
        }

        @Override
        public void onOpen(SQLiteDatabase database) {
            onOpenCalled = true;
        }

        @Override
        public synchronized void close() {
            onCreateCalled = false;
            onUpgradeCalled = false;
            onOpenCalled = false;

            super.close();
        }
    }*/
}
