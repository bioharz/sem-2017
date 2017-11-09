package at.shokri.ballgames;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bioharz on 02/11/2017.
 */

public class Pad extends View {

    protected float sizeFactor;
    protected float with;
    protected float height;


    public Pad(Context context) {
        super(context);
    }

    public Pad(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Pad(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Pad(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int withMeasureSpec, int heighMeasureSpec) {
        sizeFactor = MeasureSpec.getSize(withMeasureSpec) / 10;
        with = sizeFactor * 1.5f;
        height = sizeFactor *  0.4f;

        setY(MeasureSpec.getSize(heighMeasureSpec) - height);

        setMeasuredDimension((int) with, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.RED);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawRoundRect(0,0,with,height*0.75f,10,10, paint);
    }
}
