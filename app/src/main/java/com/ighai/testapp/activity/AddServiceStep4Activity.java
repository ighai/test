package com.ighai.testapp.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ToggleButton;


import com.ighai.testapp.R;
import com.ighai.testapp.adapter.ScheduleDateSelectAdapter;
import com.ighai.testapp.dto.ServiceSettingDayOfWeek;
import com.ighai.testapp.databinding.ActivityAddServiceStep4Binding;
import com.ighai.testapp.fragment.ScheduleLimitFragment;
import com.ighai.testapp.fragment.ScheduleLocationFragment;
import com.ighai.testapp.fragment.ScheduleTimeFragment;

import java.util.ArrayList;

import static com.ighai.testapp.container.Constants.Manager.DAY_OF_WEEK_DATA;
import static com.ighai.testapp.container.Constants.Sechedule.PAGE;
import static com.ighai.testapp.container.Constants.Sechedule.WEEK;

public class AddServiceStep4Activity extends AppCompatActivity {

    private ActivityAddServiceStep4Binding binding;

    private ScheduleDateSelectAdapter adapter;

    private ArrayList<ToggleButton> dayTab = new ArrayList<>();
    private ServiceSettingDayOfWeek mDayOfWeekData = new ServiceSettingDayOfWeek();
    private int mPage;
    private int mWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setUI();
    }

    private void initUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_service_step4);

        adapter = new ScheduleDateSelectAdapter(getSupportFragmentManager());
    }

    private void setUI() {
        binding.setViewModel(this);
        dayTab.add(binding.day1);
        dayTab.add(binding.day2);
        dayTab.add(binding.day3);
        dayTab.add(binding.day4);
        dayTab.add(binding.day5);
        dayTab.add(binding.day6);
        dayTab.add(binding.day7);

        binding.viewpager1.setAdapter(adapter);
        binding.tabs.setViewPager(binding.viewpager1);
        binding.viewpager1.addOnPageChangeListener(mDateSelect);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(DAY_OF_WEEK_DATA, mDayOfWeekData);
        outState.putInt(PAGE, mPage);
        outState.putInt(WEEK, mWeek);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mDayOfWeekData = (ServiceSettingDayOfWeek) savedInstanceState.get(DAY_OF_WEEK_DATA);
        mPage = savedInstanceState.getInt(PAGE);
        mWeek = savedInstanceState.getInt(WEEK);
        binding.setViewModel(this);
        if(adapter.getItem(mPage) instanceof ScheduleTimeFragment) {
            ((ScheduleTimeFragment) adapter.getItem(mPage)).mBtnChanged = false;
        }
    }

    public void onTab(int num) {
        if(dayTab.size() < num)
            return;
        mWeek = num;
        for(int i = 1; i <= dayTab.size(); i++) {
            if(i == num) {
                dayTab.get(i-1).setChecked(true);
            } else {
                dayTab.get(i-1).setChecked(false);
            }
        }
    }

    public void onFinish() {
        Log.d("최종", mDayOfWeekData.toString());
    }

    private ViewPager.OnPageChangeListener mDateSelect = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            Log.d("Selected", i + "");
            mPage = i;
            if(adapter.getItem(i) instanceof ScheduleTimeFragment) {
                ((ScheduleTimeFragment) adapter.getItem(mPage)).mBtnChanged = false;
                ((ScheduleTimeFragment) adapter.getItem(mPage)).setDayOfWeek(mDayOfWeekData.getDayOfWeekTimes(), mWeek);
            }
            if(adapter.getItem(i) instanceof ScheduleLocationFragment) {
                ((ScheduleTimeFragment) adapter.getItem(0)).mBtnChanged = true;
            }
            if(adapter.getItem(i) instanceof ScheduleLimitFragment) {
                ((ScheduleTimeFragment) adapter.getItem(0)).mBtnChanged = true;
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}