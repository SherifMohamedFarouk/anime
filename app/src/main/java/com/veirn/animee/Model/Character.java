package com.veirn.animee.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Character implements Parcelable {

    @SerializedName("mal_id")
    @Expose
    private Integer malId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("voice_actors")
    @Expose
    private List<VoiceActor> voiceActors = null;

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<VoiceActor> getVoiceActors() {
        return voiceActors;
    }

    public void setVoiceActors(List<VoiceActor> voiceActors) {
        this.voiceActors = voiceActors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.malId);
        dest.writeString(this.url);
        dest.writeString(this.imageUrl);
        dest.writeString(this.name);
        dest.writeString(this.role);
        dest.writeList(this.voiceActors);
    }

    public Character() {
    }

    protected Character(Parcel in) {
        this.malId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.url = in.readString();
        this.imageUrl = in.readString();
        this.name = in.readString();
        this.role = in.readString();
        this.voiceActors = new ArrayList<VoiceActor>();
        in.readList(this.voiceActors, VoiceActor.class.getClassLoader());
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel source) {
            return new Character(source);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };
}