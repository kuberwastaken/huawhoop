package com.amap.api.col.p0003sl;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class et extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<et> CREATOR = new Parcelable.Creator<et>() { // from class: com.amap.api.col.3sl.et.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ et createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ et[] newArray(int i) {
            return a(i);
        }

        private static et a(Parcel parcel) {
            return new et(parcel);
        }

        private static et[] a(int i) {
            return new et[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f950a;
    private float b;
    private float c;
    private float d;
    private float e;
    private boolean f;
    private int g;
    private double h;
    private List<es> i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public et() {
        this.f950a = 3.0f;
        this.b = 20.0f;
        this.c = Float.MIN_VALUE;
        this.d = Float.MAX_VALUE;
        this.e = 200.0f;
        this.f = true;
        this.g = -3355444;
        this.h = 3.0d;
        this.i = new ArrayList();
        this.type = "ContourLineOptions";
    }

    protected et(Parcel parcel) {
        this.f950a = 3.0f;
        this.b = 20.0f;
        this.c = Float.MIN_VALUE;
        this.d = Float.MAX_VALUE;
        this.e = 200.0f;
        this.f = true;
        this.g = -3355444;
        this.h = 3.0d;
        this.i = new ArrayList();
        this.f950a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f = zArr[0];
        this.g = parcel.readInt();
        this.h = parcel.readDouble();
        this.i = parcel.readArrayList(es.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f950a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeBooleanArray(new boolean[]{this.f});
        parcel.writeInt(this.g);
        parcel.writeDouble(this.h);
        parcel.writeList(this.i);
    }
}
