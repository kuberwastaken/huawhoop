package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azk implements c<HashMap> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, id_(parcel, i, autoParcelable.getClass().getClassLoader()));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: ie_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, HashMap map, int i2, boolean z) {
        if (map == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeMap(map);
            bac.iJ_(parcel, iIL_);
        }
    }

    private HashMap id_(Parcel parcel, int i, ClassLoader classLoader) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        HashMap hashMap = null;
        if (iIz_ == 0) {
            return null;
        }
        try {
            hashMap = parcel.readHashMap(classLoader);
        } catch (Exception unused) {
            azu.e.c("HashMapTypeProcess", "can not read map");
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return hashMap;
    }
}
