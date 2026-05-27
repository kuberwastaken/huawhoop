package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azp implements c<Parcelable[]> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, iq_(parcel, i, field));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: ir_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
                return;
            }
            return;
        }
        int iIL_ = bac.iL_(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                ip_(parcel, parcelable, i2);
            }
        }
        bac.iJ_(parcel, iIL_);
    }

    private <T extends Parcelable> T[] iq_(Parcel parcel, int i, Field field) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        T[] tArr = null;
        if (iIz_ == 0) {
            return null;
        }
        try {
            Parcelable.Creator creatorIo_ = io_(field, null);
            if (creatorIo_ != null) {
                tArr = (T[]) ((Parcelable[]) parcel.createTypedArray(creatorIo_));
            }
        } catch (Exception e) {
            azu.e.c("ParcelableArrayTypeProcess", "error readParcelableArray:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return tArr;
    }

    static <T extends Parcelable> void ip_(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    static Parcelable.Creator io_(Field field, Map<String, String> map) {
        String str;
        Class<?> type = field.getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        if (type == null || !Parcelable.class.isAssignableFrom(type)) {
            return null;
        }
        String name = field.getName();
        if (map != null && map.get(name) != null && (str = map.get(name)) != null) {
            try {
                type = Class.forName(str);
            } catch (ClassNotFoundException unused) {
                azu.e.e("ParcelableArrayTypeProcess", "error clazz:" + str);
                return null;
            }
        }
        return a(type);
    }

    public static class d extends RuntimeException {
        public d(String str) {
            super(str);
        }
    }

    static Parcelable.Creator a(Class cls) {
        try {
            return (Parcelable.Creator) cls.getDeclaredField("CREATOR").get(null);
        } catch (IllegalAccessException unused) {
            throw new d(cls + " IllegalAccessException");
        } catch (IllegalArgumentException unused2) {
            throw new d(cls + " IllegalArgumentException");
        } catch (NoSuchFieldException unused3) {
            throw new d(cls + " is an Parcelable without CREATOR");
        }
    }
}
