package defpackage;

import com.huawei.ui.homehealth.runcard.trackfragments.SportStatisticProvider;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class rjy implements Runnable {
    public final /* synthetic */ SportStatisticProvider e;

    @Override // java.lang.Runnable
    public final void run() {
        this.e.gotoStartSport();
    }

    public /* synthetic */ rjy(SportStatisticProvider sportStatisticProvider) {
        this.e = sportStatisticProvider;
    }
}
