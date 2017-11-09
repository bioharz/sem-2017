package fhkufstein.ac.at.ue2_chomp;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class Piece extends AppCompatButton {

    public Piece(Context context) {
        super(context);
    }

    public Piece(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Piece(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.getSize(widthMeasureSpec)/5; //auch hier müsste der 5er dynamisch sein
        setMeasuredDimension(size,size);
    }
}
