package defpackage;

import android.graphics.Rect;
import com.huawei.hwcommonmodel.application.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lag {
    public static final String c = BaseApplication.getContext().getFilesDir() + "/watchfacePhoto/background/";
    private boolean b;
    private int e;
    private int f;
    private List<String> j;
    private ArrayList<Rect> i = new ArrayList<>(16);
    private ArrayList<String> h = new ArrayList<>(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15041a = c;
    private Rect d = new Rect();

    public List<String> g() {
        return this.j;
    }

    public void d(List<String> list) {
        this.j = list;
    }

    public ArrayList<String> e() {
        return this.h;
    }

    public String a() {
        return this.f15041a;
    }

    public void d(String str) {
        this.f15041a = str;
    }

    public Rect bOq_() {
        return this.d;
    }

    public void bOr_(Rect rect) {
        this.d = rect;
    }

    public int d() {
        return this.f;
    }

    public int b() {
        return this.e;
    }

    public boolean j() {
        return this.b;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public void a(int i, int i2) {
        this.f = i;
        this.e = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append("clipRect: clipRect.left='").append(this.d.left);
        stringBuffer.append(", clipRect.top=").append(this.d.top);
        stringBuffer.append(", clipRect.right =").append(this.d.right);
        stringBuffer.append(", clipRect.bottom=").append(this.d.bottom);
        stringBuffer.append(", outputWidth=").append(this.f);
        stringBuffer.append(", outputHeight=").append(this.e);
        return stringBuffer.toString();
    }
}
