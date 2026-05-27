package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX INFO: loaded from: classes9.dex */
public class CrossOverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AVectorCrossAttr f1386a = null;
    private Bitmap bitmapDescriptor = null;

    public AVectorCrossAttr getAttribute() {
        return this.f1386a;
    }

    public CrossOverlayOptions setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.f1386a = aVectorCrossAttr;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap bitmap) {
        this.bitmapDescriptor = bitmap;
        return this;
    }

    public Bitmap getRes() {
        return this.bitmapDescriptor;
    }
}
