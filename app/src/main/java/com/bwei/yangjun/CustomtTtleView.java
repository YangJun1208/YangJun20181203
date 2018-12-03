package com.bwei.yangjun;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomtTtleView extends LinearLayout {

    private Context mContext;

    public CustomtTtleView(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public CustomtTtleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    private void init() {
         final View view = View.inflate(mContext, R.layout.activity_title, null);
            final EditText editText=view.findViewById(R.id.editText);
         ImageView imageView = view.findViewById(R.id.imageView);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickChangListener!=null){
                    onClickChangListener.onSuccess(editText.getText().toString());
                }

            }

        });
        addView(view);
    }
    onClickChangListener onClickChangListener;

    public void setonClickChangListener(onClickChangListener changListener){
        this.onClickChangListener=changListener;
    }

    public interface onClickChangListener{
        void onSuccess(String str);
    }

}
