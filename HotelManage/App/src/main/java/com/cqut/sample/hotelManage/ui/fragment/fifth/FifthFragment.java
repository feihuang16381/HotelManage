package com.cqut.sample.hotelManage.ui.fragment.fifth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;


public class FifthFragment extends BaseMainFragment {
    private BGABanner mContentBanner;
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
        mContentBanner = view.findViewById(R.id.banner_guide_content);
// Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
// 设置数据源
        mContentBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.uoko_guide_background_1,
                R.drawable.uoko_guide_background_2,
                R.drawable.uoko_guide_background_3);
    }
}
