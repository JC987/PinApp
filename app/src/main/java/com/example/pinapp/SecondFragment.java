package com.example.pinapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SecondFragment extends Fragment implements OnMapReadyCallback {
private View root;
private MapView mapView;
private GoogleMap map;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        root = inflater.inflate(R.layout.fragment_second, container, false);
        mapView = root.findViewById(R.id.mapView);


        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng bhs = new LatLng(40.771589, -73.781208);
        LatLng bt = new LatLng(40.779169, -73.777737);
        LatLng bt2 = new LatLng(40.779169, -73.777777);
        map.addMarker(new MarkerOptions().position(bhs).title("Marker at BHS"));
        map.addMarker(new MarkerOptions().position(bt).title("Marker at Bay Terrarace"));
        map.addMarker(new MarkerOptions().position(bt2).title("Marker at Bay Terrarace 2"));

        CameraUpdate pinLocation = CameraUpdateFactory.newLatLng(bt2);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);

        map.moveCamera(pinLocation);
        map.animateCamera(zoom);
    }

    @Override
    public void onStart() {
        mapView.onStart();
        super.onStart();
    }

    @Override
    public void onStop() {
        mapView.onStop();
        super.onStop();
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
