package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicSong;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public class pxe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16935a;
    private ArrayList<MusicSong> c;

    public void c(String str) {
        this.f16935a = str;
    }

    public String e() {
        return this.f16935a;
    }

    public void c(ArrayList<MusicSong> arrayList) {
        this.c = arrayList;
    }

    public ArrayList<MusicSong> b() {
        return this.c;
    }

    public static final d d() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class d implements Comparator, Serializable {
        private static final long serialVersionUID = -3362383176034179661L;

        d() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if ((obj instanceof pxe) && (obj2 instanceof pxe)) {
                return pxi.d(((pxe) obj).a(), ((pxe) obj2).a());
            }
            return 0;
        }
    }

    public String a() {
        return pxi.b(this.f16935a);
    }
}
