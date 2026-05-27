package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class QueryNoticeResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<QueryNoticeResponse> CREATOR = new b();
    private static final long serialVersionUID = -3769914540947941717L;

    @SerializedName("content")
    private String content;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("language")
    private String language;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.countryCode);
        parcel.writeString(this.language);
        parcel.writeString(this.content);
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    class b implements Parcelable.Creator<QueryNoticeResponse> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public QueryNoticeResponse[] newArray(int i) {
            return new QueryNoticeResponse[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: clP_, reason: merged with bridge method [inline-methods] */
        public QueryNoticeResponse createFromParcel(Parcel parcel) {
            return new QueryNoticeResponse(parcel);
        }

        b() {
        }
    }

    public String getContent() {
        return this.content;
    }

    protected QueryNoticeResponse(Parcel parcel) {
        this.countryCode = parcel.readString();
        this.language = parcel.readString();
        this.content = parcel.readString();
    }
}
