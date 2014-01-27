package com.rockwood.earsy.view.graphics;

import com.rockwood.earsy.utils.Utils;

import android.graphics.Color;
import android.graphics.Paint;

public class WhiteKeyTextPaint extends Paint
{
    public WhiteKeyTextPaint()
    {
	super();
	setStyle(Paint.Style.STROKE);
	setColor(Color.BLACK);    
	setFlags(Paint.ANTI_ALIAS_FLAG);
	this.setTextSize(Utils.NOTEHELPTEXTSIZE);
	setTextAlign(Align.CENTER);
    }
}
