package com.huawei.openalliance.ad.views.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PPSAbsSavedState implements Parcelable {
    private final Parcelable b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PPSAbsSavedState f8446a = new PPSAbsSavedState() { // from class: com.huawei.openalliance.ad.views.viewpager.PPSAbsSavedState.1
    };
    public static final Parcelable.Creator<PPSAbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<PPSAbsSavedState>() { // from class: com.huawei.openalliance.ad.views.viewpager.PPSAbsSavedState.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState[] newArray(int i) {
            return new PPSAbsSavedState[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return PPSAbsSavedState.f8446a;
            }
            throw new IllegalStateException("superState should null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSAbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }

    public final Parcelable a() {
        return this.b;
    }

    protected PPSAbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.b = parcelable == f8446a ? null : parcelable;
    }

    protected PPSAbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.b = parcelable == null ? f8446a : parcelable;
    }

    private PPSAbsSavedState() {
        this.b = null;
    }
}
