package com.example.mappolygonandpolyline

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.mappolygonandpolyline.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        val sydney = LatLng(40.3831385209533, 71.78265655177182)

        /** polyline
        val list = ArrayList<LatLng>()
        list.add(LatLng(40.3831385209533, 71.78265651177182))
        list.add(LatLng(41.3831385209533, 71.78265651177182))
        list.add(LatLng(40.3831385209533, 73.78265651177182))
        list.add(LatLng(49.3831385209533, 71.78265651177182))

        mMap.addPolyline(PolylineOptions().addAll(list))


        mMap.addPolyline(PolylineOptions().add(sydney)
        .color(Color.BLUE)
        .clickable(true)
        .add(LatLng(49.3831385209533, 71.78265651177182)))

        mMap.setOnPolylineClickListener {
        Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        }
         **/


        /** polygon
        mMap.addPolygon(PolygonOptions()
        .fillColor(Color.BLUE)
        .strokeColor(Color.RED)
        .add(sydney)
        .add(LatLng(40.3831385209533, 71.78265651177182))
        .add(LatLng(40.3831385209533, 73.78265651177182))
        .add(LatLng(49.3831385209533, 71.78265651177182)))
         **/

        val myCamera = CameraPosition.Builder()
        myCamera.target(sydney) //kordinatasi lat va long
        myCamera.bearing(45f) //shimoldan necha gradus
        myCamera.zoom(18f) //yaqinlashish
        myCamera.tilt(45f) //ko'zlash burchagi
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(myCamera.build()))

    }
}