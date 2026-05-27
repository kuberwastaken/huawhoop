package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class ky extends kw<Float> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.kw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(String str) {
        String str2;
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            hq.c("FloatDataConverter", str2);
            return Float.valueOf(0.0f);
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            hq.c("FloatDataConverter", str2);
            return Float.valueOf(0.0f);
        }
    }
}
