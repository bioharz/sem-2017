package at.shokri.ninemensmorris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Board extends View {

    int size;

    public Board(Context context) {
        super(context);
    }

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Board(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Board(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //int size;
        if (width > height) {
            size = height;
        } else {
            size = width;
        }
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int color = Color.WHITE;

        Paint linePaint = new Paint();
        linePaint.setStrokeWidth(10f);
        linePaint.setColor(color);

        Paint circlePaint = new Paint();
        circlePaint.setColor(color);

        float margin = (float) size / 8f;

        int radius = 25;

        //square outside
        canvas.drawLine(margin, margin, size - margin, margin, linePaint);
        canvas.drawLine(margin, size - margin, size - margin, size - margin, linePaint);
        canvas.drawLine(margin, margin, margin, size - margin, linePaint);
        canvas.drawLine(size - margin, size - margin, size - margin, margin, linePaint);


        //square middle
        canvas.drawLine(margin * 2, margin * 2, size - margin * 2, margin * 2, linePaint);
        canvas.drawLine(margin * 2, size - margin * 2, size - margin * 2, size - margin * 2, linePaint);
        canvas.drawLine(margin * 2, margin * 2, margin * 2, size - margin * 2, linePaint);
        canvas.drawLine(size - margin * 2, size - margin * 2, size - margin * 2, margin * 2, linePaint);

        //square inside
        canvas.drawLine(margin * 3, margin * 3, size - margin * 3, margin * 3, linePaint);
        canvas.drawLine(margin * 3, size - margin * 3, size - margin * 3, size - margin * 3, linePaint);
        canvas.drawLine(margin * 3, margin * 3, margin * 3, size - margin * 3, linePaint);
        canvas.drawLine(size - margin * 3, size - margin * 3, size - margin * 3, margin * 3, linePaint);

        //lines inside
        canvas.drawLine(margin * 4, margin, margin * 4, margin * 3, linePaint);
        canvas.drawLine(margin * 4, size - margin, margin * 4, size - margin * 3, linePaint);
        canvas.drawLine(margin, margin * 4, margin * 3, margin * 4, linePaint);
        canvas.drawLine(size - margin, margin * 4, size - margin * 3, margin * 4, linePaint);

        //circles
        canvas.drawCircle(margin, margin, radius, circlePaint);
        canvas.drawCircle(margin * 4, margin, radius, circlePaint);
        canvas.drawCircle(size - margin, margin, radius, circlePaint);
        canvas.drawCircle(margin * 2, margin * 2, radius, circlePaint);
        canvas.drawCircle(margin * 4, margin * 2, radius, circlePaint);
        canvas.drawCircle(size - margin * 2, margin * 2, radius, circlePaint);
        canvas.drawCircle(margin * 3, margin * 3, radius, circlePaint);
        canvas.drawCircle(margin * 4, margin * 3, radius, circlePaint);
        canvas.drawCircle(size - margin * 3, margin * 3, radius, circlePaint);
        canvas.drawCircle(margin, margin * 4, radius, circlePaint);
        canvas.drawCircle(margin * 2, margin * 4, radius, circlePaint);
        canvas.drawCircle(margin * 3, margin * 4, radius, circlePaint);
        canvas.drawCircle(size - margin * 3, margin * 4, radius, circlePaint);
        canvas.drawCircle(size - margin * 2, margin * 4, radius, circlePaint);
        canvas.drawCircle(size - margin, margin * 4, radius, circlePaint);
        canvas.drawCircle(margin * 3, size - margin * 3, radius, circlePaint);
        canvas.drawCircle(margin * 4, size - margin * 3, radius, circlePaint);
        canvas.drawCircle(size - margin * 3, size - margin * 3, radius, circlePaint);
        canvas.drawCircle(margin * 2, size - margin * 2, radius, circlePaint);
        canvas.drawCircle(margin * 4, size - margin * 2, radius, circlePaint);
        canvas.drawCircle(size - margin * 2, size - margin * 2, radius, circlePaint);
        canvas.drawCircle(margin, size - margin, radius, circlePaint);
        canvas.drawCircle(margin * 4, size - margin, radius, circlePaint);
        canvas.drawCircle(size - margin, size - margin, radius, circlePaint);

    }
}