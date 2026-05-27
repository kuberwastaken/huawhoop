package com.huawei.health.h5pro.service.theme;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.core.view.ViewCompat;
import com.huawei.health.h5pro.service.H5ProServiceLiveTerm;
import com.huawei.health.h5pro.service.anotation.H5ProMethod;
import com.huawei.health.h5pro.service.anotation.H5ProService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@H5ProService(liveTerm = H5ProServiceLiveTerm.WEB_VIEW, name = "theme")
public class ThemeSvc {
    public Resources c;
    public static final int[] d = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2494a = new int[0];

    @H5ProMethod
    public ArrayList<Map<String, String>> getAttrs() {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = d;
            if (i2 >= iArr.length) {
                break;
            }
            HashMap map = new HashMap();
            map.put("k", "--" + this.c.getResourceEntryName(iArr[i2]));
            map.put("v", String.format("#%06X", Integer.valueOf(Integer.valueOf(this.c.getColor(iArr[i2])).intValue() & ViewCompat.MEASURED_SIZE_MASK)));
            arrayList.add(map);
            i2++;
        }
        while (true) {
            int[] iArr2 = f2494a;
            if (i >= iArr2.length) {
                return arrayList;
            }
            HashMap map2 = new HashMap();
            map2.put("k", "--" + this.c.getResourceEntryName(iArr2[i]));
            map2.put("v", Float.valueOf(d(this.c.getDimension(iArr2[i]))).toString() + "px");
            arrayList.add(map2);
            i++;
        }
    }

    private float d(float f) {
        return TypedValue.applyDimension(1, f, this.c.getDisplayMetrics());
    }

    public ThemeSvc(Resources resources) {
        this.c = resources;
    }
}
