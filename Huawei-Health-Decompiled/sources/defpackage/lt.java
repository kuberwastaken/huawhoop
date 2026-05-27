package defpackage;

import com.alipay.sdk.m.g.i;
import com.alipay.sdk.m.g.j;
import java.lang.reflect.Type;
import java.util.Date;

/* JADX INFO: loaded from: classes9.dex */
public class lt implements i, j {
    @Override // com.alipay.sdk.m.g.i, com.alipay.sdk.m.g.j
    public boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }

    @Override // com.alipay.sdk.m.g.i
    public Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // com.alipay.sdk.m.g.j
    public Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }
}
