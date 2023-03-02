package islom.din.dodo_ilmhona_proskills.QA.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import islom.din.dodo_ilmhona_proskills.R

class MapsFragment : Fragment() {
    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val dodoOne = LatLng(38.56373892347399, 68.79698696890716)
        googleMap.addMarker(MarkerOptions().position(dodoOne).title("DodoPizzaa1"))

        val dodoTwo = LatLng(38.56442989127712, 68.75438842433617)
        googleMap.addMarker(MarkerOptions().position(dodoTwo).title("DodoPizzaa2").snippet("DodoPizzaa1"))

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dodoTwo,12f))
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fr = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        fr.getMapAsync(callback)
    }
}