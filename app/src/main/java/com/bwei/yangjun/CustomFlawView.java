package com.bwei.yangjun;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomFlawView extends LinearLayout {

    private Context mContext;
    private int MeasureHeight;
    private int mWidth=20;

    public CustomFlawView(Context context) {
        super(context);
        mContext=context;
    }



    public CustomFlawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        findHeightChilener();

        int left=0,top=0;

        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View childAt = getChildAt(i);
            if(left!=0){
                if(left+childAt.getMeasuredWidth()>sizeWidth){
                    top+=childAt.getMeasuredHeight();
                    left=0;
                }
            }
            left+=childAt.getMeasuredWidth()+mWidth;
        }

        setMeasuredDimension(sizeWidth,(top+MeasureHeight)>sizeHeight?sizeHeight:top+MeasureHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findHeightChilener();

        int left=0,top=0;

        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View childAt = getChildAt(i);
            if(left!=0){
                if(left+childAt.getMeasuredWidth()>getWidth()){
                    top+=childAt.getMeasuredHeight();
                    left=0;
                }
            }
            childAt.layout(left,top,left+childAt.getMeasuredWidth(),top+childAt.getMeasuredHeight());
            left+=childAt.getMeasuredWidth()+mWidth;
        }


    }

    private void findHeightChilener() {
        MeasureHeight=0;
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View childAt = getChildAt(i);
            if(childAt.getMeasuredHeight()>MeasureHeight){
                MeasureHeight=childAt.getMeasuredHeight();
            }
        }
    }

}
