package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class lc extends kw<Long> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.kw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long a(String str) {
        String str2;
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            hq.a("LongDataConverter", str2);
            return 0L;
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            hq.a("LongDataConverter", str2);
            return 0L;
        }
    }
}
