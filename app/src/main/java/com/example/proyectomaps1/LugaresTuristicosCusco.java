package com.example.proyectomaps1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;



import com.example.proyectomaps1.databinding.ActivityLugaresTuristicosCuscoBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class LugaresTuristicosCusco extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityLugaresTuristicosCuscoBinding binding;
    private Marker markerPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLugaresTuristicosCuscoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng plazadearmas = new LatLng(-13.516717601019808, -71.97864333595412);
        mMap.addMarker(new MarkerOptions().position(plazadearmas).title("Plaza de Armas Cusco")
                .snippet("Animado lugar de reunión urbano que tiene pórticos coloniales, una catedral, jardines y una fuente central.").
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.parque)));



        LatLng moray = new LatLng(-13.329837003720487, -72.19715169640995);
        mMap.addMarker(new MarkerOptions().position(moray).title("Moray").snippet
                ("Sitio arqueológico inca situado en un altiplano, que presenta un conjunto de terrazas concéntricas.").icon(BitmapDescriptorFactory.fromResource(R.drawable.moray)));

        LatLng Qorikancha = new LatLng(-13.520224734361637, -71.97523417441207);
        mMap.addMarker(new MarkerOptions().position(Qorikancha).title("Qorikancha").snippet
                ("Ruinas de un importante templo inca del siglo XV, que tuvo paredes y suelos cubiertos con oro puro.").icon(BitmapDescriptorFactory.fromResource(R.drawable.excavacion)));

        LatLng Qenqo = new LatLng(-13.508853415047978, -71.97066866742975);
        mMap.addMarker(new MarkerOptions().position(Qenqo).title("Complejo Arqueológico Q'enqo").snippet
                ("Antiguo sitio megalítico que presenta los restos de un templo inca y túneles tallados en roca").icon(BitmapDescriptorFactory.fromResource(R.drawable.arqueologia)));

        LatLng Saqsaywaman = new LatLng(-13.509844701342631, -71.98167995796665);
        mMap.addMarker(new MarkerOptions().position(Saqsaywaman).title("Saqsaywaman").snippet
                ("Complejo inca que está rodeado de muros construidos mediante la colocación firme de piedras sin mortero").icon(BitmapDescriptorFactory.fromResource(R.drawable.sac)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plazadearmas,7));

        googleMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker.equals(markerPrueba)){
            String lat,lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this,lat+ ""+ lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}