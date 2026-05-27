package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {
    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";

    /* JADX INFO: loaded from: classes9.dex */
    public static class b implements JacksonAnnotationValue<JacksonInject>, Serializable {
        protected static final b d = new b(null, null);
        private static final long serialVersionUID = 1;
        protected final Boolean b;
        protected final Object e;

        private static boolean a(Object obj, Boolean bool) {
            return obj == null && bool == null;
        }

        protected b(Object obj, Boolean bool) {
            this.e = obj;
            this.b = bool;
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JacksonInject> valueFor() {
            return JacksonInject.class;
        }

        public static b c(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            if (a(obj, bool)) {
                return d;
            }
            return new b(obj, bool);
        }

        public static b e(JacksonInject jacksonInject) {
            if (jacksonInject == null) {
                return d;
            }
            return c(jacksonInject.value(), jacksonInject.useInput().asBoolean());
        }

        public static b a(Object obj) {
            return c(obj, null);
        }

        public b e(Object obj) {
            if (obj == null) {
                if (this.e == null) {
                    return this;
                }
            } else if (obj.equals(this.e)) {
                return this;
            }
            return new b(obj, this.b);
        }

        public b e(Boolean bool) {
            if (bool == null) {
                if (this.b == null) {
                    return this;
                }
            } else if (bool.equals(this.b)) {
                return this;
            }
            return new b(this.e, bool);
        }

        public Object e() {
            return this.e;
        }

        public Boolean b() {
            return this.b;
        }

        public boolean a() {
            return this.e != null;
        }

        public boolean d(boolean z) {
            Boolean bool = this.b;
            return bool == null ? z : bool.booleanValue();
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.e, this.b);
        }

        public int hashCode() {
            Object obj = this.e;
            int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
            Boolean bool = this.b;
            return bool != null ? iHashCode + bool.hashCode() : iHashCode;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                b bVar = (b) obj;
                if (OptBoolean.equals(this.b, bVar.b)) {
                    Object obj2 = this.e;
                    if (obj2 == null) {
                        return bVar.e == null;
                    }
                    return obj2.equals(bVar.e);
                }
            }
            return false;
        }
    }
}
