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
	
	private int speed = 12;  //定义飞机移动的速度

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //去掉窗口标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //全屏显示
        final PlaneView planeView = new PlaneView(this);  //创建PlaneView组件
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.back);
        
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //获取屏幕宽和高
        int screenWidth = display.getWidth();
        int screenHeight = display.getHeight();
        //设置飞机的初始位置
        planeView.currentX = screenWidth / 2;
        planeView.currentY = screenHeight - 40;
        //为draw组件键盘事件绑定监听器
        planeView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event) {
				//获取哪个键触发的事件
				switch (event.getKeyCode()) 
				{
				case KeyEvent.KEYCODE_DPAD_DOWN:   //控制飞机下移
					planeView.currentY += speed;
					break;

				case KeyEvent.KEYCODE_DPAD_UP:     //控制飞机上移
					planeView.currentY -= speed;
					break;
					
				case KeyEvent.KEYCODE_DPAD_LEFT:  //控制飞机左移
					planeView.currentX -= speed;
					break;
					
				case KeyEvent.KEYCODE_DPAD_RIGHT:  //控制飞机右移
					planeView.currentX += speed;
					break;
				}
				
				planeView.invalidate();  //通知view组件重绘
				return true;
			}
		});      
        
    }

}
