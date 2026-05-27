package com.huawei.hms.kit.awareness.capture;

import android.location.Location;
import com.huawei.hms.kit.awareness.b.HHI;

/* JADX INFO: loaded from: classes10.dex */
public class LocationResponse extends HHI<Location> {
    public Location getLocation() {
        return getStatus();
    }

    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getLocation failed: ";
    }

    public LocationResponse(Location location) {
        super(location);
    }
}
