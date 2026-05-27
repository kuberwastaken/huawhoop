package com.huawei.hwdevice.phoneprocess.mgr.linkage.eventproducer;

import defpackage.dsy;

/* JADX INFO: loaded from: classes6.dex */
public interface SampleEventProducer {
    dsy createSampleEvent(int i, String str);

    default dsy sampleEventBulid(long j, byte[] bArr) {
        dsy dsyVar = new dsy();
        dsyVar.e(j);
        dsyVar.c(0);
        dsyVar.setSrcPkgName("hw.sport.linkage.app");
        dsyVar.setWearPkgName("hw.sport.linkage.device");
        dsyVar.a(bArr);
        return dsyVar;
    }
}
