package com.example.reloj2


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AdaptadorAccesoTabs: FragmentPagerAdapter {

    constructor(fm:FragmentManager) : super(fm) {

    }
    override fun getItem(p0: Int): Fragment? {
     when(p0){
         0->{
             var fragmentoAlarma=Alarma();
             return fragmentoAlarma;
         }

         1->{
             var fragmentoReloj=RelojMundial();
             return fragmentoReloj;
         }

         else->{
                return null;
         }
     }
        return null;
    }

    override fun getCount(): Int {
        return 2;
    }


    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{
                return "Alarma";
            }

            1->{
                return "Reloj Mundial";
            }

            else->{
                return null;
            }
        }
        return null;
    }
}