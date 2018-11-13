package com.ighai.testapp.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class DayOfWeekRegions implements Parcelable {
    private int dayofweek;
    private String si;
    private String gugun;
    private String dong;
    private String ri;
    private String apt;

    public DayOfWeekRegions() {
    }

    public DayOfWeekRegions(int dayofweek, String si, String gugun, String dong, String ri, String apt) {
        this.dayofweek = dayofweek;
        this.si = si;
        this.gugun = gugun;
        this.dong = dong;
        this.ri = ri;
        this.apt = apt;
    }

    protected DayOfWeekRegions(Parcel in) {
        dayofweek = in.readInt();
        si = in.readString();
        gugun = in.readString();
        dong = in.readString();
        ri = in.readString();
        apt = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dayofweek);
        dest.writeString(si);
        dest.writeString(gugun);
        dest.writeString(dong);
        dest.writeString(ri);
        dest.writeString(apt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DayOfWeekRegions> CREATOR = new Creator<DayOfWeekRegions>() {
        @Override
        public DayOfWeekRegions createFromParcel(Parcel in) {
            return new DayOfWeekRegions(in);
        }

        @Override
        public DayOfWeekRegions[] newArray(int size) {
            return new DayOfWeekRegions[size];
        }
    };

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }
}
