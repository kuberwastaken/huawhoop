package com.huawei.agconnect.apms;

/* JADX INFO: loaded from: classes3.dex */
public class m implements Runnable {
    public final /* synthetic */ n abc;

    public m(n nVar) {
        this.abc = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.abc.efg.decrementAndGet() == 0) {
            n nVar = this.abc;
            nVar.bcd.execute(new k(nVar));
        }
    }
}
