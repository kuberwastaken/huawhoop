package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HiSampleConfig implements Parcelable {
    public static final Parcelable.Creator<HiSampleConfig> CREATOR = new Parcelable.Creator<HiSampleConfig>() { // from class: com.huawei.hihealth.HiSampleConfig.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bAK_, reason: merged with bridge method [inline-methods] */
        public HiSampleConfig createFromParcel(Parcel parcel) {
            return new HiSampleConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HiSampleConfig[] newArray(int i) {
            return new HiSampleConfig[i];
        }
    };
    private int mClientId;
    private String mConfigData;
    private String mConfigDescription;
    private String mConfigId;
    private String mDeviceUniqueId;
    private int mId;
    private String mMetaData;
    private long mModifiedTime;
    private String mPackageName;
    private String mScopeApp;
    private String mScopeDeviceType;
    private int mSyncStatus;
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HiSampleConfig() {
        this.mModifiedTime = System.currentTimeMillis();
    }

    public int getId() {
        return this.mId;
    }

    public String getType() {
        return this.mType;
    }

    public String getConfigId() {
        return this.mConfigId;
    }

    public String getScopeApp() {
        return this.mScopeApp;
    }

    public String getScopeDeviceType() {
        return this.mScopeDeviceType;
    }

    public String getConfigData() {
        return this.mConfigData;
    }

    public String getConfigDescription() {
        return this.mConfigDescription;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public int getClientId() {
        return this.mClientId;
    }

    public int getSyncStatus() {
        return this.mSyncStatus;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public String getDeviceUniqueId() {
        return this.mDeviceUniqueId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mId);
        parcel.writeString(this.mType);
        parcel.writeString(this.mConfigId);
        parcel.writeString(this.mScopeApp);
        parcel.writeString(this.mScopeDeviceType);
        parcel.writeString(this.mConfigData);
        parcel.writeString(this.mConfigDescription);
        parcel.writeString(this.mMetaData);
        parcel.writeInt(this.mClientId);
        parcel.writeInt(this.mSyncStatus);
        parcel.writeLong(this.mModifiedTime);
        parcel.writeString(this.mDeviceUniqueId);
        parcel.writeString(this.mPackageName);
    }

    protected HiSampleConfig(Parcel parcel) {
        this.mModifiedTime = System.currentTimeMillis();
        this.mId = parcel.readInt();
        this.mType = parcel.readString();
        this.mConfigId = parcel.readString();
        this.mScopeApp = parcel.readString();
        this.mScopeDeviceType = parcel.readString();
        this.mConfigData = parcel.readString();
        this.mConfigDescription = parcel.readString();
        this.mMetaData = parcel.readString();
        this.mClientId = parcel.readInt();
        this.mSyncStatus = parcel.readInt();
        this.mModifiedTime = parcel.readLong();
        this.mDeviceUniqueId = parcel.readString();
        this.mPackageName = parcel.readString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiSampleConfig {id=");
        stringBuffer.append(this.mId);
        stringBuffer.append(",tp=").append(this.mType);
        stringBuffer.append(",cfgId=").append(this.mConfigId);
        stringBuffer.append(",scApp=").append(this.mScopeApp);
        stringBuffer.append(",scDevTp=").append(this.mScopeDeviceType);
        stringBuffer.append(",cfgDt=").append(this.mConfigData);
        stringBuffer.append(",cfgDesp=").append(this.mConfigDescription);
        stringBuffer.append(",mtDt=").append(this.mMetaData);
        stringBuffer.append(",clntId=").append(this.mClientId);
        stringBuffer.append(",sStatus=").append(this.mSyncStatus);
        stringBuffer.append(",mTm=").append(this.mModifiedTime);
        stringBuffer.append(",devUId=").append(this.mDeviceUniqueId);
        stringBuffer.append(",pkgNm=").append(this.mPackageName);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public HiSampleConfig(Builder builder) {
        this.mModifiedTime = System.currentTimeMillis();
        this.mId = builder.f;
        this.mType = builder.m;
        this.mConfigId = builder.f4200a;
        this.mScopeApp = builder.i;
        this.mScopeDeviceType = builder.n;
        this.mConfigData = builder.e;
        this.mConfigDescription = builder.c;
        this.mMetaData = builder.g;
        this.mClientId = builder.b;
        this.mSyncStatus = builder.k;
        this.mModifiedTime = builder.j;
        this.mDeviceUniqueId = builder.d;
        this.mPackageName = builder.h;
    }

    public Builder toBuilder() {
        return new Builder().d(this.mClientId).i(this.mType).a(this.mConfigId).g(this.mScopeApp).h(this.mScopeDeviceType).b(this.mConfigData).e(this.mConfigDescription).c(this.mMetaData).a(this.mClientId).b(this.mSyncStatus).d(this.mModifiedTime).d(this.mDeviceUniqueId).f(this.mPackageName);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4200a;
        private int b;
        private String c;
        private String d;
        private String e;
        private int f;
        private String g;
        private String h;
        private String i;
        private long j;
        private int k;
        private String m;
        private String n;

        public Builder d(int i) {
            this.f = i;
            return this;
        }

        public Builder i(String str) {
            this.m = str;
            return this;
        }

        public Builder a(String str) {
            this.f4200a = str;
            return this;
        }

        public Builder g(String str) {
            this.i = str;
            return this;
        }

        public Builder h(String str) {
            this.n = str;
            return this;
        }

        public Builder b(String str) {
            this.e = str;
            return this;
        }

        public Builder e(String str) {
            this.c = str;
            return this;
        }

        public Builder c(String str) {
            this.g = str;
            return this;
        }

        public Builder a(int i) {
            this.b = i;
            return this;
        }

        public Builder b(int i) {
            this.k = i;
            return this;
        }

        public Builder d(long j) {
            this.j = j;
            return this;
        }

        public Builder d(String str) {
            this.d = str;
            return this;
        }

        public Builder f(String str) {
            this.h = str;
            return this;
        }

        public HiSampleConfig d() {
            return new HiSampleConfig(this);
        }
    }
}
