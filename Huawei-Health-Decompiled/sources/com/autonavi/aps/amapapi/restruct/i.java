package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003sl.np;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends a<np> {
    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* bridge */ /* synthetic */ void a(np npVar, long j) {
        a2(npVar, j);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    public final /* synthetic */ String b(np npVar) {
        return a(npVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ int c(np npVar) {
        return b2(npVar);
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final /* synthetic */ long d(np npVar) {
        return c2(npVar);
    }

    public i(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String a(np npVar) {
        return npVar == null ? "" : npVar.a();
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    private static int b2(np npVar) {
        if (npVar == null) {
            return -113;
        }
        return npVar.c;
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    private static long c2(np npVar) {
        if (npVar == null) {
            return 0L;
        }
        return npVar.f;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long b() {
        return com.autonavi.aps.amapapi.config.a.e;
    }

    @Override // com.autonavi.aps.amapapi.restruct.a
    final long c() {
        return com.autonavi.aps.amapapi.config.a.f;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(np npVar, long j) {
        if (npVar != null) {
            npVar.f = j;
        }
    }
}
