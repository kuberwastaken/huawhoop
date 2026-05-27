package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.fu;
import com.amap.api.col.p0003sl.hq;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDistanceSearch f1505a;

    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f1505a == null) {
            try {
                this.f1505a = new hq(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f1505a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f1505a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f1505a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i) {
                return a(i);
            }

            private static DistanceQuery a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            private static DistanceQuery[] a(int i) {
                return new DistanceQuery[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1506a;
        private List<LatLonPoint> b;
        private LatLonPoint c;
        private String d;
        private int e;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public DistanceQuery() {
            this.f1506a = 1;
            this.b = new ArrayList();
            this.d = "base";
            this.e = 4;
        }

        protected DistanceQuery(Parcel parcel) {
            this.f1506a = 1;
            this.b = new ArrayList();
            this.d = "base";
            this.e = 4;
            this.f1506a = parcel.readInt();
            this.b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.d = parcel.readString();
            this.e = parcel.readInt();
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DistanceQuery m326clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fu.a(e, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f1506a);
            distanceQuery.setOrigins(this.b);
            distanceQuery.setDestination(this.c);
            distanceQuery.setExtensions(this.d);
            distanceQuery.setMode(this.e);
            return distanceQuery;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1506a);
            parcel.writeTypedList(this.b);
            parcel.writeParcelable(this.c, i);
            parcel.writeString(this.d);
            parcel.writeInt(this.e);
        }

        public int getType() {
            return this.f1506a;
        }

        public List<LatLonPoint> getOrigins() {
            return this.b;
        }

        public LatLonPoint getDestination() {
            return this.c;
        }

        public void setType(int i) {
            this.f1506a = i;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.b = list;
            }
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.b.add(latLonPoint);
                }
            }
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.c = latLonPoint;
        }

        public String getExtensions() {
            return this.d;
        }

        public void setExtensions(String str) {
            this.d = str;
        }

        public int getMode() {
            return this.e;
        }

        public void setMode(int i) {
            this.e = i;
        }
    }
}
