package com.oguzhandongul.easydialog.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emretekin on 22/11/16.
 */

public class SelectionModel implements Parcelable {

    int id;
    int shareIcon;
    String shareTitle;

    public SelectionModel(int id, int shareIcon, String shareTitle) {
        this.id = id;
        this.shareIcon = shareIcon;
        this.shareTitle = shareTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShareIcon() {
        return shareIcon;
    }

    public void setShareIcon(int shareIcon) {
        this.shareIcon = shareIcon;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    protected SelectionModel(Parcel in) {
        id = in.readInt();
        shareIcon = in.readInt();
        shareTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(shareIcon);
        dest.writeString(shareTitle);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SelectionModel> CREATOR = new Parcelable.Creator<SelectionModel>() {
        @Override
        public SelectionModel createFromParcel(Parcel in) {
            return new SelectionModel(in);
        }

        @Override
        public SelectionModel[] newArray(int size) {
            return new SelectionModel[size];
        }
    };
}
