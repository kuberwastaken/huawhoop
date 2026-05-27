package com.huawei.phoneservice.feedbackcommon.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class ProblemEntity implements Parcelable {
    public static final Parcelable.Creator<ProblemEntity> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8604a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8604a);
    }

    public void a(String str) {
        this.f8604a = str;
    }

    public String a() {
        return this.f8604a;
    }

    class a implements Parcelable.Creator<ProblemEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProblemEntity[] newArray(int i) {
            return new ProblemEntity[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: clN_, reason: merged with bridge method [inline-methods] */
        public ProblemEntity createFromParcel(Parcel parcel) {
            return new ProblemEntity(parcel);
        }

        a() {
        }
    }

    public ProblemEntity(String str) {
        this.f8604a = str;
    }

    protected ProblemEntity(Parcel parcel) {
        this.f8604a = parcel.readString();
    }

    public ProblemEntity() {
    }
}
