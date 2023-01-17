package com.example.jin_ing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShopBottomSheet() : BottomSheetDialogFragment() {

    lateinit var shop_id : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            shop_id = bundle.getString("bundleKey").toString()
            Log.d("bundleKey", shop_id.toString())
        }

        view?.findViewById<TextView>(R.id.shop_name)?.text = shop_id

        return inflater.inflate(R.layout.dialg_shop, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        view?.findViewById<Button>(R.id.button_bottom_sheet)?.setOnClickListener {
//            dismiss()
//        }

    }
}