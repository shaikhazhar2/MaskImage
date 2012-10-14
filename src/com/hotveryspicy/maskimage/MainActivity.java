package com.hotveryspicy.maskimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//RUNTIME
		//        ImageView mImageView= (ImageView)findViewById(R.id.imageview_id);
		//        makeMaskImage(mImageView, R.drawable.nature);
	}

	//Method of creating mask runtime
	public void makeMaskImage(ImageView mImageView, int mContent)
	{
		Bitmap original = BitmapFactory.decodeResource(getResources(), mContent);
		Bitmap mask = BitmapFactory.decodeResource(getResources(),R.drawable.mask);
		Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Config.ARGB_8888);
		Canvas mCanvas = new Canvas(result);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
		mCanvas.drawBitmap(original, 0, 0, null);
		mCanvas.drawBitmap(mask, 0, 0, paint);
		paint.setXfermode(null);
		mImageView.setImageBitmap(result);
		mImageView.setScaleType(ScaleType.CENTER);
		mImageView.setBackgroundResource(R.drawable.frame);
	}
}
