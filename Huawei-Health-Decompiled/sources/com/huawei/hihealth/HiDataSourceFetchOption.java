package com.huawei.hihealth;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class HiDataSourceFetchOption implements Parcelable {
    public static final Parcelable.Creator<HiDataSourceFetchOption> CREATOR = new Parcelable.Creator<HiDataSourceFetchOption>() { // from class: com.huawei.hihealth.HiDataSourceFetchOption.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bAt_, reason: merged with bridge method [inline-methods] */
        public HiDataSourceFetchOption createFromParcel(Parcel parcel) {
            return new HiDataSourceFetchOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HiDataSourceFetchOption[] newArray(int i) {
            return new HiDataSourceFetchOption[i];
        }
    };
    private static final String FETCH_TYPE = "fetchType";
    private final int[] mClientIds;
    private final ContentValues mValueHolder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private HiDataSourceFetchOption(Parcel parcel) {
        this.mValueHolder = (ContentValues) parcel.readParcelable(ContentValues.class.getClassLoader());
        this.mClientIds = parcel.createIntArray();
    }

    private HiDataSourceFetchOption(ContentValues contentValues, int[] iArr) {
        this.mValueHolder = contentValues;
        this.mClientIds = iArr == null ? new int[0] : iArr;
    }

    public Integer getFetchType() {
        ContentValues contentValues = this.mValueHolder;
        if (contentValues != null) {
            return contentValues.getAsInteger(FETCH_TYPE);
        }
        return null;
    }

    public int[] getClientIds() {
        return (int[]) this.mClientIds.clone();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mValueHolder, i);
        parcel.writeIntArray(this.mClientIds);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ContentValues c;
        private int[] e;

        public Builder b(Integer num) {
            bAu_().put(HiDataSourceFetchOption.FETCH_TYPE, num);
            return this;
        }

        public Builder d(int[] iArr) {
            this.e = (int[]) iArr.clone();
            return this;
        }

        public HiDataSourceFetchOption a() {
            return new HiDataSourceFetchOption(this.c, this.e);
        }

        private ContentValues bAu_() {
            if (this.c == null) {
                this.c = new ContentValues();
            }
            return this.c;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDataSourceFetchOption {");
        stringBuffer.append(this.mValueHolder);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
