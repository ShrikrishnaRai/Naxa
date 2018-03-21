package naxa.naxaco.com.naxa.Plotter.Fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import naxa.naxaco.com.naxa.DbAccess.Conversion_Area_dB;
import naxa.naxaco.com.naxa.DbAccess.ImageConverter.GetBitmapBlob;
import naxa.naxaco.com.naxa.Plotter.Formula.TotalFormula;
import naxa.naxaco.com.naxa.Plotter.RecyclerViewAdapterTraingle;

import java.util.ArrayList;
import java.util.List;

import naxa.naxaco.com.naxa.Plotter.Formula.Formula;
import naxa.naxaco.com.naxa.Plotter.Formula.FormulaTraingleDto;


import naxa.naxaco.com.naxa.R;


/**
 * Created by shri on 2/25/18.
 */

public class TraingularPlotter extends Fragment {

    @Nullable
    TextView lengthA;
    TextView lengthB;
    TextView lengthC;
    GetBitmapBlob IcGetBitmapBlob;
    Conversion_Area_dB IcConversion_Area_dB;
    String VImageName;
    TextView vAns;
    FormulaTraingleDto IcFormulaTraingle;
    ImageButton vSaveTraigleButton;
    ImageButton vInputTraingleButton;
    List<FormulaTraingleDto> IcFormulaTraingleDtoList;
    RecyclerView vRecyclerView;
    RelativeLayout vRelativeLayout;
    RelativeLayout vImageSaveRelativelayout;
    TextView vTotalArea;
    TextView vHeadingsHeadings;
    int VTraingleNumber;
    public static int VCurrentTraingleNumber;
    List<TotalFormula> IcTotalArea = new ArrayList<>();
    FormulaTraingleDto IcFormulaTraingleDto;
    Formula IcFormula;
    float total;
    Boolean VCheck = false;
    Bitmap VBitmap;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.traingular_fragment, container, false);
        IcFormulaTraingle = new FormulaTraingleDto();
        vImageSaveRelativelayout = view.findViewById(R.id.check);
        IcGetBitmapBlob = new GetBitmapBlob();
        IcConversion_Area_dB = new Conversion_Area_dB(getContext());
        VCurrentTraingleNumber = 0;
        IcFormula = new Formula();
        IcFormulaTraingleDto = new FormulaTraingleDto();
        vTotalArea = view.findViewById(R.id.total_area);
        vTotalArea.setVisibility(View.GONE);
        vRecyclerView = view.findViewById(R.id.input_recyclerView_holder);
        vRecyclerView.setHasFixedSize(false);
        showUpFirst();

        vHeadingsHeadings = view.findViewById(R.id.headings_headings);
        vInputTraingleButton = view.findViewById(R.id.inputTrainglularActivityButton);
        vInputTraingleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUp();
            }
        });
        vRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        vRelativeLayout = view.findViewById(R.id.relative_layout);
        vRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUp();
            }
        });
        IcFormula = new Formula();
        IcFormulaTraingleDtoList = new ArrayList<>();

        vInputTraingleButton = view.findViewById(R.id.inputTrainglularActivityButton);
        lengthA = view.findViewById(R.id.lengthA);
        lengthB = view.findViewById(R.id.lengthB);
        lengthC = view.findViewById(R.id.lengthC);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(550);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatCount(R.color.background);
        lengthA.startAnimation(anim);
        lengthB.startAnimation(anim);
        lengthC.startAnimation(anim);
        vSaveTraigleButton = view.findViewById(R.id.saveTrainglularActivityButton);
        vSaveTraigleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (VCurrentTraingleNumber == VTraingleNumber) {
                    View view = (LayoutInflater.from(getContext())).inflate(R.layout.image_name_save_layout, null);
                    final EditText editText = view.findViewById(R.id.ImageName);
                    AlertDialog.Builder DcoAlertBuilder = new AlertDialog.Builder(getContext());
                    DcoAlertBuilder.setView(view);
                    DcoAlertBuilder.setCancelable(true).setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String VImageName = editText.getText().toString();
                            vImageSaveRelativelayout.setDrawingCacheEnabled(true);
                            Bitmap bitmap = vImageSaveRelativelayout.getDrawingCache();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", VImageName);
                            contentValues.put("saveImage", IcGetBitmapBlob.getBlob(bitmap));
                            IcConversion_Area_dB.insertInfo(contentValues);
                            Toast.makeText(getContext(),"Image Saved",Toast.LENGTH_SHORT).show();
                        }
                    });

                    Dialog dialog = DcoAlertBuilder.create();
                    dialog.show();
                } else {
                    Toast.makeText(getContext(), "You have input sufficient Traingle Info", Toast.LENGTH_SHORT).show();
                }
            }
        });
        RecyclerViewAdapterTraingle IcRecyclerViewAdapterTraingle = new RecyclerViewAdapterTraingle(IcFormulaTraingleDtoList, getContext());
        vRecyclerView.setAdapter(IcRecyclerViewAdapterTraingle);
        return view;
    }


    public void showUp() {
        View view = (LayoutInflater.from(getContext())).inflate(R.layout.alert_dialogue_area_input_traingle, null);
        AlertDialog.Builder DcoAlertBuilder = new AlertDialog.Builder(getContext());
        DcoAlertBuilder.setView(view);
        DcoAlertBuilder.setTitle("Input Detail's");
        final EditText vInputLengthOne = view.findViewById(R.id.lengthOneInput);
        vInputLengthOne.setInputType(InputType.TYPE_CLASS_NUMBER);
        final EditText vInputLengthTwo = view.findViewById(R.id.lengthTwoInput);
        vInputLengthTwo.setInputType(InputType.TYPE_CLASS_NUMBER);
        final EditText vInputLengthThree = view.findViewById(R.id.lengthThreeInput);
        vInputLengthThree.setInputType(InputType.TYPE_CLASS_NUMBER);
        DcoAlertBuilder.setCancelable(true).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    IcFormulaTraingleDtoList.add(new FormulaTraingleDto(Integer.parseInt(vInputLengthOne.getText().toString()),
                            Integer.parseInt(vInputLengthTwo.getText().toString()),
                            Integer.parseInt(vInputLengthThree.getText().toString())
                    ));
                    VCurrentTraingleNumber++;
                    if (checkTriangle(VCurrentTraingleNumber)) {
                        vTotalArea.setVisibility(View.VISIBLE);
                        float finalVlaue;
                        float latest;
                        finalVlaue = IcFormula.totalArea(IcFormulaTraingle.getA(), IcFormulaTraingle.getB(), IcFormulaTraingle.getC());
                        latest = finalVlaue + finalVlaue;
                        IcTotalArea.add(new TotalFormula(total));

                        vTotalArea.setText(Float.toString(latest));
                    }
                    vHeadingsHeadings.setText(VCurrentTraingleNumber + "/" + VTraingleNumber);
                    IcFormulaTraingle.setA(Integer.parseInt(vInputLengthOne.getText().toString()));
                    IcFormulaTraingle.setB(Integer.parseInt(vInputLengthTwo.getText().toString()));
                    IcFormulaTraingle.setC(Integer.parseInt(vInputLengthThree.getText().toString()));
                    lengthA.setText(Integer.toString(IcFormulaTraingle.getA()));
                    lengthB.setText(Integer.toString(IcFormulaTraingle.getB()));
                    lengthC.setText(Integer.toString(IcFormulaTraingle.getC()));
                } catch (Exception e) {
                    Toast.makeText(getContext(), "" + e, Toast.LENGTH_LONG).show();
                }

            }

        });
        Dialog dialog = DcoAlertBuilder.create();
        dialog.show();
    }

    public void showUpFirst() {
        VCheck = true;
        View view = (LayoutInflater.from(getContext())).inflate(R.layout.number_traingle_plotter, null);
        AlertDialog.Builder DcoAlertBuilder = new AlertDialog.Builder(getContext());
        DcoAlertBuilder.setView(view);
        DcoAlertBuilder.setTitle("Input Detail's");
        final EditText numberTraingle = view.findViewById(R.id.numberTraingle);
        numberTraingle.setInputType(InputType.TYPE_CLASS_NUMBER);
        DcoAlertBuilder.setCancelable(true).setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    VTraingleNumber = Integer.parseInt(numberTraingle.getText().toString());
                } catch (Exception e) {
                    showUpFirst();
                    Toast.makeText(getContext(), "Enter Valid Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Dialog dialog = DcoAlertBuilder.create();
        dialog.show();
    }

    public boolean checkTriangle(int num) {
        if (num == VTraingleNumber) {
            return true;
        }
        return false;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (VCheck) {

        }
    }
}
