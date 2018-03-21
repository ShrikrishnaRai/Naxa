package naxa.naxaco.com.naxa.UnitConversion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.TitlePageIndicator;

import naxa.naxaco.com.naxa.Plotter.Fragment.DotPlotter;
import naxa.naxaco.com.naxa.Plotter.Fragment.TraingularPlotter;
import naxa.naxaco.com.naxa.Plotter.PlotterActivity;
import naxa.naxaco.com.naxa.R;
import naxa.naxaco.com.naxa.UnitConversion.Fragment.UnitConversionArea;
import naxa.naxaco.com.naxa.UnitConversion.Fragment.UnitConversionLength;

public class UnitConversionActivity extends AppCompatActivity {
    ViewPager mPager;
    TitlePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_conversion_activity);
        UnitConversionActivity.ViewpagerPagerAdapter mAdapter = new UnitConversionActivity.ViewpagerPagerAdapter(getSupportFragmentManager());
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


                    return new UnitConversionArea();
                case 1:
                    return new UnitConversionLength();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "   Area Conversion   ";
                case 1:
                    return "   Length Conversion ";
            }
            return super.getPageTitle(position);
        }
        @Override
        public int getCount() {
            return 2;
        }
    }

}
