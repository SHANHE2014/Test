package com.zhangq.android.mylibrary.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 显示全部高度的listview,用于ScrollView中
 */
public class FullHeightListView extends ListView {

    public FullHeightListView(Context context) {
        super(context);
    }

    public FullHeightListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullHeightListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
