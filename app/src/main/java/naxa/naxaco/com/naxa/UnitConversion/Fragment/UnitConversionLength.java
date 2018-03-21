package naxa.naxaco.com.naxa.UnitConversion.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import mehdi.sakout.fancybuttons.FancyButton;
import naxa.naxaco.com.naxa.R;
import naxa.naxaco.com.naxa.UnitConversion.UnitConversion;

/**
 * Created by shri on 3/4/18.
 */

public class UnitConversionLength extends Fragment {
    MaterialSpinner vSpinner;
    FancyButton vConvertButton;
    UnitConversion IcUnitConversion;
    EditText vEditText;
    EditText vCentiMeter;
    EditText vMeter;
    EditText vFeet;
    EditText vInch;
    EditText vKilometer;
    EditText vMile;
    EditText vYard;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.unit_conversion_length,container,false);
        IcUnitConversion=new UnitConversion(getContext());
        vSpinner=view.findViewById(R.id.spinner);
        vEditText=view.findViewById(R.id.inputUnit);
        vCentiMeter=view.findViewById(R.id.centimeter);
        vMeter=view.findViewById(R.id.Meter);
        vFeet=view.findViewById(R.id.feet);
        vInch=view.findViewById(R.id.Inch);
        vKilometer=view.findViewById(R.id.kilometer);
        vMile=view.findViewById(R.id.mile);
        vYard=view.findViewById(R.id.yard);
        vSpinner.setItems("Select Units","Centimeter","Meter","Feet","Inch","Kilometer","Mile","yard");
        vConvertButton=view.findViewById(R.id.Convert);
        vConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    IcUnitConversion.convertUnitLength(Double.parseDouble(vEditText.getText().toString()), vSpinner.getSelectedIndex());
                    vCentiMeter.setText(String.valueOf(IcUnitConversion.getCentimeter()));
                    vMeter.setText(String.valueOf(IcUnitConversion.getMeter()));
                    vFeet.setText(String.valueOf(IcUnitConversion.getFeet()));
                    vInch.setText(String.valueOf(IcUnitConversion.getInch()));
                    vKilometer.setText(String.valueOf(IcUnitConversion.getKilometer()));
                    vMile.setText(String.valueOf(IcUnitConversion.getMile()));
                    vYard.setText(String.valueOf(IcUnitConversion.getYard()));
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
