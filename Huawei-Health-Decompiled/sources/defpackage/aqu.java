package defpackage;

import com.huawei.ads.fund.anno.ValueConstraint;
import com.huawei.ads.fund.c;
import com.huawei.openplatform.abl.log.HiAdLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class aqu implements c<ValueConstraint> {
    @Override // com.huawei.ads.fund.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Object obj, Field field, ValueConstraint valueConstraint) throws IllegalAccessException {
        if (valueConstraint.value()) {
            Class clsConstraintClass = valueConstraint.constraintClass();
            if (clsConstraintClass != Void.class) {
                e(obj, field, valueConstraint, clsConstraintClass);
            } else {
                b(obj, field, valueConstraint);
            }
        }
    }

    private void b(Object obj, Field field, ValueConstraint valueConstraint) throws IllegalAccessException {
        int[] iArrConstraintRange = valueConstraint.constraintRange();
        if (iArrConstraintRange.length != 2) {
            HiAdLog.w("ValueConstraintProcessor", "%s - field %s the length of range constraint must be 2", obj.getClass().getSimpleName(), field.getName());
            return;
        }
        int i = iArrConstraintRange[0];
        int i2 = iArrConstraintRange[1];
        if (i2 < i) {
            i = i2;
            i2 = i;
        }
        Object obj2 = field.get(obj);
        if (obj2 instanceof Number) {
            int iIntValue = ((Number) obj2).intValue();
            if (iIntValue < i || iIntValue > i2) {
                HiAdLog.w("ValueConstraintProcessor", "%s - field %s not in constraint range, set default value", obj.getClass().getSimpleName(), field.getName());
                field.set(obj, Integer.valueOf(valueConstraint.defaultValueForRange()));
            }
        }
    }

    private void e(Object obj, Field field, ValueConstraint valueConstraint, Class cls) throws IllegalAccessException {
        Object objValueOf;
        Field[] fields = cls.getFields();
        Object obj2 = field.get(obj);
        if (fields.length <= 0) {
            HiAdLog.w("ValueConstraintProcessor", "fields of %s is empty, don't check json field value for [%s#%s]", cls, obj.getClass().getSimpleName(), field.getName());
            return;
        }
        for (Field field2 : fields) {
            Object obj3 = field2.get(null);
            if (obj3 != null && (obj3 == obj2 || obj3.equals(obj2))) {
                return;
            }
            if (obj3 == null && obj2 == null) {
                return;
            }
        }
        HiAdLog.w("ValueConstraintProcessor", "%s - field %s not in constraint values, set default value", obj.getClass().getSimpleName(), field.getName());
        Class<?> type = field.getType();
        if (String.class == type) {
            objValueOf = valueConstraint.defaultStringValueForClass();
        } else if (Integer.TYPE != type && Integer.class != type) {
            return;
        } else {
            objValueOf = Integer.valueOf(valueConstraint.defaultIntValueForClass());
        }
        field.set(obj, objValueOf);
    }
}
