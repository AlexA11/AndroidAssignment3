package ca.on.sl.comp208.clientdemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


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

        textView = (TextView) findViewById(R.id.layout_title);
        shortName = (TextView) findViewById(R.id.shortName);
        dateTime = (TextView) findViewById(R.id.datetime);
        urlString = (TextView) findViewById(R.id.urlString);

        ListView scroller = (ListView) findViewById(R.id.scrollView);
        scroller.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3)
            {
                Cursor entry = (Cursor) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, DetailView.class);
                intent.putExtra("ID", entry.getString(0));
                startActivity(intent);
            }
        });

    }

    public void click(View view){
        Uri uri = DataContract.CONTENT_URI;
        String[] projection = DataContract.columnNames;
        ContentResolver resolver = getContentResolver();
        cursor = resolver.query(uri, projection, null, null, null);
        cursor.moveToFirst();
        update(cursor);
    }

    public void update(Cursor cursor) {
        String[] from = {BaseColumns._ID, "Title", "Short Title", "URL", "Date Time Local"};
        int[] to = { R.id.layout_id,R.id.layout_title, R.id.layout_shortname, R.id.layout_urlstring, R.id.layout_datetime};
        SimpleCursorAdapter adap = new SimpleCursorAdapter(this, R.layout.list_layout, cursor, from, to);
        ListView scroller = (ListView) findViewById(R.id.scrollView);
        scroller.setAdapter(adap);

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
