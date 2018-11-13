package com.ighai.testapp.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ServiceSettingDayOfWeek implements Parcelable{

    private ArrayList<DayOfWeekTimes> dayOfWeekTimes;
    private ArrayList<DayOfWeekRegions> dayOfWeekRegions;
    private ArrayList<DayOfWeekLimits> limits;

    public ServiceSettingDayOfWeek() {
        dayOfWeekTimes = new ArrayList<>();
        dayOfWeekRegions = new ArrayList<>();
        limits = new ArrayList<>();
    }

    public ServiceSettingDayOfWeek(ArrayList<DayOfWeekTimes> dayOfWeekTimes, ArrayList<DayOfWeekRegions> dayOfWeekRegions, ArrayList<DayOfWeekLimits> limits) {
        this.dayOfWeekTimes = dayOfWeekTimes;
        this.dayOfWeekRegions = dayOfWeekRegions;
        this.limits = limits;
    }

    protected ServiceSettingDayOfWeek(Parcel in) {
        dayOfWeekTimes = in.createTypedArrayList(DayOfWeekTimes.CREATOR);
        dayOfWeekRegions = in.createTypedArrayList(DayOfWeekRegions.CREATOR);
        limits = in.createTypedArrayList(DayOfWeekLimits.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(dayOfWeekTimes);
        dest.writeTypedList(dayOfWeekRegions);
        dest.writeTypedList(limits);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ServiceSettingDayOfWeek> CREATOR = new Creator<ServiceSettingDayOfWeek>() {
        @Override
        public ServiceSettingDayOfWeek createFromParcel(Parcel in) {
            return new ServiceSettingDayOfWeek(in);
        }

        @Override
        public ServiceSettingDayOfWeek[] newArray(int size) {
            return new ServiceSettingDayOfWeek[size];
        }
    };

    public ArrayList<DayOfWeekTimes> getDayOfWeekTimes() {
        return dayOfWeekTimes;
    }

    public void setDayOfWeekTimes(ArrayList<DayOfWeekTimes> dayOfWeekTimes) {
        this.dayOfWeekTimes = dayOfWeekTimes;
    }

    public ArrayList<DayOfWeekRegions> getDayOfWeekRegions() {
        return dayOfWeekRegions;
    }

    public void setDayOfWeekRegions(ArrayList<DayOfWeekRegions> dayOfWeekRegions) {
        this.dayOfWeekRegions = dayOfWeekRegions;
    }

    public ArrayList<DayOfWeekLimits> getLimits() {
        return limits;
    }

    public void setLimits(ArrayList<DayOfWeekLimits> limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
