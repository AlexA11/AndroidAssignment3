package ca.on.sl.comp208.clientdemo;

import android.net.Uri;

/**
 * Created by alexash on 2017-04-09.
 */

public class DataContract {

    public static final String AUTHORITY = "ca.on.sl.comp208.clientdemo";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static int TITLE=0;
    public static int SHORT_TITLE=1;
    public static int URL_STRING = 2;
    public static int DATETIME = 3;


    public static final String[] columnNames = {"Title", "Short Title", "URL", "Date Time Local"};
}
