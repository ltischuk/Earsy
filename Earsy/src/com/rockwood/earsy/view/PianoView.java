package com.rockwood.earsy.view;

import com.rockwood.earsy.view.graphics.WhiteKeyPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PianoView extends View {
    WhiteKeyPaint paint;
    int numOfKeys = 7;
    Rect[] whiteKeys;
    int rectWidth;
    int rectHeight;
    int defaultWidth = 50;
    int defaultHeight = 300;

    public PianoView(Context context, AttributeSet attrs) {
	super(context, attrs);
	init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	for (Rect rect : whiteKeys) {
	    canvas.drawRect(rect, paint);
	}

    }

    private void init() {
	paint = new WhiteKeyPaint();
	int left = 0;
	int top = 0;
	rectWidth = defaultWidth;
	rectHeight = defaultHeight;
	whiteKeys = new Rect[numOfKeys];
	for (int i=0 ;i<numOfKeys; i++) {
	    whiteKeys[i] = new Rect(left, top, rectWidth, rectHeight);
	    left += defaultWidth;
	    rectWidth += defaultWidth;
	}
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(
                parentWidth, parentHeight/2);
        setRectanglesToDimensions(parentWidth/7, parentHeight/2);
        invalidate();
    }
    
    private void setRectanglesToDimensions(int x, int y)
    {
	int left = 0;
	int top = 0;
	int right= x;
	int bottom = y;
	for(Rect rect: whiteKeys)
	{
	    rect.set(left, top, right, bottom);
	    left+= x;
	    right+= x;
	}
    }
    
    
}
