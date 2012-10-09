package com.example.phonevibrator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Vibrate extends Activity {
	ToggleButton tb;
	Vibrator vt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vibrate);

		vt = (Vibrator) getApplication().getSystemService(
				Service.VIBRATOR_SERVICE);
		// 得到Vibrator对象
		tb = (ToggleButton) findViewById(R.id.toggleButton1);
		tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					// vt.vibrate(1000);
					// 最简单的震动，后面参数为振动持续的时间
					long[] l = new long[] { 1000, 5000, 2000, 1000, 1000, 500 };
					// 周期振动,索引0或偶数为间隔时间，索引为单数为振动时间（毫秒）
					vt.vibrate(l, 1);
					// 传入long数组，和重复振动开始的索引，这里是1,就是第二次执行的是{5000,2000,1000,1000,500}这样一个数组
				} else {
					vt.cancel();
				}
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_vibrate, menu);
		return true;
	}
}
