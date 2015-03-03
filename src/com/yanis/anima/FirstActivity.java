package com.yanis.anima;

import android.graphics.Canvas;
import android.os.Bundle;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * 
 * @author Yanis
 * @Description ����ʱ���ŵ�Ч��
 */
public class FirstActivity extends SlidingFragmentActivity {
	private CanvasTransformer mTransformer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initAnimation();

		initSlidingMenu();

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	/**
	 * ��ʼ�������˵�
	 */
	private void initSlidingMenu() {
		// ������������ͼ
		setContentView(R.layout.layout_right);
		// ���û����˵���ͼ
		setBehindContentView(R.layout.layout_left);
		// ���û����˵�������ֵ
		SlidingMenu sm = getSlidingMenu();
		// ����dimension��Դ�ļ���ID�������·���ͼ��ƫ����,�˴���220dp
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);

		setSlidingActionBarEnabled(true);
	}

	/**
	 * ��ʼ������Ч��
	 */
	private void initAnimation() {
		/**
		 * transformCanvas(Canvas canvas, float percentOpen) �� Canvas
		 * canvas�������ࣻ �� float percentOpen�������˵�����ʱ�İٷֱ�ֵ��
		 */
		mTransformer = new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				float scale = (float) (percentOpen * 0.25 + 0.75);
				canvas.scale(scale, scale, canvas.getWidth() / 2,
						canvas.getHeight() / 2);
			}

		};
	}
}
