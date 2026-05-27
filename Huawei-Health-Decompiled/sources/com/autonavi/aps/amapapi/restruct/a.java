package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.iq;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1605a;
    private File b;
    private Handler e;
    private String f;
    private boolean g;
    private boolean c = false;
    private Map<String, C0030a> d = new ConcurrentHashMap();
    private Runnable h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.c) {
                if (a.this.g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.e != null) {
                    a.this.e.postDelayed(a.this.h, 60000L);
                }
            }
        }
    };

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    abstract void a(T t, long j);

    abstract long b();

    public abstract String b(T t);

    abstract int c(T t);

    abstract long c();

    abstract long d(T t);

    static /* synthetic */ boolean e(a aVar) {
        aVar.g = false;
        return false;
    }

    public a(Context context, String str, Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.f1605a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = com.autonavi.aps.amapapi.utils.k.l(context);
        try {
            this.b = new File(context.getFilesDir().getPath(), this.f1605a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public final void a() {
        Handler handler;
        if (!this.c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, 60000L);
        }
        this.c = true;
    }

    public final void a(boolean z) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.c = false;
    }

    public final void a(T t) {
        b(t, com.autonavi.aps.amapapi.utils.k.b());
    }

    public final void a(List<T> list) {
        long jB = com.autonavi.aps.amapapi.utils.k.b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), jB);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || c() <= 0) {
            this.d.clear();
            for (T t : list) {
                this.d.put(b(t), new C0030a(c(t), d(t), jB));
            }
        }
    }

    private void b(T t, long j) {
        if (t == null || d(t) < 0) {
            return;
        }
        String strB = b(t);
        C0030a c0030a = this.d.get(strB);
        if (c0030a == null) {
            a(t, j);
            this.d.put(strB, new C0030a(c(t), d(t), j));
            this.g = true;
            return;
        }
        c0030a.c = j;
        if (c0030a.f1608a != c(t)) {
            a(t, j);
            c0030a.f1608a = c(t);
            c0030a.b = d(t);
            this.g = true;
            return;
        }
        a(t, c0030a.b);
    }

    private void d() {
        long jB;
        try {
            Iterator<String> it = com.autonavi.aps.amapapi.utils.k.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    String[] strArrSplit = new String(com.autonavi.aps.amapapi.security.a.b(iq.b(it.next()), this.f), "UTF-8").split(",");
                    if (strArrSplit.length >= 4) {
                        jB = Long.parseLong(strArrSplit[3]);
                    } else {
                        jB = com.autonavi.aps.amapapi.utils.k.b();
                    }
                    this.d.put(strArrSplit[0], new C0030a(Integer.parseInt(strArrSplit[1]), Long.parseLong(strArrSplit[2]), jB));
                } catch (Throwable th) {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.d.size();
            if (b() > 0) {
                long jB = com.autonavi.aps.amapapi.utils.k.b();
                Iterator<Map.Entry<String, C0030a>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (jB - this.d.get(it.next().getKey()).c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(String str, String str2) {
                        return a.a(((C0030a) a.this.d.get(str2)).c, ((C0030a) a.this.d.get(str)).c);
                    }
                });
                for (int iC = (int) c(); iC < arrayList.size(); iC++) {
                    this.d.remove(arrayList.get(iC));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C0030a> entry : this.d.entrySet()) {
            try {
                sb.append(iq.b(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue().f1608a + "," + entry.getValue().b + "," + entry.getValue().c).getBytes("UTF-8"), this.f)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.k.a(this.b, string);
    }

    /* JADX INFO: renamed from: com.autonavi.aps.amapapi.restruct.a$a, reason: collision with other inner class name */
    static final class C0030a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1608a;
        long b;
        long c;

        public C0030a(int i, long j, long j2) {
            this.f1608a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public final long e(T t) {
        return (com.autonavi.aps.amapapi.utils.k.b() - d(t)) / 1000;
    }
}
