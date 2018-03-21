package naxa.naxaco.com.naxa.Intro.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import naxa.naxaco.com.naxa.R;

/**
 * Created by shri on 3/20/18.
 */

public class TutsTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tuts_two,container,false);
        return view;
    }
}
