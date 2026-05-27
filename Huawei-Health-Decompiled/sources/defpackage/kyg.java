package defpackage;

import com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype.MusicStruct;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class kyg {
    private int b;
    private List<MusicStruct> c;
    private int e;

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public void e(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public List<MusicStruct> d() {
        return (List) kqt.e(this.c);
    }

    public void a(List<MusicStruct> list) {
        this.c = (List) kqt.e(list);
    }
}
