package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.kqt;

/* JADX INFO: loaded from: classes5.dex */
public class MsgText implements Parcelable {
    public static final Parcelable.Creator<MsgText> CREATOR = new Parcelable.Creator<MsgText>() { // from class: com.huawei.hwcommonmodel.datatypes.MsgText.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bLj_, reason: merged with bridge method [inline-methods] */
        public MsgText createFromParcel(Parcel parcel) {
            return new MsgText(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public MsgText[] newArray(int i) {
            return new MsgText[i];
        }
    };
    private String textContent;
    private int textType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MsgText() {
    }

    public MsgText(int i, String str) {
        this.textType = i;
        this.textContent = str;
    }

    protected MsgText(Parcel parcel) {
        this.textType = parcel.readInt();
        this.textContent = parcel.readString();
    }

    public int getTextType() {
        return ((Integer) kqt.e(Integer.valueOf(this.textType))).intValue();
    }

    public void setTextType(int i) {
        this.textType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getTextContent() {
        return (String) kqt.e(this.textContent);
    }

    public void setTextContent(String str) {
        this.textContent = (String) kqt.e(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.textType);
        parcel.writeString(this.textContent);
    }
}
