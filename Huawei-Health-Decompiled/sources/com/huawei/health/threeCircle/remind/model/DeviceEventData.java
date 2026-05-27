package com.huawei.health.threeCircle.remind.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceEventData implements Parcelable {
    public static final Parcelable.Creator<DeviceEventData> CREATOR = new Parcelable.Creator<DeviceEventData>() { // from class: com.huawei.health.threeCircle.remind.model.DeviceEventData.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: aRr_, reason: merged with bridge method [inline-methods] */
        public DeviceEventData createFromParcel(Parcel parcel) {
            return new DeviceEventData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceEventData[] newArray(int i) {
            return new DeviceEventData[i];
        }
    };
    private static final int DEFAULT_VALUE = 255;
    private int mAchieveNum;
    private int mAvgActiveCalorie;
    private int mAvgActiveHour;
    private int mAvgStrengthTime;
    private int mCompletedDayNum;
    private int mEventId;
    private int mGoalType;
    private int mNoCompletedDayNum;
    private int mSmartActiveCalorieGoal;
    private long mTimeStamp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DeviceEventData(Parcel parcel) {
        this.mTimeStamp = parcel.readLong();
        this.mEventId = parcel.readInt();
        this.mGoalType = parcel.readInt();
        this.mAchieveNum = parcel.readInt();
        this.mAvgActiveCalorie = parcel.readInt();
        this.mAvgStrengthTime = parcel.readInt();
        this.mAvgActiveHour = parcel.readInt();
        this.mCompletedDayNum = parcel.readInt();
        this.mNoCompletedDayNum = parcel.readInt();
        this.mSmartActiveCalorieGoal = parcel.readInt();
    }

    private DeviceEventData(d dVar) {
        this.mTimeStamp = dVar.g;
        this.mEventId = dVar.i;
        this.mGoalType = dVar.f;
        this.mAchieveNum = dVar.c;
        this.mAvgActiveCalorie = dVar.f3564a;
        this.mAvgStrengthTime = dVar.b;
        this.mAvgActiveHour = dVar.d;
        this.mCompletedDayNum = dVar.e;
        this.mNoCompletedDayNum = dVar.h;
        this.mSmartActiveCalorieGoal = dVar.j;
    }

    public static final class d {
        private int f;
        private long g;
        private int i;
        private int c = 255;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3564a = Integer.MAX_VALUE;
        private int b = Integer.MAX_VALUE;
        private int d = 255;
        private int e = 255;
        private int h = 255;
        private int j = Integer.MAX_VALUE;

        public DeviceEventData c() {
            return new DeviceEventData(this);
        }

        public d d(long j) {
            this.g = j;
            return this;
        }

        public d i(int i) {
            this.i = i;
            return this;
        }

        public d f(int i) {
            this.f = i;
            return this;
        }

        public d c(int i) {
            this.c = i;
            return this;
        }

        public d d(int i) {
            this.f3564a = i;
            return this;
        }

        public d e(int i) {
            this.b = i;
            return this;
        }

        public d a(int i) {
            this.d = i;
            return this;
        }

        public d b(int i) {
            this.e = i;
            return this;
        }

        public d j(int i) {
            this.h = i;
            return this;
        }

        public d g(int i) {
            this.j = i;
            return this;
        }
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public int getEventId() {
        return this.mEventId;
    }

    public int getGoalType() {
        return this.mGoalType;
    }

    public int getAchieveNum() {
        return this.mAchieveNum;
    }

    public int getAvgActiveCalorie() {
        return this.mAvgActiveCalorie;
    }

    public int getAvgStrengthTime() {
        return this.mAvgStrengthTime;
    }

    public int getAvgActiveHour() {
        return this.mAvgActiveHour;
    }

    public int getSmartActiveCalorieGoal() {
        return this.mSmartActiveCalorieGoal;
    }

    public int getCompletedDayNum() {
        return this.mCompletedDayNum;
    }

    public int getNoCompletedDayNum() {
        return this.mNoCompletedDayNum;
    }

    public byte[] getBytes() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt((int) this.mTimeStamp);
        byteBufferAllocate.put((byte) this.mEventId);
        byteBufferAllocate.put((byte) this.mGoalType);
        byteBufferAllocate.put((byte) this.mAchieveNum);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.putInt(this.mAvgActiveCalorie);
        byteBufferAllocate.putInt(this.mAvgStrengthTime);
        byteBufferAllocate.put((byte) this.mAvgActiveHour);
        byteBufferAllocate.put((byte) this.mCompletedDayNum);
        byteBufferAllocate.put((byte) this.mNoCompletedDayNum);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.putInt(this.mSmartActiveCalorieGoal);
        byteBufferAllocate.flip();
        return byteBufferAllocate.array();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTimeStamp);
        parcel.writeInt(this.mEventId);
        parcel.writeInt(this.mGoalType);
        parcel.writeInt(this.mAchieveNum);
        parcel.writeInt(this.mAvgActiveCalorie);
        parcel.writeInt(this.mAvgStrengthTime);
        parcel.writeInt(this.mAvgActiveHour);
        parcel.writeInt(this.mCompletedDayNum);
        parcel.writeInt(this.mNoCompletedDayNum);
        parcel.writeInt(this.mSmartActiveCalorieGoal);
    }
}
