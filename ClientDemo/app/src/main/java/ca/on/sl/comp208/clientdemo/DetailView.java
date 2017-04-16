package ca.on.sl.comp208.clientdemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class DetailView extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    SupportMapFragment mapFragment;
    static LatLng location;
    Venues venue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataProvider provider = new DataProvider();
        setContentView(R.layout.activity_detail_view);

        Bundle intent = getIntent().getExtras();
        String id = intent.getString("ID");

        String event_url = "https://api.seatgeek.com/2/events/" + id + "?client_id=Njk2MDQ1MHwxNDkxMTc5NDY3Ljg5&format=json";
        String result = NetworkUtils.getNetworkData(event_url);


        Gson gson = new Gson();
        venue = gson.fromJson(result, Venues.class);
        Log.d("Location", venue.toString());

        TextView idLabel = (TextView) findViewById(R.id.eventId);
        TextView type = (TextView) findViewById(R.id.type);
        TextView url = (TextView) findViewById(R.id.url);

        idLabel.setText(venue.getShort_title());
        type.setText(venue.getType());
        url.setClickable(true);
        url.setMovementMethod(LinkMovementMethod.getInstance());
        url.setText(Html.fromHtml("<a href=\""+venue.getUrl()+"\">Buy Tickets Here!</a> "));
        location = new LatLng(venue.getVenue().getLocation().getLat(), venue.getVenue().getLocation().getLon());

        try {

            if (googleMap == null) {

                mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
                mapFragment.getMapAsync(DetailView.this);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        final Marker marker_Durban = googleMap.addMarker(new MarkerOptions()
                .position(location)
                .snippet(venue.getVenue().getDisplay_location())
                .title(venue.getTitle()));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
