package com.cqut.sample.hotelManage.ui.fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.hotelManage.adapter.HotelPagerFragmentAdapter;
import com.cqut.sample.hotelManage.adapter.SecHotelPagerFragmentAdapter;


public class SecondViewPagerFragment extends SupportFragment {
    private TabLayout mTab;
    private ViewPager mViewPager;

    public static SecondViewPagerFragment newInstance() {
        Bundle args = new Bundle();
        SecondViewPagerFragment fragment = new SecondViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());


        mViewPager.setAdapter(new SecHotelPagerFragmentAdapter(getChildFragmentManager(),
                "房屋", "房东",
                "榜单","发现"));
        mTab.setupWithViewPager(mViewPager);
    }
}
