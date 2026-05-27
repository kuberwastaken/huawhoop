package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.core.ValidatorDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class wyv<A extends Annotation> implements ValidatorDescriptor<A> {
    private final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> f18982a = new ConcurrentHashMap();
    private final Map<Class<?>, Class<?>> e = new ConcurrentHashMap<Class<?>, Class<?>>() { // from class: wyv.1
        {
            put(Byte.TYPE, Byte.class);
            put(Short.TYPE, Short.class);
            put(Integer.TYPE, Integer.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
            put(Character.TYPE, Character.class);
            put(Boolean.TYPE, Boolean.class);
        }
    };
    private final Map<Class<?>, Class<?>> d = new ConcurrentHashMap<Class<?>, Class<?>>() { // from class: wyv.5
        {
            put(Byte.TYPE, byte[].class);
            put(Short.TYPE, short[].class);
            put(Integer.TYPE, int[].class);
            put(Long.TYPE, long[].class);
            put(Float.TYPE, float[].class);
            put(Double.TYPE, double[].class);
            put(Character.TYPE, char[].class);
            put(Boolean.TYPE, boolean[].class);
        }
    };

    @SafeVarargs
    public wyv(Class<? extends KfsConstraintValidator<A, ?>>... clsArr) {
        for (Class<? extends KfsConstraintValidator<A, ?>> cls : clsArr) {
            a(cls);
        }
    }

    private void a(Class<? extends KfsConstraintValidator<A, ?>> cls) {
        Type typeC = wyt.c(cls);
        if (typeC instanceof Class) {
            Class cls2 = (Class) typeC;
            if (cls2.isArray()) {
                this.f18982a.put(cls2.getComponentType(), cls);
            }
            this.c.put(typeC, cls);
            return;
        }
        if (typeC instanceof GenericArrayType) {
            Class cls3 = (Class) ((GenericArrayType) typeC).getGenericComponentType();
            if (this.d.containsKey(cls3)) {
                this.c.put(this.d.get(cls3), cls);
            }
        }
    }

    private Class<? extends KfsConstraintValidator<A, ?>> c(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Class<?> cls) {
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        Class<? extends KfsConstraintValidator<A, ?>> clsA = a(map, cls.getGenericSuperclass());
        if (clsA != null) {
            return clsA;
        }
        for (Type type : cls.getGenericInterfaces()) {
            Class<? extends KfsConstraintValidator<A, ?>> clsA2 = a(map, type);
            if (clsA2 != null) {
                return clsA2;
            }
        }
        return null;
    }

    private Class<? extends KfsConstraintValidator<A, ?>> a(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Type type) {
        Class<? extends KfsConstraintValidator<A, ?>> clsC;
        if (type == null) {
            return null;
        }
        if ((type instanceof Class) && (clsC = c(map, (Class) type)) != null) {
            return clsC;
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getRawType() instanceof Class) {
            return c(map, (Class) parameterizedType.getRawType());
        }
        return null;
    }

    private Class<?> e(Class<?> cls) {
        return this.e.containsKey(cls) ? this.e.get(cls) : cls;
    }

    @Override // com.huawei.wisesecurity.kfs.validation.core.ValidatorDescriptor
    public Class<? extends KfsConstraintValidator<A, ?>> getValidator(Class<?> cls) {
        Class<? extends KfsConstraintValidator<A, ?>> clsA;
        if (cls == null) {
            return null;
        }
        Class<?> clsE = e(cls);
        if (this.c.containsKey(Object.class)) {
            return this.c.get(Object.class);
        }
        if (this.c.containsKey(clsE)) {
            return this.c.get(clsE);
        }
        if (clsE.isArray()) {
            clsA = a(this.f18982a, clsE.getComponentType());
        } else {
            clsA = a(this.c, clsE);
        }
        if (clsA != null) {
            this.c.put(clsE, clsA);
        }
        return clsA;
    }
}
