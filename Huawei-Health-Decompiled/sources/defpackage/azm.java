package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azm implements c<Integer> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, Integer.valueOf(ig_(parcel, i)));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: ih_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, Integer num, int i2, boolean z) {
        if (num == null) {
            return;
        }
        bac.iK_(parcel, i, 4);
        parcel.writeInt(num.intValue());
    }

    private int ig_(Parcel parcel, int i) {
        azw.iA_(parcel, i, 4);
        return parcel.readInt();
    }
}
