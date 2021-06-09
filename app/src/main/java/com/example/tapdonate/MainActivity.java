package com.example.tapdonate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager screenPager;
    private ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    Button button,buttonSkip;
    Button buttonSecondNext;
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(restorePrefData()){
            Intent mainActivity = new Intent(MainActivity.this, Login.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        final List<ScreenCons> mList = new ArrayList<>();
        mList.add(new ScreenCons("Plan a Trip", "Lorem ipsum is simply dummy\n     text of the printing and\n        typesetting industry.",R.drawable.ic_group));
        mList.add(new ScreenCons("Plan a Trip", "Lorem ipsum is simply dummy\n     text of the printing and\n        typesetting industry.",R.drawable.ic_layout));
        mList.add(new ScreenCons("Plan a Trip", "Lorem ipsum is simply dummy\n     text of the printing and\n        typesetting industry.",R.drawable.ic_secondlayout));

        button = findViewById(R.id.btn_ab);
        buttonSecondNext = findViewById(R.id.btn_abc);
        buttonSkip = findViewById(R.id.btn_a);
        tabLayout = findViewById(R.id.tab_layout);
        screenPager = (ViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(this,mList);
        screenPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(screenPager);

        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if(position < mList.size()){

                    position++;
                    screenPager.setCurrentItem(position);
                }

                if(position == mList.size()-1){

                    loadLastScreen();
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        buttonSecondNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

                savePrefsData();
                finish();
            }
        });


    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return  isIntroActivityOpenedBefore;

    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();

    }

    private void loadLastScreen() {
        button.setVisibility(View.INVISIBLE);
        buttonSkip.setVisibility(View.INVISIBLE);
        buttonSecondNext.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
    }

}