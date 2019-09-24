package com.cqut.sample.hotelManage.ui.fragment.third.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;


/**
 * Created by fei on 2018/10/31.
 */

public class SecondHomePageFragment extends BaseMainFragment {
    public static SecondHomePageFragment newInstance() {
        Bundle args = new Bundle();
        SecondHomePageFragment fragment = new SecondHomePageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondpager, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

       /* if (findChildFragment(SecondHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, FirstSecHomeFragment.newInstance());
        }*/
    }
}
