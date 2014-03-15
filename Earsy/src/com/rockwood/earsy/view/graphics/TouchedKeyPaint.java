package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class TouchedKeyPaint extends Paint
{
	public TouchedKeyPaint()
	{
		super();
		setStyle(Paint.Style.STROKE);
		setColor(Color.BLACK);
		setStrokeWidth(3);
		setStyle(Paint.Style.FILL);
		setColor(Color.DKGRAY);
		setFlags(Paint.ANTI_ALIAS_FLAG);
		setTextAlign(Align.CENTER);

	}
}
