package com.cqut.sample.hotelManage.ui.fragment.second.child;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.adapter.HouseStaggeredRecycleViewAdapter;
import com.cqut.sample.hotelManage.adapter.LandlordStaggeredRecycleViewAdapter;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by fei on 2018/10/31.
 */

public class SSecondHomePageFragment extends BaseMainFragment {
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private int mCount = 1;
    private LandlordStaggeredRecycleViewAdapter mRecyclerViewAdapter;
    public static SSecondHomePageFragment newInstance() {
        Bundle args = new Bundle();
        SSecondHomePageFragment fragment = new SSecondHomePageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frist, container, false);
        mPullLoadMoreRecyclerView = view.findViewById(R.id.pullLoadMoreRecyclerView);
        mPullLoadMoreRecyclerView.setStaggeredGridLayout(1);//参数为列数
        mRecyclerViewAdapter = new LandlordStaggeredRecycleViewAdapter(getContext(), setList());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
        mRecyclerViewAdapter = new LandlordStaggeredRecycleViewAdapter(getContext(), setList());
        getData();
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

       /* if (findChildFragment(SecondHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, FirstSecHomeFragment.newInstance());
        }*/
    }
    private void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerViewAdapter.getDataList().addAll(setList());
                mRecyclerViewAdapter.notifyDataSetChanged();
                mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }
        }, 1000);
    }

    private List<Map<String, String>> setList() {
        List<Map<String, String>> dataList = new ArrayList<>();
        int start = 30 * (mCount - 1);
        Map<String, String> map;
        for (int i = start; i < 30 * mCount; i++) {
            map = new HashMap<>();
            map.put("text", "Third" + i);
            map.put("height", (120 + 5 * i) + "");
            dataList.add(map);
        }
        return dataList;

    }
    class PullLoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener {
        @Override
        public void onRefresh() {
            setRefresh();
            getData();
        }

        @Override
        public void onLoadMore() {
            mCount = mCount + 1;
            getData();
        }
    }
    private void setRefresh() {

        mRecyclerViewAdapter.getDataList().clear();

        mCount = 1;

    }
}
