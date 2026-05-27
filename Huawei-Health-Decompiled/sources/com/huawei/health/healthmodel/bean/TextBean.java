package com.huawei.health.healthmodel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class TextBean implements Parcelable {
    public static final Parcelable.Creator<TextBean> CREATOR = new Parcelable.Creator<TextBean>() { // from class: com.huawei.health.healthmodel.bean.TextBean.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: acb_, reason: merged with bridge method [inline-methods] */
        public TextBean createFromParcel(Parcel parcel) {
            return new TextBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public TextBean[] newArray(int i) {
            return new TextBean[i];
        }
    };

    @SerializedName("placeholderList")
    private ArrayList<PlaceholderBean> mPlaceholderBeanList;

    @SerializedName("text")
    private String mText;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextBean() {
    }

    public TextBean(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        this.mText = parcel.readString();
        this.mPlaceholderBeanList = parcel.createTypedArrayList(PlaceholderBean.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mText);
        parcel.writeTypedList(this.mPlaceholderBeanList);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public String getText() {
        return this.mText;
    }

    public void setPlaceholderList(ArrayList<PlaceholderBean> arrayList) {
        this.mPlaceholderBeanList = arrayList;
    }

    public ArrayList<PlaceholderBean> getPlaceholderList() {
        return this.mPlaceholderBeanList;
    }

    public String toString() {
        return "TextBean{mText=" + this.mText + ", mPlaceholderBeanList=" + this.mPlaceholderBeanList + "}";
    }
}
