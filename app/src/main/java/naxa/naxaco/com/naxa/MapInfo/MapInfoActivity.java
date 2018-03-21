package naxa.naxaco.com.naxa.MapInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

import naxa.naxaco.com.naxa.R;

public class MapInfoActivity extends AppCompatActivity {
    PDFView DcoPdfview;
    Button vMapBuy;
    Button vMapConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info);
        vMapBuy = findViewById(R.id.mapBuy);
        DcoPdfview = findViewById(R.id.pdfView);
        vMapConsult=findViewById(R.id.ConsultMap);
        vMapConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DcoPdfview.fromAsset("nodejs_tutorial.pdf").load();
            }
        });
        vMapBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DcoPdfview.fromAsset("android_tutorial.pdf").load();
            }
        });

    }
}
