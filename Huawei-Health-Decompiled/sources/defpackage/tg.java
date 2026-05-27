package defpackage;

import android.net.Uri;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class tg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17969a;
    private JSONObject b;
    private String c;
    private Uri d;
    private int e;
    private Uri f;

    public tg d(JSONObject jSONObject) {
        this.b = jSONObject;
        return this;
    }

    public tg b(int i) {
        this.e = i;
        return this;
    }

    public tg bS_(Uri uri) {
        this.f = uri;
        return this;
    }

    public tg e(String str) {
        this.c = str;
        return this;
    }

    public tg bP_(Uri uri) {
        this.d = uri;
        return this;
    }

    public JSONObject a() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public Uri bR_() {
        return this.f;
    }

    public String e() {
        return this.c;
    }

    public Uri bQ_() {
        return this.d;
    }

    public boolean g() {
        return this.f17969a;
    }

    public tg a(boolean z) {
        this.f17969a = z;
        return this;
    }
}
