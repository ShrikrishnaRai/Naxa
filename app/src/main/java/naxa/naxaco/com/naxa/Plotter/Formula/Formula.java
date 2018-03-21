package naxa.naxaco.com.naxa.Plotter.Formula;

/**
 * Created by shri on 2/26/18.
 */

public class Formula {
    float total;
    public  float totalArea(int a,int b,int c){
        float sa=a+b+c;
        float s=sa/2;
        float first=s-a;
        float second=s-b;
        float third=s-c;
        float mulTotal=s*first*second*third;
        return total= (float) Math.sqrt(mulTotal);
    }
}
