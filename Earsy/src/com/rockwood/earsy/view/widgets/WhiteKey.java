package com.rockwood.earsy.view.widgets;


import android.graphics.Canvas;
import android.graphics.Rect;

public class WhiteKey 
{
    WhiteKeyPaint paint = new WhiteKeyPaint();
    
    Rect rect = new Rect(0,0,200,100); 

    public void onDraw(Canvas canvas) 
    {
	int viewWidth = canvas.getWidth()/7;
	int viewHeight = canvas.getHeight();
	rect.set(0, 0, viewWidth, viewHeight);
        canvas.drawRect(rect, paint);
    }
    
}
