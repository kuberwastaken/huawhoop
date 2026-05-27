package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azq implements c<Long> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, Long.valueOf(in_(parcel, i)));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(Parcel parcel, Field field, int i, Long l, int i2, boolean z) {
        if (l == null) {
            return;
        }
        bac.iK_(parcel, i, 8);
        parcel.writeLong(l.longValue());
    }

    private long in_(Parcel parcel, int i) {
        azw.iA_(parcel, i, 8);
        return parcel.readLong();
    }
}
