package com.rockwood.earsy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.utils.Utils;
import com.rockwood.earsy.view.graphics.BlackKeyPaint;
import com.rockwood.earsy.view.graphics.BlackKeyTextPaint;
import com.rockwood.earsy.view.graphics.TouchedKeyPaint;
import com.rockwood.earsy.view.graphics.WhiteKeyPaint;
import com.rockwood.earsy.view.graphics.WhiteKeyTextPaint;

public class PianoView extends View
{
	WhiteKeyPaint whitePaint;
	BlackKeyPaint blackPaint;
	WhiteKeyTextPaint wkTextPaint;
	BlackKeyTextPaint bkTextPaint;
	TouchedKeyPaint hitKeyPaint;
	int numOfWhiteKeys = 7;
	int numOfBlackKeys = 5;
	int blackKeySpacerVal = 2;
	PianoKey[] whiteKeys = null;
	PianoKey[] blackKeys = null;
	PianoKey hitKey = null;

	double viewDimensionScale = .75;
	double blackWidthScale = 0.25;
	double blackHeightScale = 0.5;

	/**
	 * Initialize PianoView
	 * 
	 * @param context
	 * @param attrs
	 */
	public PianoView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		for (PianoKey key : whiteKeys) {
			if (hitKey != null && key.equals(hitKey)) {
				canvas.drawRect(key.getRect(), hitKeyPaint);
			} else {
				canvas.drawRect(key.getRect(), whitePaint);
			}

			canvas.drawText(key.getNote().getDisplay(), key.getXText(),
					key.getYText(), wkTextPaint);
		}
		for (PianoKey key : blackKeys) {
			if (hitKey != null && key.equals(hitKey)) {
				canvas.drawRect(key.getRect(), hitKeyPaint);
			} else {
				canvas.drawRect(key.getRect(), blackPaint);
			}
			canvas.drawText(key.getNote().getDisplay().substring(0, 2),
					key.getXText(), key.getYText(), bkTextPaint);
			canvas.drawText(key.getNote().getDisplay().substring(2, 4),
					key.getXText(), key.getYText() + bkTextPaint.getTextSize(),
					bkTextPaint);
		}

	}

	/**
	 * Initialize the rectangles and paint objects
	 */
	private void init()
	{

		MusicNote[] noteValues = MusicNote.values();
		int scaledSize = getResources().getDimensionPixelSize(
				R.dimen.piano_view_note_font_size);
		wkTextPaint = new WhiteKeyTextPaint(scaledSize);
		bkTextPaint = new BlackKeyTextPaint(scaledSize);
		whitePaint = new WhiteKeyPaint();
		blackPaint = new BlackKeyPaint();
		hitKeyPaint = new TouchedKeyPaint();

		whiteKeys = new PianoKey[numOfWhiteKeys];
		blackKeys = new PianoKey[numOfBlackKeys];

		for (int i = 0; i < numOfWhiteKeys; i++) {
			whiteKeys[i] = new PianoKey(noteValues[i]);
		}
		int offset = Utils.getIndexOfFlatNotes();
		for (int i = 0; i < numOfBlackKeys; i++) {
			blackKeys[i] = new PianoKey(noteValues[offset + i]);
		}

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
		int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
		this.setMeasuredDimension(parentWidth,
				(int) (parentHeight * viewDimensionScale));

		scalePiano(parentWidth / numOfWhiteKeys,
				(int) (parentHeight * viewDimensionScale));
		invalidate();
	}

	/**
	 * Scale keys - first white keys get scaled then black keys according to
	 * placement of white keys
	 * 
	 * @param xWhiteRight
	 *            coordinate of right x of first white key
	 * @param yWhiteBottom
	 *            coordinate of bottom y of first white key
	 */
	private void scalePiano(int xWhiteRight, int yWhiteBottom)
	{
		// handle white keys first
		int top = 0;
		int left = 0;
		int right = xWhiteRight;
		int bottom = yWhiteBottom;
		int blackKeyWidth = (int) ((xWhiteRight * blackWidthScale) * blackKeySpacerVal);

		for (PianoKey key : whiteKeys) {
			key.resizeKey(left, top, right, bottom);
			left += xWhiteRight;
			right += xWhiteRight;
		}

		left = (int) (xWhiteRight - (xWhiteRight * blackWidthScale));
		bottom = (int) (yWhiteBottom * blackHeightScale);
		right = left + blackKeyWidth;

		for (int i = 0; i < blackKeys.length; i++) {
			// on second key make a space for the fact that no black key is
			// between F and G
			if (i == blackKeySpacerVal) {
				left += blackKeyWidth * blackKeySpacerVal;
				right += blackKeyWidth * blackKeySpacerVal;
			}
			blackKeys[i].resizeKey(left, top, right, bottom);
			left += blackKeyWidth * blackKeySpacerVal;
			right += blackKeyWidth * blackKeySpacerVal;

		}
	}

	public void resetView()
	{
		hitKey = null;
		invalidate();
	}

	/**
	 * Return the note touched from user touching piano
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public MusicNote getNoteTouched(float x, float y)
	{
		int touchX = (int) x;
		int touchY = (int) y;
		// first see if its a white key then check black key coordinates
		for (PianoKey whiteKey : whiteKeys) {
			if (whiteKey.getRect().contains(touchX, touchY)) {
				hitKey = whiteKey;
				// check if its on a black key
				for (PianoKey blackKey : blackKeys) {
					if (blackKey.getRect().contains((int) x, (int) y)) {
						hitKey = blackKey;
					}

				}
				break;
			}
		}
		invalidate();
		return hitKey.getNote();
	}

}
