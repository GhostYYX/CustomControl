package com.yyx.customcontrol.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yyx.customcontrol.R;

/**
 * Created by vimi8 on 2017/3/24.
 */

public class VideosView extends LinearLayout {

    private Button play;

    public VideosView(Context context) {
        super(context);
    }

    public VideosView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_video, this);
        play = (Button) findViewById(R.id.button_play);
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"123",Toast.LENGTH_LONG).show();
            }
        });
    }

    public VideosView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
