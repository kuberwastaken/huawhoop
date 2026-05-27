package com.huawei.openalliance.ad.beans.vast;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class VideoClicks {
    private ClickThrough clickThrough;
    private List<Tracking> videoTrackings;

    public List<Tracking> b() {
        return this.videoTrackings;
    }

    public void a(List<Tracking> list) {
        this.videoTrackings = list;
    }

    public void a(ClickThrough clickThrough) {
        this.clickThrough = clickThrough;
    }

    public ClickThrough a() {
        return this.clickThrough;
    }
}
