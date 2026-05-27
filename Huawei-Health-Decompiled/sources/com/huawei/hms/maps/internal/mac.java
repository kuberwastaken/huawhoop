package com.huawei.hms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class mac {
    public static Bundle b(Bundle bundle, String str, Parcelable parcelable) {
        Bundle bundle2;
        if (bundle != null) {
            try {
                bundle2 = bundle.getBundle("map_state");
            } catch (Exception e) {
                Log.e("MapStateUtils", "getOrgMapState exception " + e.getMessage());
                bundle2 = null;
            }
        } else {
            bundle2 = null;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(mac.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        return bundle2;
    }

    public static void a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(mac.class.getClassLoader());
        bundle.putBundle("map_state", b(bundle, str, parcelable));
    }

    private static <T extends Parcelable> T a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(mac.class.getClassLoader());
        Bundle bundle2 = (Bundle) bundle.get("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(mac.class.getClassLoader());
        return (T) bundle2.getParcelable(str);
    }

    public static Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            return bundle2;
        }
        Parcelable parcelableA = a(bundle, "HuaweiMapOptions");
        if (parcelableA != null) {
            a(bundle2, "HuaweiMapOptions", parcelableA);
        }
        Parcelable parcelableA2 = a(bundle, "StreetViewOptions");
        if (parcelableA2 != null) {
            a(bundle2, "StreetViewOptions", parcelableA2);
        }
        Parcelable parcelableA3 = a(bundle, "CameraState");
        if (parcelableA3 != null) {
            a(bundle2, "CameraState", parcelableA3);
        }
        if (bundle.containsKey("position")) {
            bundle2.putString("position", bundle.getString("position"));
        }
        return bundle2;
    }

    private mac() {
    }
}
