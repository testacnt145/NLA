package com.nearbylocation.constants;


public class Network {

    //test url
    //https://api.foursquare.com/v2/venues/search?client_id=AL4MXJV4FQHIX5UHB0PSAEXX2QSQJBCNIV2ZYO5KNF5OMJ4F&client_secret=OROT2PGNS1ZQQLMNJEWUFH2EBPHUWWSDDMVEGGVMIFAZEGFH&v=20130815&ll=24.860345,67.062703

    //latitude longitude from
    //https://www.latlong.net/

    //[email_: testacnt145@gmail.com]
    private static final String FOURSQUARE_CLIENT_ID = "AL4MXJV4FQHIX5UHB0PSAEXX2QSQJBCNIV2ZYO5KNF5OMJ4F";
    private static final String FOURSQUARE_CLIENT_SECRET = "OROT2PGNS1ZQQLMNJEWUFH2EBPHUWWSDDMVEGGVMIFAZEGFH";
    private static final String DATE = "20170929";
    private static final float LATITUDE = 24.877349f;
    private static final float LONGITUDE = 67.052997f;

    //https://github.com/Taishi-Y/Foursquare-API-client-sample-app-for-Android
    //https://github.com/Taishi-Y/Foursquare-API-client-sample-app-for-Android/blob/master/app/src/main/java/com/taishi/foursquareapiforandroid/Model/Explore/Venue.java

    public static String baseUrl4Square = "https://api.foursquare.com/";

    public static final String URL = "https://api.foursquare.com/v2/venues/search?" +
            "client_id=" + FOURSQUARE_CLIENT_ID +
            "&client_secret="	+ FOURSQUARE_CLIENT_SECRET +
            "&v=" + DATE +
            "&ll=" + LATITUDE + "," + LONGITUDE;
}
