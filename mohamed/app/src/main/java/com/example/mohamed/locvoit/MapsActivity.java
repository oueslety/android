package com.example.mohamed.locvoit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.internal.a.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
       /* LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    1);
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();*/
        // Add a marker in Sydney and move the camera
        Intent intent = getIntent();
        String pays=(intent.getStringExtra("pays"));
if(pays.equals("Tunis"))
{LatLng point = new LatLng( 36.7948624,10.213318);


        mMap.addMarker(new MarkerOptions().position(point).title("Tunis"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point));}

        if(pays.equals("Algerie"))
        {LatLng point = new LatLng(36.7596531,3.2065941);


            mMap.addMarker(new MarkerOptions().position(point).title("Algerie"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point));}

        if(pays.equals("Maroc"))
        {LatLng point = new LatLng(33.969199,-6.7872223);


            mMap.addMarker(new MarkerOptions().position(point).title("Maroc"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point));}
        if(pays.equals("Libye"))
        {LatLng point = new LatLng(26.0511052,26.2988357);


            mMap.addMarker(new MarkerOptions().position(point).title("Libye"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(point));}

    }

}
