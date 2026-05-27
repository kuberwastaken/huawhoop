package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7521a = mc.a("com.iab.omid.library.huawei.adsession.VerificationScriptResource");
    private List<VerificationScriptResource> b = new ArrayList();

    public List<VerificationScriptResource> b() {
        return this.b;
    }

    public void a(Om om) {
        if (om == null || !f7521a) {
            hq.b("VerficationScriptResourceWrapper", "om is not avalible");
            return;
        }
        String strA = om.a();
        URL urlA = a(om.b());
        String strC = om.c();
        if (strA == null || urlA == null || strC == null) {
            hq.b("VerficationScriptResourceWrapper", "Parameters is null");
            return;
        }
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(strA, urlA, strC);
        if (verificationScriptResourceCreateVerificationScriptResourceWithParameters == null) {
            hq.b("VerficationScriptResourceWrapper", "Create verificationScriptResource failed");
        } else {
            this.b.add(verificationScriptResourceCreateVerificationScriptResourceWithParameters);
        }
    }

    public static boolean a() {
        return f7521a;
    }

    private URL a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            hq.c("VerficationScriptResourceWrapper", "parseURL: " + com.huawei.openalliance.ad.utils.dp.a(e.getMessage()));
            return null;
        }
    }
}
