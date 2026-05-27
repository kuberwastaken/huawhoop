package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() { // from class: com.amap.api.services.route.RidePath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RidePath[] newArray(int i) {
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RidePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        private static RidePath a(Parcel parcel) {
            return new RidePath(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RideStep> f1525a;

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f1525a;
    }

    public void setSteps(List<RideStep> list) {
        this.f1525a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f1525a);
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f1525a = new ArrayList();
        this.f1525a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    public RidePath() {
        this.f1525a = new ArrayList();
    }
}
