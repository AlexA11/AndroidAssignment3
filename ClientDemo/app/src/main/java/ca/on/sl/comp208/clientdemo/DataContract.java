package ca.on.sl.comp208.clientdemo;

import android.net.Uri;

/**
 * Created by alexash on 2017-04-09.
 */

public class DataContract {

    public static final String AUTHORITY = "ca.on.sl.comp208.clientdemo";
//    private static final String secret = "&client_secret=23d95673239dfb61249b43d4f3a1a0b3998f7bf7d93a61aa39046d122c2e90f7";
//    private static final String URL = "api.seatgeek.com/2/events?client_id=Njk2MDQ1MHwxNDkxMTc5NDY3Ljg5&format=json" + secret;

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static int TITLE=0;
    public static int SHORT_TITLE=1;
    public static int URL_STRING = 2;
    public static int DATETIME = 3;


    public static final String[] columnNames = {"Title", "Short Title", "URL", "Date Time Local"};
}
