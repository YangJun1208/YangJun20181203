package com.bwei.yangjun;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private CustomFlawView flawView;
    private CustomtTtleView titleView;
    private String[] datas=new String[]{"考拉三周年人气热销榜","电动牙刷","尤妮佳","豆豆鞋","沐浴露","日东红茶","榴莲","尤妮佳","雅诗兰黛","豆豆鞋"};
    private String value;
    private UsersDao usersDao;
    private PersonDao personDao;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flawView=findViewById(R.id.customFlawView);
        titleView=findViewById(R.id.customTitleView);
      CustomFlawView shuView=findViewById(R.id.shuView);
      button=findViewById(R.id.clear);

        usersDao=new UsersDao(this);
        personDao=new PersonDao(this);
        titleView.setonClickChangListener(new CustomtTtleView.onClickChangListener() {
            @Override
            public void onSuccess(final String str) {
                UUID uuid = UUID.randomUUID();
                TextView view = new TextView(MainActivity.this);
                view.setBackgroundResource(R.drawable.edit_bg);
                view.setTag(uuid);
                view.setText(str);
                view.setTextColor(Color.BLACK);
                value = String.valueOf(view.getTag());
                flawView.addView(view);
                usersDao.add(value,str);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,str+"",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersDao.delAll();
                flawView.removeAllViews();
            }
        });


        for ( int i=0;i<datas.length;i++){
            UUID uuid = UUID.randomUUID();
            TextView view = new TextView(this);
            view.setText(datas[i]);
            view.setTag(uuid);
            String s = String.valueOf(view.getTag());
            personDao.add(s,datas[i]);
            view.setTextColor(Color.BLACK);
            view.setBackgroundResource(R.drawable.edit_bg);
            shuView.addView(view);
            final int index=i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,datas[index]+"",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
