package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azh implements c<byte[]> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, ia_(parcel, i));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(Parcel parcel, Field field, int i, byte[] bArr, int i2, boolean z) {
        if (bArr == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeByteArray(bArr);
            bac.iJ_(parcel, iIL_);
        }
    }

    private byte[] ia_(Parcel parcel, int i) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        byte[] bArrCreateByteArray = new byte[0];
        if (iIz_ == 0) {
            return bArrCreateByteArray;
        }
        try {
            bArrCreateByteArray = parcel.createByteArray();
        } catch (Exception e) {
            azu.e.c("ByteArrayTypeProcess", "error readByteArray:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return bArrCreateByteArray;
    }
}
