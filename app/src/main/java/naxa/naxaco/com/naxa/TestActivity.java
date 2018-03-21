package naxa.naxaco.com.naxa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class TestActivity extends AppCompatActivity {
    ImageView vImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        vImageView = findViewById(R.id.imageView_test);

        String imgUrl = "https://api.androidhive.info/images/glide/medium/deadpool.jpg";
        Picasso.with(getApplicationContext()).load(R.mipmap.back).into(vImageView);
    }
}
