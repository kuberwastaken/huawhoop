package defpackage;

import android.text.SpannableStringBuilder;
import com.huawei.ui.commonui.linechart.common.DataInfos;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class tjj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SpannableStringBuilder f18012a;
    private SpannableStringBuilder g;
    private long h;
    private String n;
    private List<pdn> i = new ArrayList();
    private String f = null;
    private boolean d = false;
    private long j = 0;
    private long e = 0;
    private boolean b = false;
    private DataInfos c = DataInfos.NoDataPlaceHolder;

    public void e(long j) {
        this.h = j;
    }

    public long c() {
        return this.h;
    }

    public void e(String str) {
        this.n = str;
    }

    public String i() {
        return this.n;
    }

    public void e(DataInfos dataInfos) {
        this.c = dataInfos;
    }

    public DataInfos e() {
        return this.c;
    }

    public void e(long j, long j2) {
        this.j = j;
        this.e = j2;
    }

    public void b(List<pdn> list) {
        this.i.clear();
        this.i.addAll(list);
    }

    public void b(String str) {
        this.f = str;
    }

    public String j() {
        return this.f;
    }

    public boolean n() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public List<pdn> g() {
        return this.i;
    }

    public long h() {
        return this.j;
    }

    public long a() {
        return this.e;
    }

    public SpannableStringBuilder eap_() {
        return this.f18012a;
    }

    public SpannableStringBuilder eaq_() {
        return this.g;
    }

    public void ear_(SpannableStringBuilder spannableStringBuilder) {
        this.f18012a = spannableStringBuilder;
    }

    public void eas_(SpannableStringBuilder spannableStringBuilder) {
        this.g = spannableStringBuilder;
    }

    public boolean f() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String toString() {
        return "PressureData{mDataInfos=" + this.c + ", mJumpTime=" + this.h + '}';
    }
}
