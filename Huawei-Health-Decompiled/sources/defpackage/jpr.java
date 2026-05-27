package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hihealthkit.context.H5ProAppInfo;
import com.huawei.hihealthkit.context.NativeAppInfo;
import com.huawei.hihealthkit.context.OutOfBandData;
import com.huawei.hihealthkit.context.QuickAppInfo;

/* JADX INFO: loaded from: classes5.dex */
public class jpr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: bCN_, reason: merged with bridge method [inline-methods] */
    public OutOfBandData createFromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if (i == 1) {
            return QuickAppInfo.CREATOR.createFromParcel(parcel);
        }
        if (i == 2) {
            return H5ProAppInfo.CREATOR.createFromParcel(parcel);
        }
        if (i == 3) {
            return NativeAppInfo.CREATOR.createFromParcel(parcel);
        }
        Log.e("OutOfBandCreator", "unsupported OutOfBandData type");
        return null;
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public OutOfBandData[] newArray(int i) {
        return new OutOfBandData[i];
    }
}
