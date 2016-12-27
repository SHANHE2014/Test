package com.zhangq.android.mylibrary.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zhangq.android.mylibrary.R;


public class WrapImageView extends ImageView {
    private Context mContext;
    private float widthPerHeight;

    public WrapImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        setCustomAttributes(attrs);
    }

    public WrapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setCustomAttributes(attrs);
    }

    public WrapImageView(Context context) {
        super(context);
        this.mContext = context;
    }

    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs,
                R.styleable.WrapImageView);
        widthPerHeight = array.getFloat(
                R.styleable.WrapImageView_widthPerHeight, 1f);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));

        // Children are just made to fill our space.
        int childWidthSize = getMeasuredWidth();

        // 设置高度
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                (int) (childWidthSize / widthPerHeight), MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
