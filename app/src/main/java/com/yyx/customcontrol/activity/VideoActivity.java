package com.yyx.customcontrol.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yyx.customcontrol.R;
import com.yyx.customcontrol.widget.VideosView;

/**
 * Created by vimi8 on 2017/3/27.
 */

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        VideosView videosView = (VideosView) findViewById(R.id.v_1);
        videosView.setVideoUrl("456");

        VideosView videosView1 = (VideosView) findViewById(R.id.v_2);
        videosView1.setThumbnail("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=7696697,4045052968&fm=23&gp=0.jpg");
        videosView1.setVideoUrl("http://v.youku.com/v_show/id_XMjY2MjcxOTg0OA==.html?firsttime=192");
    }
}
