package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class HwObject implements Parcelable {
    public static final Parcelable.Creator<HwObject> CREATOR = new Parcelable.Creator<HwObject>() { // from class: com.huawei.android.airsharing.api.HwObject.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HwObject[] newArray(int i) {
            return new HwObject[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eT_, reason: merged with bridge method [inline-methods] */
        public HwObject createFromParcel(Parcel parcel) {
            HwObject hwObject = new HwObject();
            hwObject.setExtendObj(parcel.readValue(Object.class.getClassLoader()));
            return hwObject;
        }
    };
    protected Object extendObj;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getExtendObj() {
        return this.extendObj;
    }

    public void setExtendObj(Object obj) {
        this.extendObj = obj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeValue(this.extendObj);
        }
    }

    public HwObject copy() {
        HwObject hwObject = new HwObject();
        hwObject.setExtendObj(this.extendObj);
        return hwObject;
    }
}
