package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class BlackKeyTextPaint extends Paint
{
	public BlackKeyTextPaint(int textSize)
	{
		super();
		setStyle(Paint.Style.STROKE);
		setColor(Color.WHITE);
		setFlags(Paint.ANTI_ALIAS_FLAG);
		this.setTextSize(textSize);
		setTextAlign(Align.CENTER);
	}
}
