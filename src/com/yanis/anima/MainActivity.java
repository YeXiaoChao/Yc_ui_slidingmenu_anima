package com.yanis.anima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn1, btn2, btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inintView();
	}

	private void inintView() {
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			startActivity(new Intent(MainActivity.this, FirstActivity.class));
			break;
		case R.id.btn2:
			startActivity(new Intent(MainActivity.this, SecondActivity.class));
			break;
		case R.id.btn3:
			startActivity(new Intent(MainActivity.this, ThirdActivity.class));
			break;

		default:
			break;
		}
	}
}
