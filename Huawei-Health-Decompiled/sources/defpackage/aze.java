package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class aze implements c<IBinder> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, a(parcel, i));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: hX_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, IBinder iBinder, int i2, boolean z) {
        if (iBinder == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeStrongBinder(iBinder);
            bac.iJ_(parcel, iIL_);
        }
    }

    public static IBinder a(Parcel parcel, int i) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        IBinder strongBinder = null;
        if (iIz_ == 0) {
            return null;
        }
        try {
            strongBinder = parcel.readStrongBinder();
        } catch (Exception e) {
            azu.e.c("BinderTypeProcess", "error readBinder:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return strongBinder;
    }
}
