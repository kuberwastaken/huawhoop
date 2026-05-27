package defpackage;

import com.huawei.openplatform.abl.log.i;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class ndw extends com.huawei.openplatform.abl.log.a {
    private final i d;
    private final Executor e = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ned("FileLog"));

    @Override // com.huawei.openplatform.abl.log.i
    public void a(nef nefVar, int i, String str) {
        this.e.execute(new b(nefVar, i, str));
        i iVar = this.f8510a;
        if (iVar != null) {
            iVar.a(nefVar, i, str);
        }
    }

    class a implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ String d;

        @Override // java.lang.Runnable
        public void run() {
            ndw.this.d.a(this.b, this.d);
        }

        a(String str, String str2) {
            this.b = str;
            this.d = str2;
        }
    }

    class b implements Runnable {
        final /* synthetic */ int b;
        final /* synthetic */ nef c;
        final /* synthetic */ String e;

        @Override // java.lang.Runnable
        public void run() {
            ndw.this.d.a(this.c, this.b, this.e);
        }

        b(nef nefVar, int i, String str) {
            this.c = nefVar;
            this.b = i;
            this.e = str;
        }
    }

    @Override // com.huawei.openplatform.abl.log.i
    public i a(String str, String str2) {
        this.e.execute(new a(str, str2));
        i iVar = this.f8510a;
        if (iVar != null) {
            iVar.a(str, str2);
        }
        return this;
    }

    public ndw(i iVar) {
        this.d = iVar;
    }
}
