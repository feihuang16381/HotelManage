package com.cqut.sample.hotelManage.ui.fragment.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.cqut.sample.hotelManage.ui.SearchActivity;




public class HotelFirstFragment extends BaseMainFragment {
    SearchView searchView;
    public static HotelFirstFragment newInstance() {
        Bundle args = new Bundle();
        HotelFirstFragment fragment = new HotelFirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_firstlayout, container, false);
       initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     /*   if (findChildFragment(SecondViewPagerFragment.class) == null) {
            loadRootFragment(R.id.fl_second_container, SecondViewPagerFragment.newInstance());
        }*/
    }
public  void initView(View view){
    searchView = view.findViewById(R.id.search);
    searchView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        }
    });
}
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create+
    }
}
