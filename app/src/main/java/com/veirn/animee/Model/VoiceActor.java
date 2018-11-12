package com.veirn.animee.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoiceActor implements Parcelable {

    @SerializedName("mal_id")
    @Expose
    private Integer malId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("language")
    @Expose
    private String language;

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.malId);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.imageUrl);
        dest.writeString(this.language);
    }

    public VoiceActor() {
    }

    protected VoiceActor(Parcel in) {
        this.malId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.url = in.readString();
        this.imageUrl = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<VoiceActor> CREATOR = new Parcelable.Creator<VoiceActor>() {
        @Override
        public VoiceActor createFromParcel(Parcel source) {
            return new VoiceActor(source);
        }

        @Override
        public VoiceActor[] newArray(int size) {
            return new VoiceActor[size];
        }
    };
}