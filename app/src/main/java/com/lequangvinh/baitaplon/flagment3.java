package com.lequangvinh.baitaplon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.lequangvinh.baitaplon.Adapter.PagerAdapter2;

public class flagment3 extends Fragment {
    public flagment3(){

    }

    private View rootview;
    ViewPager pager;
    TabLayout tl;
    PagerAdapter2 adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.flagment3,container,false);
        initView();
        return rootview;
    }

    private void initView() {
        pager = rootview.findViewById(R.id.view_paper2);
        tl = rootview.findViewById(R.id.tab_layout2);
        adapter = new PagerAdapter2(getActivity().getSupportFragmentManager());

        pager.setAdapter(adapter);
        tl.setupWithViewPager(pager);
    }
}
