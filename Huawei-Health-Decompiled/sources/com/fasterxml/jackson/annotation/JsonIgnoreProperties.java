package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIgnoreProperties {
    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};

    /* JADX INFO: loaded from: classes9.dex */
    public static class b implements JacksonAnnotationValue<JsonIgnoreProperties>, Serializable {
        protected static final b d = new b(Collections.emptySet(), false, false, false, true);
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final boolean f1653a;
        protected final boolean b;
        protected final boolean c;
        protected final Set<String> e;
        protected final boolean g;

        protected b(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            if (set == null) {
                this.e = Collections.emptySet();
            } else {
                this.e = set;
            }
            this.f1653a = z;
            this.c = z2;
            this.b = z3;
            this.g = z4;
        }

        public static b e(JsonIgnoreProperties jsonIgnoreProperties) {
            if (jsonIgnoreProperties == null) {
                return d;
            }
            return a(d(jsonIgnoreProperties.value()), jsonIgnoreProperties.ignoreUnknown(), jsonIgnoreProperties.allowGetters(), jsonIgnoreProperties.allowSetters(), false);
        }

        public static b a(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            if (e(set, z, z2, z3, z4)) {
                return d;
            }
            return new b(set, z, z2, z3, z4);
        }

        public static b e() {
            return d;
        }

        public static b c(b bVar, b bVar2) {
            return bVar == null ? bVar2 : bVar.b(bVar2);
        }

        public b b(b bVar) {
            if (bVar == null || bVar == d) {
                return this;
            }
            if (!bVar.g) {
                return bVar;
            }
            if (a(this, bVar)) {
                return this;
            }
            return a(a(this.e, bVar.e), this.f1653a || bVar.f1653a, this.c || bVar.c, this.b || bVar.b, true);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIgnoreProperties> valueFor() {
            return JsonIgnoreProperties.class;
        }

        protected Object readResolve() {
            return e(this.e, this.f1653a, this.c, this.b, this.g) ? d : this;
        }

        public Set<String> c() {
            if (this.c) {
                return Collections.emptySet();
            }
            return this.e;
        }

        public Set<String> a() {
            if (this.b) {
                return Collections.emptySet();
            }
            return this.e;
        }

        public boolean b() {
            return this.f1653a;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.e, Boolean.valueOf(this.f1653a), Boolean.valueOf(this.c), Boolean.valueOf(this.b), Boolean.valueOf(this.g));
        }

        public int hashCode() {
            int size = this.e.size();
            int i = this.f1653a ? 1 : -3;
            int i2 = this.c ? 3 : -7;
            return size + i + i2 + (this.b ? 7 : -11) + (this.g ? 11 : -13);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            return obj.getClass() == getClass() && a(this, (b) obj);
        }

        private static boolean a(b bVar, b bVar2) {
            return bVar.f1653a == bVar2.f1653a && bVar.g == bVar2.g && bVar.c == bVar2.c && bVar.b == bVar2.b && bVar.e.equals(bVar2.e);
        }

        private static Set<String> d(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String str : strArr) {
                hashSet.add(str);
            }
            return hashSet;
        }

        private static Set<String> a(Set<String> set, Set<String> set2) {
            if (set.isEmpty()) {
                return set2;
            }
            if (set2.isEmpty()) {
                return set;
            }
            HashSet hashSet = new HashSet(set.size() + set2.size());
            hashSet.addAll(set);
            hashSet.addAll(set2);
            return hashSet;
        }

        private static boolean e(Set<String> set, boolean z, boolean z2, boolean z3, boolean z4) {
            b bVar = d;
            return z == bVar.f1653a && z2 == bVar.c && z3 == bVar.b && z4 == bVar.g && (set == null || set.size() == 0);
        }
    }
}
