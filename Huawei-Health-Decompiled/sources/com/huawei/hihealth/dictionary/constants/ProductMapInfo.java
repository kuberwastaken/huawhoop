package com.huawei.hihealth.dictionary.constants;

import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class ProductMapInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4287a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private OptionalFileds g;
    private String i;
    private Map<String, String> j;

    public static class OptionalFileds {
        private String e;

        public void c(String str) {
            this.e = str;
        }

        public int hashCode() {
            return Objects.hash(this.e);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof OptionalFileds) {
                return TextUtils.equals(this.e, ((OptionalFileds) obj).e);
            }
            return false;
        }

        public String toString() {
            return "OptionalFileds{deviceEnName='" + this.e + "'}";
        }
    }

    public ProductMapInfo(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.e = str;
        this.i = str2;
        this.f = str3;
        this.c = str4;
        this.f4287a = str5;
        this.b = str6;
        this.d = i;
    }

    public String b() {
        return this.e;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.f;
    }

    public String a() {
        return this.c;
    }

    public String e() {
        return this.f4287a;
    }

    public String d() {
        return this.b;
    }

    public String c(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.j) == null) {
            return this.b;
        }
        String str2 = map.get(str);
        return str2 != null ? str2 : this.b;
    }

    public int c() {
        return this.d;
    }

    public void d(OptionalFileds optionalFileds) {
        this.g = optionalFileds;
    }

    public void b(Map<String, String> map) {
        this.j = map;
    }

    public int hashCode() {
        return Objects.hash(this.e, this.i, this.f, this.c, this.f4287a, this.b, Integer.valueOf(this.d), this.j);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductMapInfo)) {
            return false;
        }
        ProductMapInfo productMapInfo = (ProductMapInfo) obj;
        return TextUtils.equals(this.e, productMapInfo.e) && TextUtils.equals(this.i, productMapInfo.i) && TextUtils.equals(this.f, productMapInfo.f) && TextUtils.equals(this.c, productMapInfo.c) && TextUtils.equals(this.f4287a, productMapInfo.f4287a) && TextUtils.equals(this.b, productMapInfo.b) && this.d == productMapInfo.d && b(this.g, productMapInfo.g) && a(this.j, productMapInfo.j);
    }

    private boolean a(Map<String, String> map, final Map<String, String> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        return map.entrySet().stream().allMatch(new Predicate() { // from class: com.huawei.hihealth.dictionary.constants.ProductMapInfo$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ProductMapInfo.d(map2, (Map.Entry) obj);
            }
        });
    }

    static /* synthetic */ boolean d(Map map, Map.Entry entry) {
        if (entry.getKey() == null) {
            return false;
        }
        return Objects.equals(entry.getValue(), map.get(entry.getKey()));
    }

    private boolean b(OptionalFileds optionalFileds, OptionalFileds optionalFileds2) {
        return (optionalFileds == null && optionalFileds2 == null) || (optionalFileds != null && optionalFileds.equals(optionalFileds2));
    }

    public String toString() {
        return "ProductMapInfo{mDeviceType='" + this.e + "', mSmartProductId='" + this.i + "', mProductId='" + this.f + "', mModelName='" + this.c + "', mManufactorId='" + this.f4287a + "', mMarketingName='" + this.b + "', mDeviceId=" + this.d + ", optionalFileds=" + this.g + ", subIdMarketingNameMap=" + this.j + '}';
    }
}
