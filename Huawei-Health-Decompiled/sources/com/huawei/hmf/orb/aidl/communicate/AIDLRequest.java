package com.huawei.hmf.orb.aidl.communicate;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AIDLRequest<R extends IMessageEntity> {
    private static final String TAG = "AIDLRequest";
    public ClientIdentity clientIdentity;
    public AIDLResponse response;

    protected int checkPermission(R r) {
        return 0;
    }

    protected abstract void onRequest(R r);

    public final void execute(R r) {
        ClientIdentity clientIdentity = this.clientIdentity;
        if (clientIdentity == null || !clientIdentity.isValid()) {
            this.response.failure(207135000);
            return;
        }
        int iCheckPermission = !this.clientIdentity.isCore() ? checkPermission(r) : 0;
        if (iCheckPermission <= 0) {
            onRequest(r);
        } else {
            this.response.failure(iCheckPermission);
        }
    }

    public R makeParam() {
        try {
            return getParamType().newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    private Class<R> getParamType() {
        Class<?> superclass = getClass();
        Type genericSuperclass = superclass.getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            superclass = superclass.getSuperclass();
            genericSuperclass = superclass.getGenericSuperclass();
        }
        return (Class<R>) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }
}
