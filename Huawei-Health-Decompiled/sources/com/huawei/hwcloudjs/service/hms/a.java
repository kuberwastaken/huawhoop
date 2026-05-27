package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public class a extends com.huawei.hwcloudjs.e.b.c<b> {
    private static final String b = "ActivityResultNotifier";
    private static a c = new a();

    /* JADX INFO: loaded from: classes11.dex */
    public interface c {
        void a(b bVar);
    }

    public static final class b extends com.huawei.hwcloudjs.e.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Intent f6431a;
        private int b;
        private int c;

        public int c() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public int b() {
            return this.c;
        }

        public void a(Intent intent) {
            this.f6431a = intent;
        }

        public void a(int i) {
            this.c = i;
        }

        public Intent a() {
            return this.f6431a;
        }
    }

    public void a(Activity activity, Intent intent, int i, c cVar) {
        a().b(new C0175a(i, cVar));
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
            com.huawei.hwcloudjs.f.d.b(b, "ActivityNotFoundException .. ", true);
        }
    }

    public void a(int i, c cVar) {
        a().b(new C0175a(i, cVar));
    }

    /* JADX INFO: renamed from: com.huawei.hwcloudjs.service.hms.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes11.dex */
    static final class C0175a implements com.huawei.hwcloudjs.e.b.b<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6430a;
        private c b;

        @Override // com.huawei.hwcloudjs.e.b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onReceive(b bVar) {
            if (this.f6430a != bVar.c) {
                return true;
            }
            this.b.a(bVar);
            return false;
        }

        public C0175a(int i, c cVar) {
            this.f6430a = i;
            this.b = cVar;
        }
    }

    public static a a() {
        return c;
    }
}
