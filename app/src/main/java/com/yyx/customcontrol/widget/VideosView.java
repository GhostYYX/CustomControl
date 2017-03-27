package com.yyx.customcontrol.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.yyx.customcontrol.R;

/**
 * Created by vimi8 on 2017/3/24.
 */

public class VideosView extends LinearLayout {

    private Button play;
    private VideoView videoView;
    private String videoUrl;
    private String thumbnail;
    private ImageView thumbnailImage;


    public VideosView(Context context) {
        super(context);
    }

    public VideosView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_video, this);
        TypedArray ta = getContext().obtainStyledAttributes(attrs,R.styleable.VideosView);
        videoUrl = ta.getString(R.styleable.VideosView_video_url);   //获取在attrs文件中定义的VideosView的videourl的值
        videoView = (VideoView) findViewById(R.id.video);
        play = (Button) findViewById(R.id.button_play);
        thumbnailImage = (ImageView) findViewById(R.id.video_thumbnail);


        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,videoUrl,Toast.LENGTH_LONG).show();
                videoView.setVisibility(View.VISIBLE);
                //videoImage.setVisibility(View.GONE);
                videoView.setVideoPath(videoUrl);
                if (videoView.isPlaying()) {
                    videoView.pause();
                    play.setVisibility(View.VISIBLE);
                } else {
                    videoView.start();
                    play.setVisibility(View.GONE);
                }
            }
        });


        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                play.setVisibility(View.GONE);
                Glide.with(context)
                        .load(R.drawable.video_error)
                        .into(thumbnailImage);
                thumbnailImage.setVisibility(View.VISIBLE);
                return true;
            }
        });

        findViewById(R.id.li_video).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
                play.setVisibility(View.VISIBLE);
            }
        });


        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play.setVisibility(View.VISIBLE);
            }
        });
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Glide.with(getContext())
                .load(thumbnail)
                .error(R.drawable.default_video)
                .placeholder(R.drawable.default_video)
                .into(thumbnailImage);
        this.thumbnail = thumbnail;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public VideosView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
