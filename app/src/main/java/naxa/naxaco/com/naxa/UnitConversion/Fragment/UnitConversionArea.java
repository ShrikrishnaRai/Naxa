package naxa.naxaco.com.naxa.UnitConversion.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import mehdi.sakout.fancybuttons.FancyButton;
import naxa.naxaco.com.naxa.R;
import naxa.naxaco.com.naxa.UnitConversion.UnitConversion;

/**
 * Created by shri on 3/4/18.
 */

public class UnitConversionArea extends Fragment {
    MaterialSpinner vSpinner;
    EditText vEditText;
    FancyButton vConvertButton;
    EditText vBigha;
    EditText vKatha;
    EditText vDhur;
    EditText vRopani;
    EditText vKhetmuri;
    EditText vAana;
    EditText vPaisa;
    EditText vDaam;
    EditText vMeterSquare;
    EditText vSquareFeet;
    UnitConversion IcUnitConversion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unit_conversion_area, container, false);
        vSpinner = view.findViewById(R.id.spinner);
        IcUnitConversion = new UnitConversion(getContext());
        vSpinner.setItems("Select Unit", "Bigha", "Katha", "Dhur", "Ropani", "Khetmuri", "Aana", "Paisa", "Daam", "Meter square", "Square feet");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        vEditText = view.findViewById(R.id.inputUnit);
        vBigha = view.findViewById(R.id.biggha);
        vKatha = view.findViewById(R.id.kathha);
        vDhur = view.findViewById(R.id.dhur);
        vRopani = view.findViewById(R.id.ropani);
        vKhetmuri = view.findViewById(R.id.khetmuri);
        vAana = view.findViewById(R.id.aana);
        vPaisa = view.findViewById(R.id.paisa);
        vDaam = view.findViewById(R.id.daam);
        vMeterSquare = view.findViewById(R.id.meterSquare);
        vSquareFeet = view.findViewById(R.id.squareFeet);
        vConvertButton = view.findViewById(R.id.Convert);
        vConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    IcUnitConversion.convertUnit(Double.parseDouble(vEditText.getText().toString()), vSpinner.getSelectedIndex());
                    vBigha.setText(String.valueOf(IcUnitConversion.getBigha()));
                    vKatha.setText(String.valueOf(IcUnitConversion.getKatha()));
                    vDhur.setText(String.valueOf(IcUnitConversion.getDhur()));
                    vRopani.setText(String.valueOf(IcUnitConversion.getRopani()));
                    vKhetmuri.setText(String.valueOf(IcUnitConversion.getKhetmuri()));
                    vAana.setText(String.valueOf(IcUnitConversion.getAana()));
                    vPaisa.setText(String.valueOf(IcUnitConversion.getPaisa()));
                    vDaam.setText(String.valueOf(IcUnitConversion.getDaam()));
                    vMeterSquare.setText(String.valueOf(IcUnitConversion.getMeterSquare()));
                    vSquareFeet.setText(String.valueOf(IcUnitConversion.getSquareFeet()));
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                }
            }
        });
        vEditText.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                vEditText.setText(null);
            }
        });
        return view;
    }
}
