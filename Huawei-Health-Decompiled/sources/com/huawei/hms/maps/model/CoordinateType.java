package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.AMapLocation;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

/* JADX INFO: loaded from: classes5.dex */
public class CoordinateType implements Parcelable {
    public static final Parcelable.Creator<CoordinateType> CREATOR = new Parcelable.Creator<CoordinateType>() { // from class: com.huawei.hms.maps.model.CoordinateType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoordinateType[] newArray(int i) {
            return new CoordinateType[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoordinateType createFromParcel(Parcel parcel) {
            return new CoordinateType(parcel);
        }
    };
    private int coordinateType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int iBeginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeInt(2, this.coordinateType);
        parcelWrite.finishObjectHeader(iBeginObjectHeader);
    }

    public void setCoordinateType(int i) {
        this.coordinateType = i;
    }

    public int getCoordinateType() {
        return this.coordinateType;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CoordinateType(com.huawei.hms.maps.model.CoordinateType.CoordinateTypeEnum r2) {
        /*
            r1 = this;
            r1.<init>()
            if (r2 != 0) goto L6
            goto L12
        L6:
            com.huawei.hms.maps.model.CoordinateType$CoordinateTypeEnum r0 = com.huawei.hms.maps.model.CoordinateType.CoordinateTypeEnum.WGS84
            if (r2 != r0) goto Lc
            r2 = 0
            goto L13
        Lc:
            com.huawei.hms.maps.model.CoordinateType$CoordinateTypeEnum r0 = com.huawei.hms.maps.model.CoordinateType.CoordinateTypeEnum.GCJ02
            if (r2 != r0) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = -1
        L13:
            r1.coordinateType = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.maps.model.CoordinateType.<init>(com.huawei.hms.maps.model.CoordinateType$CoordinateTypeEnum):void");
    }

    public enum CoordinateTypeEnum {
        WGS84(AMapLocation.COORD_TYPE_WGS84),
        GCJ02(AMapLocation.COORD_TYPE_GCJ02),
        UNKNOWN("UNKNOWN");

        private final String coordinateTypeName;

        CoordinateTypeEnum(String str) {
            this.coordinateTypeName = str;
        }
    }

    protected CoordinateType(Parcel parcel) {
        this.coordinateType = new ParcelReader(parcel).readInt(2, 0);
    }

    public CoordinateType() {
    }
}
