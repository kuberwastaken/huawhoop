package com.huawei.watchface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ez {
    ey[] a() default {};

    ey[] b() default {};

    ey[] c() default {};

    String[] d() default {"userToken", "usertoken", "reservedInfor", "licenseReq", "authCode", "deviceId", "userRefreshToken", "sign", "x-sign", "deviceid", "phoneId", "publicKey", "x-usertoken"};

    String[] e() default {"userToken", "reservedInfor", "licenseReq", "authCode", "deviceId", "userRefreshToken", "sign", "phoneId", "publicKey", "watchDeviceInfo-deviceId"};

    boolean f() default false;

    String[] g() default {"resultCode", "resultcode", "retCode"};

    String[] h() default {"resultInfo", "resultinfo", "retDesc"};
}
