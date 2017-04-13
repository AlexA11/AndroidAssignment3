package ca.on.sl.comp208.clientdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Bundle intent = getIntent().getExtras();
        String id = intent.getString("ID");

        TextView idLabel = (TextView) findViewById(R.id.eventId);
        idLabel.setText(id);

    }
}
