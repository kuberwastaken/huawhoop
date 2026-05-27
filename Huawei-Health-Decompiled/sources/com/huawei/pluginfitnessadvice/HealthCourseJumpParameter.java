package com.huawei.pluginfitnessadvice;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.pluginfitnessadvice.course.EssenceVideoInfo;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class HealthCourseJumpParameter implements Parcelable {
    public static final Parcelable.Creator<HealthCourseJumpParameter> CREATOR = new Parcelable.Creator<HealthCourseJumpParameter>() { // from class: com.huawei.pluginfitnessadvice.HealthCourseJumpParameter.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: csF_, reason: merged with bridge method [inline-methods] */
        public HealthCourseJumpParameter createFromParcel(Parcel parcel) {
            return new HealthCourseJumpParameter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public HealthCourseJumpParameter[] newArray(int i) {
            return new HealthCourseJumpParameter[i];
        }
    };

    @SerializedName("currentOrder")
    private int currentOrder;

    @SerializedName("essenceVideos")
    private List<EssenceVideoInfo> essenceVideos;

    @SerializedName("serialCourseId")
    private String serialCourseId;

    @SerializedName("totalCount")
    private int totalCount;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentOrder() {
        return this.currentOrder;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<EssenceVideoInfo> getEssenceVideos() {
        return this.essenceVideos;
    }

    public String getSerialCourseId() {
        return this.serialCourseId;
    }

    protected HealthCourseJumpParameter(Parcel parcel) {
        this.serialCourseId = parcel.readString();
        this.currentOrder = parcel.readInt();
        this.totalCount = parcel.readInt();
        this.essenceVideos = parcel.createTypedArrayList(EssenceVideoInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.serialCourseId);
        parcel.writeInt(this.currentOrder);
        parcel.writeInt(this.totalCount);
        parcel.writeTypedList(this.essenceVideos);
    }

    public String toString() {
        return "HealthCourseJumpParameter{serialCourseId='" + this.serialCourseId + "', currentOrder=" + this.currentOrder + ", totalCount=" + this.totalCount + ", essenceVideos=" + this.essenceVideos + '}';
    }
}
