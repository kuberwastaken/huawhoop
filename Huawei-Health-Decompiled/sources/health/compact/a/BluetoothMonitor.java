package health.compact.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.BadParcelableException;
import com.huawei.featureuserprofile.route.hwgpxmodel.Wpt;
import com.huawei.haf.application.BaseApplication;
import com.huawei.health.device.api.EcologyDeviceApi;
import com.huawei.health.manager.BluetoothMonitor$BluetoothDeviceInfo;
import com.huawei.health.manager.hdp.BloodPressureController;
import com.huawei.health.manager.reconnect.ReconnectManager;
import com.huawei.hwlogsmodel.LogUtil;
import defpackage.dbs;
import health.compact.a.LogAnonymous;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothMonitor {
    private static BluetoothMonitor b;
    private volatile BloodPressureController d;
    private final Object e = new Object();
    private HashMap<String, BluetoothMonitor$BluetoothDeviceInfo> c = new HashMap<>();
    private List<BluetoothMonitor$BluetoothDeviceInfo> f = new ArrayList();
    private String i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothGattCallback f13731a = new BluetoothGattCallback() { // from class: com.huawei.health.manager.BluetoothMonitor$1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (bluetoothGatt == null) {
                LogUtil.b("BluetoothMonitor", "onConnectionStateChange ", "bluetoothGatt is null");
                return;
            }
            String address = bluetoothGatt.getDevice().getAddress();
            LogUtil.e("BluetoothMonitor", "ConnectionStateChange: status =", Integer.valueOf(i), ", newState = ", Integer.valueOf(i2));
            if (i == 0) {
                synchronized (this.c.e) {
                    this.c.amF_(bluetoothGatt, i2, address);
                }
            }
        }
    };
    private BroadcastReceiver g = new BroadcastReceiver() { // from class: com.huawei.health.manager.BluetoothMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            LogUtil.b("BluetoothMonitor", "Received action: ", action);
            if (action == null) {
                return;
            }
            action.hashCode();
            if (action.equals("com.huawei.health.action.DEVICE_CHANGED")) {
                try {
                    int intExtra = intent.getIntExtra("operation", 0);
                    String stringExtra = intent.getStringExtra("productId");
                    String stringExtra2 = intent.getStringExtra("uniqueId");
                    if (intExtra == 1) {
                        this.c.d(stringExtra, stringExtra2, intent.getIntExtra(Wpt.MODE, 0), intent.getStringExtra("kind"), intent.getStringExtra("name"));
                    } else if (intExtra == -1) {
                        this.c.a(stringExtra, stringExtra2);
                    } else {
                        LogUtil.b("BluetoothMonitor", "unexpected operation");
                    }
                    return;
                } catch (BadParcelableException e) {
                    LogUtil.a("BluetoothMonitor", "BadParcelableException: ", LogAnonymous.b(e));
                    return;
                }
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                if (intExtra2 == 12) {
                    this.c.a();
                    ReconnectManager.d().b();
                } else if (intExtra2 == 10) {
                    this.c.e();
                    ReconnectManager.d().e();
                } else {
                    LogUtil.b("BluetoothMonitor", "wrong action state");
                }
            }
        }
    };

    private BluetoothMonitor() {
        b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("com.huawei.health.action.DEVICE_CHANGED");
        BroadcastManagerUtil.bLA_(BaseApplication.a(), this.g, intentFilter, LocalBroadcast.d, null);
    }

    public static BluetoothMonitor d() {
        BluetoothMonitor bluetoothMonitor;
        synchronized (BluetoothMonitor.class) {
            if (b == null) {
                b = new BluetoothMonitor();
            }
            bluetoothMonitor = b;
        }
        return bluetoothMonitor;
    }

    public boolean a() {
        BluetoothAdapter defaultAdapter;
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "isStartMonitor");
        try {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        } catch (NullPointerException unused) {
            com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "IBluetooth.getState() nullPointerException");
            return false;
        } catch (NoSuchElementException e) {
            com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "isStartMonitor fail ", e.getMessage());
        }
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            synchronized (this.e) {
                com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "", Integer.valueOf(this.c.size()), " device(s) to be monitored");
                for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.c.values()) {
                    if (bluetoothMonitor$BluetoothDeviceInfo != null && bluetoothMonitor$BluetoothDeviceInfo.h == null) {
                        amE_(defaultAdapter, bluetoothMonitor$BluetoothDeviceInfo);
                    }
                }
            }
            return true;
        }
        com.huawei.hwlogsmodel.LogUtil.j("BluetoothMonitor", "bluetoothAdapter is null or is not enable");
        return false;
    }

    public boolean e(String str) {
        if (str != null) {
            com.huawei.hwlogsmodel.LogUtil.e("BluetoothMonitor", "isStartMonitorByDeviceInfo device info = ", str);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (!defaultAdapter.isEnabled()) {
                return false;
            }
            synchronized (this.e) {
                com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "", Integer.valueOf(this.c.size()), " device(s) to be monitored");
                for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.c.values()) {
                    if (bluetoothMonitor$BluetoothDeviceInfo != null && bluetoothMonitor$BluetoothDeviceInfo.h == null && (str.equals(bluetoothMonitor$BluetoothDeviceInfo.e) || str.equals(bluetoothMonitor$BluetoothDeviceInfo.c))) {
                        amE_(defaultAdapter, bluetoothMonitor$BluetoothDeviceInfo);
                    }
                }
            }
            return true;
        }
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "isStartMonitorByDeviceInfo device info = null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amF_(BluetoothGatt bluetoothGatt, int i, String str) {
        Context contextA = BaseApplication.a();
        if (i == 2) {
            for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.c.values()) {
                if (bluetoothMonitor$BluetoothDeviceInfo.e.equals(str)) {
                    Intent intent = new Intent("com.huawei.health.action.DEVICE_CONNECTED");
                    intent.setPackage(contextA.getPackageName());
                    intent.putExtra("productId", bluetoothMonitor$BluetoothDeviceInfo.f2823a);
                    intent.putExtra("uniqueId", bluetoothMonitor$BluetoothDeviceInfo.e);
                    intent.putExtra("kind", bluetoothMonitor$BluetoothDeviceInfo.b);
                    com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "sendBroadcast for ", bluetoothMonitor$BluetoothDeviceInfo.f2823a, ", kind = ", bluetoothMonitor$BluetoothDeviceInfo.b);
                    contextA.sendBroadcast(intent, LocalBroadcast.d);
                    return;
                }
            }
            return;
        }
        if (i == 0) {
            String str2 = this.i;
            if (str2 != null && !this.c.containsKey(str2)) {
                this.i = null;
                try {
                    bluetoothGatt.close();
                } catch (SecurityException unused) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.c("BluetoothMonitor", "handleBluetoothState SecurityException");
                }
            }
            for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo2 : this.c.values()) {
                if (bluetoothMonitor$BluetoothDeviceInfo2.e.equals(str) && bluetoothMonitor$BluetoothDeviceInfo2.c.equals("AH100")) {
                    Intent intent2 = new Intent("com.huawei.health.action.DEVICE_DISCONNECTED");
                    intent2.setPackage(contextA.getPackageName());
                    intent2.putExtra("productId", bluetoothMonitor$BluetoothDeviceInfo2.f2823a);
                    intent2.putExtra("uniqueId", bluetoothMonitor$BluetoothDeviceInfo2.e);
                    intent2.putExtra("kind", bluetoothMonitor$BluetoothDeviceInfo2.b);
                    com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "sendBroadcast for ", bluetoothMonitor$BluetoothDeviceInfo2.f2823a, ", kind = ", bluetoothMonitor$BluetoothDeviceInfo2.b);
                    contextA.sendBroadcast(intent2, LocalBroadcast.d);
                    return;
                }
            }
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "onConnectionStateChange ", "invalid status");
    }

    private void amE_(BluetoothAdapter bluetoothAdapter, BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo) {
        try {
            if (bluetoothMonitor$BluetoothDeviceInfo.d == 1) {
                if (!BluetoothAdapter.checkBluetoothAddress(bluetoothMonitor$BluetoothDeviceInfo.e)) {
                    com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "connectDevice invalid Bluetooth address");
                } else {
                    BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(bluetoothMonitor$BluetoothDeviceInfo.e);
                    if (remoteDevice != null) {
                        com.huawei.hwlogsmodel.LogUtil.e("BluetoothMonitor", "connGatt to #### for ####", bluetoothMonitor$BluetoothDeviceInfo.f2823a);
                        bluetoothMonitor$BluetoothDeviceInfo.h = remoteDevice.connectGatt(BaseApplication.a(), true, this.f13731a);
                    }
                }
            } else if (bluetoothMonitor$BluetoothDeviceInfo.d == 2) {
                com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "isStartMonitor for classic bluetooth");
                if (BluetoothAdapter.checkBluetoothAddress(bluetoothMonitor$BluetoothDeviceInfo.e)) {
                    amH_(bluetoothAdapter.getRemoteDevice(bluetoothMonitor$BluetoothDeviceInfo.e), bluetoothMonitor$BluetoothDeviceInfo.f2823a, bluetoothMonitor$BluetoothDeviceInfo.e, bluetoothMonitor$BluetoothDeviceInfo.b);
                } else {
                    com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "connectDevice invalid Bluetooth address");
                }
            } else {
                com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "connectDevice ", "wrong connectMode");
            }
        } catch (IllegalArgumentException unused) {
            com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "connectDevice illegalArgumentException");
        } catch (IllegalStateException unused2) {
            com.huawei.hwlogsmodel.LogUtil.a("BluetoothMonitor", "connectDevice illegalStateException");
        } catch (SecurityException e) {
            health.compact.a.hwlogsmodel.ReleaseLogUtil.c("BluetoothMonitor", "connectDevice SecurityException", LogAnonymous.b(e));
        }
    }

    private void amH_(BluetoothDevice bluetoothDevice, String str, String str2, String str3) {
        BloodPressureController bloodPressureController = this.d;
        if (bloodPressureController == null) {
            bloodPressureController = new BloodPressureController(BaseApplication.a());
            this.d = bloodPressureController;
        }
        bloodPressureController.anC_(bluetoothDevice, str, str2, str3);
        bloodPressureController.d();
    }

    private void h() {
        BloodPressureController bloodPressureController = this.d;
        this.d = null;
        if (bloodPressureController != null) {
            bloodPressureController.a();
        }
    }

    public void b(String str) {
        if (str != null) {
            com.huawei.hwlogsmodel.LogUtil.e("BluetoothMonitor", "stopMonitorByDeviceInfo deviceInfo = ", str);
            synchronized (this.e) {
                for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.c.values()) {
                    if (bluetoothMonitor$BluetoothDeviceInfo != null && bluetoothMonitor$BluetoothDeviceInfo.h != null && (str.equals(bluetoothMonitor$BluetoothDeviceInfo.c) || str.equals(bluetoothMonitor$BluetoothDeviceInfo.e))) {
                        c(bluetoothMonitor$BluetoothDeviceInfo);
                    }
                }
            }
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "stopMonitorByDeviceInfo deviceInfo = n");
    }

    public void e() {
        synchronized (this.e) {
            for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.c.values()) {
                if (bluetoothMonitor$BluetoothDeviceInfo != null && bluetoothMonitor$BluetoothDeviceInfo.h != null) {
                    c(bluetoothMonitor$BluetoothDeviceInfo);
                }
            }
        }
    }

    private void c(BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo) {
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "disconnectDevice enter");
        if (bluetoothMonitor$BluetoothDeviceInfo.d == 1) {
            BluetoothGatt bluetoothGatt = (BluetoothGatt) bluetoothMonitor$BluetoothDeviceInfo.h;
            if (bluetoothGatt != null) {
                com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "BluetoothGatt disconnect and close");
                try {
                    bluetoothGatt.disconnect();
                } catch (SecurityException unused) {
                    health.compact.a.hwlogsmodel.ReleaseLogUtil.c("BluetoothMonitor", "disconnectDevice SecurityException");
                }
            }
            bluetoothMonitor$BluetoothDeviceInfo.h = null;
            return;
        }
        if (bluetoothMonitor$BluetoothDeviceInfo.d == 2) {
            com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "stopMonitor for classic bluetooth");
            h();
        } else {
            com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "disconnectDevice ", "wrong connect mode");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0077 A[Catch: all -> 0x0089, PHI: r3 r4
      0x0077: PHI (r3v5 android.database.Cursor) = (r3v3 android.database.Cursor), (r3v4 android.database.Cursor), (r3v9 android.database.Cursor) binds: [B:24:0x0075, B:18:0x0060, B:10:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x0077: PHI (r4v7 android.database.sqlite.SQLiteDatabase) = 
      (r4v5 android.database.sqlite.SQLiteDatabase)
      (r4v6 android.database.sqlite.SQLiteDatabase)
      (r4v10 android.database.sqlite.SQLiteDatabase)
     binds: [B:24:0x0075, B:18:0x0060, B:10:0x0048] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x0089, blocks: (B:9:0x0045, B:26:0x007a, B:27:0x0080, B:25:0x0077, B:17:0x005d, B:23:0x0072, B:31:0x0085, B:35:0x008d, B:36:0x0090), top: B:43:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0085 A[Catch: all -> 0x0089, TryCatch #3 {all -> 0x0089, blocks: (B:9:0x0045, B:26:0x007a, B:27:0x0080, B:25:0x0077, B:17:0x005d, B:23:0x0072, B:31:0x0085, B:35:0x008d, B:36:0x0090), top: B:43:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d A[Catch: all -> 0x0089, TryCatch #3 {all -> 0x0089, blocks: (B:9:0x0045, B:26:0x007a, B:27:0x0080, B:25:0x0077, B:17:0x005d, B:23:0x0072, B:31:0x0085, B:35:0x008d, B:36:0x0090), top: B:43:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b() {
        /*
            r15 = this;
            java.lang.Object r0 = r15.e
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            r3 = 0
            android.content.Context r4 = com.huawei.haf.application.BaseApplication.a()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4e java.lang.NumberFormatException -> L63
            java.lang.String r5 = "device.db"
            android.database.sqlite.SQLiteDatabase r4 = r4.openOrCreateDatabase(r5, r2, r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4e java.lang.NumberFormatException -> L63
            r5 = 5
            java.lang.String[] r8 = new java.lang.String[r5]     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r5 = "productId"
            r8[r2] = r5     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r5 = "uniqueId"
            r8[r1] = r5     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r5 = "mode"
            r6 = 2
            r8[r6] = r5     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r5 = "kind"
            r6 = 3
            r8[r6] = r5     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r5 = "name"
            r6 = 4
            r8[r6] = r5     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            java.lang.String r7 = "device"
            java.lang.String r9 = "auto=1"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r6 = r4
            android.database.Cursor r3 = r6.query(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            r15.amG_(r3)     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            r3.close()     // Catch: android.database.sqlite.SQLiteException -> L4f java.lang.NumberFormatException -> L64 java.lang.Throwable -> L82
            if (r3 == 0) goto L48
            r3.close()     // Catch: java.lang.Throwable -> L89
        L48:
            if (r4 == 0) goto L7a
            goto L77
        L4b:
            r1 = move-exception
            r4 = r3
            goto L83
        L4e:
            r4 = r3
        L4f:
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = "loadDeviceList SQLiteException"
            r1[r2] = r5     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "BluetoothMonitor"
            com.huawei.hwlogsmodel.LogUtil.j(r2, r1)     // Catch: java.lang.Throwable -> L82
            if (r3 == 0) goto L60
            r3.close()     // Catch: java.lang.Throwable -> L89
        L60:
            if (r4 == 0) goto L7a
            goto L77
        L63:
            r4 = r3
        L64:
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = "loadDeviceList NumberFormatException"
            r1[r2] = r5     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "BluetoothMonitor"
            com.huawei.hwlogsmodel.LogUtil.j(r2, r1)     // Catch: java.lang.Throwable -> L82
            if (r3 == 0) goto L75
            r3.close()     // Catch: java.lang.Throwable -> L89
        L75:
            if (r4 == 0) goto L7a
        L77:
            r4.close()     // Catch: java.lang.Throwable -> L89
        L7a:
            java.util.HashMap<java.lang.String, com.huawei.health.manager.BluetoothMonitor$BluetoothDeviceInfo> r1 = r15.c     // Catch: java.lang.Throwable -> L89
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L89
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            return r1
        L82:
            r1 = move-exception
        L83:
            if (r3 == 0) goto L8b
            r3.close()     // Catch: java.lang.Throwable -> L89
            goto L8b
        L89:
            r1 = move-exception
            goto L91
        L8b:
            if (r4 == 0) goto L90
            r4.close()     // Catch: java.lang.Throwable -> L89
        L90:
            throw r1     // Catch: java.lang.Throwable -> L89
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: health.compact.a.BluetoothMonitor.b():int");
    }

    private void amG_(Cursor cursor) {
        int iB = 0;
        int iB2 = 0;
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            String prodId = ((EcologyDeviceApi) Services.c("EcologyDevice", EcologyDeviceApi.class)).getProdId(string);
            int iE = SharedPreferenceManager.e(String.valueOf(10000), cursor.getString(1), 2);
            if (c(prodId, iE, iB, iB2) && !this.c.containsKey(cursor.getString(1))) {
                iB = b(iB, prodId, iE);
                iB2 = b(iB2, prodId, iE);
                BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo = new BluetoothMonitor$BluetoothDeviceInfo();
                bluetoothMonitor$BluetoothDeviceInfo.f2823a = string;
                bluetoothMonitor$BluetoothDeviceInfo.e = cursor.getString(1);
                bluetoothMonitor$BluetoothDeviceInfo.d = Integer.parseInt(cursor.getString(2), 10);
                bluetoothMonitor$BluetoothDeviceInfo.b = cursor.getString(3);
                bluetoothMonitor$BluetoothDeviceInfo.c = cursor.getString(4);
                com.huawei.hwlogsmodel.LogUtil.e("BluetoothMonitor", "loadDeviceList() mdi.name = ", bluetoothMonitor$BluetoothDeviceInfo.c);
                bluetoothMonitor$BluetoothDeviceInfo.h = null;
                this.c.put(bluetoothMonitor$BluetoothDeviceInfo.e, bluetoothMonitor$BluetoothDeviceInfo);
                this.f.add(bluetoothMonitor$BluetoothDeviceInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null || str4 == null) {
            return;
        }
        com.huawei.hwlogsmodel.LogUtil.e("BluetoothMonitor", "Device for ", str, " was added mode = ", Integer.valueOf(i), ",name = ", str4);
        synchronized (this.e) {
            if (!this.c.containsKey(str2)) {
                e(str, ((EcologyDeviceApi) Services.c("EcologyDevice", EcologyDeviceApi.class)).getProdId(str));
                BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo = new BluetoothMonitor$BluetoothDeviceInfo();
                bluetoothMonitor$BluetoothDeviceInfo.f2823a = str;
                bluetoothMonitor$BluetoothDeviceInfo.e = str2;
                bluetoothMonitor$BluetoothDeviceInfo.d = i;
                bluetoothMonitor$BluetoothDeviceInfo.b = str3;
                bluetoothMonitor$BluetoothDeviceInfo.c = str4;
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter.isEnabled()) {
                    amE_(defaultAdapter, bluetoothMonitor$BluetoothDeviceInfo);
                }
                this.c.put(str2, bluetoothMonitor$BluetoothDeviceInfo);
                this.f.add(bluetoothMonitor$BluetoothDeviceInfo);
            }
        }
    }

    private void e(String str, String str2) {
        if (this.c.size() < 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!dbs.ad.contains(str2)) {
            com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "Not second-generation jump rope.");
            return;
        }
        for (BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfo : this.f) {
            if (bluetoothMonitor$BluetoothDeviceInfo.f2823a.equals(str)) {
                arrayList.add(bluetoothMonitor$BluetoothDeviceInfo.e);
            }
        }
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "device size is ", Integer.valueOf(arrayList.size()));
        if (arrayList.size() < 2) {
            return;
        }
        String str3 = (String) arrayList.get(0);
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "remove device ", CommonUtil.l(str3));
        a(str, str3);
    }

    private boolean c(String str, int i, int i2, int i3) {
        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "isNeedAddSecondRopeMonitorProfile connectMode = ", Integer.valueOf(i));
        if (dbs.ad.contains(str) && i == 2) {
            return false;
        }
        return "2G97".equals(str) ? i2 < 2 : !"2G98".equals(str) || i3 < 2;
    }

    private int b(int i, String str, int i2) {
        return (!dbs.ad.contains(str) || i2 == 2) ? i : i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (str2 != null) {
            com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "Device for ", str, " was removed");
            synchronized (this.e) {
                this.i = str2;
                BluetoothMonitor$BluetoothDeviceInfo bluetoothMonitor$BluetoothDeviceInfoRemove = this.c.remove(str2);
                this.f.remove(bluetoothMonitor$BluetoothDeviceInfoRemove);
                if (bluetoothMonitor$BluetoothDeviceInfoRemove == null || bluetoothMonitor$BluetoothDeviceInfoRemove.d != 1) {
                    if (bluetoothMonitor$BluetoothDeviceInfoRemove != null && bluetoothMonitor$BluetoothDeviceInfoRemove.d == 2) {
                        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "removeDevice");
                        h();
                    } else {
                        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "removeDevice ", "wrong connectMode");
                    }
                } else {
                    BluetoothProfile bluetoothProfile = bluetoothMonitor$BluetoothDeviceInfoRemove.h;
                    if (!(bluetoothProfile instanceof BluetoothGatt)) {
                        com.huawei.hwlogsmodel.LogUtil.b("BluetoothMonitor", "removeDevice ", "wrong object type");
                    } else {
                        try {
                            ((BluetoothGatt) bluetoothProfile).disconnect();
                        } catch (SecurityException unused) {
                            health.compact.a.hwlogsmodel.ReleaseLogUtil.c("BluetoothMonitor", "removeDevice SecurityException");
                        }
                        SharedPreferenceManager.c(String.valueOf(10000), str2);
                    }
                }
            }
        }
    }

    public void c() {
        BaseApplication.a().unregisterReceiver(this.g);
    }
}
