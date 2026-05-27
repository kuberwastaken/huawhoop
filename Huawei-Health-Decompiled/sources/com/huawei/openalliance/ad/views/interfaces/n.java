package com.huawei.openalliance.ad.views.interfaces;

import android.view.View;
import com.huawei.openalliance.ad.db.bean.ContentRecord;
import com.huawei.openalliance.ad.jd;
import com.huawei.openalliance.ad.jm;
import com.huawei.openalliance.ad.lo;
import com.huawei.openalliance.ad.mb;

/* JADX INFO: loaded from: classes11.dex */
public interface n extends jm, lo, IViewLifeCycle {
    void a(int i);

    void a(int i, int i2);

    void a(View view, Integer num);

    void a(mb mbVar);

    void b();

    void c();

    void c(int i);

    void d();

    boolean e();

    void g();

    jd getAdMediator();

    void h();

    boolean i();

    void setAdContent(ContentRecord contentRecord);

    void setAdMediator(jd jdVar);

    void setAudioFocusType(int i);

    void setDisplayDuration(int i);
}
