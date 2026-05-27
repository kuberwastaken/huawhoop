package com.huawei.agconnect.core.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceRegistrarParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1804a;

    public List<Service> c() {
        Log.i("AGC_Registrar", "getServices");
        List<String> listB = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            ServiceRegistrar serviceRegistrarA = a(it.next());
            if (serviceRegistrarA != null) {
                serviceRegistrarA.initialize(this.f1804a);
                List<Service> services = serviceRegistrarA.getServices(this.f1804a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }

    static class ValueComparator implements Comparator<Map.Entry<String, Integer>>, Serializable {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }

        private ValueComparator() {
        }
    }

    private List<String> b() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle bundleA = a();
        if (bundleA == null) {
            return arrayList;
        }
        HashMap map = new HashMap(10);
        for (String message : bundleA.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleA.getString(message))) {
                String[] strArrSplit = message.split(":");
                if (strArrSplit.length == 2) {
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder("registrar configuration format error:");
                        message = e.getMessage();
                        sb.append(message);
                        Log.e("AGC_Registrar", sb.toString());
                    }
                } else if (strArrSplit.length == 1) {
                    map.put(strArrSplit[0], 1000);
                } else {
                    sb = new StringBuilder("registrar configuration error, ");
                    sb.append(message);
                    Log.e("AGC_Registrar", sb.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(map.entrySet());
        Collections.sort(arrayList2, new ValueComparator());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb;
        String localizedMessage;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            sb = new StringBuilder("Can not found service class, ");
            localizedMessage = e.getMessage();
            sb.append(localizedMessage);
            Log.e("AGC_Registrar", sb.toString());
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e.getLocalizedMessage();
            sb.append(localizedMessage);
            Log.e("AGC_Registrar", sb.toString());
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e.getLocalizedMessage();
            sb.append(localizedMessage);
            Log.e("AGC_Registrar", sb.toString());
            return null;
        }
    }

    private Bundle a() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f1804a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f1804a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
        if (serviceInfo != null) {
            return serviceInfo.metaData;
        }
        Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
        return null;
    }

    ServiceRegistrarParser(Context context) {
        this.f1804a = context;
    }
}
