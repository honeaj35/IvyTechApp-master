package net.androidbootcamp.ivytechapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    double latitude;
    double longitude;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_maps);
        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String roomNum = sharedPref.getString("key1","");

        DBHandler db = new DBHandler(this);

        Classroom classrooms = db.getClassroom(roomNum);

        latitude = Double.parseDouble(classrooms.getLatitude());
        longitude = Double.parseDouble(classrooms.getLongitude());
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng colCampus = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(colCampus).title("Your Classroom"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(colCampus));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude) , 19.0f));
        //float zoomLevel = 15.0f;
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colCampus, zoomLevel));
        //mMap.setMaxZoomPreference(14.0f);
        //mMap.setMinZoomPreference(9.0f);
        //mMap.addMarker(new MarkerOptions().position(colCampus).title("Coliseum Campus"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(colCampus));
    }

}
