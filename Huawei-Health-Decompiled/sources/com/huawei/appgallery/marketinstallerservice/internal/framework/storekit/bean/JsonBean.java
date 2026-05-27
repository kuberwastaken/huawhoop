package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.appgallery.marketinstallerservice.b.b.f.a;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.utils.seuqneceutils.SequenceDetailFieldConfig;
import defpackage.bbf;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonBean {
    public String toJson() {
        Object obj;
        Field[] fieldArrA = a.a(getClass());
        if (fieldArrA.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < fieldArrA.length; i++) {
            Field field = fieldArrA[i];
            String name = field.getName();
            if (field.isAnnotationPresent(InstallerNetTransmission.class)) {
                boolean zIsAccessible = field.isAccessible();
                Field fieldA = a(field, true);
                try {
                    try {
                        obj = fieldA.get(this);
                    } catch (IllegalAccessException unused) {
                        bbf.c("JsonBean", "can not access");
                        a(fieldA, zIsAccessible);
                        obj = null;
                    }
                    String strA = a(obj);
                    if (strA != null) {
                        sb.append("\"");
                        sb.append(name);
                        sb.append("\":");
                        sb.append(strA);
                        sb.append(',');
                    } else {
                        bbf.c("JsonBean", "valueToJson error, field:" + fieldArrA[i]);
                    }
                } finally {
                    a(fieldA, zIsAccessible);
                }
            }
        }
        a(sb);
        sb.append("}");
        return sb.toString();
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        StringBuilder sb;
        String str;
        Field[] fieldArrA = a.a(getClass());
        Object objA = null;
        for (int i = 0; i < fieldArrA.length; i++) {
            Field field = fieldArrA[i];
            String name = field.getName();
            if (fieldArrA[i].isAnnotationPresent(InstallerNetTransmission.class) && jSONObject.has(name)) {
                Object obj = jSONObject.get(name);
                if (!JSONObject.NULL.equals(obj)) {
                    boolean zIsAccessible = field.isAccessible();
                    Field fieldA = a(field, true);
                    try {
                        objA = a(fieldA.getType(), a.a(fieldA), obj);
                        fieldArrA[i].set(this, objA);
                    } catch (ClassNotFoundException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append(getClass().getName());
                        str = ".fromJson error ClassNotFoundException, fieldName:";
                        sb.append(str);
                        sb.append(name);
                        bbf.c("JsonBean", sb.toString(), e);
                        a(fieldA, objA);
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append(getClass().getName());
                        str = ".fromJson error IllegalAccessException, fieldName:";
                        sb.append(str);
                        sb.append(name);
                        bbf.c("JsonBean", sb.toString(), e);
                        a(fieldA, objA);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append(getClass().getName());
                        str = ".fromJson error IllegalArgumentException, fieldName:";
                        sb.append(str);
                        sb.append(name);
                        bbf.c("JsonBean", sb.toString(), e);
                        a(fieldA, objA);
                    } catch (InstantiationException e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append(getClass().getName());
                        str = ".fromJson error InstantiationException, fieldName:";
                        sb.append(str);
                        sb.append(name);
                        bbf.c("JsonBean", sb.toString(), e);
                        a(fieldA, objA);
                    } catch (JSONException unused) {
                        bbf.c("JsonBean", getClass().getName() + ".fromJson error JSONException, fieldName:" + name + " :JSONException");
                        a(fieldA, objA);
                    }
                    a(fieldA, zIsAccessible);
                }
            }
        }
    }

    protected Object b(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONObject)) {
            throw new IllegalArgumentException("jsonobject is not JSONObject, jsonValue:" + obj);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objA = a(cls, null, jSONObject.get(next));
            if (objA != null) {
                if (objA.getClass().toString().equals(cls.toString())) {
                    linkedHashMap.put(next, objA);
                } else {
                    bbf.c("JsonBean", "mapFromJson error, memberClass:" + cls + ", valueClass:" + objA.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    protected Object a(Class cls, Object obj) {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        }
        if (!(obj instanceof JSONArray)) {
            throw new IllegalArgumentException("jsonobject is not JSONArray, jsonValue:" + obj);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objA = a(cls, null, jSONArray.get(i));
            if (objA != null) {
                if (objA.getClass().toString().equals(cls.toString())) {
                    arrayList.add(objA);
                } else {
                    bbf.c("JsonBean", "listFromJson error, memberClass:" + cls + ", valueClass:" + objA.getClass());
                }
            }
        }
        return arrayList;
    }

    public static String mapToJson(Map map) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        Iterator it = map.entrySet().iterator();
        while (true) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            String strA = a(entry.getValue());
            if (strA != null) {
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                sb.append(strA);
            }
            if (!it.hasNext()) {
                sb.append("}");
                return sb.toString();
            }
            if (strA != null) {
                sb.append(',');
            }
        }
    }

    public static String listToJson(List list) {
        if (list.size() <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            String strA = a(list.get(i));
            if (strA != null) {
                sb.append(strA);
                sb.append(',');
            }
        }
        a(sb);
        sb.append("]");
        return sb.toString();
    }

    private Object c(Class cls, Object obj) throws JSONException {
        JsonBean jsonBean = (JsonBean) cls.newInstance();
        jsonBean.fromJson((JSONObject) obj);
        return jsonBean;
    }

    public static String arrayToJson(Array array) {
        int length = Array.getLength(array);
        if (length <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            String strA = a(Array.get(array, i));
            if (strA != null) {
                sb.append(strA);
                sb.append(',');
            }
        }
        a(sb);
        sb.append("]");
        return sb.toString();
    }

    private void a(Field field, Object obj) {
        Object objValueOf;
        if (obj instanceof String) {
            try {
                Class<?> type = field.getType();
                if (type.isPrimitive()) {
                    String name = type.getName();
                    if ("int".equals(name)) {
                        objValueOf = Integer.valueOf(Integer.parseInt((String) obj));
                    } else if ("float".equals(name)) {
                        objValueOf = Float.valueOf(Float.parseFloat((String) obj));
                    } else if ("long".equals(name)) {
                        objValueOf = Long.valueOf(Long.parseLong((String) obj));
                    } else if (TypedValues.Custom.S_BOOLEAN.equals(name)) {
                        objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj));
                    } else if (SequenceDetailFieldConfig.DOUBLE.equals(name)) {
                        objValueOf = Double.valueOf(Double.parseDouble((String) obj));
                    } else if ("short".equals(name)) {
                        objValueOf = Short.valueOf(Short.parseShort((String) obj));
                    } else if ("byte".equals(name)) {
                        objValueOf = Byte.valueOf(Byte.parseByte((String) obj));
                    } else if (!SequenceDetailFieldConfig.CHAR.equals(name)) {
                        return;
                    } else {
                        objValueOf = Character.valueOf(((String) obj).charAt(0));
                    }
                    field.set(this, objValueOf);
                }
            } catch (Throwable unused) {
                bbf.c("JsonBean", "processValueError error!");
            }
        }
    }

    private static void a(StringBuilder sb) {
        int length = sb.length();
        if (length > 0) {
            int i = length - 1;
            if (sb.charAt(i) == ',') {
                sb.delete(i, length);
            }
        }
    }

    static class b implements PrivilegedAction<Field> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Field f1914a;
        private boolean c;

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Field run() {
            this.f1914a.setAccessible(this.c);
            return this.f1914a;
        }

        b(Field field, boolean z) {
            this.f1914a = field;
            this.c = z;
        }
    }

    private Field a(Field field, boolean z) {
        return (Field) AccessController.doPrivileged(new b(field, z));
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "\"null\"";
        }
        if (obj instanceof String) {
            return "\"" + obj.toString() + "\"";
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Short)) {
            return String.valueOf(obj);
        }
        if (obj instanceof JsonBean) {
            return ((JsonBean) obj).toJson();
        }
        if (obj instanceof List) {
            return listToJson((List) obj);
        }
        if (obj instanceof Map) {
            return mapToJson((Map) obj);
        }
        if (obj.getClass().isArray()) {
            return arrayToJson((Array) obj);
        }
        return null;
    }

    private Object a(Class cls, Class cls2, Object obj) {
        if (cls.isPrimitive() || String.class.toString().equals(cls.toString())) {
            return ("float".equals(cls.getName()) && (obj instanceof Double)) ? Float.valueOf(((Double) obj).floatValue()) : obj;
        }
        if (List.class.isAssignableFrom(cls)) {
            return a(cls2, obj);
        }
        if (JsonBean.class.isAssignableFrom(cls)) {
            if (!cls.toString().equals(JsonBean.class.toString())) {
                return c(cls, obj);
            }
            throw new IllegalArgumentException("error type, type:" + cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return b(cls2, obj);
        }
        throw new IllegalArgumentException("unsupport type, Type:" + cls);
    }
}
