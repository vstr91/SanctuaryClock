package br.com.vostre.sanctuaryclock;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Almir on 19/10/2017.
 */

public class Clock extends View {

    Paint paint;

    public Clock(Context context) {
        super(context);
        init();
    }

    public Clock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Clock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth()/2;
        float centerY = getHeight()/2;

        System.out.println(centerX+" | "+centerY);

//        rectF.set(400, 100, 400, 100);
        canvas.drawCircle(centerX, centerY, 500, paint);
        Drawable d = getResources().getDrawable(R.drawable.clock);
        d.setBounds((int)centerX-500, (int)centerY-500, (int)centerX+500, (int)centerY+500);
        d.draw(canvas);

        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        int r = 450;
        paint.setTextSize(30);

        for(int i = 1; i <= 12; i++){

            float hour = i;///60f;

            Drawable dr = ContextCompat.getDrawable(getContext(), R.drawable.fire);
            //Centre the drawing
            int bitMapWidthCenter = getWidth()/2;
            int bitMapheightCenter = getHeight()/2;
            dr.setBounds((int)(centerX+(r-15)*Math.cos(Math.toRadians((hour / 12.0f * 360.0f)-90f))),
                    (int)(centerY+(r-10)*Math.sin(Math.toRadians((hour / 12.0f * 360.0f)-90f))), 20, 20);
            //And draw it...
            dr.draw(canvas);

//            canvas.drawText(String.valueOf(i), (float)(centerX+(r-15)*Math.cos(Math.toRadians((hour / 12.0f * 360.0f)-90f))),
//                    (float)(centerY+(r-10)*Math.sin(Math.toRadians((hour / 12.0f * 360.0f)-90f))), paint);

//            canvas.drawLine(centerX, centerY, (float)(centerX+(r-15)*Math.cos(Math.toRadians((hour / 12.0f * 360.0f)-90f))),
//                    (float)(centerY+(r-10)*Math.sin(Math.toRadians((hour / 12.0f * 360.0f)-90f))), paint);
        }

//        canvas.drawLine(centerX, centerY, centerX/4, centerY/2, paint);
//        canvas.drawLine(centerX, centerY, centerX+500, centerY*2, paint);


        paint.setColor(Color.GREEN);

//        canvas.drawLine(centerX, centerY, centerX, centerY+500, paint);
//        canvas.drawLine(centerX, centerY, centerX, centerY-500, paint);
//        canvas.drawLine(centerX, centerY, centerX+500, centerY, paint);
//        canvas.drawLine(centerX, centerY, centerX-500, centerY, paint);
//        canvas.drawOval(rectF, paint);

    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);
    }

}
