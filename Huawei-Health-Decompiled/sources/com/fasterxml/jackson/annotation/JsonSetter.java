package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSetter {
    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";

    /* JADX INFO: loaded from: classes9.dex */
    public static class b implements JacksonAnnotationValue<JsonSetter>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static final b f1656a = new b(Nulls.DEFAULT, Nulls.DEFAULT);
        private static final long serialVersionUID = 1;
        private final Nulls c;
        private final Nulls d;

        protected b(Nulls nulls, Nulls nulls2) {
            this.c = nulls;
            this.d = nulls2;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonSetter> valueFor() {
            return JsonSetter.class;
        }

        protected Object readResolve() {
            return e(this.c, this.d) ? f1656a : this;
        }

        public static b b(JsonSetter jsonSetter) {
            if (jsonSetter == null) {
                return f1656a;
            }
            return b(jsonSetter.nulls(), jsonSetter.contentNulls());
        }

        public static b b(Nulls nulls, Nulls nulls2) {
            if (nulls == null) {
                nulls = Nulls.DEFAULT;
            }
            if (nulls2 == null) {
                nulls2 = Nulls.DEFAULT;
            }
            if (e(nulls, nulls2)) {
                return f1656a;
            }
            return new b(nulls, nulls2);
        }

        public static b a() {
            return f1656a;
        }

        public b e(b bVar) {
            if (bVar == null || bVar == f1656a) {
                return this;
            }
            Nulls nulls = bVar.c;
            Nulls nulls2 = bVar.d;
            if (nulls == Nulls.DEFAULT) {
                nulls = this.c;
            }
            if (nulls2 == Nulls.DEFAULT) {
                nulls2 = this.d;
            }
            return (nulls == this.c && nulls2 == this.d) ? this : b(nulls, nulls2);
        }

        public Nulls c() {
            if (this.c == Nulls.DEFAULT) {
                return null;
            }
            return this.c;
        }

        public Nulls d() {
            if (this.d == Nulls.DEFAULT) {
                return null;
            }
            return this.d;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this.c, this.d);
        }

        public int hashCode() {
            return this.c.ordinal() + (this.d.ordinal() << 2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.c == this.c && bVar.d == this.d;
        }

        private static boolean e(Nulls nulls, Nulls nulls2) {
            return nulls == Nulls.DEFAULT && nulls2 == Nulls.DEFAULT;
        }
    }
}
