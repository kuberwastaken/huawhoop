package com.huawei.agconnect.apms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class pon {
    public final Object abc = new Object();
    public boolean bcd = false;
    public final ArrayList<qpo> cde = new ArrayList<>();

    public void abc(rqp rqpVar) {
        if (abc()) {
            return;
        }
        Iterator it = ((ArrayList) bcd()).iterator();
        while (it.hasNext()) {
            ((qpo) it.next()).bcd(rqpVar);
        }
    }

    public void bcd(rqp rqpVar) {
        if (abc()) {
            return;
        }
        Iterator it = ((ArrayList) bcd()).iterator();
        while (it.hasNext()) {
            ((qpo) it.next()).abc(rqpVar);
        }
    }

    public boolean cde() {
        boolean z;
        synchronized (this.abc) {
            z = this.bcd;
        }
        return z;
    }

    public final boolean abc() {
        boolean zCde;
        synchronized (this.abc) {
            zCde = cde();
            if (!zCde) {
                this.bcd = true;
            }
        }
        return zCde;
    }

    public final List<qpo> bcd() {
        ArrayList arrayList;
        synchronized (this.cde) {
            arrayList = new ArrayList(this.cde);
            this.cde.clear();
        }
        return arrayList;
    }
}
