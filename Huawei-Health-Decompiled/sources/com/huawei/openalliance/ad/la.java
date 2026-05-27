package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class la extends kw<Integer> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.kw
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(String str) {
        String str2;
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            str2 = "convertStringToData NumberFormatException";
            hq.c("IntegerDataConverter", str2);
            return 0;
        } catch (Exception unused2) {
            str2 = "convertStringToData Exception";
            hq.c("IntegerDataConverter", str2);
            return 0;
        }
    }
}
