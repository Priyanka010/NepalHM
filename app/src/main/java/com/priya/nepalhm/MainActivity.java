package com.priya.nepalhm;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.priya.nepalhm.R.attr.title;


public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,ViewPager.OnPageChangeListener{
    SliderLayout mDemoSlider;
    private CoordinatorLayout coordinatorLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView img_drawer;
    private List<ClipData.Item> itemList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;

    //    CollapsingToolbarLayout collapsingToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        List<String> data = new ArrayList<>();
        String[] movies = getResources().getStringArray(R.array.movies);

        Collections.addAll(data, movies);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(data,this));



        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        img_drawer=(ImageView)drawerLayout.findViewById(R.id.image_view);

        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);

                Intent intent;
                switch (menuItem.getItemId()){
                    case R.id.Login:
                        intent=new Intent((MainActivity.this),Login.class);
                        startActivity(intent);
                        return true;
                    case R.id.AboutUs:
                        intent=new Intent((MainActivity.this),AboutUs.class);
                        startActivity(intent);
                        return true;
                    case R.id.quality:
                        intent=new Intent((MainActivity.this),Quality.class);
                        startActivity(intent);
                        return true;
                    case R.id.FAQ:
                        intent=new Intent((MainActivity.this),FAQ.class);
                        startActivity(intent);
                        return true;
                    case R.id.ContactUs:
                        intent=new Intent((MainActivity.this),Contact.class);
                        startActivity(intent);
                        return true;
                }

                return false;
            }
        });

        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Nepalhm");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("Nepalhm");

            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();



//        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mDemoSlider=(SliderLayout)findViewById(R.id.slider);
        int[] ress=new int[7];
        ress[0]=R.drawable.imageone;
        ress[1]=R.drawable.imagetwo;
        ress[2]=R.drawable.imagethree;
        ress[3]=R.drawable.imagefour;
        ress[4]=R.drawable.imagefive;
         ress[5]=R.drawable.imagesix;
        ress[6]=R.drawable.imageseven;

        for (int i = 0; i < ress.length; i++) {
            TextSliderView textSliderView = new TextSliderView(getApplicationContext());
            String name = "";
            textSliderView
                    .description(name)
                    .image(ress[i])
//                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setDuration(2000);
        mDemoSlider.setPresetTransformer("Default");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }




}


