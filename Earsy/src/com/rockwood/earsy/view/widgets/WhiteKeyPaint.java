package com.rockwood.earsy.view.widgets;

import android.graphics.Color;
import android.graphics.Paint;

public class WhiteKeyPaint extends Paint 
{
    public WhiteKeyPaint()
    {
	super();
	 setStyle(Paint.Style.FILL);
	 setColor(Color.WHITE); 
	 setStyle(Paint.Style.STROKE);
	 setColor(Color.BLACK);    
    }    
    
}
