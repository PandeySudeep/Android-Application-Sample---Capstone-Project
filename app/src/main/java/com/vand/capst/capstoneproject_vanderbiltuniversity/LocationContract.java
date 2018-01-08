package com.vand.capst.capstoneproject_vanderbiltuniversity;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Sudeep.Pandey on 1/7/2018.
 */

public class LocationContract {



//package vandy.mooc.hobbitcontentprovider.provider;

  //      import android.content.ContentUris;
    //    import android.net.Uri;
      //  import android.provider.BaseColumns;

/**
 * This contract defines the metadata for the HobbitContentProvider,
 * including the provider's access URIs and its "database" constants.
 */
//public final class CharacterContract {
    /**
     * This ContentProvider's unique identifier.
     */
    public static final String CONTENT_AUTHORITY =
            //"vandy.mooc.hobbitprovider";
    "vand.capst.myprovider";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which
     * apps will use to contact the content provider.
     */
    public static final Uri BASE_CONTENT_URI =
            Uri.parse("content://"
                    + CONTENT_AUTHORITY);

    /**
     * Possible paths (appended to base content URI for possible
     * URI's), e.g., a valid path for looking at Character data is
     * content://vandy.mooc.hobbitcontentprovider/character_table .
     * However, content://vandy.mooc.hobbitcontentprovider/givemeroot
     * will fail, as the ContentProvider hasn't been given any
     * information on what to do with "givemeroot".
     */
    public static final String PATH_LOCATION =
            LocationEntry.TABLE_NAME;

    /*
     * Columns
     */

    /**
     * Inner class that defines the table contents of the Hobbit
     * table.
     */
    public static final class LocationEntry
            implements BaseColumns {
        /**
         * Use BASE_CONTENT_URI to create the unique URI for Acronym
         * Table that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon()
                        .appendPath(PATH_LOCATION).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "caps.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_LOCATION;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "caps.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_LOCATION;

        /**
         * Columns to display.
         */
        public static final String sColumnsToDisplay [] =
                new String[] {
                        LocationContract.LocationEntry._ID,
                        LocationContract.LocationEntry.COLUMN_INFO1,
                        LocationContract.LocationEntry.COLUMN_INFO2
                };

        /**
         * Name of the database table.
         */
        public static final String TABLE_NAME =
                "character_table";

        /**
         * Columns to store data.
         */
        public static final String COLUMN_INFO1 = "result_item_1";
        public static final String COLUMN_INFO2 = "rasult_item_2";

        /**
         * Return a Uri that points to the row containing a given id.
         *
         * @param id row id
         * @return Uri URI for the specified row id
         */
        public static Uri buildUri(Long id) {
            return ContentUris.withAppendedId(CONTENT_URI,
                    id);
        }
    }
}
