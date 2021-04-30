package com.example.hw5;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;
import java.util.HashMap;


public class MyCanvas extends View {
    HashMap <Integer, Path> activePaths;
    Paint pathPaint;
    ArrayList<HashMap <Integer, Path>> allLines;
    ArrayList<Paint> allPaints;
    ArrayList<Bitmap> allIcons;
    ArrayList<float[]> iconPlaces;

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        activePaths = new HashMap<>();
        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setColor(Color.RED);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeWidth(10);
        allLines = new ArrayList<HashMap<Integer, Path>>();
        allPaints = new ArrayList<Paint>();
        allIcons = new ArrayList<Bitmap>();
        iconPlaces = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < allIcons.size(); i++) {
            canvas.drawBitmap(allIcons.get(i),iconPlaces.get(i)[0], iconPlaces.get(i)[1] , null);
        }
        assert(allLines.size() == allPaints.size());
        for (int i = 0; i < allLines.size(); i++) {
            for (Path path: allLines.get(i).values()) {
                canvas.drawPath(path, allPaints.get(i));
            }
        }
        for(Path path: activePaths.values()){
            canvas.drawPath(path, pathPaint);
        }

        super.onDraw(canvas);
    }

    public void onEndPath() {
        allLines.add(activePaths);
        allPaints.add(pathPaint);
        activePaths = new HashMap<>();
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
        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeWidth(10);
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

    public void onClear() {
        allLines.clear();
        allPaints.clear();
        allIcons.clear();
        iconPlaces.clear();
        invalidate();
    }

    public void onUndo() {
        if (!allLines.isEmpty()) {
            allLines.remove(allLines.size() - 1);
            allPaints.remove(allPaints.size() - 1);
            invalidate();
        }
    }

    public void addIcon(int i, MotionEvent e) {
        float[] arr = new float[]{e.getX(), e.getY()};
        iconPlaces.add(arr);
        if (i == 0) {
            Bitmap img = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hokie_bird), 100, 100, false);
            allIcons.add(img);
        }
        else if (i == 1){
            Bitmap img = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.vt_logo), 100, 100, false);
            allIcons.add(img);
        }
        invalidate();
    }
}