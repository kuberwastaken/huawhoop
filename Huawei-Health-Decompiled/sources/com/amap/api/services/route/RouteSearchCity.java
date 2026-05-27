package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() { // from class: com.amap.api.services.route.RouteSearchCity.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteSearchCity[] newArray(int i) {
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteSearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        private static RouteSearchCity a(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<District> f1542a;

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.f1542a;
    }

    public void setDistricts(List<District> list) {
        this.f1542a = list;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f1542a);
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f1542a = new ArrayList();
        this.f1542a = parcel.createTypedArrayList(District.CREATOR);
    }

    public RouteSearchCity() {
        this.f1542a = new ArrayList();
    }
}
