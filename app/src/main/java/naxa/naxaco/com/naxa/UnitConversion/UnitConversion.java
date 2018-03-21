package naxa.naxaco.com.naxa.UnitConversion;

import android.content.Context;
import android.widget.Toast;

import naxa.naxaco.com.naxa.UnitDto.UnitDto;

/**
 * Created by shri on 2/25/18.
 */


public class UnitConversion {
    // UnitDto unitDto;
    UnitDto IcUnitDto;
    private double bigha;
    private double katha;
    private double dhur;
    private double ropani;
    private double khetmuri;
    private double aana;
    private double paisa;
    private double daam;
    private double meterSquare;
    private double squareFeet;
    private double centimeter;
    private double feet;
    private double inch;
    private double meter;
    private double kilometer;
    private double mile;
    private double yard;
    private static Context context;

    public UnitConversion(Context c) {
        context = c;
    }


    public void convertUnitLength(double vInputUnit, int cCaseUnit) {
        IcUnitDto = new UnitDto();
        switch (cCaseUnit) {
            case 1:
                //for centimeter
                centimeter = vInputUnit;
                meter = vInputUnit * 0.01;
                feet = vInputUnit * 0.03;
                inch = vInputUnit * 0.39;
                kilometer = 0.0009;
                mile = 0.0009;
                yard = vInputUnit * 0.01;
                break;
            case 2:
                //for meter
                meter = vInputUnit;
                centimeter = vInputUnit * 100.0;
                feet = vInputUnit * 3.28;
                inch = vInputUnit * 39.37;
                kilometer = vInputUnit * 0.0001;
                mile = vInputUnit * 0.001;
                yard = vInputUnit * 1.09;
                break;
            case 3:
                //for feet
                centimeter = vInputUnit * 30.48;
                meter = vInputUnit * 0.3;
                feet = vInputUnit;
                inch = vInputUnit * 12.0;
                kilometer = 0.0009;
                mile = 0.0009;
                yard = vInputUnit * 0.33;
                break;
            case 4:
                //for inch
                centimeter=vInputUnit*2.54;
                meter=vInputUnit*0.03;
                feet=vInputUnit*0.08;
                inch=vInputUnit;
                kilometer=0.0009;
                mile=0.0009;
                yard=vInputUnit*0.03;
                break;
            case 5:
                //for kilometer
                centimeter=vInputUnit*100000.0;
                meter=vInputUnit*1000.0;
                feet=vInputUnit*3280.84;
                inch=vInputUnit*39370.08;
                kilometer=vInputUnit;
                mile=vInputUnit*0.62;
                yard=vInputUnit*1093.61;
                break;
            case 6:
                //for mile
                centimeter=vInputUnit*160934.39;
                meter=vInputUnit*1609.34;
                feet=vInputUnit*5280.0;
                inch=vInputUnit*63360.0;
                kilometer=vInputUnit*1.61;
                mile=vInputUnit;
                yard=vInputUnit*1760.0;
                break;
            case 7:
                centimeter=vInputUnit*91.44;
                meter=vInputUnit*0.91;
                feet=vInputUnit*3.0;
                inch=vInputUnit*36.0;
                kilometer=vInputUnit*0.001;
                mile=vInputUnit*0.001;
                yard=vInputUnit;
                break;
            default:
                Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }


    public void convertUnit(double vInputUnit, int cCaseUnit) {


        IcUnitDto = new UnitDto();
        int a = 5;
        switch (cCaseUnit) {

            case 1:
                //for bigha
                katha = vInputUnit * 20;
                meterSquare = vInputUnit * 6772.63;
                squareFeet = vInputUnit * 72900;
                bigha = vInputUnit;
                dhur = vInputUnit * 400;
                ropani = squareFeet / 5476;
                khetmuri = ropani / 25;
                aana = squareFeet / 342.25;
                paisa = squareFeet / 4 * 21.39;
                daam = squareFeet / 21.39;

                //unitDto.setKatha(a);
                IcUnitDto.setKatha(katha);
                //  Toast.makeText(context,"h"+unitDto.getKatha(),Toast.LENGTH_SHORT).show();
                //  Toast.makeText(context,"h"+String.valueOf(unitDto.getKatha()),Toast.LENGTH_SHORT).show();
                //unitDto.getKatha();
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setRopani(ropani);
                IcUnitDto.setBigha(bigha);
                return;

            case 2:
                //for katha
                dhur = vInputUnit * 20;
                squareFeet = vInputUnit * 3645;
                meterSquare = vInputUnit * 338.63;
                katha = vInputUnit;
                IcUnitDto.setDhur(dhur);
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setKatha(katha);
                break;

            case 3:
                //for dhur
                meterSquare = vInputUnit * 16.93;
                squareFeet = vInputUnit * 182.25;
                dhur = vInputUnit;
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setDhur(dhur);
                break;

            case 4:
                //for ropani
                aana = vInputUnit * vInputUnit; //Unchecked;
                paisa = vInputUnit * 64;
                meterSquare = vInputUnit * 508.72;
                squareFeet = vInputUnit * 5476;
                daam = vInputUnit * 256;
                ropani = vInputUnit;
                IcUnitDto.setAana(aana);
                IcUnitDto.setPaisa(paisa);
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setDaam(daam);
                IcUnitDto.setRopani(ropani);
                break;

            case 5:
                //for khetmuri
                ropani = vInputUnit * 25;
                khetmuri = vInputUnit;
                IcUnitDto.setRopani(ropani);
                IcUnitDto.setKhetmuri(khetmuri);
                break;

            case 6:
                //for aana
                paisa = vInputUnit * 4;
                meterSquare = vInputUnit * 31.80;
                squareFeet = vInputUnit * 342.25;
                daam = vInputUnit * 16;
                aana = vInputUnit;
                IcUnitDto.setPaisa(paisa);
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setDaam(daam);
                IcUnitDto.setAana(aana);
                break;

            case 7:
                //for paisa
                daam = vInputUnit * 4;
                meterSquare = vInputUnit * 7.95;
                squareFeet = vInputUnit * 85.56;
                paisa = vInputUnit;
                IcUnitDto.setDaam(daam);
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setSquareFeet(squareFeet);
                IcUnitDto.setPaisa(paisa);
                break;

            case 8:
                //for daam
                meterSquare = vInputUnit * 1.99;
                daam = vInputUnit;
                IcUnitDto.setMeterSquare(meterSquare);
                IcUnitDto.setDaam(daam);
                break;
            default:
                Toast.makeText(context, "Select Unit to convert", Toast.LENGTH_LONG).show();
                break;
        }
    }


    //Aftermath conversion
    public double getBigha() {
        return bigha;
    }

    public double getKatha() {
        return katha;
    }

    public double getDhur() {
        return dhur;
    }

    public double getRopani() {
        return ropani;
    }

    public double getKhetmuri() {
        return khetmuri;
    }

    public double getAana() {
        return aana;
    }

    public double getPaisa() {
        return paisa;
    }

    public double getDaam() {
        return daam;
    }

    public double getMeterSquare() {
        return meterSquare;
    }

    public double getSquareFeet() {
        return squareFeet;
    }

    public double getCentimeter() {
        return centimeter;
    }


    public double getFeet() {
        return feet;
    }

    public double getInch() {
        return inch;
    }

    public double getMeter() {
        return meter;
    }

    public double getKilometer() {
        return kilometer;
    }

    public double getMile() {
        return mile;
    }

    public double getYard() {
        return yard;
    }
}
