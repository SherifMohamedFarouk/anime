package com.veirn.animee.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Top implements Parcelable {

    @SerializedName("mal_id")
    @Expose
    private Integer malId;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("episodes")
    @Expose
    private Integer episodes;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("members")
    @Expose
    private Integer members;
    @SerializedName("score")
    @Expose
    private Double score;

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.malId);
        dest.writeValue(this.rank);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.imageUrl);
        dest.writeString(this.type);
        dest.writeValue(this.episodes);
        dest.writeString(this.startDate);
        dest.writeString(this.endDate);
        dest.writeValue(this.members);
        dest.writeValue(this.score);
    }

    public Top() {
    }

    protected Top(Parcel in) {
        this.malId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rank = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.url = in.readString();
        this.imageUrl = in.readString();
        this.type = in.readString();
        this.episodes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.members = (Integer) in.readValue(Integer.class.getClassLoader());
        this.score = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Top> CREATOR = new Parcelable.Creator<Top>() {
        @Override
        public Top createFromParcel(Parcel source) {
            return new Top(source);
        }

        @Override
        public Top[] newArray(int size) {
            return new Top[size];
        }
    };
}