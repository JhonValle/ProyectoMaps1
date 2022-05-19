package com.example.proyectomaps1;


import androidx.fragment.app.FragmentActivity;


import android.os.Bundle;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;



public class MapsRutas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerDragListener {

    GoogleMap mapa;
    Marker p1, p2;
    TextView distancia;
    Polyline poly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_rutas);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
        distancia=findViewById(R.id.txtdistancia);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-13.673618905213033, -71.67688847211295), 20));
        p1=mapa.addMarker(new MarkerOptions().position(new LatLng(-13.673618905213033, -71.67688847211295)).draggable(true));
        p2=mapa.addMarker(new MarkerOptions().position(new LatLng(-13.670319501856433, -71.67459371629421)).draggable(true));
        poly = mapa.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        p1.getPosition(),
                        new LatLng(-13.670319501856433, -71.67459371629421)
                ));
        distancia.setText(Puntos.formatDistanceBetween(p1.getPosition(),p2.getPosition()));
        mapa.setOnMarkerDragListener(this);

    }


    @Override
    //inicia el desplazamiento
    public void onMarkerDragStart(Marker marker) {
        if(poly!=null) poly.remove();
        PolylineOptions polylineOptions = new PolylineOptions()
                .add( p1.getPosition(),
                        p2.getPosition()).clickable(true);
        poly=mapa.addPolyline(polylineOptions);
        distancia.setText(Puntos.formatDistanceBetween(p1.getPosition(),p2.getPosition()));
    }
    @Override
    //Desplazando el icono
    public void onMarkerDrag(Marker marker) {
        if(poly!=null) poly.remove();
        PolylineOptions polylineOptions = new PolylineOptions()
                .add( p1.getPosition(),
                        p2.getPosition()).clickable(true);
        poly=mapa.addPolyline(polylineOptions);
        distancia.setText(Puntos.formatDistanceBetween(p1.getPosition(),p2.getPosition()));
    }
    @Override
    public void onMarkerDragEnd(Marker marker) {
    }

}