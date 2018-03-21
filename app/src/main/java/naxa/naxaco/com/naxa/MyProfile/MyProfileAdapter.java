package naxa.naxaco.com.naxa.MyProfile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import naxa.naxaco.com.naxa.DbAccess.Conversion_Area_dB_dto;
import naxa.naxaco.com.naxa.DbAccess.ImageConverter.GetBitmapBlob;
import naxa.naxaco.com.naxa.MainActivity;
import naxa.naxaco.com.naxa.R;

/**
 * Created by shri on 3/15/18.
 */

public class MyProfileAdapter extends RecyclerView.Adapter<MyProfileAdapter.ViewHolder> {
    private ArrayList<Conversion_Area_dB_dto> profileDtoArrayList;
    private Context DcoContext;

    public MyProfileAdapter(ArrayList<Conversion_Area_dB_dto> profileDtoArrayList, Context dcoContext) {
        this.profileDtoArrayList = profileDtoArrayList;
        DcoContext = dcoContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_my_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.vName.setText(profileDtoArrayList.get(position).getName());
        holder.vImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.vImage.setImageBitmap(GetBitmapBlob.getBitmap(profileDtoArrayList.get(position).getImage()));
        holder.vImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DcoContext, MyProfileDisplay.class);
                holder.vImage.setDrawingCacheEnabled(true);
                Bitmap b = holder.vImage.getDrawingCache();
                i.putExtra("image", b);
                DcoContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView vName;
        private ImageView vImage;

        public ViewHolder(View itemView) {
            super(itemView);
            vName = itemView.findViewById(R.id.title_image_myProfile);
            vImage = itemView.findViewById(R.id.img_myProfile);
        }
    }
}
