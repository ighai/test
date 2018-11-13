package com.ighai.testapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ighai.testapp.R;


public class ScheduleLocationFragment extends Fragment {


//    private ArrayList<managerServiceRegion> regions = new ArrayList<>();

    public static ScheduleLocationFragment newInstance() {
        ScheduleLocationFragment f = new ScheduleLocationFragment();
        Bundle b = new Bundle();
//        b.putSerializable(NeConstant.Fragment.Argument.CAR_INFO, carInfo);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_schedule_location, container, false);

        initUI(view);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUI();
    }

    private void initUI(View view) {

    }

    private void setUI() {

    }
}