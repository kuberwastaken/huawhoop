package com.huawei.openalliance.ad;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes6.dex */
public class cx implements cw<com.huawei.openalliance.ad.annotations.h> {
    @Override // com.huawei.openalliance.ad.cw
    public void a(Object obj, Field field, com.huawei.openalliance.ad.annotations.h hVar) throws IllegalAccessException {
        if (hVar.a()) {
            Class clsB = hVar.b();
            if (clsB != Void.class) {
                a(obj, field, hVar, clsB);
            } else {
                b(obj, field, hVar);
            }
        }
    }

    private void b(Object obj, Field field, com.huawei.openalliance.ad.annotations.h hVar) throws IllegalAccessException {
        int[] iArrE = hVar.e();
        if (iArrE.length != 2) {
            hq.c("ValueConstraintProcessor", "%s - field %s the length of range constraint must be 2", obj.getClass().getSimpleName(), field.getName());
            return;
        }
        int i = iArrE[0];
        int i2 = iArrE[1];
        if (i2 < i) {
            i = i2;
            i2 = i;
        }
        Object obj2 = field.get(obj);
        if (obj2 instanceof Number) {
            int iIntValue = ((Number) obj2).intValue();
            if (iIntValue < i || iIntValue > i2) {
                hq.c("ValueConstraintProcessor", "%s - field %s not in constraint range, set default value", obj.getClass().getSimpleName(), field.getName());
                field.set(obj, Integer.valueOf(hVar.f()));
            }
        }
    }

    private void a(Object obj, Field field, com.huawei.openalliance.ad.annotations.h hVar, Class cls) throws IllegalAccessException {
        Object objValueOf;
        Field[] fieldArrA = com.huawei.openalliance.ad.utils.co.a(cls);
        Object obj2 = field.get(obj);
        for (Field field2 : fieldArrA) {
            Object obj3 = field2.get(null);
            if (obj3 != null && (obj3 == obj2 || obj3.equals(obj2))) {
                return;
            }
            if (obj3 == null && obj2 == null) {
                return;
            }
        }
        hq.c("ValueConstraintProcessor", "%s - field %s not in constraint values, set default value", obj.getClass().getSimpleName(), field.getName());
        Class<?> type = field.getType();
        if (String.class == type) {
            objValueOf = hVar.d();
        } else if (Integer.TYPE != type && Integer.class != type) {
            return;
        } else {
            objValueOf = Integer.valueOf(hVar.c());
        }
        field.set(obj, objValueOf);
    }
}
