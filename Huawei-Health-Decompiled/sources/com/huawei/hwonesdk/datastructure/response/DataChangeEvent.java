package com.huawei.hwonesdk.datastructure.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;

/* JADX INFO: loaded from: classes6.dex */
public class DataChangeEvent implements Parcelable {
    public static final Parcelable.Creator<DataChangeEvent> CREATOR = new Parcelable.Creator<DataChangeEvent>() { // from class: com.huawei.hwonesdk.datastructure.response.DataChangeEvent.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bYy_, reason: merged with bridge method [inline-methods] */
        public DataChangeEvent createFromParcel(Parcel parcel) {
            return new DataChangeEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DataChangeEvent[] newArray(int i) {
            return new DataChangeEvent[i];
        }
    };

    @SerializedName("dataTimeRange")
    private DataChangeTimeRangeType dataTimeRange;

    @SerializedName("externalDataType")
    private DataType externalDataType;

    @SerializedName("unsubscribeRes")
    private boolean unsubscribeRes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected DataChangeEvent(Parcel parcel) {
        this.externalDataType = (DataType) parcel.readParcelable(DataType.class.getClassLoader());
        this.dataTimeRange = (DataChangeTimeRangeType) parcel.readParcelable(DataChangeTimeRangeType.class.getClassLoader());
        this.unsubscribeRes = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.externalDataType, i);
        parcel.writeParcelable(this.dataTimeRange, i);
        parcel.writeByte(this.unsubscribeRes ? (byte) 1 : (byte) 0);
    }

    static class DataChangeTimeRangeType implements Parcelable {
        public static final Parcelable.Creator<DataChangeTimeRangeType> CREATOR = new Parcelable.Creator<DataChangeTimeRangeType>() { // from class: com.huawei.hwonesdk.datastructure.response.DataChangeEvent.DataChangeTimeRangeType.4
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: bYz_, reason: merged with bridge method [inline-methods] */
            public DataChangeTimeRangeType createFromParcel(Parcel parcel) {
                return new DataChangeTimeRangeType(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public DataChangeTimeRangeType[] newArray(int i) {
                return new DataChangeTimeRangeType[i];
            }
        };

        @SerializedName("dataType")
        private DataType dataType;

        @SerializedName("maxStartTime")
        private long maxStartTime;

        @SerializedName("minStartTime")
        private long minStartTime;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public DataChangeTimeRangeType(DataType dataType, long j, long j2) {
            this.dataType = dataType;
            this.minStartTime = j;
            this.maxStartTime = j2;
        }

        public DataChangeTimeRangeType() {
        }

        protected DataChangeTimeRangeType(Parcel parcel) {
            this.dataType = (DataType) parcel.readParcelable(DataType.class.getClassLoader());
            this.minStartTime = parcel.readLong();
            this.maxStartTime = parcel.readLong();
        }

        public DataType getDataType() {
            return this.dataType;
        }

        public void setDataType(DataType dataType) {
            this.dataType = dataType;
        }

        public long getMinStartTime() {
            return this.minStartTime;
        }

        public void setMinStartTime(long j) {
            this.minStartTime = j;
        }

        public long getMaxStartTime() {
            return this.maxStartTime;
        }

        public void setMaxStartTime(long j) {
            this.maxStartTime = j;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.dataType, i);
            parcel.writeLong(this.minStartTime);
            parcel.writeLong(this.maxStartTime);
        }
    }

    public DataChangeEvent() {
    }

    public DataChangeEvent(DataType dataType, DataChangeTimeRangeType dataChangeTimeRangeType, boolean z) {
        this.externalDataType = dataType;
        this.dataTimeRange = dataChangeTimeRangeType;
        this.unsubscribeRes = z;
    }

    public void setDataTimeRange(DataType dataType, long j, long j2) {
        setDataTimeRange(new DataChangeTimeRangeType(dataType, j, j2));
    }

    public void setDataTimeRange(DataChangeTimeRangeType dataChangeTimeRangeType) {
        this.dataTimeRange = dataChangeTimeRangeType;
    }

    public void setDataType(DataType dataType) {
        this.externalDataType = dataType;
    }

    public void setUnsubscribeRes(boolean z) {
        this.unsubscribeRes = z;
    }
}
