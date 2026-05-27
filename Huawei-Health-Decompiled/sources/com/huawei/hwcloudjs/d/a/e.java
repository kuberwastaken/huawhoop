package com.huawei.hwcloudjs.d.a;

import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f6405a;

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        if (f6405a.contains(objectStreamClass.getName())) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException(objectStreamClass.getName() + " not find");
    }

    public e(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public e() throws SecurityException, IOException {
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6405a = arrayList;
        arrayList.add(AuthBean.class.getName());
    }
}
