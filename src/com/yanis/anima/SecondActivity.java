package com.yanis.anima;

import android.graphics.Canvas;
import android.os.Bundle;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 
 * @author Yanis
 * @Description 当滑动菜单栏打开时滑动伸缩的效果
 */
public class SecondActivity extends SlidingFragmentActivity {
	private CanvasTransformer mTransformer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initAnimation();

		initSlidingMenu();

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	/**
	 * 初始化滑动菜单
	 */
	private void initSlidingMenu() {
		// 设置主界面视图
		setContentView(R.layout.layout_right);
		// 设置滑动菜单视图
		setBehindContentView(R.layout.layout_left);
		// 设置滑动菜单的属性值
		SlidingMenu sm = getSlidingMenu();
		// 根据dimension资源文件的ID来设置下方视图的偏移量,此处是220dp
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);

		setSlidingActionBarEnabled(true);
	}

	/**
	 * 初始化动画效果
	 */
	private void initAnimation() {
		mTransformer = new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.scale(percentOpen, 1, 0, 0);
			}

		};
	}
}
