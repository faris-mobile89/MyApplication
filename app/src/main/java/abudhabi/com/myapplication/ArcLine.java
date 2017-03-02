package abudhabi.com.myapplication;

/**
 * Created by Faris on 2/28/17.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
//http://stackoverflow.com/questions/34743177/how-to-get-point-on-of-any-curved-line

//http://blogs.sitepointstatic.com/examples/tech/canvas-curves/bezier-curve.html

/**
 * Created by Faris on 2/28/17.
 */

public class ArcLine extends View {

    Paint paint;
    Path path;

    public ArcLine(Context context) {
        super(context);
        init();
    }

    public ArcLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(17);
        paint.setAntiAlias(true);
    }

    int w = 0;
    int h = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        w = canvas.getWidth();
        h = canvas.getHeight();

        //left point
        float x1 = 0;//fixed left point
        float y1 = 0;

        float x2 = w/2;//fixed
        float y2 = h/3;//fixed center point

        //Right  point
        float x3 = w;//fixed
        float y3 = 0;//fixed

        final Path path = new Path();

        //path.moveTo(0, 0);
        path.cubicTo(x1, y1, x2, y2, x3, y3);
        canvas.drawPath(path, paint);
    }
}
