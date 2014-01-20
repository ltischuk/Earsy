package com.rockwood.earsy.view.graphics;

import android.graphics.Color;
import android.graphics.Paint;

public class BlackKeyPaint extends Paint 
{
    public BlackKeyPaint()
    {
	super();
	 setStyle(Paint.Style.FILL);
	 setColor(Color.BLACK); 
	 setFlags(Paint.ANTI_ALIAS_FLAG);
    }    
    
}
