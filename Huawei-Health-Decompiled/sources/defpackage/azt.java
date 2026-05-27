package defpackage;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class azt implements c<List<String>> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void a(AutoParcelable autoParcelable, Field field, Parcel parcel, int i, Map<String, String> map) throws IllegalAccessException {
        field.set(autoParcelable, iw_(parcel, i));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* JADX INFO: renamed from: ix_, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i, List<String> list, int i2, boolean z) {
        if (list == null) {
            if (z) {
                bac.iK_(parcel, i, 0);
            }
        } else {
            int iIL_ = bac.iL_(parcel, i);
            parcel.writeStringList(list);
            bac.iJ_(parcel, iIL_);
        }
    }

    private ArrayList<String> iw_(Parcel parcel, int i) {
        int iIz_ = azw.iz_(parcel, i);
        int iDataPosition = parcel.dataPosition();
        ArrayList<String> arrayListCreateStringArrayList = null;
        if (iIz_ == 0) {
            return null;
        }
        try {
            arrayListCreateStringArrayList = parcel.createStringArrayList();
        } catch (Exception e) {
            azu.e.c("StringListProcess", "error readStringList:" + e.getMessage());
        }
        parcel.setDataPosition(iDataPosition + iIz_);
        return arrayListCreateStringArrayList;
    }
}
