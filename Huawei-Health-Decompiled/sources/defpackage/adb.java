package defpackage;

import com.huawei.operation.utils.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes9.dex */
public final class adb {
    static final Class<?>[] c = new Class[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Class<?>[] f175a;
    final String d;

    public adb(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public adb(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public adb(String str, Class<?>[] clsArr) {
        this.d = str;
        this.f175a = clsArr == null ? c : clsArr;
    }

    public String b() {
        return this.d;
    }

    public int d() {
        return this.f175a.length;
    }

    public String toString() {
        return this.d + Constants.LEFT_BRACKET_ONLY + this.f175a.length + "-args)";
    }

    public int hashCode() {
        return this.d.hashCode() + this.f175a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        adb adbVar = (adb) obj;
        if (!this.d.equals(adbVar.d)) {
            return false;
        }
        Class<?>[] clsArr = adbVar.f175a;
        int length = this.f175a.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this.f175a[i]) {
                return false;
            }
        }
        return true;
    }
}
