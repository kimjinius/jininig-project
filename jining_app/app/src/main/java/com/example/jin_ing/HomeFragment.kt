package com.example.jin_ing

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.Overlay
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), OnMapReadyCallback{

    private lateinit var mapView: MapView

    private lateinit var ct : Context

    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    var markerMutable = mutableListOf<Marker>()

    var shopAPIS = ShopAPIS.create()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ct = container!!.context
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(35.1798159, 129.0750222), 15.0))
            .mapType(NaverMap.MapType.Terrain)


        val fm: FragmentManager = childFragmentManager
        val mapFragment = MapFragment.newInstance(options)
        fm.beginTransaction().add(R.id.map_view, mapFragment).commit()

        mapFragment.getMapAsync(this)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = view.findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // ?????? ?????????
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        naverMap.addOnLocationChangeListener { location ->

//            Toast.makeText(ct, "${location.latitude}, ${location.longitude}",
//                Toast.LENGTH_SHORT).show()

        }

        shopAPIS.getShop().enqueue(object : Callback<List<Shop>>{
            override fun onResponse(call: Call<List<Shop>>, response: Response<List<Shop>>) {

                val shopList = response.body()
                for (i in shopList?.indices!!){

                    var shop_x = shopList[i].shop_site_x
                    var shop_y = shopList[i].shop_site_y
                    var shop_id = shopList[i].shop_id

                    val marker = Marker().apply {
                        position = LatLng(shop_x.toDouble(), shop_y.toDouble())
                        setOnClickListener {

                            val result = shop_id.toString()
                            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.home_fragment, ShopBottomSheet())
                                .commit()

                            val bottomSheet = ShopBottomSheet()
                            bottomSheet.show(activity!!.supportFragmentManager, bottomSheet.tag)

                            true
                        }
                        map = naverMap
                    }
//                    marker.position = LatLng(shop_x.toDouble(), shop_y.toDouble())
//                    marker.map = naverMap
//                    markerMutable.add(marker)

                }
                Log.d("shop", response.body().toString())
            }
            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                errorDialog("Shop get fail", t)
            }
        })
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000

    }

    fun errorDialog(msg: String, t: Throwable){
        val dialog = AlertDialog.Builder(ct)
        Log.d(msg, t.message.toString())
        dialog.setTitle("$msg ??????")
        dialog.setMessage("????????????????????????.")
        dialog.show()
    }

    fun hideMarker(map:NaverMap, marker:Marker){
        marker.map = null
    }

}


