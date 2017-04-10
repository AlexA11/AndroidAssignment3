package ca.on.sl.comp208.clientdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    Cursor cursor;
    TextView textView;
    TextView shortName;
    TextView urlString;
    TextView dateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        textView = (TextView) findViewById(R.id.textview);
        shortName = (TextView) findViewById(R.id.shortName);
        dateTime = (TextView) findViewById(R.id.datetime);
        urlString = (TextView) findViewById(R.id.urlString);

    }

    public void click(View view){

//        if(NetworkUtils.networkAvailable(this)){
//            HttpConnectionTask task = new HttpConnectionTask();
//            task.execute(URL);
//        }

        Uri uri = DataContract.CONTENT_URI;
        String[] projection = DataContract.columnNames;
        ContentResolver resolver = getContentResolver();
        cursor = resolver.query(uri, projection, null, null, null);
        cursor.moveToFirst();
        update(cursor);
    }

    public void update(Cursor cursor) {
        textView.setText(cursor.getString(DataContract.TITLE));
        shortName.setText(cursor.getString(DataContract.SHORT_TITLE));
        dateTime.setText(cursor.getString(DataContract.DATETIME));
        urlString.setText(cursor.getString(DataContract.URL_STRING));
    }

    public void next(View v) {
        cursor.moveToNext();
        update(cursor);
    }

    public void previous(View v) {
        cursor.moveToPrevious();
        update(cursor);
    }

    private class HttpConnectionTask extends AsyncTask<String, String, Void> {

        @Override
        protected Void doInBackground(String... params) {

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.append(values[0] + "\n");
            textView.setText(values[0]);
        }

    }
}
