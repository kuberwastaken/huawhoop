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
public @interface JsonIncludeProperties {
    String[] value() default {};

    /* JADX INFO: loaded from: classes9.dex */
    public static class a implements JacksonAnnotationValue<JsonIncludeProperties>, Serializable {
        protected static final a c = new a(null);
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Set<String> f1655a;

        protected a(Set<String> set) {
            this.f1655a = set;
        }

        public static a b(JsonIncludeProperties jsonIncludeProperties) {
            if (jsonIncludeProperties == null) {
                return c;
            }
            return new a(a(jsonIncludeProperties.value()));
        }

        public static a a() {
            return c;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonIncludeProperties> valueFor() {
            return JsonIncludeProperties.class;
        }

        public Set<String> c() {
            return this.f1655a;
        }

        public a d(a aVar) {
            Set<String> setC;
            if (aVar == null || (setC = aVar.c()) == null) {
                return this;
            }
            if (this.f1655a == null) {
                return aVar;
            }
            HashSet hashSet = new HashSet();
            for (String str : setC) {
                if (this.f1655a.contains(str)) {
                    hashSet.add(str);
                }
            }
            return new a(hashSet);
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this.f1655a);
        }

        public int hashCode() {
            Set<String> set = this.f1655a;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            return obj.getClass() == getClass() && b(this.f1655a, ((a) obj).f1655a);
        }

        private static boolean b(Set<String> set, Set<String> set2) {
            if (set == null) {
                return set2 == null;
            }
            return set.equals(set2);
        }

        private static Set<String> a(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String str : strArr) {
                hashSet.add(str);
            }
            return hashSet;
        }
    }
}
