package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class WhiteKeyTextPaint extends Paint
{
    public WhiteKeyTextPaint()
    {
	super();
	setStyle(Paint.Style.STROKE);
	setColor(Color.BLACK);    
	setStrokeWidth(3);
	setFlags(Paint.ANTI_ALIAS_FLAG);
	setTextAlign(Align.CENTER);
    }
}
