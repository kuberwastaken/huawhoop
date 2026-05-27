package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azl implements c<int[]> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, a(parcel, i));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: if_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, int[] iArr, int i2, boolean z) {
        if (iArr == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeIntArray(iArr);
            bac.iJ_(parcel, iIL_);
        }
    }

    private int[] a(Parcel parcel, int i) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        int[] iArrCreateIntArray = new int[0];
        if (iIz_ == 0) {
            return iArrCreateIntArray;
        }
        try {
            iArrCreateIntArray = parcel.createIntArray();
        } catch (Exception e) {
            azu.e.c("IntegerArrayTypeProcess", "error readIntArray:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return iArrCreateIntArray;
    }
}
