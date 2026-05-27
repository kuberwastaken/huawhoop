package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QueryIsoLanguageResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<QueryIsoLanguageResponse> CREATOR = new c();
    private static final long serialVersionUID = 1084303714530711384L;

    @SerializedName("langCode")
    private String langCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.langCode);
    }

    public void setLangCode(String str) {
        this.langCode = str;
    }

    class c implements Parcelable.Creator<QueryIsoLanguageResponse> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public QueryIsoLanguageResponse[] newArray(int i) {
            return new QueryIsoLanguageResponse[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryIsoLanguageResponse createFromParcel(Parcel parcel) {
            return new QueryIsoLanguageResponse(parcel);
        }

        c() {
        }
    }

    public String getLangCode() {
        return this.langCode;
    }

    protected QueryIsoLanguageResponse(Parcel parcel) {
        this.langCode = parcel.readString();
    }
}
