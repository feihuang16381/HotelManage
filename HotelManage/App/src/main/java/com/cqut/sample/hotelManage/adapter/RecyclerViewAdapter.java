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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WuXiaolong
 * on 2015/7/2.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> dataList = new ArrayList<>();
    GoodView mGoodView;
    private int mCount = 1;



    public void addAllData(List<String> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        mGoodView = new GoodView(mContext);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView goodView;
        View dddView;

        public ViewHolder(View itemView) {
            super(itemView);
            dddView =itemView;

             goodView =(ImageView) itemView.findViewById(R.id.good);


        }


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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        mGoodView = new GoodView(mContext);
final ViewHolder holder = new ViewHolder(v);
holder.goodView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //里面写点击后想要实现的效果
        good(view);
    }

});
        holder.dddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //里面写点击后想要实现的效果
                Toast.makeText(view.getContext(),"ddd",Toast.LENGTH_SHORT);
            }

        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       /* holder.title.setText(dataList.get(position));*/
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}