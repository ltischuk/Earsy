package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class TouchedKeyPaint extends Paint
{
	public TouchedKeyPaint()
	{
		super();
		setStyle(Paint.Style.FILL);
		setColor(Color.CYAN);
		setStyle(Paint.Style.STROKE);
		setColor(Color.BLACK);
		setStrokeWidth(3);
		setFlags(Paint.ANTI_ALIAS_FLAG);
		setTextAlign(Align.CENTER);

	}
}
