package com.ighai.testapp.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class DayOfWeekLimits implements Parcelable {
    private int dayofweek;
    private int limit;

    public DayOfWeekLimits() {
    }

    public DayOfWeekLimits(int dayofweek, int limit) {
        this.dayofweek = dayofweek;
        this.limit = limit;
    }

    protected DayOfWeekLimits(Parcel in) {
        dayofweek = in.readInt();
        limit = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dayofweek);
        dest.writeInt(limit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DayOfWeekLimits> CREATOR = new Creator<DayOfWeekLimits>() {
        @Override
        public DayOfWeekLimits createFromParcel(Parcel in) {
            return new DayOfWeekLimits(in);
        }

        @Override
        public DayOfWeekLimits[] newArray(int size) {
            return new DayOfWeekLimits[size];
        }
    };

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
