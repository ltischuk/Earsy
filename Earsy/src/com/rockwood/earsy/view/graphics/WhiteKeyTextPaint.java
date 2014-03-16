package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class WhiteKeyTextPaint extends Paint
{
	public WhiteKeyTextPaint(int textSize)
	{
		super();
		setStyle(Paint.Style.STROKE);
		setColor(Color.BLACK);
		setFlags(Paint.ANTI_ALIAS_FLAG);
		this.setTextSize(textSize);
		setTextAlign(Align.CENTER);
	}
}
