package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(),
    OnMapReadyCallback,
    GoogleMap.OnCameraMoveStartedListener, //cuando empeiza a movers
    GoogleMap.OnCameraMoveListener, //cuando se mueve
    GoogleMap.OnCameraIdleListener, //cuando no hace nada
    GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener
{
    override fun onPolylineClick(p0: Polyline?) {
        Log.i("map","Polilinea: ${p0.toString()}")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("map","Polipoligono: ${p0.toString()}")
    }

    override fun onCameraMoveStarted(p0: Int) {
        Log.i("map","Me empiezo a mover");
    }

    override fun onCameraMove() {
        Log.i("map","Me muevo :3");
    }

    override fun onCameraIdle() {
        Log.i("map","Soy Lenin Moreno");
    }

    private lateinit var mMap: GoogleMap

    private var tienePermisosLocalizacion=false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        solicitarPermisosLocalizacion();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        establecerConfiguracionMapa(mMap);
        establecerListeners(mMap);
        // Add a marker in Sydney and move the camera
        val foch = LatLng(-0.202920, -78.491039)



        mMap.setOnMarkerClickListener {
            Toast.makeText(this,"${mMap.myLocation.latitude}",Toast.LENGTH_LONG).show();

            true
        }
        val title="Plaza Foch";
        /*mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Poli :v")
        )*/

        this.aniadirMarcador(foch,title);
        moverCamaraZoom(foch);









        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,17f))


        val poliLineaUno=googleMap
            .addPolyline(
                PolylineOptions()
                    .clickable(true)
                    .add(
                        LatLng(-0.210462, -78.493948),
                        LatLng(-0.208218, -78.490163),
                        LatLng(-0.208583, -78.488940),
                        LatLng(-0.209377, -78.490303)
                    )

            )

        val poliOligini=googleMap
            .addPolygon(
                PolygonOptions()
                    .clickable(true)
                    .add(
                        LatLng(-0.209431, -78.490078),
                        LatLng(-0.208734, -78.488951),
                        LatLng(-0.209431, -78.488286),
                        LatLng(-0.210085, -78.489745)
                    )

            )
        poliOligini.fillColor=-0xc771c4;
    }


    fun establecerConfiguracionMapa(mapa:GoogleMap){
        val contexto=this.applicationContext;
        with(mapa){
            val permisoFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto, android.Manifest.permission.ACCESS_FINE_LOCATION
                )

            val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

            if(tienePermiso){
                mapa.isMyLocationEnabled=true
            }
           //
            this.uiSettings.isZoomControlsEnabled=true;
            uiSettings.isMyLocationButtonEnabled=true;
        }
    }

    fun solicitarPermisosLocalizacion() {
        val permisoFineLocation = ContextCompat
            .checkSelfPermission(
                this.applicationContext, android.Manifest.permission.ACCESS_FINE_LOCATION
            )

        val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

        if(tienePermiso){
            Log.i("mapa","tiene permiso");
            this.tienePermisosLocalizacion=true
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf( //el arreglo de permisos
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1 // codigo que se espera, si quiero manejar este codigo, uso OnRequestPermissionsResult ->documentacion de android
            );
        }




    }

        fun aniadirMarcador(latLng:LatLng,title:String){

        mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        );

    }

    fun ubicacionActual(){

        /*mMap.addMarker(
            MarkerOptions()
                .position(LatLng(mMap.myLocation.latitude)

        )*/
    }

    fun moverCamaraZoom(latLng: LatLng, zoom:Float=10f){
        mMap.moveCamera(
            CameraUpdateFactory
                .newLatLngZoom(latLng,zoom)
        );
    }


    fun establecerListeners(mapa: GoogleMap){
        with(mapa){
            setOnCameraIdleListener(this@MapsActivity);
            setOnCameraMoveStartedListener(this@MapsActivity);
            setOnCameraMoveListener(this@MapsActivity)
            setOnPolygonClickListener(this@MapsActivity)
            setOnPolylineClickListener(this@MapsActivity)
        }
    }


}
