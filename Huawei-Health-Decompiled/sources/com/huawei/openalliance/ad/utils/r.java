package com.huawei.openalliance.ad.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.common.Constant;
import com.huawei.openalliance.ad.beans.metadata.BluetoothInfo;
import com.huawei.openalliance.ad.hq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class r {

    public interface a {
        void a(List<BluetoothInfo> list, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(a aVar, List<BluetoothInfo> list) {
        a(aVar, list, bj.a(list) ? 3 : 0);
    }

    private static void a(a aVar, List<BluetoothInfo> list, int i) {
        if (aVar != null) {
            try {
                Collections.sort(list);
            } catch (Throwable th) {
                hq.c("BluetoothUtils", "sort bluetoothInfos exception: %s", th.getClass().getSimpleName());
            }
            aVar.a(list, i);
        }
    }

    public static void a(Context context, final a aVar) {
        final ArrayList arrayList = new ArrayList();
        if (context == null) {
            a(aVar, arrayList, 4);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!cg.a(applicationContext)) {
            hq.b("BluetoothUtils", "missing permissions");
            a(aVar, arrayList, 1);
            return;
        }
        final HashMap map = new HashMap();
        try {
            final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bj.a(bondedDevices)) {
                    a(aVar, arrayList, 3);
                    return;
                }
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    if (bluetoothDevice != null) {
                        BluetoothInfo bluetoothInfo = new BluetoothInfo();
                        bluetoothInfo.a(bluetoothDevice.getName());
                        bluetoothInfo.b(bluetoothDevice.getAddress());
                        arrayList.add(bluetoothInfo);
                        map.put(bluetoothInfo.a(), bluetoothInfo);
                    }
                }
                int iA = a(defaultAdapter);
                hq.b("BluetoothUtils", "BluetoothProfile: %s", Integer.valueOf(iA));
                if (iA == -1) {
                    b(aVar, arrayList);
                    return;
                } else {
                    defaultAdapter.getProfileProxy(applicationContext, new BluetoothProfile.ServiceListener() { // from class: com.huawei.openalliance.ad.utils.r.1
                        @Override // android.bluetooth.BluetoothProfile.ServiceListener
                        public void onServiceDisconnected(int i) {
                            hq.b("BluetoothUtils", "onServiceDisconnected");
                            r.b(aVar, arrayList);
                        }

                        @Override // android.bluetooth.BluetoothProfile.ServiceListener
                        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                            BluetoothInfo bluetoothInfo2;
                            try {
                                hq.b("BluetoothUtils", Constant.SERVICE_CONNECT_MESSAGE);
                                List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                                if (!bj.a(connectedDevices)) {
                                    for (BluetoothDevice bluetoothDevice2 : connectedDevices) {
                                        if (bluetoothDevice2 != null) {
                                            String address = bluetoothDevice2.getAddress();
                                            if (!TextUtils.isEmpty(address) && (bluetoothInfo2 = (BluetoothInfo) map.get(address)) != null) {
                                                bluetoothInfo2.a((Integer) 1);
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                hq.c("BluetoothUtils", "onServiceConnected exception: %s", th.getClass().getSimpleName());
                            }
                            defaultAdapter.closeProfileProxy(i, bluetoothProfile);
                            r.b(aVar, arrayList);
                        }
                    }, iA);
                    return;
                }
            }
            hq.b("BluetoothUtils", "bluetooth service is unavailable");
            a(aVar, arrayList, 2);
        } catch (Throwable th) {
            hq.c("BluetoothUtils", "getBondedBluetoothDevices exception: %s", th.getClass().getSimpleName());
            a(aVar, arrayList, 5);
        }
    }

    private static int a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter.getProfileConnectionState(2) == 2) {
            return 2;
        }
        return bluetoothAdapter.getProfileConnectionState(1) == 2 ? 1 : -1;
    }
}
