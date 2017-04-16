package ca.on.sl.comp208.clientdemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class DetailView extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap googleMap;
    MapFragment mapFragment;
    static final LatLng Durban = new LatLng(55.70, 13.19);

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
        Venues venue = gson.fromJson(result, Venues.class);

        TextView idLabel = (TextView) findViewById(R.id.eventId);
        TextView type = (TextView) findViewById(R.id.type);
        TextView url = (TextView) findViewById(R.id.url);

        idLabel.setText(venue.getShort_title());
        type.setText(venue.getType());
        url.setText(venue.getUrl());

        try {

            if (googleMap == null) {

                mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
                mapFragment.getMapAsync(this);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        final Marker marker_Durban = googleMap.addMarker(new MarkerOptions()
                .position(Durban)
                .snippet("Durban, KwaZulu-Natal, South Africa")
                .title("Durban"));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(55.70, 13.19)).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Durban));
//        googleMap.animateCamera(CameraUpdateFactory.zoomBy(15));

    }
}
