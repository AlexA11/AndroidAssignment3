package ca.on.sl.comp208.clientdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.ContentProvider;

import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by alexash on 2017-04-09.
 */

public class DataProvider extends ContentProvider {

    private static final String secret = "&client_secret=23d95673239dfb61249b43d4f3a1a0b3998f7bf7d93a61aa39046d122c2e90f7";
    private static final String URL = "https://api.seatgeek.com/2/events?client_id=Njk2MDQ1MHwxNDkxMTc5NDY3Ljg5&format=json" + secret;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        String result = NetworkUtils.getNetworkData(URL);

        Gson gson = new Gson();
        Event events = gson.fromJson(result, Event.class);

        MatrixCursor mc = new MatrixCursor(new String[] {"_id", "Title", "Short Title", "URL", "Date Time Local"});
        for (int i = 0; i < events.events.size() ; i++) {
            mc.addRow(new Object[] {events.events.get(i).getId(), events.events.get(i).getTitle(), events.events.get(i).getShort_title(), events.events.get(i).datetime_local, events.events.get(i).getUrl()});
        }

        return mc;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
