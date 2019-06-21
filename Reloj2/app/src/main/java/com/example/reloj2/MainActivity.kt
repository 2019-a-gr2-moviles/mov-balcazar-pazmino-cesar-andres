package com.example.reloj2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private var toolbar:Toolbar?=null;
   // private var myViewPager:ViewPager?=null;
   // private var mytabLayout:TabLayout?=null;
    private var adaptador_Acceso:AdaptadorAccesoTabs?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.main_page_toolbar) as Toolbar;
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(1)

       var myViewPager=findViewById(R.id.main_tabs_pager) as ViewPager;
        adaptador_Acceso= AdaptadorAccesoTabs(supportFragmentManager);
        myViewPager.adapter=adaptador_Acceso

        var mytabLayout=findViewById(R.id.main_tabs_pager) as TabLayout
        mytabLayout.setupWithViewPager(myViewPager)
    }
}
