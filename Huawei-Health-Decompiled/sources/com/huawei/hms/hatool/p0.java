package com.huawei.hms.hatool;

import com.huawei.openalliance.ad.constant.Constants;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4794a = 1800000;
    private volatile boolean b = false;
    private a c = null;

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4795a = UUID.randomUUID().toString().replace(Constants.LINK, "");
        boolean b;
        private long c;

        void a(long j) {
            if (p0.this.b) {
                p0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }

        private boolean b(long j, long j2) {
            return j2 - j >= p0.this.f4794a;
        }

        private void b(long j) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f4795a = string;
            this.f4795a = string.replace(Constants.LINK, "");
            this.f4795a += "_" + j;
            this.c = j;
            this.b = true;
        }

        private boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        a(long j) {
            this.f4795a += "_" + j;
            this.c = j;
            this.b = true;
            p0.this.b = false;
        }
    }

    void a(long j) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(j);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.c = new a(j);
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.f4795a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }
}
