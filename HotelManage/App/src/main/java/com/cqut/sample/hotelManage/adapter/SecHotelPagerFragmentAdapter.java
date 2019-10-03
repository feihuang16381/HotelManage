package com.cqut.sample.hotelManage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cqut.sample.hotelManage.ui.fragment.second.child.SFirstHomePageFragment;
import com.cqut.sample.hotelManage.ui.fragment.second.child.SFourthHomeFragment;
import com.cqut.sample.hotelManage.ui.fragment.second.child.SSecondHomePageFragment;
import com.cqut.sample.hotelManage.ui.fragment.second.child.SThirdHomeFragment;



//为fragment添加数据
public class SecHotelPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public SecHotelPagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }
//创建一个Fragment实例
    @Override
    public Fragment getItem(int position) {
       if (position == 0) {
            return SFirstHomePageFragment.newInstance();
        }else  if(position ==1){
         return SSecondHomePageFragment.newInstance();
       }
        else if(position==2){
           return SThirdHomeFragment.newInstance();
        }else{
            return SFourthHomeFragment.newInstance();
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
