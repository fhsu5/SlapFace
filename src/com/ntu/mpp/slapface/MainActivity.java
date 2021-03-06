/*
 * Wifi Connecter
 * 
 * Copyright (c) 20101 Kevin Yuan (farproc@gmail.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 **/ 

package com.ntu.mpp.slapface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private ImageButton btnHost;
	private ImageButton btnClient;
//	private Button faceButton;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	//Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
    	
    	btnHost = (ImageButton) findViewById(R.id.btnHost);
    	btnHost.setOnClickListener(mBtnHostOnClick);
//    	faceButton=(Button)findViewById(R.id.faceTest);
//    	faceButton.setOnClickListener(new Button.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(MainActivity.this, GameActivity.class);
//				startActivity(intent);
//			}
//		});
    	
    	btnClient = (ImageButton) findViewById(R.id.btnClient);
    	btnClient.setOnClickListener(mBtnClientOnClick);
    	
    	Log.d("Peter", "haha");
	}
	
	@Override
	protected void onResume() {
		HostActivity.releaseServerAgent();
		ClientActivity.releaseClientAgent();
		super.onResume();
	}
	
	private OnClickListener mBtnHostOnClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, HostActivity.class);
			startActivity(intent);
//			finish();
		}
	};
	
	private OnClickListener mBtnClientOnClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, ClientActivity.class);
			startActivity(intent);
//			finish();
		}
	};
}