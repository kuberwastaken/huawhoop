package defpackage;

import android.os.Parcel;
import androidx.core.internal.view.SupportMenu;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes3.dex */
public final class azw {
    static int d(int i) {
        return i & 65535;
    }

    static void iC_(Parcel parcel, int i) {
        int iIz_ = iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        int i2 = iDataPosition + iIz_;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            parcel.setDataPosition(i2);
            return;
        }
        throw new d("error length:" + iDataPosition + Constants.LINK + iIz_);
    }

    static void iB_(Parcel parcel, int i) {
        if ((i & SupportMenu.CATEGORY_MASK) == -65536) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
        }
    }

    public static void iA_(Parcel parcel, int i, int i2) {
        int iIz_ = iz_(parcel, i);
        if (iIz_ == i2) {
            return;
        }
        throw new a("Expected size " + i2 + " got " + iIz_ + " (0x" + Integer.toHexString(iIz_) + com.huawei.operation.utils.Constants.RIGHT_BRACKET_ONLY, parcel);
    }

    public static int iz_(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    static class a extends RuntimeException {
        a(String str, Parcel parcel) {
            super(str);
        }
    }

    static class d extends RuntimeException {
        d(String str) {
            super(str);
        }
    }

    static int a(Parcel parcel) {
        int i = parcel.readInt();
        int iIz_ = iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (d(i) != 20293) {
            throw new a("Expected object header. Got 0x" + Integer.toHexString(i), parcel);
        }
        int i2 = iIz_ + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i2, parcel);
    }
}
