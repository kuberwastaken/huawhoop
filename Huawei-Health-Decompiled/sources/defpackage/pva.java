package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicSong;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class pva {
    private static final Object b = new Object();
    private static pva c;
    private ArrayList<MusicSong> d = new ArrayList<>(16);

    private pva() {
    }

    public static pva a() {
        pva pvaVar;
        synchronized (b) {
            if (c == null) {
                c = new pva();
            }
            pvaVar = c;
        }
        return pvaVar;
    }

    public void e() {
        c();
    }

    private static void c() {
        synchronized (b) {
            c = null;
        }
    }

    public ArrayList<MusicSong> b() {
        return this.d;
    }
}
