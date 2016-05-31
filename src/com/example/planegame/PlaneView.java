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

	//�Զ���view�����������Ϸ�ķɻ�
	public PlaneView(Context context) {
		super(context);
		// ����ɻ�ͼƬ
		plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
		setFocusable(true);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint p = new Paint(); //��������
		canvas.drawBitmap(plane, currentX, currentY, p); //���Ʒɻ�
	}

}
