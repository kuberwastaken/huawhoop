package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.bundlecore.download.DownloadRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
final class asy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f307a;
    private List<DownloadRequest> b;
    private List<String> c;
    final List<ask> d;
    private long e;
    private List<Intent> f;
    private final int g;
    private int h;
    private final List<String> i;
    private long j;
    private PendingIntent m;

    asy(int i, List<String> list, List<ask> list2, List<DownloadRequest> list3, long j) {
        this.g = i;
        this.i = list;
        this.d = list2;
        c(list3, j);
    }

    void c(List<DownloadRequest> list, long j) {
        this.b = list;
        this.c = a(list);
        this.j = j;
    }

    int e() {
        return this.g;
    }

    List<String> d() {
        return this.i;
    }

    List<DownloadRequest> a() {
        return this.b;
    }

    List<String> c() {
        return this.c;
    }

    long g() {
        return this.j;
    }

    int b() {
        return this.h;
    }

    void c(int i) {
        this.h = i;
    }

    void d(long j) {
        this.e = j;
    }

    void b(int i) {
        this.f307a = i;
    }

    void fB_(PendingIntent pendingIntent) {
        this.m = pendingIntent;
    }

    void b(List<Intent> list) {
        this.f = list;
    }

    static Bundle fA_(asy asyVar) {
        int iB = asyVar.b();
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", asyVar.e());
        bundle.putInt("status", iB);
        bundle.putInt("error_code", asyVar.f307a);
        bundle.putLong("total_bytes_to_download", asyVar.g());
        bundle.putLong("bytes_downloaded", asyVar.e);
        bundle.putStringArrayList("module_names", (ArrayList) asyVar.d());
        bundle.putStringArrayList("download_module_names", (ArrayList) asyVar.c());
        if (iB == 8) {
            bundle.putParcelable("user_confirmation_intent", asyVar.m);
        } else if (iB == 10) {
            bundle.putParcelableArrayList("split_file_intents", (ArrayList) asyVar.f);
        }
        return bundle;
    }

    private static List<String> a(List<DownloadRequest> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<DownloadRequest> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getModuleName());
        }
        return arrayList;
    }
}
