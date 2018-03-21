package naxa.naxaco.com.naxa.MyProfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import naxa.naxaco.com.naxa.DbAccess.Conversion_Area_dB;
import naxa.naxaco.com.naxa.DbAccess.Conversion_Area_dB_dto;
import naxa.naxaco.com.naxa.R;

public class MyProfile extends AppCompatActivity {
    RecyclerView vRecyclerViewMyProfile;
    Conversion_Area_dB IcConversion_Area_dB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        IcConversion_Area_dB = new Conversion_Area_dB(this);
        vRecyclerViewMyProfile = findViewById(R.id.recyclerView_myProfile);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        vRecyclerViewMyProfile.setLayoutManager(layoutManager);
        vRecyclerViewMyProfile.setHasFixedSize(true);
        MyProfileAdapter IcMyProfileAdapter = new MyProfileAdapter(IcConversion_Area_dB.getUserList(), this);
        vRecyclerViewMyProfile.setAdapter(IcMyProfileAdapter);
    }

}
