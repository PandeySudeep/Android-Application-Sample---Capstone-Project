package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowBinder;
//import org.robolectric.RuntimeEnvironment;
//import org.robolectric.annotation.Config;
//import org.robolectric.TestRunners;

//import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sudeep.Pandey on 1/24/2018.
 */
@RunWith(RobolectricTestRunner.class)
//@RunWith(TestRunners.MultiApiWithDefaults.class)
//@Config(constants=BuildConfig.class)
public class DBHelperTest {

    //private TestOpenHelper helper;
    private DBHelper helper;
    //Context ctx = Robolectric.buildActivity(MainActivity.class).get();
    Context ctx = RuntimeEnvironment.application;

    //public static boolean onCreateCalled=false;
    // public static boolean onUpgradeCalled=false;
    // public static boolean onOpenCalled=false;


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
        assertTrue(database.getPath().contains("google_place_db"));
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
    public void onUpgradeImpliesVersionChange() throws Exception{
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.onUpgrade(db,1,2);
        //assertTrue(db.getVersion()==1);
        Cursor cursor = db.rawQuery("Select * from location_table",null);
        assertTrue(cursor.getCount()==0);


    }

    @Test
    public void testSameDBInstanceSubsequentGetReadableDatabase() throws Exception {
        SQLiteDatabase db1 = helper.getReadableDatabase();
        SQLiteDatabase db2 = helper.getReadableDatabase();

        assertTrue(db1==db2);
    }

    @Test
    public void testInitialGetWritableDatabase() throws Exception {
        SQLiteDatabase database = helper.getWritableDatabase();
        //assertInitialDB(database, helper);
        //assertDatabaseOpened(database, helper);
        assertNotNull(database);
        assertTrue(database.isOpen());
    }

    @Test
    public void testSubsequentGetWritableDatabase() throws Exception {
        helper.getWritableDatabase();
        helper.close();

        //assertSubsequentDB(helper.getWritableDatabase(), helper);
        assertNotNull(helper.getWritableDatabase());
        assertTrue(helper.getWritableDatabase().isOpen());
    }

    @Test
    public void testSameDBInstanceSubsequentGetWritableDatabase() throws Exception {
        SQLiteDatabase db1 = helper.getWritableDatabase();
        SQLiteDatabase db2 = helper.getWritableDatabase();

        assertTrue(db1==db2);
    }

    @Test
    public void testClose() throws Exception {
        SQLiteDatabase database = helper.getWritableDatabase();

        assertTrue(database.isOpen());
        helper.close();
        assertFalse(database.isOpen());
    }

    @Test
    public void testCloseMultipleDbs() throws Exception {
        DBHelper helper2 = new DBHelper(ctx);
        SQLiteDatabase database1 = helper.getWritableDatabase();
        SQLiteDatabase database2 = helper2.getWritableDatabase();
        assertTrue(database1.isOpen());
        assertTrue(database2.isOpen());
        helper.close();
        assertFalse(database1.isOpen());

        assertTrue(database2.isOpen());
        helper2.close();
        assertFalse(database2.isOpen());
    }




    private void setupTable(SQLiteDatabase db, String table) {
        db.execSQL("CREATE TABLE " + table + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "testVal INTEGER DEFAULT 0" +
                ");");
    }
    private void insertData(SQLiteDatabase db, String table, int[] values) {
        for (int i : values) {
            ContentValues cv = new ContentValues();
            cv.put("testVal", i);
            db.insert(table, null, cv);
        }
    }

    private void verifyData(SQLiteDatabase db, String table, int expectedVals) {
        assertEquals(db.query(table, null, null, null,
                null, null, null).getCount(),(expectedVals));
    }

    @Test
    public void testMultipleDbsPreserveData() throws Exception {
        final String TABLE_NAME1 = "fart", TABLE_NAME2 = "fart2";
        SQLiteDatabase db1 = helper.getWritableDatabase();
        setupTable(db1, TABLE_NAME1);
        insertData(db1, TABLE_NAME1, new int[]{1, 2});
        DBHelper helper2 = new DBHelper(ctx);
        SQLiteDatabase db2 = helper2.getWritableDatabase();
        setupTable(db2, TABLE_NAME2);
        insertData(db2, TABLE_NAME2, new int[]{4, 5, 6});
        verifyData(db1, TABLE_NAME1, 2);
        verifyData(db2, TABLE_NAME2, 3);
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
