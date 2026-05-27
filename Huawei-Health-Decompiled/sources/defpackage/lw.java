package defpackage;

import com.alipay.sdk.m.g.i;
import com.alipay.sdk.m.g.j;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes9.dex */
public class lw implements i, j {
    @Override // com.alipay.sdk.m.g.i, com.alipay.sdk.m.g.j
    public boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    @Override // com.alipay.sdk.m.g.i
    public Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // com.alipay.sdk.m.g.j
    public Object a(Object obj) {
        return ((Enum) obj).name();
    }
}
