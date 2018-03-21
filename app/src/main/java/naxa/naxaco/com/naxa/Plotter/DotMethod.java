package naxa.naxaco.com.naxa.Plotter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shri on 2/25/18.
 */

public class DotMethod extends View {
    Paint DcoPaint=new Paint();
    Canvas DcoCanvas;
    public DotMethod(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public DotMethod(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.DcoCanvas=canvas;
        DcoCanvas.drawCircle(300,300,50,DcoPaint);
    }
}
