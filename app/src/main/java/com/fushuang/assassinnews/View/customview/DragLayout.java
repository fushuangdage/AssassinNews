package com.fushuang.assassinnews.View.customview;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by fushuang on 2017/4/28.
 */

public class DragLayout extends LinearLayout{


    private final ViewDragHelper mViewDragHelper;

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                //让视图回到最上层
                child.bringToFront();
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                /**
                 * 如果子控件超出右边边界,控制视图不能超过边界
                 */
                if (left < 0) {
                    return 0;
                }
                if (left + child.getMeasuredWidth() >= getMeasuredWidth()) {
                    return getMeasuredWidth() - child.getMeasuredWidth();
                }
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                /**
                 * 控制视图不能上下越界
                 */
                if (top < 0) {
                    return 0;
                }
                if (top + child.getMeasuredHeight() > getMeasuredHeight()) {
                    return getMeasuredHeight() - child.getMeasuredHeight();
                }
                return top;
            }

            //手指释放的时候回调
            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {

            }

            //如果你拖动View添加了clickable = true 或者为 button 会出现拖不动的情况，原因是拖动的时候onInterceptTouchEvent方法，
            // 判断是否可以捕获，而在判断的过程中会去判断另外两个回调的方法getViewHorizontalDragRange和getViewVerticalDragRange，
            // 只有这两个方法返回大于0的值才能正常的捕获。如果未能正常捕获就会导致手势down后面的move以及up都没有进入到onTouchEvent
            @Override
            public int getViewHorizontalDragRange(View child) {
                return getMeasuredWidth() - child.getMeasuredWidth();
            }

            @Override
            public int getViewVerticalDragRange(View child) {
                return getMeasuredHeight() - child.getMeasuredHeight();
            }
        });

        mViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
       return mViewDragHelper.shouldInterceptTouchEvent(event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll()
    {
        if(mViewDragHelper.continueSettling(true))
        {
            invalidate();
        }
    }


}
