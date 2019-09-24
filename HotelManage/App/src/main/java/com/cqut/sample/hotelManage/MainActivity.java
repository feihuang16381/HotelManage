package com.cqut.sample.hotelManage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.cqut.fragmentation.SupportActivity;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.hotelManage.base.BaseMainFragment;
import com.cqut.sample.hotelManage.ui.fragment.fifth.FifthFragment;
import com.cqut.sample.hotelManage.ui.fragment.first.HotelFirstFragment;
import com.cqut.sample.hotelManage.ui.fragment.fourth.FourthFragment;
import com.cqut.sample.hotelManage.ui.fragment.second.HotelSecondFragment;
import com.cqut.sample.hotelManage.ui.fragment.third.ThirdFragment;
import com.cqut.sample.hotelManage.ui.view.BottomBar;
import com.cqut.sample.hotelManage.ui.view.BottomBarTab;


public class MainActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_activity_main);

        SupportFragment firstFragment = findFragment(HotelFirstFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HotelFirstFragment.newInstance();
            mFragments[SECOND] = HotelSecondFragment.newInstance();
            mFragments[THIRD] = ThirdFragment.newInstance("Colleage");
            mFragments[FOURTH] = FourthFragment.newInstance();
            mFragments[FIFTH] = FifthFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(HotelFirstFragment.class);
            mFragments[THIRD] = findFragment(ThirdFragment.class);
            mFragments[FOURTH] = findFragment(FourthFragment.class);
        }
        initView();
    }

    private void initView() {
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
          mBottomBar.addItem(new BottomBarTab(this, R.drawable.ic_message_white_24dp))
                    .addItem(new BottomBarTab(this, R.drawable.ic_record_voice_over))
                    .addItem(new BottomBarTab(this, R.drawable.ic_chrome_reader_mode))
                    .addItem(new BottomBarTab(this, R.drawable.ic_notifications))
                    .addItem(new BottomBarTab(this,R.drawable.ic_account_circle_white_24dp));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }
            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void onBackToFirstFragment() {
        mBottomBar.setCurrentItem(0);
    }


}
