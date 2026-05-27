package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class nnd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static nnd f16047a;
    private static final Object e = new Object();
    private final Context b;
    private final Handler d;
    private final HashMap<BroadcastReceiver, ArrayList<d>> h = new HashMap<>();
    private final ArrayList<e> j = new ArrayList<>();
    private final HashMap<String, ArrayList<d>> c = new HashMap<>();

    static final class d {
        private final IntentFilter b;
        private boolean c;
        private boolean d;
        private final BroadcastReceiver e;

        d(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.b = intentFilter;
            this.e = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.e);
            sb.append(" filter=");
            sb.append(this.b);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f16049a;
        private final ArrayList<d> d;

        e(Intent intent, ArrayList<d> arrayList) {
            this.f16049a = intent;
            this.d = arrayList;
        }
    }

    public static nnd b(Context context) {
        nnd nndVar;
        synchronized (e) {
            if (f16047a == null && context != null) {
                f16047a = new nnd(context.getApplicationContext());
            }
            nndVar = f16047a;
        }
        return nndVar;
    }

    private nnd(Context context) {
        this.b = context;
        this.d = new Handler(context.getMainLooper()) { // from class: nnd.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    nnd.this.b();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public void cmj_(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.h) {
            d dVar = new d(intentFilter, broadcastReceiver);
            ArrayList<d> arrayList = this.h.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.h.put(broadcastReceiver, arrayList);
            }
            arrayList.add(dVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<d> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(dVar);
            }
        }
    }

    public void cml_(BroadcastReceiver broadcastReceiver) {
        synchronized (this.h) {
            ArrayList<d> arrayListRemove = this.h.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                d dVar = arrayListRemove.get(size);
                dVar.d = true;
                for (int i = 0; i < dVar.b.countActions(); i++) {
                    String action = dVar.b.getAction(i);
                    ArrayList<d> arrayList = this.c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            d dVar2 = arrayList.get(size2);
                            if (dVar2.e == broadcastReceiver) {
                                dVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public boolean cmk_(Intent intent) {
        boolean z;
        String str;
        String str2;
        int i;
        ArrayList arrayList;
        Uri uri;
        boolean z2;
        synchronized (this.h) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.b.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList<d> arrayList2 = this.c.get(intent.getAction());
            boolean z3 = false;
            if (arrayList2 != null) {
                ArrayList arrayList3 = null;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    d dVar = arrayList2.get(i2);
                    if (dVar.c) {
                        i = i2;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList3;
                        z2 = z3;
                    } else {
                        str = action;
                        String str3 = strResolveTypeIfNeeded;
                        str2 = strResolveTypeIfNeeded;
                        i = i2;
                        Uri uri2 = data;
                        arrayList = arrayList3;
                        uri = data;
                        z2 = z3;
                        if (dVar.b.match(action, str3, scheme, uri2, categories, "ThemeLocalBroadcastManager") >= 0) {
                            arrayList3 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList3.add(dVar);
                            dVar.c = true;
                            i2 = i + 1;
                            z3 = z2;
                            action = str;
                            strResolveTypeIfNeeded = str2;
                            data = uri;
                        } else {
                            nni.b("ThemeLocalBroadcastManager", "match is lower than 0");
                        }
                    }
                    arrayList3 = arrayList;
                    i2 = i + 1;
                    z3 = z2;
                    action = str;
                    strResolveTypeIfNeeded = str2;
                    data = uri;
                }
                ?? r11 = arrayList3;
                z = z3;
                if (r11 != 0) {
                    for (?? r9 = z; r9 < r11.size(); r9++) {
                        ((d) r11.get(r9)).c = z;
                    }
                    this.j.add(new e(intent, r11));
                    if (!this.d.hasMessages(1)) {
                        this.d.sendEmptyMessage(1);
                    }
                    return true;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int size;
        e[] eVarArr;
        while (true) {
            synchronized (this.h) {
                size = this.j.size();
                if (size < 0 || size == 0) {
                    break;
                }
                eVarArr = new e[size];
                this.j.toArray(eVarArr);
                this.j.clear();
            }
            for (int i = 0; i < size; i++) {
                e eVar = eVarArr[i];
                int size2 = eVar.d.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    d dVar = (d) eVar.d.get(i2);
                    if (!dVar.d) {
                        dVar.e.onReceive(this.b, eVar.f16049a);
                    }
                }
            }
        }
    }
}
