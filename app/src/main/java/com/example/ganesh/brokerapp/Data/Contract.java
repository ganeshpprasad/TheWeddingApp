package com.example.ganesh.brokerapp.Data;

import android.provider.BaseColumns;

/**
 * Created by Ganesh Prasad on 30-06-2016.
 */
public class Contract {

    public static final class Clients implements BaseColumns {
        //Table name
        public static final String TABLE_NAME = "clients";

        //Client name retrieved from email / user input
        public static final String CLIENT_NAME_COL = "name";
        //Client email
        public static final String CLIENT_EMAIL_COL = "email";
        //
        public static final String URI_DP_COL = "dp";
        //
        public static final String AUTH_TOKEN_COL = "auth";
        //
        public static final String PHONE_NO_COL = "phone";
        //
        public static final String CITY_COL = "city";

    }

    public static final class Vendors implements BaseColumns {
        //Table name
        public static final String TABLE_NAME = "vendors";

        //
        public static final String VENDOR_NAME_COL = "name";
        //
        public static final String VENDOR_EMAIL_COL = "email";
        //
        public static final String URI_DP_COL = "dp";
        //
        public static final String AUTH_TOKEN_COL= "auth";
        //
        public static final String PHONE_NO_COL = "phone";
        //
        public static final String CITY_COL = "city";
        // describes the type of vendor - only one type for v1
        public static final String TYPE_COL = "type";
    }


    // Events table will contail details of the event and link 3 tables
    // First table is a set of vandors hired by the user for the event which
    // will in turn have vendor ids as foreign key
    // Second table is a set of friends added by the user for the event which
    // will in turn have user ids as foreign key
    // Third table is a set of photos

    public static final class Events implements BaseColumns {
        //Table name
        public static final String TABLE_NAME = "events";

        // a foreign key to link the creating user
        public static final String CLIENT_ID = "owner";
        // Type of event
        public static final String TYPE_COL = "type";
        // another foreign key but v1 is not implementing the feature of this completely
        // It will point to another table - EVENT_VENDORS , created for each event
        // Populated by the user
        public static final String VENDOR_COL = "vendors";
        // Field to store the friends added by the owner
        // It wll point to another table - EVENT_FRIENDS created for each new event
        public static final String FRIENDS_COL = "friends";
        //
        public static final String DATE_COL = "date";
        //
        public static final String PHOTOS_COL = "photos";
    }

}
