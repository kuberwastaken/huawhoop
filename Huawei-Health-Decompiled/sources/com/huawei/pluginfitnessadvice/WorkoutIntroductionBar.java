package com.huawei.pluginfitnessadvice;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class WorkoutIntroductionBar implements Parcelable {
    public static final Parcelable.Creator<WorkoutIntroductionBar> CREATOR = new Parcelable.Creator<WorkoutIntroductionBar>() { // from class: com.huawei.pluginfitnessadvice.WorkoutIntroductionBar.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: csV_, reason: merged with bridge method [inline-methods] */
        public WorkoutIntroductionBar createFromParcel(Parcel parcel) {
            return new WorkoutIntroductionBar(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public WorkoutIntroductionBar[] newArray(int i) {
            return new WorkoutIntroductionBar[i];
        }
    };

    @SerializedName("layouts")
    private List<ShowLayout> mLayoutList;

    @SerializedName("name")
    private String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected WorkoutIntroductionBar(Parcel parcel) {
        this.mName = parcel.readString();
        this.mLayoutList = parcel.createTypedArrayList(ShowLayout.CREATOR);
    }

    private WorkoutIntroductionBar(d dVar) {
        this.mName = dVar.b;
        this.mLayoutList = dVar.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeTypedList(this.mLayoutList);
    }

    /* JADX INFO: loaded from: classes11.dex */
    public static final class d {
        private String b;
        private List<ShowLayout> e;
    }

    public String getName() {
        return this.mName;
    }

    public List<ShowLayout> getLayoutList() {
        return this.mLayoutList;
    }

    public String toString() {
        return "WorkoutIntroductionBar{mName='" + this.mName + "', mLayoutList=" + this.mLayoutList + '}';
    }
}
