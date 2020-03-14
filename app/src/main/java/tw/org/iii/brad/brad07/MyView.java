package tw.org.iii.brad.brad07;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyView extends View {
    private Bitmap ballBmp;
    private MainActivity activity;
    private Resources resources;
    private Paint paint;
    private int viewW, viewH;
    private float ballW, ballH;
    private boolean isInit;

    public MyView(Context context) {
        super(context);

        //setBackgroundColor(Color.GREEN);
        setBackgroundResource(R.drawable.bg);

        activity = (MainActivity) context;
        resources = activity.getResources();


    }

    private void init(){
        isInit = true;

        paint = new Paint();
        paint.setAlpha(127);
        ballBmp = BitmapFactory.decodeResource(resources, R.drawable.ball);

        viewW = getWidth(); viewH = getHeight();
        ballW = viewW / 12f; ballH = ballW;

        Matrix matrix = new Matrix();
        matrix.postScale(ballW/ballBmp.getWidth(), ballH/ballBmp.getHeight());
        ballBmp = Bitmap.createBitmap(ballBmp, 0, 0,
                ballBmp.getWidth(), ballBmp.getHeight(), matrix,false);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();
        canvas.drawBitmap(ballBmp, 0, 0, null);

    }
}
