package com.huawei.health.threeCircle.remind.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.oai;

/* JADX INFO: loaded from: classes5.dex */
public class ThreeCircleRemindData implements Parcelable {
    public static final Parcelable.Creator<ThreeCircleRemindData> CREATOR = new Parcelable.Creator<ThreeCircleRemindData>() { // from class: com.huawei.health.threeCircle.remind.model.ThreeCircleRemindData.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: aRs_, reason: merged with bridge method [inline-methods] */
        public ThreeCircleRemindData createFromParcel(Parcel parcel) {
            return new ThreeCircleRemindData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ThreeCircleRemindData[] newArray(int i) {
            return new ThreeCircleRemindData[i];
        }
    };
    private DeviceEventData mDeviceEventData;
    private int mPriority;
    private String mRemindText;
    private String mRemindType;
    private String mSubRemindType;
    private long mTimeMill;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ThreeCircleRemindData(Parcel parcel) {
        this.mRemindType = parcel.readString();
        this.mSubRemindType = parcel.readString();
        this.mPriority = parcel.readInt();
        this.mRemindText = parcel.readString();
        this.mDeviceEventData = (DeviceEventData) parcel.readParcelable(DeviceEventData.class.getClassLoader());
        this.mTimeMill = parcel.readLong();
    }

    private ThreeCircleRemindData(e eVar) {
        this.mRemindType = eVar.b;
        this.mPriority = eVar.d;
        this.mSubRemindType = eVar.e;
        this.mRemindText = eVar.f3565a;
        this.mDeviceEventData = eVar.c;
        this.mTimeMill = eVar.h;
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3565a;
        private String b;
        private DeviceEventData c;
        private int d;
        private String e;
        private long h;

        public ThreeCircleRemindData e() {
            return new ThreeCircleRemindData(this);
        }

        public e c(String str) {
            this.b = str;
            return this;
        }

        public e b(int i) {
            this.d = i;
            return this;
        }

        public e a(String str) {
            this.e = str;
            return this;
        }

        public e d(String str) {
            this.f3565a = str;
            return this;
        }

        public e d(DeviceEventData deviceEventData) {
            this.c = deviceEventData;
            return this;
        }

        public e a(long j) {
            this.h = j;
            return this;
        }
    }

    public int getPriority() {
        return this.mPriority;
    }

    public String getRemindType() {
        return this.mRemindType;
    }

    public String getRemindText() {
        return this.mRemindText;
    }

    public DeviceEventData getDeviceEventData() {
        return this.mDeviceEventData;
    }

    public String getSubRemindType() {
        return this.mSubRemindType;
    }

    public String toString() {
        return oai.b(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRemindType);
        parcel.writeString(this.mSubRemindType);
        parcel.writeInt(this.mPriority);
        parcel.writeString(this.mRemindText);
        parcel.writeParcelable(this.mDeviceEventData, i);
        parcel.writeLong(this.mTimeMill);
    }
}
