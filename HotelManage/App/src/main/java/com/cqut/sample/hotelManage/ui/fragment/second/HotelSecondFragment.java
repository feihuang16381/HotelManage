package com.cqut.sample.hotelManage.ui.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.cqut.sample.hotelManage.ui.fragment.third.ViewPagerFragment;


public class HotelSecondFragment extends BaseMainFragment {

    public static HotelSecondFragment newInstance() {

        Bundle args = new Bundle();

        HotelSecondFragment fragment = new HotelSecondFragment();
            fragment.setArguments(args);

        return fragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(ViewPagerFragment.class) == null) {
            loadRootFragment(R.id.Sfl_second_container, SecondViewPagerFragment.newInstance());
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_secondlayout, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }
}
