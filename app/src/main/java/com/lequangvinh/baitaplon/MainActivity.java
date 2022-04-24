package com.lequangvinh.baitaplon;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.lequangvinh.baitaplon.SQLite.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{
    ViewPager pager;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pager = (ViewPager)findViewById(R.id.view_paper);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> ){
            database = new Database(MainActivity.this);
            if (pager.getCurrentItem() == 0){
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_thu);

                final EditText edt_khoanthu = (EditText)dialog.findViewById(R.id.edtkhoanthu);
                final EditText edt_loaithu = (EditText)dialog.findViewById(R.id.edtkhoanchi);
                Button btnvaothu = (Button) dialog.findViewById(R.id.btnvaothu);
                btnvaothu.setOnClickListener((view -> ){
                    String a = edt_khoanthu.getText().toString();
                    String b = edt_loaithu.getText().toString();
                    String c = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                    if(a.isEmpty()||b.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
                    }else{
                        database.SendData("INSERT INTO THU VALUES('"+c+"','"+a+"','"+b+"', NULL)");
                        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                        pager.setAdapter(adapter);
                        pager.setCurrentItem(2);
                        Toast.makeText(MainActivity.this, "thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            dialog.show();
            }else if(pager.getCurrentItem()==1){
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.id.dialog_chi);
                final EditText edt_khoanchi = (EditText) dialog.findViewById(R.id.edtkhoanchi);
                final EditText edt_loaichi = (EditText) dialog.findViewById(R.id.edtloaichi);
                Button btnvaochi = (Button) dialog.findViewById(R.id.btnvaochi);
                btnvaochi.setOnClickListener(view -> ){
                    String a = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                    String b = edt_khoanchi.getText().toString();
                    String c = edt_loaichi.getText().toString();
                    if(a.isEmpty()||b.isEmpty()){
                        Toast.makeText(MainActivity.this, "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
                    }else{
                        database.SendData("INSERT INTO THU VALUES('"+c+"','"+a+"','"+b+"', NULL)");
                        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                        pager.setAdapter(adapter);
                        pager.setCurrentItem(2);
                        Toast.makeText(MainActivity.this, "thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this,drawer,toolbar,"Open navigation drawer","Close navigation drawer");
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_khoanthu){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
        }if(id == R.id.nav_khoanchi){
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
        }if(id == R.id.nav_thongke) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
        }if(id == R.id.nav_gioithieu) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
        }if(id == R.id.nav_thoat){
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}