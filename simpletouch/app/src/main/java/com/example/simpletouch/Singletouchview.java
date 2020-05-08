package com.example.simpletouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;


public class  Singletouchview extends View {
    int ipaint=0;
    int ipath=0;
    ArrayList<Paint> paintArrayList=new ArrayList<>();
    ArrayList<Path> pathArrayList=new ArrayList<>();

    public Singletouchview(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintArrayList.add(new Paint());
        pathArrayList.add(new Path());
        paintArrayList.get(ipaint).setStrokeWidth(10.0f);
        paintArrayList.get(ipaint).setColor(Color.BLACK);
        paintArrayList.get(ipaint).setStyle(Paint.Style.STROKE);
        paintArrayList.get(ipaint).setStrokeJoin(Paint.Join.ROUND);//꺾일때 그 꼭짓점을 조금더 부드럽게(라운드) 해주는 것
        paintArrayList.get(ipaint).setAntiAlias(true);//계단현상(Alias)을 매끄럽게해주는것,성능에는 마이너

    }

    @Override
    protected void onDraw(Canvas canvas) {
            for (int i = 0; i < ipath; i++) {
                canvas.drawPath(pathArrayList.get(i), paintArrayList.get(i));
            }
            if(!pathArrayList.isEmpty())
            canvas.drawPath(pathArrayList.get(ipath), paintArrayList.get(ipaint));

    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventx = event.getX();
        float eventy = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pathArrayList.get(ipath).moveTo(eventx, eventy);//여기서 끊고 저기서 새로그리는;
                break;
            case MotionEvent.ACTION_MOVE:
                pathArrayList.get(ipath).lineTo(eventx, eventy);
                break;
            case MotionEvent.ACTION_UP://특별히 할 내용없음
                break;
            default:
                return false;//딱히 실행시켜줄 내용없
        }

        invalidate();
        return true;
    }
    public void clearPath(){
        pathArrayList.clear();
        paintArrayList.clear();
        ipath=0;
        ipaint=0;
        invalidate();

    }
    public void setColor(int c){
        paintArrayList.add(new Paint());
        pathArrayList.add(new Path());
        ipaint++;
        ipath++;
        paintArrayList.get(ipaint).setColor(c);
        invalidate();
    }
}
