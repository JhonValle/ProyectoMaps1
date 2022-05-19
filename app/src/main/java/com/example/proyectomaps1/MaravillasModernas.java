package com.example.proyectomaps1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;




import com.example.proyectomaps1.databinding.ActivityMaravillasAntiguasBinding;
import com.example.proyectomaps1.databinding.ActivityMaravillasModernasBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MaravillasModernas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMaravillasModernasBinding binding;
    private Marker markerPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaravillasModernasBinding.inflate(getLayoutInflater());
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
        LatLng piedra = new LatLng(-3.150051470472285, -79.35706998754206);
        mMap.addMarker(new MarkerOptions().position(piedra).title("Petra:La ciudad de Piedra")
                .snippet("Petra fue levantada por los edomitas en el siglo VIII a.C.").
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.piedra)));

        LatLng taj = new LatLng(27.17539294048843, 78.04209928208557);
        mMap.addMarker(new MarkerOptions().position(taj).title("Taj Mahal").snippet
                ("Monumento funerario construido entre 1631 y 1654 en la ciudad de Agra").icon(BitmapDescriptorFactory.fromResource(R.drawable.taj)));

        LatLng  Muralla = new LatLng(40.432103676177555, 116.57034271129521);
        mMap.addMarker(new MarkerOptions().position(Muralla).title(" Muralla China").snippet
                ("reconstruida en el siglo xvi para proteger la frontera del Imperio chino").icon(BitmapDescriptorFactory.fromResource(R.drawable.muralla)));

        LatLng Cristo = new LatLng(-22.951885877980384, -43.210489867324696);
        mMap.addMarker(new MarkerOptions().position(Cristo).title("Cristo Redentor").snippet
                ("Estatua de Jesús de 30 m situada en la cima de un cerro; se puede acceder en tren y tiene vista a la ciudad.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.jesus)));

        LatLng Coliseo = new LatLng(41.89024194628402, 12.492227537048429);
        mMap.addMarker(new MarkerOptions().position(Coliseo).title("Coliseo Romano").snippet
                ("Imponente anfiteatro romano de 3 pisos que fue escenario de combates entre gladiadores; se ofrecen recorridos.").icon(BitmapDescriptorFactory.fromResource(R.drawable.coliseo)));

        LatLng Chichen = new LatLng(20.684348499820278, -88.56779212422681);
        mMap.addMarker(new MarkerOptions().position(Chichen).title(" Chichén Itzá").snippet
                ("Sitio arqueológico con ruinas excavadas de la gran ciudad maya, con una emblemática pirámide escalonada.").icon(BitmapDescriptorFactory.fromResource(R.drawable.chichen)));

        LatLng Machu = new LatLng(-13.163116121075577, -72.54496660469276);
        mMap.addMarker(new MarkerOptions().position(Machu).title(" Machu Picchu").snippet
                ("Ruinas de una ciudad inca del siglo XV situadas en un promontorio; incluye diversas esculturas y terrazas.").icon(BitmapDescriptorFactory.fromResource(R.drawable.machu)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(piedra,7));

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