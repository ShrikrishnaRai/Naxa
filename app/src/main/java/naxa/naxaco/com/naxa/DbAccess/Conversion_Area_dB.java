package naxa.naxaco.com.naxa.DbAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by cri_r on 04/02/2018.
 */

public class Conversion_Area_dB extends SQLiteOpenHelper {
    static String Db_name="conversion_area";
    static int version=1;
    String create_Table="CREATE TABLE if not exists `conversion_area_table` " +
            "( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " `name` TEXT NOT NULL, " +
            "`saveImage` blob NOT NULL )";
    public Conversion_Area_dB(Context context) {
        super(context,Db_name,null,version);
        getWritableDatabase().execSQL(create_Table);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertInfo(ContentValues contentValues){
        getWritableDatabase().insert("conversion_area_table","",contentValues);
    }

    public Conversion_Area_dB_dto getInfo(){
        String sql="select * from conversion_area_table";
        Cursor cursor=getWritableDatabase().rawQuery(sql,null);
        Conversion_Area_dB_dto conversion_area_dto=new Conversion_Area_dB_dto();
        while (cursor.moveToNext()){
            conversion_area_dto.setId(cursor.getInt(cursor.getColumnIndex("id")));
            conversion_area_dto.setName(cursor.getString(cursor.getColumnIndex("name")));
            conversion_area_dto.setImage(cursor.getBlob(cursor.getColumnIndex("saveImage")));
        }
        cursor.close();
        return conversion_area_dto;
    }
    public ArrayList<Conversion_Area_dB_dto> getUserList(){
        String sql="Select * from conversion_area_table";
        Cursor DcoCursor=getWritableDatabase().rawQuery(sql,null);
        ArrayList<Conversion_Area_dB_dto> list =new ArrayList<Conversion_Area_dB_dto>();
        while (DcoCursor.moveToNext()){
                Conversion_Area_dB_dto IcConversion_Area_dB_dto=new Conversion_Area_dB_dto();
                IcConversion_Area_dB_dto.setId(DcoCursor.getInt(DcoCursor.getColumnIndex("id")));
                IcConversion_Area_dB_dto.setName(DcoCursor.getString(DcoCursor.getColumnIndex("name")));
                IcConversion_Area_dB_dto.setImage(DcoCursor.getBlob(DcoCursor.getColumnIndex("saveImage")));
                list.add(IcConversion_Area_dB_dto);
        }
        DcoCursor.close();
        return list;
    }

}
