package com.cqut.sample.hotelManage;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cqut.sample.R;

import com.cqut.sample.hotelManage.adapter.StaggeredRecycleViewAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerviewWaterfall_Activity extends AppCompatActivity {
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    GoodView mGoodView;
    private int mCount = 1;
    private StaggeredRecycleViewAdapter mRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mGoodView = new GoodView(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_frist);
        mPullLoadMoreRecyclerView = findViewById(R.id.pullLoadMoreRecyclerView);
        //mPullLoadMoreRecyclerView.setRefreshing(true);
      mPullLoadMoreRecyclerView.setStaggeredGridLayout(2);//参数为列数
        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(this, setList());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());

       // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(this, setList());


        getData();
    }

    public void good(View view) {
        ((ImageView) view).setImageResource(R.drawable.good_checked);
        mGoodView.setText("+1");
        mGoodView.show(view);
    }
    public void collection(View view) {
        ((ImageView) view).setImageResource(R.drawable.collection_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#f66467"), 12);
        mGoodView.show(view);
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
