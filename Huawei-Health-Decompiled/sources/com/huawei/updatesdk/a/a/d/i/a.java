package com.huawei.updatesdk.a.a.d.i;

import android.car.Car;
import android.car.CarInfoManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.operation.utils.CloudParamKeys;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Car f11311a = null;
    private static String b = null;
    private static String c = null;
    private static boolean d = false;

    public static String e() {
        return b;
    }

    public static String d() {
        return c;
    }

    public static void b(Context context) {
        a(context);
    }

    /* JADX INFO: renamed from: com.huawei.updatesdk.a.a.d.i.a$a, reason: collision with other inner class name */
    static final class ServiceConnectionC0292a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.huawei.updatesdk.a.a.a.b("CarInfoUtil", "onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                CarInfoManager carInfoManager = (CarInfoManager) a.f11311a.getCarManager(CloudParamKeys.INFO);
                String unused = a.c = carInfoManager.getManufacturer();
                String unused2 = a.b = carInfoManager.getModel();
                com.huawei.updatesdk.a.a.a.b("CarInfoUtil", "car getManufacturer = " + a.c + "  getModel = " + a.b);
            } catch (Throwable th) {
                com.huawei.updatesdk.a.a.a.a("CarInfoUtil", "Car not connected in onServiceConnected" + th.getMessage());
            }
        }

        ServiceConnectionC0292a() {
        }
    }

    private static void a(Context context) {
        if (context == null || d) {
            return;
        }
        try {
            d = true;
            Car carCreateCar = Car.createCar(context.getApplicationContext(), new ServiceConnectionC0292a());
            f11311a = carCreateCar;
            if (carCreateCar != null) {
                carCreateCar.connect();
            }
        } catch (Throwable th) {
            com.huawei.updatesdk.a.a.a.a("CarInfoUtil", "Car Service Connect Error" + th.getMessage());
        }
    }
}
