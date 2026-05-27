package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ParcelableMap<k, t> implements Parcelable {
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new b();
    private static final String TAG = "ParcelableMap";
    private Map<k, t> map;

    static final class b implements Parcelable.Creator<ParcelableMap> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ParcelableMap[] newArray(int i) {
            return new ParcelableMap[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: gn_, reason: merged with bridge method [inline-methods] */
        public ParcelableMap createFromParcel(Parcel parcel) {
            return new ParcelableMap(parcel, null);
        }
    }

    /* synthetic */ ParcelableMap(Parcel parcel, b bVar) {
        this(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.map = parcel.readHashMap(ParcelableMap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<k, t> getMap() {
        return this.map;
    }

    public void setMap(Map<k, t> map) {
        this.map = map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    private ParcelableMap(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ParcelableMap() {
    }
}
