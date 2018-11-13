package com.ighai.testapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.ighai.testapp.R;


public class ScheduleLimitFragment extends Fragment {

    private EditText mEtLimit;
    private View mLl1;

//    private ArrayList<managerServiceDayLimit> mLimit;
    private int selectedNum = -1;
    private boolean mEtChanged = true;

    public static ScheduleLimitFragment newInstance() {
        ScheduleLimitFragment f = new ScheduleLimitFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_schedule_limit, container, false);

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
        mEtLimit = (EditText) view.findViewById(R.id.et_limit);
        mLl1 = view.findViewById(R.id.ll1);
    }

    private void setUI() {
        mEtLimit.addTextChangedListener(ChangeListener);
        mLl1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    clearFocus();
                }
                return false;
            }
        });
    }

    private TextWatcher ChangeListener = new TextWatcher() {
        private String beforeText = "0";
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            beforeText = s.toString();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().length() > 0 && !mEtChanged) {
                if(Integer.parseInt(s.toString()) < 0) {
                    mEtLimit.setText(beforeText);
                } else {
//                    mLimit.get(selectedNum).setDay_limit(Integer.parseInt(s.toString()));
                }
            }
        }
    };

    public void clearFocus(){
        if (mEtLimit.isFocused()) {
            mEtLimit.clearFocus();
            InputMethodManager imm = (InputMethodManager) mLl1.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mLl1.getWindowToken(), 0);
        }
    }
}
