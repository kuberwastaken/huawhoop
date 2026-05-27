package defpackage;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes8.dex */
public class wyt {
    public static Type c(Class<? extends KfsConstraintValidator<?, ?>> cls) {
        return ((ParameterizedType) cls.getGenericInterfaces()[0]).getActualTypeArguments()[1];
    }
}
