package naxa.naxaco.com.naxa.Plotter.Fragment;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLClientInfoException;

import naxa.naxaco.com.naxa.DbAccess.Conversion_Area_dB;
import naxa.naxaco.com.naxa.DbAccess.ImageConverter.GetBitmapBlob;
import naxa.naxaco.com.naxa.R;

/**
 * Created by shri on 2/25/18.
 */

public class DotPlotter extends Fragment {
    GetBitmapBlob IcGetBitmapBlob;
    Conversion_Area_dB IcConversion_Area_dB;
    @Nullable
    EditText vBiggha;
    EditText vKatha;
    EditText vDhur;
    EditText vRopani;
    EditText vKhetmuri;
    EditText vAana;
    EditText vPaisa;
    EditText vDaam;
    EditText vMeterSquare;
    EditText vSquareFeet;
    TextView vHeadings;
    Button vButtonSave;
    LinearLayout vLinearLayout;
    LinearLayout vImageLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dot_fragment, container, false);
        IcGetBitmapBlob = new GetBitmapBlob();
        IcConversion_Area_dB = new Conversion_Area_dB(getContext());
        vImageLinearLayout = view.findViewById(R.id.image_to_be_save_dot);
        vBiggha = view.findViewById(R.id.biggha);
        vKatha = view.findViewById(R.id.kathha);
        vDhur = view.findViewById(R.id.dhur);
        vRopani = view.findViewById(R.id.ropani);
        vKhetmuri = view.findViewById(R.id.khetmuri);
        vAana = view.findViewById(R.id.aana);
        vPaisa = view.findViewById(R.id.paisa);
        vDaam = view.findViewById(R.id.daam);
        vMeterSquare = view.findViewById(R.id.meterSquare);
        vSquareFeet = view.findViewById(R.id.squareFeet);
        vButtonSave = view.findViewById(R.id.Save);
        vHeadings = view.findViewById(R.id.headings);
        vLinearLayout = view.findViewById(R.id.linearOne);
        vLinearLayout.setVisibility(view.GONE);
        vHeadings.setVisibility(view.GONE);
        vButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vLinearLayout.setVisibility(view.VISIBLE);
                vHeadings.setVisibility(view.VISIBLE);
                vBiggha.setText("100");
                vKatha.setText("100");
                vDhur.setText("100");
                vRopani.setText("100");
                vKhetmuri.setText("100");
                vAana.setText("100");
                vPaisa.setText("100");
                vDaam.setText("100");
                vMeterSquare.setText("100");
                vSquareFeet.setText("100");
                vButtonSave.setText("100");


                View view = (LayoutInflater.from(getActivity())).inflate(R.layout.image_name_save_layout, null);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
                alertBuilder.setView(view);
                alertBuilder.setTitle("Input Info");
                final EditText image_name = view.findViewById(R.id.ImageName);

                alertBuilder.setCancelable(true)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    String imageName = image_name.getText().toString();
                                    vImageLinearLayout.setDrawingCacheEnabled(true);
                                    Bitmap bitmap = vImageLinearLayout.getDrawingCache();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("name", imageName);
                                    contentValues.put("saveImage", IcGetBitmapBlob.getBlob(bitmap));
                                    IcConversion_Area_dB.insertInfo(contentValues);
                                    Toast.makeText(getContext(), "Saved Sucessfully", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getContext(), "Input Image Name", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                Dialog dialog = alertBuilder.create();
                dialog.show();


            }
        });
        return view;
    }
}
