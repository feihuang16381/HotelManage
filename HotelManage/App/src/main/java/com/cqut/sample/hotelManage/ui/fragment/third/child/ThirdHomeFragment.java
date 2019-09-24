package com.cqut.sample.hotelManage.ui.fragment.third.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
/**
 * Created by fei on 2018/11/1.
 */

public class ThirdHomeFragment extends SupportFragment {


    public static ThirdHomeFragment newInstance() {
        Bundle args = new Bundle();
        ThirdHomeFragment fragment = new ThirdHomeFragment();
        fragment.setArguments(args);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thirdpager, container, false);
        /*EventBusActivityScope.getDefault(_mActivity).register(this);*/
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
