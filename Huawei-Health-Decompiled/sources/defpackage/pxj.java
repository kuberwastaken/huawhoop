package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicSong;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public class pxj {
    private ArrayList<MusicSong> b;
    private String d;

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.d;
    }

    public void a(ArrayList<MusicSong> arrayList) {
        this.b = arrayList;
    }

    public ArrayList<MusicSong> e() {
        return this.b;
    }

    public static final e d() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class e implements Comparator, Serializable {
        private static final long serialVersionUID = -3362383176034179661L;

        e() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return pxi.d(obj instanceof pxj ? ((pxj) obj).c() : "", obj2 instanceof pxj ? ((pxj) obj2).c() : "");
        }
    }

    public String c() {
        return pxi.b(this.d);
    }
}
