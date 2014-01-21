package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class BlackKeyTextPaint extends Paint
{
    public BlackKeyTextPaint()
    {
	super();
	setStyle(Paint.Style.STROKE);
	setColor(Color.WHITE);    
	setStrokeWidth(3);
	setFlags(Paint.ANTI_ALIAS_FLAG);
	setTextAlign(Align.CENTER);
    }
}
