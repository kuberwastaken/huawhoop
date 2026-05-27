package com.huawei.hihealth.dictionary.constants;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ProductMap {
    private static final Map<String, Set<ProductMapInfo>> d;
    private static final Map<String, ProductMapInfo> g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Set<ProductMapInfo>> f4286a = new ConcurrentHashMap();
    private static final Map<String, Set<ProductMapInfo>> h = new ConcurrentHashMap();
    private static final Map<String, Set<ProductMapInfo>> f = new ConcurrentHashMap();
    private static final Map<String, Set<ProductMapInfo>> b = new ConcurrentHashMap();
    private static final Map<String, Set<ProductMapInfo>> c = new ConcurrentHashMap();
    private static final Map<String, Set<ProductMapInfo>> e = new ConcurrentHashMap();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        d = concurrentHashMap;
        ProductMapInfo productMapInfo = new ProductMapInfo("001", null, null, null, null, null, 1);
        HashSet hashSet = new HashSet(1);
        hashSet.add(productMapInfo);
        concurrentHashMap.put(String.valueOf(1), hashSet);
        concurrentHashMap.put(String.valueOf(10001), hashSet);
    }

    private ProductMap() {
    }

    public static void b(ProductMapInfo productMapInfo) {
        synchronized (ProductMap.class) {
            if (productMapInfo == null) {
                return;
            }
            String strF = productMapInfo.f();
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            g.put(strF, productMapInfo);
            b(f4286a, "deviceType", productMapInfo);
            b(h, "smartProductId", productMapInfo);
            b(f, "productId", productMapInfo);
            b(b, "modelName", productMapInfo);
            b(c, "manufacturerId", productMapInfo);
            b(e, "marketingName", productMapInfo);
            b(d, "deviceId", productMapInfo);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r2, java.lang.String r3, com.huawei.hihealth.dictionary.constants.ProductMapInfo r4) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.dictionary.constants.ProductMap.b(java.util.Map, java.lang.String, com.huawei.hihealth.dictionary.constants.ProductMapInfo):void");
    }

    public static ArrayList<ProductMapInfo> a() {
        ArrayList<ProductMapInfo> arrayList = new ArrayList<>();
        arrayList.addAll(g.values());
        return arrayList;
    }

    public static ProductMapInfo b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, ProductMapInfo> map = g;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.huawei.hihealth.dictionary.constants.ProductMapInfo> d(java.lang.String r1, java.lang.String r2) {
        /*
            r1.hashCode()
            int r0 = r1.hashCode()
            switch(r0) {
                case -2010829484: goto L51;
                case -1051830678: goto L45;
                case -442550831: goto L39;
                case 647647905: goto L2d;
                case 781190832: goto L22;
                case 1109191185: goto L17;
                case 1537506508: goto Lb;
                default: goto La;
            }
        La:
            goto L5d
        Lb:
            java.lang.String r0 = "manufacturerId"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L15
            goto L5d
        L15:
            r1 = 6
            goto L5e
        L17:
            java.lang.String r0 = "deviceId"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L20
            goto L5d
        L20:
            r1 = 5
            goto L5e
        L22:
            java.lang.String r0 = "deviceType"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L2b
            goto L5d
        L2b:
            r1 = 4
            goto L5e
        L2d:
            java.lang.String r0 = "smartProductId"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L37
            goto L5d
        L37:
            r1 = 3
            goto L5e
        L39:
            java.lang.String r0 = "marketingName"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L43
            goto L5d
        L43:
            r1 = 2
            goto L5e
        L45:
            java.lang.String r0 = "productId"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4f
            goto L5d
        L4f:
            r1 = 1
            goto L5e
        L51:
            java.lang.String r0 = "modelName"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L5b
            goto L5d
        L5b:
            r1 = 0
            goto L5e
        L5d:
            r1 = -1
        L5e:
            switch(r1) {
                case 0: goto L91;
                case 1: goto L8a;
                case 2: goto L83;
                case 3: goto L7c;
                case 4: goto L75;
                case 5: goto L6e;
                case 6: goto L67;
                default: goto L61;
            }
        L61:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            return r1
        L67:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.c
            java.util.List r1 = d(r1, r2)
            return r1
        L6e:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.d
            java.util.List r1 = d(r1, r2)
            return r1
        L75:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.f4286a
            java.util.List r1 = d(r1, r2)
            return r1
        L7c:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.h
            java.util.List r1 = d(r1, r2)
            return r1
        L83:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.e
            java.util.List r1 = d(r1, r2)
            return r1
        L8a:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.f
            java.util.List r1 = d(r1, r2)
            return r1
        L91:
            java.util.Map<java.lang.String, java.util.Set<com.huawei.hihealth.dictionary.constants.ProductMapInfo>> r1 = com.huawei.hihealth.dictionary.constants.ProductMap.b
            java.util.List r1 = d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.dictionary.constants.ProductMap.d(java.lang.String, java.lang.String):java.util.List");
    }

    private static List<ProductMapInfo> d(Map<String, Set<ProductMapInfo>> map, String str) {
        ArrayList arrayList;
        synchronized (ProductMap.class) {
            arrayList = new ArrayList();
            if (map.containsKey(str) && map.get(str) != null) {
                arrayList = new ArrayList(map.get(str));
            }
        }
        return arrayList;
    }
}
