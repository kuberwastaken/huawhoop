package com.huawei.hmf.services.codec;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class MessageCodec {
    private static final String LIST_ITEM_VALUE = "_list_item_";
    private static final String LIST_SIZE = "_list_size_";
    private static final String TAG = "MessageCodec";
    private static final int VAL_ENTITY = 0;
    private static final int VAL_LIST = 1;
    private static final int VAL_NULL = -1;
    private static final String VAL_TYPE = "_val_type_";

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T decode(Bundle bundle, Type type) {
        Object objDecode = (T) null;
        if (bundle != null && type != null) {
            Class<?> type2 = GenericTypeReflector.getType(type);
            try {
                if (type2 == List.class) {
                    objDecode = (T) readList(type, bundle);
                } else {
                    objDecode = decode(bundle, type2.newInstance());
                }
            } catch (Exception unused) {
            }
        }
        return (T) objDecode;
    }

    public <T> T decode(Bundle bundle, T t) {
        return (bundle == null || t == null) ? t : (T) decode(bundle, t, t.getClass());
    }

    private <T> T decode(Bundle bundle, T t, Type type) {
        if (bundle != null && t != null) {
            for (Class<?> superclass = t.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    try {
                        readField(type, t, field, bundle);
                    } catch (IllegalAccessException | IllegalArgumentException e) {
                        Log.e(TAG, "decode, set value of the field exception, field name:" + field.getName(), e);
                    }
                }
                type = GenericTypeReflector.resolve(type, superclass, superclass.getGenericSuperclass());
            }
        }
        return t;
    }

    private void readField(Type type, Object obj, Field field, Bundle bundle) throws IllegalAccessException {
        Object value;
        if (Modifier.isTransient(field.getModifiers()) || (value = readValue(type, field, bundle)) == null) {
            return;
        }
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(obj, value);
        field.setAccessible(zIsAccessible);
    }

    protected Object readValue(Type type, Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (!(obj instanceof Bundle) || field.getDeclaringClass() == Variant.class) {
            return obj;
        }
        try {
            Bundle bundle2 = (Bundle) obj;
            int i = bundle2.getInt(VAL_TYPE, -1);
            if (i == 1) {
                return readList(GenericTypeReflector.resolve(type, field.getDeclaringClass(), field.getGenericType()), bundle2);
            }
            if (i == 0) {
                Type typeResolve = GenericTypeReflector.resolve(type, field.getDeclaringClass(), field.getGenericType());
                return decode((Bundle) obj, GenericTypeReflector.getType(typeResolve).newInstance(), typeResolve);
            }
            return obj;
        } catch (Exception e) {
            Log.e(TAG, "decode, read value of the field exception, field name: " + name, e);
            return null;
        }
    }

    protected List<Object> readList(Type type, Bundle bundle) throws IllegalAccessException, InstantiationException {
        int i = bundle.getInt(LIST_SIZE);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = bundle.get(LIST_ITEM_VALUE + i2);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                int i3 = bundle2.getInt(VAL_TYPE, -1);
                if (i3 == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                }
                if (i3 == 0) {
                    arrayList.add(decode(bundle2, ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else {
                    throw new InstantiationException("Unknown type can not be supported");
                }
            } else {
                continue;
            }
        }
        return arrayList;
    }

    public Bundle encode(Object obj, Bundle bundle) {
        for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                try {
                    writeField(obj, field, bundle);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    Log.e(TAG, "encode, get value of the field exception, field name: " + field.getName(), e);
                }
            }
        }
        return bundle;
    }

    private void writeField(Object obj, Field field, Bundle bundle) throws IllegalAccessException {
        if (Modifier.isTransient(field.getModifiers())) {
            return;
        }
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        writeValue(field.getName(), field.get(obj), bundle);
        field.setAccessible(zIsAccessible);
    }

    protected void writeValue(String str, Object obj, Bundle bundle) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
            return;
        }
        if (obj instanceof IBinder) {
            bundle.putBinder(str, (IBinder) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof List) {
            writeList(str, (List) obj, bundle);
            return;
        }
        if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj.getClass() != Object.class) {
            Bundle bundleEncode = encode(obj, new Bundle());
            bundleEncode.putInt(VAL_TYPE, 0);
            bundle.putBundle(str, bundleEncode);
        }
    }

    protected void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(VAL_TYPE, 1);
        bundle2.putInt(LIST_SIZE, list.size());
        for (int i = 0; i < list.size(); i++) {
            writeValue(LIST_ITEM_VALUE + i, list.get(i), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
