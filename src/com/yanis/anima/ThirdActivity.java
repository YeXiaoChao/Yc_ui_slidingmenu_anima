package com.yanis.anima;

import android.graphics.Canvas;  
import android.os.Bundle;    
import android.view.animation.Interpolator;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;  
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;  
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;  
/**
 * 
 * @author Yanis
 *@Description �������˵����ոմ�ʱ�������˵�������ͼ���ݴ��·������������ƶ����Ȼ����˵�����ȫ ��ʱ������ͼ�ͻ��ƶ�����ˡ�
 */
public class ThirdActivity extends SlidingFragmentActivity {
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
    private void initSlidingMenu(){  
        // ������������ͼ  
        setContentView(R.layout.layout_right);  
        // ���û����˵���ͼ  
        setBehindContentView(R.layout.layout_left);  
        // ���û����˵�������ֵ  
        SlidingMenu sm = getSlidingMenu();      
        //����dimension��Դ�ļ���ID�������·���ͼ��ƫ����,�˴���220dp
       sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);  
        sm.setFadeDegree(0.35f);  
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        sm.setBehindScrollScale(0.0f);  
        sm.setBehindCanvasTransformer(mTransformer);  
          
        setSlidingActionBarEnabled(true);  
    }  

	// Interpolator
	// �����˶����ı仯�ٶȣ�����ʵ�����١������١������١��޹������ٵȡ�����Ҫ��ʵ�ֻ��������ƶ���Ч����Ҫʹ�õ�������������д�˽ӿ��е�getInterpolation(float
	// t)������
	private static Interpolator interp = new Interpolator() {
		@Override
		public float getInterpolation(float t) {
			t -= 1.0f;
			return t * t * t + 1.0f;
		}
	};

	/**
	 * ��ʼ������Ч��
	 */
	private void initAnimation() {
		mTransformer = new CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.translate(
						0,
						canvas.getHeight()
								* (1 - interp.getInterpolation(percentOpen)));
			}
		};
	}
}
