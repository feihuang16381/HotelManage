package com.cqut.sample.hotelManage.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cqut.sample.R;
import com.wx.goodview.GoodView;

import java.util.List;
import java.util.Map;

/**
 * Created by fei on 2015/9/14.
 */
public class HouseStaggeredRecycleViewAdapter extends RecyclerView.Adapter<HouseStaggeredRecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Map<String, String>> dataList;
    GoodView mGoodView;

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public HouseStaggeredRecycleViewAdapter(Context context, List<Map<String, String>> dataList) {
        this.dataList = dataList;
        mContext = context;
        mGoodView = new GoodView(mContext);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView goodView;
        View dddView;
        ImageView collectView;
        ImageView house;

        public ViewHolder(View itemView) {
            super(itemView);
         //  title = (TextView) itemView.findViewById(R.id.title);
            dddView =itemView;
            house = (ImageView) itemView.findViewById(R.id.House);

            collectView =(ImageView) itemView.findViewById(R.id.collection);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_recycler_view_item, parent, false);
        mGoodView = new GoodView(mContext);
        final HouseStaggeredRecycleViewAdapter.ViewHolder holder = new HouseStaggeredRecycleViewAdapter.ViewHolder(v);

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
   /*     Resources resources = mContext.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels/3;
        int height = width*3/2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.house.getLayoutParams();
        layoutParams.height = height;
        holder.house.setLayoutParams(layoutParams);*/
//        holder.title.setText(dataList.get(position).get("text"));
     //   holder.house.setImageResource(Integer.parseInt(dataList.get(position).get("house")));
      holder.house.setImageDrawable(mContext.getResources().getDrawable(Integer.parseInt(dataList.get(position).get("house"))));
      //  holder.title.setHeight(Integer.parseInt(dataList.get(position).get("height")));//高度随机，下拉刷新高度会变
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
