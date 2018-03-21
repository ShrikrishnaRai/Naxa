package naxa.naxaco.com.naxa.Plotter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import naxa.naxaco.com.naxa.Plotter.Fragment.DotPlotter;
import naxa.naxaco.com.naxa.Plotter.Fragment.TraingularPlotter;
import naxa.naxaco.com.naxa.R;

public class PlotterActivity extends AppCompatActivity {
    ViewPager mPager;
    TitlePageIndicator mIndicator;
    TraingularPlotter IcTraingularPlotter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plotter);
        IcTraingularPlotter = new TraingularPlotter();
        ViewpagerPagerAdapter mAdapter = new ViewpagerPagerAdapter(getSupportFragmentManager());
        mPager = findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.setBackgroundColor(0xFFCCCCCC);
    }

    public class ViewpagerPagerAdapter extends FragmentPagerAdapter {

        public ViewpagerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:


                    return new TraingularPlotter();
                case 1:
                    return new DotPlotter();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Traingular Method";
                case 1:
                    return "Dot Method";
            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
