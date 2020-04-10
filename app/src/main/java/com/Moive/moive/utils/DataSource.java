package com.Moive.moive.utils;

import com.Moive.moive.R;
import com.Moive.moive.models.Moive;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public  static List<Moive> getPopularMoives(){


        List<Moive> Istmoive=new ArrayList<>();
        Istmoive.add(new Moive("malik", R.drawable.slide1,R.drawable.harry));
        Istmoive.add(new Moive("usama",R.drawable.slide2,R.drawable.harry));
        Istmoive.add(new Moive("malik",R.drawable.slide1));
        Istmoive.add(new Moive("Usama",R.drawable.slide2));
        return Istmoive;

    }
}
