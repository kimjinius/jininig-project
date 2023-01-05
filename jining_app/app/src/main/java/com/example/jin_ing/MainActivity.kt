package com.example.jin_ing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

import android.widget.LinearLayout
import android.R
import android.view.MenuItem

import com.example.jin_ing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    var home_ly: LinearLayout? = null
    var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        home_ly = binding.homeLy
        bottomNavigationView = binding.bottomNavigationView

        //맨 처음 시작할 탭 설정
        bottomNavigationView!!.selectedItemId = R.id.home

        bottomNavigationView!!.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.home -> {
                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        NaviHomeFragment()
                        // Respond to navigation item 1 click
                    }
                    R.id.pro -> {
                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_bnv2)
                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_bnv2)
                        NaviAttendanceFragment()
                        // Respond to navigation item 2 click
                    }
                    R.id.first3 -> {
                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_bnv2)
                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_bnv2)
                        NaviInfoFragment()
                        // Respond to navigation item 3 click
                    }
                    else -> {
                        bnv_main.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        bnv_main.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_bnv1)
                        NaviCertificateFragment()
                    }
                }
            )
            true
        }
        bnv_main.selectedItemId = R.id.first
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_con, fragment)
            .commit()
    }

}