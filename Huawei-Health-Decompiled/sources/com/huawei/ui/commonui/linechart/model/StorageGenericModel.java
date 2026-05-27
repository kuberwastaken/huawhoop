package com.huawei.ui.commonui.linechart.model;

import android.text.TextUtils;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.commonui.linechart.icommon.IStorageModel;
import defpackage.mgx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class StorageGenericModel implements IStorageModel {
    private PresentStyle c;
    private Map<String, Float> b = new HashMap();
    private Map<String, Object> e = new HashMap();

    public interface PresentStyle {
        boolean validate();
    }

    public void a(String str, float f) {
        this.b.put(str, Float.valueOf(f));
    }

    public void d(String str, Object obj) {
        List arrayList;
        if (this.e.get(str) == null) {
            arrayList = new ArrayList();
            this.e.put(str, arrayList);
        } else {
            Object obj2 = this.e.get(str);
            if (!mgx.e(obj2, Object.class)) {
                throw new RuntimeException("addGenericObject old not list");
            }
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    public List<Object> a(String str) {
        if (str != null) {
            Object obj = this.e.get(str);
            if (obj != null) {
                if (!mgx.e(obj, Object.class)) {
                    throw new RuntimeException("queryGenericObjects old not list");
                }
                return (List) obj;
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public void b(PresentStyle presentStyle) {
        this.c = presentStyle;
    }

    public PresentStyle a() {
        return this.c;
    }

    public boolean c() {
        PresentStyle presentStyle = this.c;
        return presentStyle != null && presentStyle.validate();
    }

    public class d implements PresentStyle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9244a;
        private String[] c;

        public d(String str, String... strArr) {
            this.f9244a = str;
            if (strArr == null) {
                this.c = null;
            } else {
                this.c = (String[]) strArr.clone();
            }
        }

        public float c() {
            Float f = (Float) StorageGenericModel.this.b.get(this.f9244a);
            if (f != null) {
                return f.floatValue();
            }
            String[] strArr = this.c;
            if (strArr == null || strArr.length == 0) {
                return 0.0f;
            }
            for (String str : strArr) {
                Float f2 = (Float) StorageGenericModel.this.b.get(str);
                if (f2 != null) {
                    return f2.floatValue();
                }
            }
            return 0.0f;
        }

        @Override // com.huawei.ui.commonui.linechart.model.StorageGenericModel.PresentStyle
        public boolean validate() {
            return !TextUtils.isEmpty(this.f9244a);
        }
    }

    public class e implements PresentStyle {
        private String b;
        private String d;

        public e(String str, String str2) {
            this.d = str;
            this.b = str2;
            if ("HR_WARNING_MAX".equals(str2) && "HR_WARNING_MIN".equals(this.d) && StorageGenericModel.this.e.size() == 0) {
                LogUtil.a("BarDataPresentation", "not has detail");
            }
        }

        public float a() {
            Float f = (Float) StorageGenericModel.this.b.get(this.b);
            if (f == null) {
                return 0.0f;
            }
            return f.floatValue();
        }

        public float e() {
            Float f = (Float) StorageGenericModel.this.b.get(this.d);
            if (f == null) {
                return 0.0f;
            }
            return f.floatValue();
        }

        @Override // com.huawei.ui.commonui.linechart.model.StorageGenericModel.PresentStyle
        public boolean validate() {
            return !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.d) && StorageGenericModel.this.b.containsKey(this.b) && StorageGenericModel.this.b.containsKey(this.d);
        }
    }

    public static class c implements PresentStyle {
        @Override // com.huawei.ui.commonui.linechart.model.StorageGenericModel.PresentStyle
        public boolean validate() {
            return true;
        }

        public c(String str) {
        }
    }
}
