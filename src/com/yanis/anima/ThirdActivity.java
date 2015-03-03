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
 *@Description 当滑动菜单栏刚刚打开时，滑动菜单栏的视图内容从下方渐渐的往上移动，等滑动菜单栏完全 打开时，该视图就会移动到最顶端。
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
     * 初始化滑动菜单 
     */  
    private void initSlidingMenu(){  
        // 设置主界面视图  
        setContentView(R.layout.layout_right);  
        // 设置滑动菜单视图  
        setBehindContentView(R.layout.layout_left);  
        // 设置滑动菜单的属性值  
        SlidingMenu sm = getSlidingMenu();      
        //根据dimension资源文件的ID来设置下方视图的偏移量,此处是220dp
       sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);  
        sm.setFadeDegree(0.35f);  
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);  
        sm.setBehindScrollScale(0.0f);  
        sm.setBehindCanvasTransformer(mTransformer);  
          
        setSlidingActionBarEnabled(true);  
    }  

	// Interpolator
	// 定义了动画的变化速度，可以实现匀速、正加速、负加速、无规则变加速等。所以要想实现缓慢往上移动的效果就要使用到此它，并且重写此接口中的getInterpolation(float
	// t)方法。
	private static Interpolator interp = new Interpolator() {
		@Override
		public float getInterpolation(float t) {
			t -= 1.0f;
			return t * t * t + 1.0f;
		}
	};

	/**
	 * 初始化动画效果
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
