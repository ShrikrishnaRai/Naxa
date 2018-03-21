package naxa.naxaco.com.naxa.MyProfile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Tricks.InfinitePagerAdapter;

import java.io.File;
import java.util.zip.Inflater;

import naxa.naxaco.com.naxa.R;

public class MyProfileDisplay extends AppCompatActivity {
    Bitmap DcoBitmap;
    ImageView vDisplayImage;
    ImageButton vShare;
    ImageButton vDetail;
    TextView vShare_text;
    TextView vDetail_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_display);
        Intent intent = getIntent();
        DcoBitmap = intent.getParcelableExtra("image");
        vDisplayImage = findViewById(R.id.full_display_my_profile_image);
        vDisplayImage.setImageBitmap(DcoBitmap);
        vShare = findViewById(R.id.share_button);
        vDetail = findViewById(R.id.detail_button);
        vShare_text = findViewById(R.id.share_text);
        vDetail_text = findViewById(R.id.detail_text);

        vShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sourceFile = new File("//mnt/sdcard/file.apk");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, DcoBitmap);
                startActivity(intent);
            }
        });
        vShare_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sourceFile = new File("//mnt/sdcard/file.apk");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(sourceFile));
                startActivity(intent);
            }
        });
        vDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        vDetail_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
