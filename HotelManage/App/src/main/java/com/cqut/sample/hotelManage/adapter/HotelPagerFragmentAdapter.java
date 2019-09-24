package com.cqut.sample.hotelManage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cqut.sample.hotelManage.ui.fragment.third.child.FirstHomePageFragment;
import com.cqut.sample.hotelManage.ui.fragment.third.child.SecondHomePageFragment;
import com.cqut.sample.hotelManage.ui.fragment.third.child.ThirdHomeFragment;


//为fragment添加数据
public class HotelPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public HotelPagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }
//创建一个Fragment实例
    @Override
    public Fragment getItem(int position) {
       if (position == 0) {
            return FirstHomePageFragment.newInstance();
        }else  if(position ==1){
         return SecondHomePageFragment.newInstance();
       }
        else {
           return ThirdHomeFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
