package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import java.io.IOException;

public class PaintActivity extends AppCompatActivity {

    MyCanvas myCanvas;
    Button redBut, blueBut, greenBut, undoBut, clearBut, doneBut;
    TouchListener touchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        myCanvas = (MyCanvas) findViewById(R.id.myCanvas);


        Bundle extras = getIntent().getExtras();
        Bitmap pic = (Bitmap) extras.get("pic");
        myCanvas.setBackground(new BitmapDrawable(getResources(), pic));

        touchListener = new TouchListener(this);
        myCanvas.setOnTouchListener(touchListener);



        redBut = (Button) findViewById(R.id.redBut);
        redBut.setBackgroundColor(Color.RED);
        blueBut = (Button) findViewById(R.id.blueBut);
        blueBut.setBackgroundColor(Color.BLUE);
        greenBut = (Button) findViewById(R.id.greenBut);
        greenBut.setBackgroundColor(Color.GREEN);

        undoBut = (Button) findViewById(R.id.undoBut);
        clearBut = (Button) findViewById(R.id.clearBut);
        doneBut = (Button) findViewById(R.id.doneBut);

    }


    public void addPath(int id, float x, float y) {
        myCanvas.addPath(id, x, y);
    }

    public void updatePath(int id, float x, float y) {
        myCanvas.updatePath(id, x, y);
    }

    public void removePath(int id) {
        myCanvas.removePath(id);
    }
}