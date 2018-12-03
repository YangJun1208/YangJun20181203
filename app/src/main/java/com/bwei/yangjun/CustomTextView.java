package com.bwei.yangjun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView {

    private Context mContext;
    public CustomTextView(Context context) {
        super(context);
        mContext=context;
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

        int color = typedArray.getColor(R.styleable.CustomTextView_title_color, Color.BLUE);

        typedArray.recycle();
        setTextColor(color);

    }
}
