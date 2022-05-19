package com.example.proyectomaps1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;




import com.example.proyectomaps1.databinding.ActivityMaravillasAntiguasBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MaravillasAntiguas extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMaravillasAntiguasBinding binding;
    private Marker markerPrueba;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaravillasAntiguasBinding.inflate(getLayoutInflater());
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
        LatLng piramide = new LatLng(29.977294404250845, 31.132498294455633);
        mMap.addMarker(new MarkerOptions().position(piramide).title("Gran Pirámide de Guiza")
                .snippet("La mayor de las pirámides de Egipto, situada en un complejo que incluye templos y otros artefactos antiguos").
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.piramide)));

        LatLng Mausoleo = new LatLng(37.03789739168588, 27.424107979066335);
        mMap.addMarker(new MarkerOptions().position(Mausoleo).title("Mausoleo de Halicarnaso").snippet
                ("Sitio arqueológico que alberga las ruinas de la tumba enorme de Mausolo, de alrededor del año 350 a. C.").icon(BitmapDescriptorFactory.fromResource(R.drawable.elmausoleo)));

        LatLng  Estatua = new LatLng(37.96931342842976, 23.73309791656751);
        mMap.addMarker(new MarkerOptions().position(Estatua).title(" Estatua de Zeus").snippet
                ("Olimpia: un santuario en la antigua Grecia, el sitio de los primeros Juegos Olímpicos y el hogar de una Maravilla.").icon(BitmapDescriptorFactory.fromResource(R.drawable.estatua)));

        LatLng Jardines = new LatLng(37.40428, -5.99354);
        mMap.addMarker(new MarkerOptions().position(Jardines).title("Jardines Colgantes de Babilonia").snippet
                ("A pesar de la existencia de descripciones detalladas en muchos textos antiguos, tanto griegos como romanos, ninguna otra Maravilla es más misteriosa que los Jardines Colgantes de Babilonia.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.parque)));

        LatLng faro = new LatLng(31.206879803355868, 29.940128169748995);
        mMap.addMarker(new MarkerOptions().position(faro).title("El Faro de Alejandría").snippet
                ("Navegar hacia el puerto de Alejandría era complicado, debido a las aguas poco profundas y las rocas.").icon(BitmapDescriptorFactory.fromResource(R.drawable.faro)));

        LatLng coloso = new LatLng(36.45100287952351, 28.225807791483255);
        mMap.addMarker(new MarkerOptions().position(coloso).title(" Coloso de Rodas").snippet
                ("Erigido en 282 a.C., el Coloso de Rodas fue la última Maravilla construida y una de las primeras destruidas." +
                        " Permaneció en pie durante menos de 60 años, pero eso no lo descalificó de ser considerado una Maravilla.").icon(BitmapDescriptorFactory.fromResource(R.drawable.coloso)));

        LatLng artemisa = new LatLng(37.949608716439286, 27.363902774523645);
        mMap.addMarker(new MarkerOptions().position(artemisa).title(" Templo de Artemisa").snippet
                ("Sitio histórico que incluye los restos del templo de Artemisa, una diosa del mundo antiguo.").icon(BitmapDescriptorFactory.fromResource(R.drawable.templo)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(piramide,7));

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