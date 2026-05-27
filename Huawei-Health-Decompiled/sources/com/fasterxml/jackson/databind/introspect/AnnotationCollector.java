package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.Annotations;
import defpackage.acv;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AnnotationCollector {
    protected static final Annotations NO_ANNOTATIONS = new a();
    protected final Object _data;

    public abstract AnnotationCollector addOrOverride(Annotation annotation);

    public abstract acv asAnnotationMap();

    public abstract Annotations asAnnotations();

    public abstract boolean isPresent(Annotation annotation);

    protected AnnotationCollector(Object obj) {
        this._data = obj;
    }

    public static Annotations emptyAnnotations() {
        return NO_ANNOTATIONS;
    }

    public static AnnotationCollector emptyCollector() {
        return d.e;
    }

    public static AnnotationCollector emptyCollector(Object obj) {
        return new d(obj);
    }

    public Object getData() {
        return this._data;
    }

    static class d extends AnnotationCollector {
        public static final d e = new d(null);

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return false;
        }

        d(Object obj) {
            super(obj);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            return NO_ANNOTATIONS;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public acv asAnnotationMap() {
            return new acv();
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            return new c(this._data, annotation.annotationType(), annotation);
        }
    }

    static class c extends AnnotationCollector {
        private Annotation b;
        private Class<?> c;

        public c(Object obj, Class<?> cls, Annotation annotation) {
            super(obj);
            this.c = cls;
            this.b = annotation;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            return new e(this.c, this.b);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public acv asAnnotationMap() {
            return acv.e(this.c, this.b);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return annotation.annotationType() == this.c;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            if (this.c == clsAnnotationType) {
                this.b = annotation;
                return this;
            }
            return new b(this._data, this.c, this.b, clsAnnotationType, annotation);
        }
    }

    static class b extends AnnotationCollector {
        protected final HashMap<Class<?>, Annotation> d;

        public b(Object obj, Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            super(obj);
            HashMap<Class<?>, Annotation> map = new HashMap<>();
            this.d = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            if (this.d.size() == 2) {
                Iterator<Map.Entry<Class<?>, Annotation>> it = this.d.entrySet().iterator();
                Map.Entry<Class<?>, Annotation> next = it.next();
                Map.Entry<Class<?>, Annotation> next2 = it.next();
                return new j(next.getKey(), next.getValue(), next2.getKey(), next2.getValue());
            }
            return new acv(this.d);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public acv asAnnotationMap() {
            acv acvVar = new acv();
            Iterator<Annotation> it = this.d.values().iterator();
            while (it.hasNext()) {
                acvVar.b(it.next());
            }
            return acvVar;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return this.d.containsKey(annotation.annotationType());
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            this.d.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static class a implements Annotations, Serializable {
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 0;
        }

        a() {
        }
    }

    public static class e implements Annotations, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> d;
        private final Annotation e;

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 1;
        }

        public e(Class<?> cls, Annotation annotation) {
            this.d = cls;
            this.e = annotation;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            if (this.d == cls) {
                return (A) this.e;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return this.d == cls;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this.d) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class j implements Annotations, Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Annotation f1682a;
        private final Annotation b;
        private final Class<?> d;
        private final Class<?> e;

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 2;
        }

        public j(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this.d = cls;
            this.b = annotation;
            this.e = cls2;
            this.f1682a = annotation2;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            if (this.d == cls) {
                return (A) this.b;
            }
            if (this.e == cls) {
                return (A) this.f1682a;
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return this.d == cls || this.e == cls;
        }

        @Override // com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this.d || cls == this.e) {
                    return true;
                }
            }
            return false;
        }
    }
}
