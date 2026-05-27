package com.fasterxml.jackson.annotation;

import com.huawei.hms.network.embedded.g4;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    /* JADX INFO: loaded from: classes9.dex */
    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    Include content() default Include.ALWAYS;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.ALWAYS;

    Class<?> valueFilter() default Void.class;

    /* JADX INFO: loaded from: classes9.dex */
    public static class d implements JacksonAnnotationValue<JsonInclude>, Serializable {
        protected static final d c = new d(Include.USE_DEFAULTS, Include.USE_DEFAULTS, null, null);
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Class<?> f1654a;
        protected final Include b;
        protected final Include d;
        protected final Class<?> e;

        protected d(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            this.d = include == null ? Include.USE_DEFAULTS : include;
            this.b = include2 == null ? Include.USE_DEFAULTS : include2;
            this.f1654a = cls == Void.class ? null : cls;
            this.e = cls2 == Void.class ? null : cls2;
        }

        public static d a() {
            return c;
        }

        public static d c(d dVar, d dVar2) {
            return dVar == null ? dVar2 : dVar.a(dVar2);
        }

        public static d a(d... dVarArr) {
            d dVar = null;
            for (d dVarA : dVarArr) {
                if (dVarA != null) {
                    if (dVar != null) {
                        dVarA = dVar.a(dVarA);
                    }
                    dVar = dVarA;
                }
            }
            return dVar;
        }

        protected Object readResolve() {
            return (this.d == Include.USE_DEFAULTS && this.b == Include.USE_DEFAULTS && this.f1654a == null && this.e == null) ? c : this;
        }

        public d a(d dVar) {
            if (dVar != null && dVar != c) {
                Include include = dVar.d;
                Include include2 = dVar.b;
                Class<?> cls = dVar.f1654a;
                Class<?> cls2 = dVar.e;
                boolean z = (include == this.d || include == Include.USE_DEFAULTS) ? false : true;
                boolean z2 = (include2 == this.b || include2 == Include.USE_DEFAULTS) ? false : true;
                Class<?> cls3 = this.f1654a;
                boolean z3 = (cls == cls3 && cls2 == cls3) ? false : true;
                if (z) {
                    if (z2) {
                        return new d(include, include2, cls, cls2);
                    }
                    return new d(include, this.b, cls, cls2);
                }
                if (z2) {
                    return new d(this.d, include2, cls, cls2);
                }
                if (z3) {
                    return new d(this.d, this.b, cls, cls2);
                }
            }
            return this;
        }

        public static d a(Include include, Include include2) {
            if ((include == Include.USE_DEFAULTS || include == null) && (include2 == Include.USE_DEFAULTS || include2 == null)) {
                return c;
            }
            return new d(include, include2, null, null);
        }

        public static d b(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            if (cls == Void.class) {
                cls = null;
            }
            if (cls2 == Void.class) {
                cls2 = null;
            }
            if ((include == Include.USE_DEFAULTS || include == null) && ((include2 == Include.USE_DEFAULTS || include2 == null) && cls == null && cls2 == null)) {
                return c;
            }
            return new d(include, include2, cls, cls2);
        }

        public static d c(JsonInclude jsonInclude) {
            if (jsonInclude == null) {
                return c;
            }
            Include includeValue = jsonInclude.value();
            Include includeContent = jsonInclude.content();
            if (includeValue == Include.USE_DEFAULTS && includeContent == Include.USE_DEFAULTS) {
                return c;
            }
            Class<?> clsValueFilter = jsonInclude.valueFilter();
            if (clsValueFilter == Void.class) {
                clsValueFilter = null;
            }
            Class<?> clsContentFilter = jsonInclude.contentFilter();
            return new d(includeValue, includeContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
        }

        public d b(Include include) {
            return include == this.d ? this : new d(include, this.b, this.f1654a, this.e);
        }

        public d a(Class<?> cls) {
            Include include;
            if (cls == null || cls == Void.class) {
                include = Include.USE_DEFAULTS;
                cls = null;
            } else {
                include = Include.CUSTOM;
            }
            return b(this.d, include, this.f1654a, cls);
        }

        public d d(Include include) {
            return include == this.b ? this : new d(this.d, include, this.f1654a, this.e);
        }

        @Override // com.fasterxml.jackson.annotation.JacksonAnnotationValue
        public Class<JsonInclude> valueFor() {
            return JsonInclude.class;
        }

        public Include d() {
            return this.d;
        }

        public Include c() {
            return this.b;
        }

        public Class<?> e() {
            return this.f1654a;
        }

        public Class<?> b() {
            return this.e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this.d);
            sb.append(",content=");
            sb.append(this.b);
            if (this.f1654a != null) {
                sb.append(",valueFilter=");
                sb.append(this.f1654a.getName());
                sb.append(".class");
            }
            if (this.e != null) {
                sb.append(",contentFilter=");
                sb.append(this.e.getName());
                sb.append(".class");
            }
            sb.append(g4.l);
            return sb.toString();
        }

        public int hashCode() {
            return (this.d.hashCode() << 2) + this.b.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.d == this.d && dVar.b == this.b && dVar.f1654a == this.f1654a && dVar.e == this.e;
        }
    }
}
