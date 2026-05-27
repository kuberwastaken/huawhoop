package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicSong;

/* JADX INFO: loaded from: classes6.dex */
public class kym {
    private int b;
    private String c;
    private MusicSong d;
    private int e;

    public kym(int i, int i2, String str, MusicSong musicSong) {
        this.b = i;
        this.e = i2;
        this.c = str;
        this.d = musicSong;
    }

    public int a() {
        return this.e;
    }

    public String e() {
        return this.c;
    }

    public MusicSong d() {
        return this.d;
    }
}
