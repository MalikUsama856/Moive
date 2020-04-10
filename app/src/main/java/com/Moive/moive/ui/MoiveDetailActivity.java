package com.Moive.moive.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.Moive.moive.R;
import com.Moive.moive.adapters.CastAdapter;
import com.Moive.moive.models.cast;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MoiveDetailActivity extends AppCompatActivity {
    private ImageView MoivethumbnailImg, MoiveCoverimage;
    private TextView tv_title, tv_Description;
    private FloatingActionButton floatingActionButton;
    private CastAdapter castAdapter;
    private RecyclerView rvcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_detail);

        initViews();


        //setuplist cast
        setupRvCast();


    }

    private void setupRvCast() {
        List<cast> mdata = new ArrayList<>();
        mdata.add(new cast("name", R.drawable.a));
        mdata.add(new cast("name", R.drawable.a));
        mdata.add(new cast("name", R.drawable.a));

        castAdapter = new CastAdapter(this, mdata);
        rvcast.setAdapter(castAdapter);
        rvcast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    void initViews() {
        rvcast = findViewById(R.id.Rv_cast);
        floatingActionButton = findViewById(R.id.PlayFab);

        String moivetitle = getIntent().getExtras().getString("title");
        int imageResourceid = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("coverimage");
        MoivethumbnailImg = findViewById(R.id.detailMoive_img);
        Glide.with(this).load(imageResourceid).into(MoivethumbnailImg);
        MoivethumbnailImg.setImageResource(imageResourceid);
        MoiveCoverimage = findViewById(R.id.detail_moive_cover);
        Glide.with(this).load(imagecover).into(MoiveCoverimage);
        tv_title = findViewById(R.id.detail_moive_title);
        tv_title.setText(moivetitle);
        getSupportActionBar().setTitle(moivetitle);
        tv_Description = findViewById(R.id.detailmoivedescription);
        MoiveCoverimage.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        floatingActionButton.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
    }


}
