package com.cqut.sample.hotelManage.ui.fragment.second.child;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.eventbusactivityscope.EventBusActivityScope;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.hotelManage.MainActivity;
import com.cqut.sample.hotelManage.adapter.StaggeredRecycleViewAdapter;
import com.cqut.sample.hotelManage.event.TabSelectedEvent;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fei on 2018/11/1.
 */

public class SFourthHomeFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener{

    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private int mCount = 1;
    private boolean mAtTop = true;
    private RecyclerView mRecy;
    private StaggeredRecycleViewAdapter mRecyclerViewAdapter;
    public static SFourthHomeFragment newInstance() {
        Bundle args = new Bundle();
        SFourthHomeFragment fragment = new SFourthHomeFragment();
        fragment.setArguments(args);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frist, container, false);
   //     EventBusActivityScope.getDefault(_mActivity).register(this);
        mPullLoadMoreRecyclerView = view.findViewById(R.id.pullLoadMoreRecyclerView);
        mPullLoadMoreRecyclerView.setStaggeredGridLayout(2);//参数为列数
        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(getContext(), setList());
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
        mRecyclerViewAdapter = new StaggeredRecycleViewAdapter(getContext(), setList());


        getData();
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
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

    private void setRefresh() {

        mRecyclerViewAdapter.getDataList().clear();

        mCount = 1;

    }
}
