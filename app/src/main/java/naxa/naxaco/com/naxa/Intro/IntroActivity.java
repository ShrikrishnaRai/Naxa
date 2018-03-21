package naxa.naxaco.com.naxa.Intro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ActionMode;

import com.github.paolorotolo.appintro.AppIntro;

import naxa.naxaco.com.naxa.Intro.Fragment.TutsFour;
import naxa.naxaco.com.naxa.Intro.Fragment.TutsOne;
import naxa.naxaco.com.naxa.Intro.Fragment.TutsThree;
import naxa.naxaco.com.naxa.Intro.Fragment.TutsTwo;
import naxa.naxaco.com.naxa.Main2Activity;
import naxa.naxaco.com.naxa.MainActivity;
import naxa.naxaco.com.naxa.Plotter.Fragment.DotPlotter;
import naxa.naxaco.com.naxa.UnitConversion.Fragment.UnitConversionArea;
import naxa.naxaco.com.naxa.UnitConversion.Fragment.UnitConversionLength;

/**
 * Created by shri on 3/20/18.
 */

public class IntroActivity extends AppIntro {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFirstTime()) {
            TutsOne IcTutsOne=new TutsOne();
            TutsTwo IcTutsTwo=new TutsTwo();
            TutsThree IcTutsThree=new TutsThree();
            TutsFour IcTutsFour=new TutsFour();
            addSlide(IcTutsOne);
            addSlide(IcTutsTwo);
            addSlide(IcTutsThree);
            addSlide(IcTutsFour);
        }
        else{
            Intent intent=new Intent(IntroActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
    }

    private Boolean firstTime = null;

    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;
    }
}
