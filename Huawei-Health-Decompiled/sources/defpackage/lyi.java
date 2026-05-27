package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.linkage.eventproducer.SampleEventProducer;

/* JADX INFO: loaded from: classes6.dex */
public class lyi implements SampleEventProducer {
    @Override // com.huawei.hwdevice.phoneprocess.mgr.linkage.eventproducer.SampleEventProducer
    public dsy createSampleEvent(int i, String str) {
        dsy dsyVar = new dsy();
        dsyVar.e(Long.MAX_VALUE);
        return dsyVar;
    }
}
