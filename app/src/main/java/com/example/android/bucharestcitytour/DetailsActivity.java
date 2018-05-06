package com.example.android.bucharestcitytour;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location location;

    private String locationName;
    private int locationImageResourceId;
    private String locationDescription;
    private double locationLatitude;
    private double locationLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Set the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Collect the selected Location details
        Intent intent = getIntent();
        location = intent.getParcelableExtra("Location");
        locationName = location.getName();
        locationImageResourceId = location.getImageResourceId();
        locationDescription = location.getDescription();
        locationLatitude = location.getLatitude();
        locationLongitude = location.getLongitude();

        // Set the fab icon button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGoogleMaps();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the location name as title
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(locationName);

        // Set the location image
        ImageView detailsLocationImage = findViewById(R.id.details_location_image);
        detailsLocationImage.setImageResource(locationImageResourceId);

        // Set the location description
        TextView detailsLocationDescription = findViewById(R.id.details_location_description);
        detailsLocationDescription.setText(locationDescription);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // Load the map
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker on the map and move the camera
        LatLng locationPosition = new LatLng(locationLatitude, locationLongitude);
        mMap.addMarker(new MarkerOptions().position(locationPosition).title(locationName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationPosition));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));
    }

    // Start GoogleMaps
    private void startGoogleMaps() {
        Intent googleMapsIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?daddr=" + locationLatitude + "," + locationLongitude));

        if (googleMapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(googleMapsIntent);
        }
    }
}
