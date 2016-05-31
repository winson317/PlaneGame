package com.example.planegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlaneView extends View {
	
	public float currentX;
	public float currentY;
	Bitmap plane;

	//自定义view，负责绘制游戏的飞机
	public PlaneView(Context context) {
		super(context);
		// 定义飞机图片
		plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
		setFocusable(true);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint p = new Paint(); //创建画笔
		canvas.drawBitmap(plane, currentX, currentY, p); //绘制飞机
	}

}
