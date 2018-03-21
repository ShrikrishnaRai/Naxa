package naxa.naxaco.com.naxa.Plotter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import naxa.naxaco.com.naxa.Plotter.Formula.Formula;
import naxa.naxaco.com.naxa.Plotter.Formula.FormulaTraingleDto;
import naxa.naxaco.com.naxa.R;

import static naxa.naxaco.com.naxa.Plotter.Fragment.TraingularPlotter.VCurrentTraingleNumber;

/**
 * Created by shri on 2/28/18.
 */

public class RecyclerViewAdapterTraingle extends RecyclerView.Adapter<RecyclerViewAdapterTraingle.ViewHolder> {
    public static int VTotalArea;
    List<FormulaTraingleDto> IcFormulaTraingleDtos = new ArrayList<>();
    FormulaTraingleDto IcFormulaTraingleDto = new FormulaTraingleDto();
    private Context DcoContext;
    Formula IcFormula = new Formula();

    public RecyclerViewAdapterTraingle(List<FormulaTraingleDto> icFormulaTraingleDtos, Context dcoContext) {
        IcFormulaTraingleDtos = icFormulaTraingleDtos;
        DcoContext = dcoContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(DcoContext);
        View view = inflater.inflate(R.layout.card_view_show_traingle, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FormulaTraingleDto IcFormulaTraingleDto = IcFormulaTraingleDtos.get(position);
        holder.vLengthOne.setText(Float.toString(IcFormulaTraingleDto.getA()));
        holder.vLengthTwo.setText(Float.toString(IcFormulaTraingleDto.getB()));
        holder.vLengthThree.setText(Float.toString(IcFormulaTraingleDto.getC()));
        holder.VArea.setText(Float.toString(IcFormula.totalArea(IcFormulaTraingleDto.getA(), IcFormulaTraingleDto.getB(), IcFormulaTraingleDto.getC())));
        holder.vHeadings.setText("Traingle ::" + VCurrentTraingleNumber);
    }

    @Override
    public int getItemCount() {
        return IcFormulaTraingleDtos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EditText vLengthOne;
        EditText vLengthTwo;
        EditText vLengthThree;
        EditText VArea;
        TextView vHeadings;

        public ViewHolder(View itemView) {
            super(itemView);
            vLengthOne = itemView.findViewById(R.id.cardLengthOneInput);
            vLengthTwo = itemView.findViewById(R.id.cardLengthTwoInput);
            vLengthThree = itemView.findViewById(R.id.cardLengthThreeInput);
            VArea = itemView.findViewById(R.id.AreaAns);
            vHeadings = itemView.findViewById(R.id.headings_traingle);
//            VTotalArea = VTotalArea + Integer.parseInt(VArea.getText().toString());
        }
    }
}
