package naxa.naxaco.com.naxa.Plotter.Formula;

/**
 * Created by shri on 2/26/18.
 */

public class FormulaTraingleDto {
    private  int a;
    private  int b;
    private  int c;
    public FormulaTraingleDto(){

    }

    public FormulaTraingleDto(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
