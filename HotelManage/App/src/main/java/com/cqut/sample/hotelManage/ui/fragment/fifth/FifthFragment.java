package com.cqut.sample.hotelManage.ui.fragment.fifth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.PsetActivity;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.cqut.sample.hotelManage.browsehisActivity;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;


public class FifthFragment extends BaseMainFragment {
    private BGABanner mContentBanner;
    RelativeLayout relativeLayout;
    ImageView Pset;
    public static FifthFragment newInstance() {

        Bundle args = new Bundle();

        FifthFragment fragment = new FifthFragment();
            fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pcenter, container, false);
        lunboPic(view);
        browHis();
        Pset();
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    /*    if (findChildFragment(SecondHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, SecondHomeFragment.newInstance());
        }*/
    }
    public void lunboPic(View view){
        relativeLayout = view.findViewById(R.id.browseHis);
        mContentBanner = view.findViewById(R.id.banner_guide_content);
        Pset =view.findViewById(R.id.pset);
// Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
// 设置数据源
        mContentBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_background_1
              );
    }

    public void browHis(){
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(getActivity(), browsehisActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Pset(){
        Pset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PsetActivity.class);
                startActivity(intent);
            }
        });
    }
}
