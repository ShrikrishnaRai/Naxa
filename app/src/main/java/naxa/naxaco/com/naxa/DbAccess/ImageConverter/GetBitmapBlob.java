package naxa.naxaco.com.naxa.DbAccess.ImageConverter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by cri_r on 08/02/2018.
 */

public class GetBitmapBlob {
    public static Bitmap getBitmap(byte[] byteArray){
        return BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
    }
    public static byte[] getBlob(Bitmap bitmap){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[] bArray=bos.toByteArray();
        return bArray;
    }
}
