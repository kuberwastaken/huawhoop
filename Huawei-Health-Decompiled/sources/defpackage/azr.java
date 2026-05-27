package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azr implements c<String[]> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, iu_(parcel, i));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: iv_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, String[] strArr, int i2, boolean z) {
        if (strArr == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeStringArray(strArr);
            bac.iJ_(parcel, iIL_);
        }
    }

    public static String[] iu_(Parcel parcel, int i) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        String[] strArrCreateStringArray = new String[0];
        if (iIz_ == 0) {
            return strArrCreateStringArray;
        }
        try {
            strArrCreateStringArray = parcel.createStringArray();
        } catch (Exception e) {
            azu.e.c("StringArrayTypeProcess", "error readStringArray:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return strArrCreateStringArray;
    }
}
