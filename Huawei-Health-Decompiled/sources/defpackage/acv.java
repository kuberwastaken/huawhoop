package defpackage;

import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class acv implements Annotations {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<Class<?>, Annotation> f169a;

    public acv() {
    }

    public static acv e(Class<?> cls, Annotation annotation) {
        HashMap map = new HashMap(4);
        map.put(cls, annotation);
        return new acv(map);
    }

    public acv(HashMap<Class<?>, Annotation> map) {
        this.f169a = map;
    }

    @Override // com.fasterxml.jackson.databind.util.Annotations
    public <A extends Annotation> A get(Class<A> cls) {
        HashMap<Class<?>, Annotation> map = this.f169a;
        if (map == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    @Override // com.fasterxml.jackson.databind.util.Annotations
    public boolean has(Class<?> cls) {
        HashMap<Class<?>, Annotation> map = this.f169a;
        if (map == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    @Override // com.fasterxml.jackson.databind.util.Annotations
    public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
        if (this.f169a != null) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (this.f169a.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Iterable<Annotation> b() {
        HashMap<Class<?>, Annotation> map = this.f169a;
        if (map == null || map.size() == 0) {
            return Collections.emptyList();
        }
        return this.f169a.values();
    }

    public static acv c(acv acvVar, acv acvVar2) {
        HashMap<Class<?>, Annotation> map;
        HashMap<Class<?>, Annotation> map2;
        if (acvVar == null || (map = acvVar.f169a) == null || map.isEmpty()) {
            return acvVar2;
        }
        if (acvVar2 == null || (map2 = acvVar2.f169a) == null || map2.isEmpty()) {
            return acvVar;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : acvVar2.f169a.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : acvVar.f169a.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new acv(map3);
    }

    @Override // com.fasterxml.jackson.databind.util.Annotations
    public int size() {
        HashMap<Class<?>, Annotation> map = this.f169a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public boolean b(Annotation annotation) {
        return c(annotation);
    }

    public String toString() {
        HashMap<Class<?>, Annotation> map = this.f169a;
        return map == null ? "[null]" : map.toString();
    }

    protected final boolean c(Annotation annotation) {
        if (this.f169a == null) {
            this.f169a = new HashMap<>();
        }
        Annotation annotationPut = this.f169a.put(annotation.annotationType(), annotation);
        return annotationPut == null || !annotationPut.equals(annotation);
    }
}
