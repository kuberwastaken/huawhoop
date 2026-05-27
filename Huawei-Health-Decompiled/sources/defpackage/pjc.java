package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pjc {
    private List<d> d;
    private String e;

    public pjc(String str, List<d> list) {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        this.e = str;
        arrayList.addAll(list);
    }

    public String b() {
        return this.e;
    }

    public List<d> d() {
        return this.d;
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16724a;
        public final String c;

        public d(String str, String str2) {
            this.c = str;
            this.f16724a = str2;
        }
    }
}
