package com.cqut.sample.hotelManage;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.cqut.fragmentation.SupportActivity;
import com.cqut.sample.R;
import com.cqut.sample.hotelManage.adapter.billboardStaggeredRecycleViewAdapter;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class browsehisActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener{
    private int mCount = 1;
    private billboardStaggeredRecycleViewAdapter mRecyclerViewAdapter;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browsehis);
        mPullLoadMoreRecyclerView = findViewById(R.id.pullLoadMoreRecyclerView);
        mPullLoadMoreRecyclerView.setStaggeredGridLayout(1);//参数为列数
        mRecyclerViewAdapter = new billboardStaggeredRecycleViewAdapter(getApplicationContext(), setList());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
        mRecyclerViewAdapter = new billboardStaggeredRecycleViewAdapter(getApplicationContext(), setList());


    }
    @Override
    public void onBackToFirstFragment() {

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
