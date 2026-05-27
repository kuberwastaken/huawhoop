package androidx.work.multiprocess.parcelable;

import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public final class ParcelUtils {
    private ParcelUtils() {
    }

    public static boolean readBooleanValue(Parcel parcel) {
        return parcel.readInt() == 1;
    }

    public static void writeBooleanValue(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
