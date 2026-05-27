package com.huawei.ui.main.stories.health.interactors.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.ui.commonui.linechart.icommon.IStorageModel;

/* JADX INFO: loaded from: classes8.dex */
public class RunningDayData implements Parcelable, IStorageModel {
    public static final Parcelable.Creator<RunningDayData> CREATOR = new Parcelable.Creator<RunningDayData>() { // from class: com.huawei.ui.main.stories.health.interactors.healthdata.RunningDayData.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: dZw_, reason: merged with bridge method [inline-methods] */
        public RunningDayData createFromParcel(Parcel parcel) {
            return new RunningDayData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RunningDayData[] newArray(int i) {
            return new RunningDayData[i];
        }
    };
    private float mCurrentRunLevel;
    private float mRealRunLevel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RunningDayData() {
    }

    protected RunningDayData(Parcel parcel) {
        this.mCurrentRunLevel = parcel.readFloat();
        this.mRealRunLevel = parcel.readFloat();
    }

    public float getCurrentRunLevel() {
        return this.mCurrentRunLevel;
    }

    public void setCurrentRunLevel(float f) {
        this.mCurrentRunLevel = f;
    }

    public float getRealRunLevel() {
        return this.mRealRunLevel;
    }

    public void setRealRunLevel(float f) {
        this.mRealRunLevel = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.mCurrentRunLevel);
        parcel.writeFloat(this.mRealRunLevel);
    }
}
