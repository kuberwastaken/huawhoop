package com.huawei.hms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.utils.LogM;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class MapStyleOptions implements Parcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new Parcelable.Creator<MapStyleOptions>() { // from class: com.huawei.hms.maps.model.MapStyleOptions.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStyleOptions[] newArray(int i) {
            return new MapStyleOptions[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MapStyleOptions createFromParcel(Parcel parcel) {
            return new MapStyleOptions(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5189a;
    public boolean resetPreviousStyle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int iBeginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeString(2, this.f5189a, false);
        parcelWrite.finishObjectHeader(iBeginObjectHeader);
    }

    public boolean getResetFlag() {
        return this.resetPreviousStyle;
    }

    public String getJson() {
        return this.f5189a;
    }

    public static MapStyleOptions loadRawResourceStyle(Context context, int i) {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int i2 = inputStreamOpenRawResource.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } finally {
                }
            } catch (IOException unused) {
                throw new Resources.NotFoundException("MapStyleOptions read resource failure: " + i);
            }
        }
        MapStyleOptions mapStyleOptions = new MapStyleOptions(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
        try {
            inputStreamOpenRawResource.close();
        } catch (IOException unused2) {
            LogM.e("MapStyleOptions", "IOException");
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused3) {
            LogM.e("MapStyleOptions", "IOException");
        }
        return mapStyleOptions;
    }

    public static MapStyleOptions loadAssetResouceStyle(String str) {
        return new MapStyleOptions(str);
    }

    public MapStyleOptions(String str, boolean z) {
        this.f5189a = str;
        this.resetPreviousStyle = z;
    }

    public MapStyleOptions(String str) {
        this.resetPreviousStyle = true;
        this.f5189a = str;
    }

    protected MapStyleOptions(Parcel parcel) {
        this.resetPreviousStyle = true;
        this.f5189a = new ParcelReader(parcel).createString(2, null);
    }
}
