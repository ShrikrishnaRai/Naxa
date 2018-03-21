package naxa.naxaco.com.naxa.MapsActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Toast;

import com.cocoahero.android.geojson.GeoJSON;
import com.cocoahero.android.geojson.GeoJSONObject;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.google.maps.android.kml.KmlLayer;

//import_icon com.getbase.floatingactionbutton.FloatingActionButton;
//import_icon com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import naxa.naxaco.com.naxa.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    SharedPreferences IcSharedPreferences;

    private GoogleMap mMap;
    FloatingActionButton floatingActionButton;
    FloatingActionButton vFloatingActionButtonClear;
    FloatingActionButton vFloatingActionButtonGeoJson;
    private static final int PICKFIlE_RESULT_CODE = 2;
    private static final int PICKFILE_RESULT_GEOJSON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        IcSharedPreferences = getSharedPreferences("check", 0);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        vFloatingActionButtonGeoJson = findViewById(R.id.menu_item1);
        vFloatingActionButtonGeoJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFILE_RESULT_GEOJSON);
            }
        });
        vFloatingActionButtonClear = findViewById(R.id.menu_item3);
        vFloatingActionButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
            }
        });
        floatingActionButton = findViewById(R.id.menu_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("*/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, PICKFIlE_RESULT_CODE);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                SharedPreferences.Editor editor = IcSharedPreferences.edit();
                editor.putString("value", "MapLoaded");
                editor.commit();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICKFIlE_RESULT_CODE) {
            try {
                Uri uri = data.getData();
                InputStream ips = getContentResolver().openInputStream(uri);
                KmlLayer layer = new KmlLayer(mMap, ips, getApplicationContext());
                layer.addLayerToMap();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == PICKFILE_RESULT_GEOJSON) {
            try {

                // GeoJsonLayer layer=new GeoJsonLayer(mMap,R.raw)
               /* Uri urii=data.getData();
                InputStream ipss=getContentResolver().openInputStream(urii);
               GeoJsonLayer layer=new GeoJsonLayer(mMap,ips,getApplicationContext());
              GeoJsonLayer layer=new GeoJsonLayer(mMap,ipss,getApplicationContext());
                GeoJSONObject geoJSONObject = GeoJSON.parse(ipss);*/
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_LONG).show();
            }
        }
    }

}
