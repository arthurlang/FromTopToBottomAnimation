package com.lj.translatedownanimationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Animation mTranslateAnimation;
    private Animation mScaleAnimation;

    @Bind(R.id.vertical_line)
    View mline0;

    @Bind(R.id.vertical_line1)
    View mline1;

    @Bind(R.id.vertical_line2)
    View mline2;

    @Bind(R.id.vertical_line3)
    View mline3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    /** https://github.com/arthurlang/FromTopToBottomAnimation.git
     * 渐变下落出现View的效果的3种方法：类似钢笔从上到下画图动画效果。
     * <p>方法1：移动动画</p>
     * <p>方法2：自定义动画</p>
     * <p>方法3：放大缩小动画</p>
     * <p>如果还有其它的实现方式，请告知，分享出你的想法</p>
     *
     * @param view
     */
    public void startAnimation(View view){
        //1 tranlate
        mTranslateAnimation = AnimationUtils.loadAnimation(this,R.anim.translate_in_from_top_to_bottom);
        mTranslateAnimation.setFillAfter(true);
        mline1.startAnimation(mTranslateAnimation);

        //2 applyTransformation
        mline2.startAnimation(new ViewAnimation());

        //3 scale
        mScaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scale_fade_in);
        mScaleAnimation.setFillAfter(true);
        mline3.startAnimation(mScaleAnimation);

    }
}
