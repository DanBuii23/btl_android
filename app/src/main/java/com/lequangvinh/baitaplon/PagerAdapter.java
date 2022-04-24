package com.lequangvinh.baitaplon;

import android.app.FragmentManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {super(fm); }

    public PagerAdapter(androidx.fragment.app.FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int i){
        Fragment frag = null;
            switch (i){
                case 0:
                    frag = new flagment2();
                    break;
                case 1:
                    frag = new flagment3();
                    break;
                case 2:
                    frag = new flagment1();
                    break;
                case 3:
                    frag = new GioiThieuActivity();
                    break;
            }
            return frag;
    }
    @Override
    public int getCount(){return 4; }
}