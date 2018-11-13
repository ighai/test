package com.ighai.testapp.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class DayOfWeekTimes implements Parcelable {

    private int dayofweek;
    private int times;

    public DayOfWeekTimes() {
    }

    public DayOfWeekTimes(int dayofweek, int times) {
        this.dayofweek = dayofweek;
        this.times = times;
    }

    protected DayOfWeekTimes(Parcel in) {
        dayofweek = in.readInt();
        times = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dayofweek);
        dest.writeInt(times);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DayOfWeekTimes> CREATOR = new Creator<DayOfWeekTimes>() {
        @Override
        public DayOfWeekTimes createFromParcel(Parcel in) {
            return new DayOfWeekTimes(in);
        }

        @Override
        public DayOfWeekTimes[] newArray(int size) {
            return new DayOfWeekTimes[size];
        }
    };

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
