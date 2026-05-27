package defpackage;

import com.huawei.hwcommonmodel.datatypes.MsgImage;
import com.huawei.hwcommonmodel.datatypes.MsgText;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class kpz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14831a;
    private ArrayList<MsgText> b;
    private ArrayList<MsgImage> c;
    private int e;

    public kpz(int i, ArrayList<MsgImage> arrayList, ArrayList<MsgText> arrayList2, boolean z) {
        this.e = i;
        this.c = arrayList;
        this.b = arrayList2;
        this.f14831a = z;
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void a(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public ArrayList<MsgText> d() {
        return (ArrayList) kqt.e(this.b);
    }

    public ArrayList<MsgImage> a() {
        return (ArrayList) kqt.e(this.c);
    }

    public void a(boolean z) {
        this.f14831a = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean b() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.f14831a))).booleanValue();
    }
}
