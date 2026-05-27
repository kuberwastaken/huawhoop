package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class FileIdentificationParcel implements Parcelable {
    public static final Parcelable.Creator<FileIdentificationParcel> CREATOR = new Parcelable.Creator<FileIdentificationParcel>() { // from class: com.huawei.wearengine.p2p.FileIdentificationParcel.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: fCL_, reason: merged with bridge method [inline-methods] */
        public FileIdentificationParcel createFromParcel(Parcel parcel) {
            FileIdentificationParcel fileIdentificationParcel = new FileIdentificationParcel();
            if (parcel != null) {
                fileIdentificationParcel.setFileName(parcel.readString());
                fileIdentificationParcel.setDescription(parcel.readString());
                fileIdentificationParcel.setExtendJson(parcel.readString());
            }
            return fileIdentificationParcel;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public FileIdentificationParcel[] newArray(int i) {
            return (i > 65535 || i < 0) ? new FileIdentificationParcel[0] : new FileIdentificationParcel[i];
        }
    };
    private String mDescription;
    private String mExtendJson;
    private String mFileName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mFileName);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mExtendJson);
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getExtendJson() {
        return this.mExtendJson;
    }

    public void setExtendJson(String str) {
        this.mExtendJson = str;
    }
}
