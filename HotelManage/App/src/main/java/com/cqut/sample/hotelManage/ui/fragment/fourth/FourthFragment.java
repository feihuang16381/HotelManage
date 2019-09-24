package com.cqut.sample.hotelManage.ui.fragment.fourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;


public class FourthFragment extends BaseMainFragment {

    public static FourthFragment newInstance() {

        Bundle args = new Bundle();

        FourthFragment fragment = new FourthFragment();
            fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_message, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    /*    if (findChildFragment(SecondHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, SecondHomeFragment.newInstance());
        }*/
    }
}
