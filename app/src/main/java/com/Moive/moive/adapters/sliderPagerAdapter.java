package com.Moive.moive.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.Moive.moive.R;
import com.Moive.moive.models.slide;

import java.util.List;

public class sliderPagerAdapter extends PagerAdapter {

    private Context mcontext;
    private List<slide> mList;



    public sliderPagerAdapter(Context mcontext, List<slide> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sideLayout=inflater.inflate(R.layout.slider_item,null);

        ImageView slideImage=sideLayout.findViewById(R.id.slide_img);
        TextView slideText=sideLayout.findViewById(R.id.slide_title);
        slideImage.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());
        container.addView(sideLayout);
        return  sideLayout;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      container.removeView((View)object);
    }
}
