package defpackage;

import defpackage.axt;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes10.dex */
public class axt {
    private List<a> b;

    public axt() {
        this.b = Collections.emptyList();
    }

    public axt(List<a> list) {
        this.b = Collections.emptyList();
        this.b = (List) list.stream().sorted(new Comparator() { // from class: axu
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return axt.d((axt.a) obj, (axt.a) obj2);
            }
        }).collect(Collectors.toList());
    }

    static /* synthetic */ int d(a aVar, a aVar2) {
        return -Float.compare(aVar.f370a, aVar2.f370a);
    }

    public List<a> a() {
        return this.b;
    }

    public String toString() {
        return this.b.toString();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f370a;
        private final String d;

        public a(String str, float f) {
            this.d = str;
            this.f370a = f;
        }

        public String e() {
            return this.d;
        }

        public String toString() {
            return "{label='" + this.d + "', prob=" + this.f370a + '}';
        }
    }
}
