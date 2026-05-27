package com.fasterxml.jackson.annotation;

import com.huawei.hihealth.dictionary.model.HealthDataMergePolicy;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {
    public abstract boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> forScope(Class<?> cls);

    public abstract T generateId(Object obj);

    public abstract Class<?> getScope();

    public boolean isValidReferencePropertyName(String str, Object obj) {
        return false;
    }

    public abstract b key(Object obj);

    public boolean maySerializeAsObject() {
        return false;
    }

    public abstract ObjectIdGenerator<T> newForSerialization(Object obj);

    public static final class b implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1657a;
        public final Class<?> c;
        public final Class<?> d;
        private final int e;

        public b(Class<?> cls, Class<?> cls2, Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("Can not construct IdKey for null key");
            }
            this.d = cls;
            this.c = cls2;
            this.f1657a = obj;
            int iHashCode = obj.hashCode() + cls.getName().hashCode();
            this.e = cls2 != null ? iHashCode ^ cls2.getName().hashCode() : iHashCode;
        }

        public int hashCode() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f1657a.equals(this.f1657a) && bVar.d == this.d && bVar.c == this.c;
        }

        public String toString() {
            Object[] objArr = new Object[3];
            objArr[0] = this.f1657a;
            Class<?> cls = this.d;
            String name = HealthDataMergePolicy.NONE;
            objArr[1] = cls == null ? HealthDataMergePolicy.NONE : cls.getName();
            Class<?> cls2 = this.c;
            if (cls2 != null) {
                name = cls2.getName();
            }
            objArr[2] = name;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", objArr);
        }
    }
}
