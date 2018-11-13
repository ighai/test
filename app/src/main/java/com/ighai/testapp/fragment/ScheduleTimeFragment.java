package com.ighai.testapp.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.ToggleButton;

import com.ighai.testapp.R;
import com.ighai.testapp.activity.AddServiceStep4Activity;
import com.ighai.testapp.activity.SendDataForFragment;
import com.ighai.testapp.dto.DayOfWeekTimes;

import java.util.ArrayList;
import java.util.List;

public class ScheduleTimeFragment extends Fragment {

    private View view;
    private ScrollView sv1;
    private ToggleButton tb07, tb08, tb09, tb10, tb11, tb12, tb13, tb14, tb15, tb16, tb17, tb18, tb19, tb25;

    private List<ToggleButton> tb = new ArrayList<ToggleButton>();
    private ArrayList<DayOfWeekTimes> times = new ArrayList<>();
    private int mDayOfWeek = 7;
    public boolean mBtnChanged = true;

    public static ScheduleTimeFragment newInstance() {
        ScheduleTimeFragment f = new ScheduleTimeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("생명주기", "onCreateView");
        view =  inflater.inflate(R.layout.fragment_schedule_time, container, false);
        initUI(view);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("생명주기", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        setUI();
    }

    @Override
    public void onResume() {
        Log.d("생명주기", "onResume");
        super.onResume();
        initUI(view);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("생명주기", "onConfigurationChanged - LAND");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("생명주기", "onConfigurationChanged - PORT");
        }
    }

    private void initUI(View view) {
        sv1 = (ScrollView) view.findViewById(R.id.sv1);
        tb07 = (ToggleButton) view.findViewById(R.id.tb07);
        tb08 = (ToggleButton) view.findViewById(R.id.tb08);
        tb09 = (ToggleButton) view.findViewById(R.id.tb09);
        tb10 = (ToggleButton) view.findViewById(R.id.tb10);
        tb11 = (ToggleButton) view.findViewById(R.id.tb11);
        tb12 = (ToggleButton) view.findViewById(R.id.tb12);
        tb13 = (ToggleButton) view.findViewById(R.id.tb13);
        tb14 = (ToggleButton) view.findViewById(R.id.tb14);
        tb15 = (ToggleButton) view.findViewById(R.id.tb15);
        tb16 = (ToggleButton) view.findViewById(R.id.tb16);
        tb17 = (ToggleButton) view.findViewById(R.id.tb17);
        tb18 = (ToggleButton) view.findViewById(R.id.tb18);
        tb19 = (ToggleButton) view.findViewById(R.id.tb19);
        tb25 = (ToggleButton) view.findViewById(R.id.tb25);
        Log.d("initUI", view.findViewById(R.id.sv1).getId()+"");
    }

    private void setUI() {
        tb.clear();
        tb.add(tb07);
        tb.add(tb08);
        tb.add(tb09);
        tb.add(tb10);
        tb.add(tb11);
        tb.add(tb12);
        tb.add(tb13);
        tb.add(tb14);
        tb.add(tb15);
        tb.add(tb16);
        tb.add(tb17);
        tb.add(tb18);
        tb.add(tb19);
        tb.add(tb25);

        for(int i = 0; i < tb.size(); i++) {
            tb.get(i).setOnCheckedChangeListener(mChangeListener);
            tb.get(i).setText(getResources().getStringArray(R.array.schedule_time)[i]);
            tb.get(i).setTextOn(getResources().getStringArray(R.array.schedule_time)[i]);
            tb.get(i).setTextOff(getResources().getStringArray(R.array.schedule_time)[i]);
        }
        ((AddServiceStep4Activity)getActivity()).setListener(setDayOfWeek);
    }

    private CompoundButton.OnCheckedChangeListener mChangeListener =  new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Log.d("바뀌는 데이터", buttonView.getId() + "");
            for(int i = 0; i < tb.size(); i++) {
                if(tb.get(i).getId() == buttonView.getId() && !mBtnChanged) {
                    if(isChecked) {
                        DayOfWeekTimes data = new DayOfWeekTimes();
                        data.setDayofweek(mDayOfWeek);
                        data.setTimes(i);
                        times.add(data);
                        Log.d("최종 데이터-1", times.toString());
                        break;
                    } else {
                        for(int j = 0; j < times.size(); j++) {
                            if(times.get(j).getTimes() == i && times.get(j).getDayofweek() == mDayOfWeek) {
                                times.remove(j);
                                break;
                            }
                        }
                    }
                    Log.d("최종 데이터-1", times.toString());
                    break;
                }
            }
        }
    };

    public SendDataForFragment setDayOfWeek = new SendDataForFragment() {
        @Override
        public void setDayOfWeek(ArrayList<DayOfWeekTimes> timess, int mDayOfWeeks) {
            Log.d("데이터 받음 - 시간", times.toString() + " - " + tb.size());
            mBtnChanged = true;
            times = timess;
            mDayOfWeek = mDayOfWeeks;
            try {
                sv1.fullScroll(View.FOCUS_UP);
                for(ToggleButton tb : tb) {
                    tb.setChecked(false);
                }
                for(DayOfWeekTimes mt : times) {
                    tb.get(mt.getTimes()).setChecked(true);
                }
            } catch (NullPointerException e) {

                Log.d("에러", "널 포인트 " + e.toString());
            }
            mBtnChanged = false;
        }
    };

//    public void setDayOfWeek(ArrayList<DayOfWeekTimes> timess, int mDayOfWeeks) {
//        Log.d("데이터 받음 - 시간", times.toString() + " - " + tb.size());
//        mBtnChanged = true;
//        times = timess;
//        mDayOfWeek = mDayOfWeeks;
//        try {
//            sv1.fullScroll(View.FOCUS_UP);
//            for(ToggleButton tb : tb) {
//                tb.setChecked(false);
//            }
//            for(DayOfWeekTimes mt : times) {
//                tb.get(mt.getTimes()).setChecked(true);
//            }
//        } catch (NullPointerException e) {
//
//            Log.d("에러", "널 포인트 " + e.toString());
//        }
//        this.mBtnChanged = false;
//    }
}