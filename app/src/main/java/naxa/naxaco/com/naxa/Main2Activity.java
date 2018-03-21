package naxa.naxaco.com.naxa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import gr.net.maroulis.library.EasySplashScreen;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EasySplashScreen config = new EasySplashScreen(Main2Activity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(1500)
                .withBackgroundResource(R.mipmap.splash)
                .withFooterText("Copyright @2016 Naxa Pvt Ltd")
                .withBeforeLogoText("Naxa")
                .withLogo(R.mipmap.naxa_icon)
                .withAfterLogoText("Coz Location Matters");
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
