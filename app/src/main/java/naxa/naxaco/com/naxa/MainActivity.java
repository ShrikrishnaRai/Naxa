package naxa.naxaco.com.naxa;


import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;
import java.util.zip.Inflater;

import naxa.naxaco.com.naxa.MapInfo.MapInfoActivity;
import naxa.naxaco.com.naxa.MapsActivity.Fragment.MapModalFragment;
import naxa.naxaco.com.naxa.MapsActivity.MapsActivity;
import naxa.naxaco.com.naxa.MyProfile.MyProfile;
import naxa.naxaco.com.naxa.Plotter.PlotterActivity;
import naxa.naxaco.com.naxa.UnitConversion.UnitConversionActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, ActivityCompat.OnRequestPermissionsResultCallback {
    CardView vCardView;
    CardView vSecondCardView;
    CardView vProfile;
    CardView vMapInfo;
    MapModalFragment IcMapFragment;
    FrameLayout vMap_Holder;
    FloatingActionButton vFloatingActionButton;
    private SliderLayout mDemoSlider;
    private static final int REQUEST_WRITE_PERMISSION = 786;
    private static final int REQUEST_ACESS_PERMISSION = 67;
    SharedPreferences IcSharedPreferences;
    ConnectivityManager connManager;
//    NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IcSharedPreferences = getSharedPreferences("check", 0);
        String check = IcSharedPreferences.getString("value", "");
      //  if (check.equals("MapLoaded")) {
            vMap_Holder = findViewById(R.id.map_holder);
            IcMapFragment = new MapModalFragment();
            FragmentManager manager1 = getSupportFragmentManager();
            manager1.beginTransaction().replace(R.id.map_holder, IcMapFragment).commit();
        /*} else {
            mDemoSlider = findViewById(R.id.slider);
            HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
            file_maps.put("State 1", R.mipmap.state_one);
            file_maps.put("State 2", R.mipmap.state_two);
            file_maps.put("State 3", R.mipmap.state_three);
            file_maps.put("State 4", R.mipmap.state_four);
            file_maps.put("State 5", R.mipmap.state_five);
            file_maps.put("State 6/ Karnali", R.mipmap.state_karnali);
            file_maps.put("State 7", R.mipmap.state_seven);

            for (String name : file_maps.keySet()) {
                TextSliderView textSliderView = new TextSliderView(this);
                // initialize a SliderLayout
                textSliderView
                        .description(name)
                        .image(file_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra", name);

                mDemoSlider.addSlider(textSliderView);


            }
            
        /*
        }*/
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
            // Write you code here if permission already given.
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        requestPermission();
        vFloatingActionButton = findViewById(R.id.map_explore);
        vFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
        vMapInfo = findViewById(R.id.map_info);
        vMapInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapInfoActivity.class);
                startActivity(i);
            }
        });
        vSecondCardView = findViewById(R.id.conversion);
        vProfile = findViewById(R.id.profile);
        vProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivity(intent);
                Intent i = new Intent(MainActivity.this, MyProfile.class);
                startActivity(i);
            }
        });
        vSecondCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UnitConversionActivity.class);
                startActivity(i);
            }
        });
        vCardView = findViewById(R.id.plotter);
        vCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlotterActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

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

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        } else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
