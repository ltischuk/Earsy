package com.rockwood.earsy.view.graphics;

import com.rockwood.earsy.utils.Utils;

import android.graphics.Color;
import android.graphics.Paint;

public class BlackKeyTextPaint extends Paint
{
    public BlackKeyTextPaint()
    {
	super();
	setStyle(Paint.Style.STROKE);
	setColor(Color.WHITE);    
	setFlags(Paint.ANTI_ALIAS_FLAG);
	this.setTextSize(Utils.NOTEHELPTEXTSIZE);
	setTextAlign(Align.CENTER);
    }
}
