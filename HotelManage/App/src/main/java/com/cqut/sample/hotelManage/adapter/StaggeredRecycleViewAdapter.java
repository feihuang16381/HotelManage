package com.cqut.sample.hotelManage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cqut.sample.R;
import com.wx.goodview.GoodView;

import java.util.List;
import java.util.Map;

/**
 * Created by fei on 2015/9/14.
 */
public class StaggeredRecycleViewAdapter extends RecyclerView.Adapter<StaggeredRecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Map<String, String>> dataList;
    GoodView mGoodView;

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public StaggeredRecycleViewAdapter(Context context, List<Map<String, String>> dataList) {
        this.dataList = dataList;
        mContext = context;
        mGoodView = new GoodView(mContext);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView goodView;
        View dddView;
        ImageView collectView;

        public ViewHolder(View itemView) {
            super(itemView);
         //  title = (TextView) itemView.findViewById(R.id.title);
            dddView =itemView;

            goodView =(ImageView) itemView.findViewById(R.id.good);
            collectView =(ImageView) itemView.findViewById(R.id.collection);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        mGoodView = new GoodView(mContext);
        final StaggeredRecycleViewAdapter.ViewHolder holder = new StaggeredRecycleViewAdapter.ViewHolder(v);
        holder.goodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //里面写点击后想要实现的效果
                good(view);
            }

        });
        holder.collectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //里面写点击后想要实现的效果
                collection(view);
            }

        });

        return holder;

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
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
    //    holder.title.setText(dataList.get(position).get("text"));
      //  holder.title.setHeight(Integer.parseInt(dataList.get(position).get("height")));//高度随机，下拉刷新高度会变
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
