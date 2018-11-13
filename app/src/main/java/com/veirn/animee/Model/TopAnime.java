package com.veirn.animee.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TopAnime implements Parcelable {

    @SerializedName("request_hash")
    @Expose
    private String requestHash;
    @SerializedName("request_cached")
    @Expose
    private Boolean requestCached;
    @SerializedName("request_cache_expiry")
    @Expose
    private Integer requestCacheExpiry;
    @SerializedName("top")
    @Expose
    private List<Top> top = null;

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public Boolean getRequestCached() {
        return requestCached;
    }

    public void setRequestCached(Boolean requestCached) {
        this.requestCached = requestCached;
    }

    public Integer getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(Integer requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public List<Top> getTop() {
        return top;
    }

    public void setTop(List<Top> top) {
        this.top = top;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.requestHash);
        dest.writeValue(this.requestCached);
        dest.writeValue(this.requestCacheExpiry);
        dest.writeTypedList(this.top);
    }

    public TopAnime() {
    }

    protected TopAnime(Parcel in) {
        this.requestHash = in.readString();
        this.requestCached = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.requestCacheExpiry = (Integer) in.readValue(Integer.class.getClassLoader());
        this.top = in.createTypedArrayList(Top.CREATOR);
    }

    public static final Parcelable.Creator<TopAnime> CREATOR = new Parcelable.Creator<TopAnime>() {
        @Override
        public TopAnime createFromParcel(Parcel source) {
            return new TopAnime(source);
        }

        @Override
        public TopAnime[] newArray(int size) {
            return new TopAnime[size];
        }
    };
}