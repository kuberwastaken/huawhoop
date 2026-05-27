package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicSong;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public class pxl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<MusicSong> f16938a;
    private String c;

    public void b(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public void b(ArrayList<MusicSong> arrayList) {
        this.f16938a = arrayList;
    }

    public ArrayList<MusicSong> e() {
        return this.f16938a;
    }

    public static final c c() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class c implements Comparator, Serializable {
        private static final long serialVersionUID = -3362383176034179661L;

        c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return pxi.d(obj instanceof pxl ? ((pxl) obj).d() : "", obj2 instanceof pxl ? ((pxl) obj2).d() : "");
        }
    }

    public String d() {
        return pxi.b(this.c);
    }
}
