package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FeedMedia implements Serializable, Parcelable {
    public static final Parcelable.Creator<FeedMedia> CREATOR = new c();
    private static final long serialVersionUID = -6196153509419034853L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("size")
    private String f8602a;

    @SerializedName("attachId")
    private String b;

    @SerializedName("downloadURL")
    private String c;

    @SerializedName("isReplay")
    private boolean d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8602a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
    }

    public String getSize() {
        return this.f8602a;
    }

    public String getDownloadURL() {
        return this.c;
    }

    class c implements Parcelable.Creator<FeedMedia> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public FeedMedia[] newArray(int i) {
            return new FeedMedia[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: clL_, reason: merged with bridge method [inline-methods] */
        public FeedMedia createFromParcel(Parcel parcel) {
            return new FeedMedia(parcel);
        }

        c() {
        }
    }

    public String getAttachId() {
        return this.b;
    }

    protected FeedMedia(Parcel parcel) {
        this.d = false;
        this.f8602a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readByte() != 0;
    }
}
