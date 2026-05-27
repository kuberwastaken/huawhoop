package com.huawei.hianalytics.visual;

import android.content.SharedPreferences;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public class c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<SharedPreferences> f4054a;
    public final String b;
    public final a<T> c;
    public T d;

    public interface a<T> {
        T a();

        T a(String str);

        String a(T t);
    }

    public c0(Future<SharedPreferences> future, String str, a<T> aVar) {
        this.f4054a = future;
        this.b = str;
        this.c = aVar;
    }

    public T a() {
        T t = this.d;
        if (t != null) {
            return t;
        }
        synchronized (this.f4054a) {
            String string = null;
            try {
                SharedPreferences sharedPreferences = this.f4054a.get();
                if (sharedPreferences != null) {
                    string = sharedPreferences.getString(this.b, null);
                }
            } catch (Exception unused) {
                HiLog.w("PreferencesHolder", "fail to get sp file");
            }
            if (string != null) {
                return this.c.a(string);
            }
            T tA = this.c.a();
            this.d = tA;
            a(tA);
            return this.d;
        }
    }

    public void a(T t) {
        SharedPreferences sharedPreferences;
        if (b.a().b()) {
            return;
        }
        this.d = t;
        synchronized (this.f4054a) {
            try {
                sharedPreferences = this.f4054a.get();
            } catch (Exception unused) {
                HiLog.w("PreferencesHolder", "fail to get sp file");
                sharedPreferences = null;
            }
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (this.d == null) {
                this.d = this.c.a();
            }
            editorEdit.putString(this.b, this.c.a(this.d));
            editorEdit.apply();
        }
    }
}
