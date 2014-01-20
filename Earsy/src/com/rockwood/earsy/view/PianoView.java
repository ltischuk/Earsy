package com.rockwood.earsy.view;

import com.rockwood.earsy.view.graphics.BlackKeyPaint;
import com.rockwood.earsy.view.graphics.WhiteKeyPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PianoView extends View {
    WhiteKeyPaint whitePaint;
    BlackKeyPaint blackPaint;
    int numOfWhiteKeys = 7;
    int numOfBlackKeys = 5;
    Rect[] whiteKeys;
    Rect[] blackKeys;
    double blackWidthScale = 0.25;
    double blackHeightScale = 0.5;

    public PianoView(Context context, AttributeSet attrs) {
	super(context, attrs);
	init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
	for (Rect rect : whiteKeys) {
	    canvas.drawRect(rect, whitePaint);
	}
	for (Rect rect : blackKeys) {
	    canvas.drawRect(rect, blackPaint);
	}

    }

    /**
     * Initialize the rectangles and paint objects
     */
    private void init() {
	whitePaint = new WhiteKeyPaint();
	blackPaint = new BlackKeyPaint();
	whiteKeys = new Rect[numOfWhiteKeys];
	blackKeys = new Rect[numOfBlackKeys];
	
	for (int i=0 ;i<numOfWhiteKeys; i++) {
	    whiteKeys[i] = new Rect(0, 0, 0, 0);
	}
	
	for(int i = 0; i<numOfBlackKeys;i++)
	{
	    blackKeys[i] = new Rect(0, 0, 0, 0);
	}
	
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(
                parentWidth, parentHeight/2);
        
        scaleKeys(parentWidth/7, parentHeight/2);
        invalidate();
    }
    
    /**
     * Scale keys - first white keys get scaled then black keys according to placement of white keys
     * @param xWhiteRight coordinate of right x of first white key
     * @param yWhiteBottom coordinate of bottom y of first white key
     */
    private void scaleKeys(int xWhiteRight, int yWhiteBottom)
    {
	//handle white keys first
	int top = 0;
	int left = 0;	
	int right= xWhiteRight;
	int bottom = yWhiteBottom;
	int blackKeyWidth = (int) ((xWhiteRight*blackWidthScale)*2);
	
	for(Rect rect: whiteKeys)
	{	    
	    rect.set(left, top, right, bottom);
	    left+= xWhiteRight;
	    right += xWhiteRight;
	}	
	
	left =  (int) (xWhiteRight - (xWhiteRight*blackWidthScale));	
	bottom = (int) (yWhiteBottom *blackHeightScale);
	right = left + blackKeyWidth;
	
	for(int i=0;i<blackKeys.length;i++)
	{	  
	    //on second key make a space for the fact that no black key is between F and G
	    if(i==2)
	    {
		left+= blackKeyWidth*2;
		right += blackKeyWidth*2;
	    }
	    blackKeys[i].set(left, top, right, bottom);
	    left+= blackKeyWidth*2;
	    right += blackKeyWidth*2;
	    
	}
    } 
    
}
