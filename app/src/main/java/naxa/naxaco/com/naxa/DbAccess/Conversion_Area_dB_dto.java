package naxa.naxaco.com.naxa.DbAccess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by cri_r on 05/02/2018.
 */

public class Conversion_Area_dB_dto {
    private int id;
    private String name;
    private byte[] image;

    public Conversion_Area_dB_dto() {

    }

    public Conversion_Area_dB_dto(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
