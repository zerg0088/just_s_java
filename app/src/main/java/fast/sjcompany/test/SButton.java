package fast.sjcompany.test;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jeonsangsu on 2018. 8. 19..
 */

public class SButton extends FrameLayout {
    private Point point;
    private TextView tv;
    private LinearLayout opaLayout;

    public boolean isViewDisplay;
    public SButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
    }

    public SButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initControl(context);
    }

    public SButton(Context context) {
        super(context);
        initControl(context);
    }

    public void setText(String text) {
        tv.setText(text);
    }

    private void initControl(final Context context)
    {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.sbutton_layout, this);
        tv = (TextView)findViewById(R.id.text);
        opaLayout = (LinearLayout)findViewById(R.id.opaLayout);
    }
    //public void set

    public void setGreenBackground(boolean isDisplay) {
        if(isDisplay) {
            opaLayout.setAlpha(1.0f);
        } else {
            opaLayout.setAlpha(0.0f);
        }
    }

    AlphaAnimation animation1;
    AlphaAnimation animation2;

    public void opacityAnimationStart(int duration,int offset) {
        opaLayout.setAlpha(1.0f);
        animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setStartOffset(offset);
        animation1.setDuration(duration);
        animation1.setFillAfter(true);
        opaLayout.startAnimation(animation1);
    }

    public void opacityAnimationStop() {
        this.clearAnimation();
    }


}


