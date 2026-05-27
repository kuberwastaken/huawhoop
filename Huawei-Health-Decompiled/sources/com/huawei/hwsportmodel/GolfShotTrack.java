package com.huawei.hwsportmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class GolfShotTrack implements Parcelable {
    public static final Parcelable.Creator<GolfShotTrack> CREATOR = new Parcelable.Creator<GolfShotTrack>() { // from class: com.huawei.hwsportmodel.GolfShotTrack.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bZC_, reason: merged with bridge method [inline-methods] */
        public GolfShotTrack createFromParcel(Parcel parcel) {
            return new GolfShotTrack(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public GolfShotTrack[] newArray(int i) {
            return new GolfShotTrack[i];
        }
    };

    @SerializedName("dis")
    @Expose
    private int mDistance;

    @SerializedName("lat")
    @Expose
    private double mLatitude;

    @SerializedName("lon")
    @Expose
    private double mLongitude;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private GolfShotTrack(c cVar) {
        this.mLongitude = cVar.f6635a.doubleValue();
        this.mLatitude = cVar.b.doubleValue();
        this.mDistance = cVar.c;
    }

    public GolfShotTrack(Parcel parcel) {
        this.mLongitude = parcel.readDouble();
        this.mLatitude = parcel.readDouble();
        this.mDistance = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLongitude);
        parcel.writeDouble(this.mLatitude);
        parcel.writeInt(this.mDistance);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Double f6635a;
        private Double b;
        private int c;

        public c d(Double d) {
            this.f6635a = d;
            return this;
        }

        public c e(Double d) {
            this.b = d;
            return this;
        }

        public c e(int i) {
            this.c = i;
            return this;
        }

        public GolfShotTrack e() {
            return new GolfShotTrack(this);
        }
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public String toString() {
        return "GolfShotTrack{mLongitude=" + this.mLongitude + ", mLatitude=" + this.mLatitude + ", mDistance=" + this.mDistance + '}';
    }
}
