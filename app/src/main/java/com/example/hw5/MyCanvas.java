package com.example.hw5;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;


public class MyCanvas extends View {
    HashMap <Integer, Path> activePaths;
    Paint pathPaint;

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        activePaths = new HashMap<>();
        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setColor(Color.RED);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(Path path: activePaths.values()){
            canvas.drawPath(path, pathPaint);
        }
        super.onDraw(canvas);
    }

    public void addPath(int id, float x, float y) {
        Path path = new Path();
        path.moveTo(x, y);
        activePaths.put(id, path);
        invalidate();
    }

    public void updatePath(int id, float x, float y) {
        Path path = activePaths.get(id);
        if(path != null){
            path.lineTo(x, y);
        }
        invalidate();
    }

    public void removePath(int id) {
        if(activePaths.containsKey(id)){
            activePaths.remove(id);
        }
        invalidate();
    }

    public void setColor(int id) {
        if (id == 0) {
            pathPaint.setColor(Color.RED);
        }
        else if (id == 1) {
            pathPaint.setColor(Color.BLUE);
        }
        else if (id == 2) {
            pathPaint.setColor(Color.GREEN);
        }
    }
}