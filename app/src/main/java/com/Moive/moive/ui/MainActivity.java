package com.Moive.moive.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.Moive.moive.models.Moive;
import com.Moive.moive.adapters.MoiveAdapter;
import com.Moive.moive.adapters.Moiveitemclicklistener;
import com.Moive.moive.R;
import com.Moive.moive.models.slide;
import com.Moive.moive.adapters.sliderPagerAdapter;
import com.Moive.moive.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements Moiveitemclicklistener {

    private List<slide> IstSlides;
    private ViewPager slidePager;
    private TabLayout indicator;
    private RecyclerView moiverv;
    private  RecyclerView Rv_cast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        initSlider();
        iniPopularMoives();


    }

    private void iniPopularMoives() {
        //recyler view setup




        MoiveAdapter moiveAdapter=new MoiveAdapter(this, DataSource.getPopularMoives(),this);
        moiverv.setAdapter(moiveAdapter);
        moiverv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initSlider() {
        IstSlides=new ArrayList<>();
        IstSlides.add(new slide(R.drawable.slide1,"slide Title \n more text"));
        IstSlides.add(new slide(R.drawable.slide2,"slide Title \n more text"));
        IstSlides.add(new slide(R.drawable.slide1,"slide Title \n more text"));
        IstSlides.add(new slide(R.drawable.slide2,"slide Title \n more text"));

        sliderPagerAdapter sliderPagerAdapter=new sliderPagerAdapter(this,IstSlides);
        slidePager.setAdapter(sliderPagerAdapter);

        //setuptime
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MainActivity.sliderTimer(),4000,6000);

        indicator.setupWithViewPager(slidePager,true);
    }

    private void init() {
        slidePager=findViewById(R.id.slider_pager);
        indicator=findViewById(R.id.indicator);
        moiverv=findViewById(R.id.Rv_moives);
        Rv_cast=findViewById(R.id.Rv_cast);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMoiveClick(Moive moive, ImageView movieImageView) {

        Intent intent=new Intent(this,MoiveDetailActivity.class);
        intent.putExtra("title",moive.getTitle());
        intent.putExtra("imgURL",moive.getThumbnail());
        intent.putExtra("coverimage",moive.getCoverphoto());
        //creat animation in recyler view

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

        Toast.makeText(this, "itemClicked" +moive.getTitle(), Toast.LENGTH_SHORT).show();

    }


    class sliderTimer  extends TimerTask{


        @Override
        public void run() {
         MainActivity.this.runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 if(slidePager.getCurrentItem()<IstSlides.size()-1){

                     slidePager.setCurrentItem(slidePager.getCurrentItem()+1);


                 }
                 else{
                     slidePager.setCurrentItem(0);
                 }
             }
         });
        }
    }
}
