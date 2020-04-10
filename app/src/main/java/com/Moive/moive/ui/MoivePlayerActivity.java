package com.Moive.moive.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.Moive.moive.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MoivePlayerActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    public static  final  String Video_TEST_URL="http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_player);

        iniExoPlayer();

    }

    private void iniExoPlayer() {
        playerView=findViewById(R.id.moive_exo_player);
        simpleExoPlayer= ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);
        DataSource.Factory factory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,
                "app_name"));
        MediaSource  source=new ExtractorMediaSource.Factory(factory)
                .createMediaSource(Uri.parse(Video_TEST_URL));
        simpleExoPlayer.prepare(source);
        simpleExoPlayer.setPlayWhenReady(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}
