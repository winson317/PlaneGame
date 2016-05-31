package com.example.planegame;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


public class PlaneGame extends Activity {
	
	private int speed = 12;  //����ɻ��ƶ����ٶ�

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //ȥ�����ڱ���
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //ȫ����ʾ
        final PlaneView planeView = new PlaneView(this);  //����PlaneView���
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.back);
        
        //��ȡ���ڹ�����
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //��ȡ��Ļ��͸�
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();
        //���÷ɻ��ĳ�ʼλ��
        planeView.currentX = screenWidth / 2;
        planeView.currentY = screenHeight - 40;
        //Ϊdraw��������¼��󶨼�����
        planeView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event) {
				//��ȡ�ĸ����������¼�
				switch (event.getKeyCode()) 
				{
				case KeyEvent.KEYCODE_DPAD_DOWN:   //���Ʒɻ�����
					planeView.currentY += speed;
					break;

				case KeyEvent.KEYCODE_DPAD_UP:     //���Ʒɻ�����
					planeView.currentY -= speed;
					break;
					
				case KeyEvent.KEYCODE_DPAD_LEFT:  //���Ʒɻ�����
					planeView.currentX -= speed;
					break;
					
				case KeyEvent.KEYCODE_DPAD_RIGHT:  //���Ʒɻ�����
					planeView.currentX += speed;
					break;
				}
				
				planeView.invalidate();  //֪ͨview����ػ�
				return true;
			}
		});      
        
    }

}
