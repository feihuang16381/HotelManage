package com.cqut.sample.hotelManage.ui.fragment.third.child;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cqut.eventbusactivityscope.EventBusActivityScope;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.hotelManage.MainActivity;
import com.cqut.sample.hotelManage.RecyclerviewWaterfall_Activity;
import com.cqut.sample.hotelManage.adapter.StaggeredRecycleViewAdapter;
import com.cqut.sample.hotelManage.event.TabSelectedEvent;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.wx.goodview.GoodView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fei on 2018/10/30.
 */

public class FirstHomePageFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView mRecy;
    private SwipeRefreshLayout mRefreshLayout;
    //private HomeAdapter mAdapter;
    private boolean mAtTop = true;
    private int mScrollTotal;
    private String[] mTitles;
    private String[] mContents;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    GoodView mGoodView;
    private int mCount = 1;
    private StaggeredRecycleViewAdapter mRecyclerViewAdapter;
    public static FirstHomePageFragment newInstance() {

        Bundle args = new Bundle();

        FirstHomePageFragment fragment = new FirstHomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frist, container, false);
       // EventBusActivityScope.getDefault(_mActivity).register(this);
     initView(view);
        mGoodView = new GoodView(getContext());
        super.onCreate(savedInstanceState);

        mPullLoadMoreRecyclerView = view.findViewById(R.id.pullLoadMoreRecyclerView);
        //mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setStaggeredGridLayout(2);//参数为列数
        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(getContext(), setList());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());

        // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(getContext(), setList());


        getData();
        return view;
    }

    private void initView(View view) {

    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    private void scrollToTop() {
        mRecy.smoothScrollToPosition(0);
    }

    /**
     * 选择tab事件
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainActivity.SECOND) return;

        if (mAtTop) {
            mRefreshLayout.setRefreshing(true);
            onRefresh();
        } else {
            scrollToTop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
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
