package com.silaw.moviecatalogue;


import android.os.Parcel;
import android.os.Parcelable;

class Movie implements Parcelable {
    private int photo;
    private String title;
    private String description;
    private String genre;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.genre);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.photo = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.genre = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
