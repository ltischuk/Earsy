package com.rockwood.earsy.view;

import com.rockwood.earsy.view.widgets.WhiteKeyPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PianoView extends View 
{
    WhiteKeyPaint paint = new WhiteKeyPaint();
    Rect [] rectShapes = new Rect[7];
    int rectWidth;
    int rectHeight;

    public PianoView(Context context, AttributeSet attrs) 
    {
	super(context, attrs);	
	setRectangles();
    }
      

    @Override
    protected void onDraw(Canvas canvas) 
    {
    super.onDraw(canvas);
    for(Rect rect : rectShapes)
    {
	canvas.drawRect(rect, paint);
    }
    
    }
    
    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        rectWidth = xNew/7;
        rectHeight = yNew/2;
   }

    private void setRectangles() 
    {
	int startPos = 0;
	rectWidth = 0;
	rectHeight = 0;
	for(int i=0;i<7;i++)
	{	    
	    rectShapes[i] = new Rect(startPos,0, rectWidth,rectHeight);
	    startPos+= rectWidth;
	}	
    }
}
