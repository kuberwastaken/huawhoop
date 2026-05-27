package defpackage;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.main.R$string;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class sqn {
    private static final byte[] c = new byte[1];
    private static sqn d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17795a;
    private int g;
    private long j;
    private String p;
    private long u;
    private String w;
    private final List<sqa> q = new ArrayList(12);
    private final Map<Integer, String> b = new HashMap(16);
    private final List<Integer> t = new ArrayList(16);
    private boolean k = false;
    private boolean o = false;
    private boolean i = false;
    private boolean r = true;
    private boolean s = false;
    private boolean m = false;
    private boolean n = false;
    private int h = 1;
    private boolean l = false;
    private boolean f = false;
    private String e = "unknown";

    private sqn() {
    }

    public static sqn e() {
        sqn sqnVar;
        synchronized (c) {
            if (d == null) {
                d = new sqn();
            }
            sqnVar = d;
        }
        return sqnVar;
    }

    public List<sqa> q() {
        return this.q;
    }

    public void d(boolean z) {
        this.k = z;
    }

    public boolean h() {
        return this.k;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public boolean a() {
        return this.f;
    }

    private void c(int i) {
        this.h = i;
    }

    private int y() {
        return this.h;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public boolean f() {
        return this.o;
    }

    public void j(boolean z) {
        this.n = z;
    }

    public boolean n() {
        return this.n;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean i() {
        return this.i;
    }

    public void f(boolean z) {
        this.r = z;
    }

    public boolean k() {
        return this.r;
    }

    public void i(boolean z) {
        this.s = z;
    }

    public boolean m() {
        return this.s;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public boolean j() {
        return this.m;
    }

    public void d(long j) {
        this.u = j;
    }

    public long s() {
        return this.u;
    }

    public void a(long j) {
        this.j = j;
    }

    public long d() {
        return this.j;
    }

    public void d(String str) {
        this.e = str;
    }

    public String l() {
        return this.e;
    }

    public void a(String str) {
        this.w = str;
    }

    public String r() {
        return this.w;
    }

    public String p() {
        return this.p;
    }

    public void c(String str) {
        this.p = str;
    }

    public void b(int i) {
        this.f17795a = i;
    }

    public int b() {
        return this.f17795a;
    }

    public void g(boolean z) {
        this.l = z;
    }

    public boolean g() {
        return this.l;
    }

    public int c() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public void t() {
        if (y() == 1) {
            c(0);
            LogUtil.b("AnswerQuestionUtil", "initList() success");
            w();
        }
    }

    private void w() {
        String string = BaseApplication.getContext().getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_item_1);
        String string2 = BaseApplication.getContext().getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_item_2);
        String string3 = BaseApplication.getContext().getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_item_3);
        String string4 = BaseApplication.getContext().getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_item_4);
        String[] strArrU = u();
        int i = 0;
        while (i < 12) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(new sqe("A", string));
            arrayList.add(new sqe("B", string2));
            arrayList.add(new sqe(TypeParams.SEARCH_CODE, string3));
            arrayList.add(new sqe("D", string4));
            int i2 = i + 1;
            this.q.add(new sqa(i2, strArrU[i], arrayList));
            i = i2;
        }
    }

    private String[] u() {
        Context context = BaseApplication.getContext();
        return new String[]{context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_1), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_2), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_3), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_4), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_5), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_6), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_7), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_8), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_9), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_10), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_11), context.getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_question_text_12)};
    }

    private void c(List<?> list) {
        if (list != null) {
            list.clear();
        }
    }

    private void d(Map<?, ?> map) {
        if (map != null) {
            map.clear();
        }
    }

    public int e(int i) {
        if (!this.b.containsKey(Integer.valueOf(i))) {
            return -1;
        }
        String str = this.b.get(Integer.valueOf(i));
        LogUtil.b("AnswerQuestionUtil", "getAnswerMap() questionId = ", Integer.valueOf(i));
        return d(str, i == 5 || i == 7 || i == 10);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int d(String str, boolean z) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case 65:
                b = !str.equals("A") ? (byte) -1 : (byte) 0;
                break;
            case 66:
                b = !str.equals("B") ? (byte) -1 : (byte) 1;
                break;
            case 67:
                b = !str.equals(TypeParams.SEARCH_CODE) ? (byte) -1 : (byte) 2;
                break;
            case 68:
                b = !str.equals("D") ? (byte) -1 : (byte) 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return z ? 3 : 0;
        }
        if (b == 1) {
            return z ? 2 : 1;
        }
        if (b == 2) {
            return z ? 1 : 2;
        }
        if (b == 3) {
            return z ? 0 : 3;
        }
        LogUtil.j("AnswerQuestionUtil", "matchSelected is error name, name is ", str);
        return -1;
    }

    public void c(int i, String str) {
        this.b.put(Integer.valueOf(i), str);
        LogUtil.b("AnswerQuestionUtil", "setAnswerMap() questionId = ", Integer.valueOf(i), ", checkedItem = ", str);
        if (i == 5 || i == 7 || i == 10) {
            b(this.b, i);
        }
    }

    private void b(Map<Integer, String> map, int i) {
        String str = map.get(Integer.valueOf(i));
        LogUtil.b("AnswerQuestionUtil", "changeMap() value = ", str);
        if ("A".equals(str)) {
            map.put(Integer.valueOf(i), "D");
            return;
        }
        if ("B".equals(str)) {
            map.put(Integer.valueOf(i), TypeParams.SEARCH_CODE);
            return;
        }
        if (TypeParams.SEARCH_CODE.equals(str)) {
            map.put(Integer.valueOf(i), "B");
        } else if ("D".equals(str)) {
            map.put(Integer.valueOf(i), "A");
        } else {
            LogUtil.b("AnswerQuestionUtil", "changeMap() value err");
        }
    }

    public float o() {
        Iterator<Map.Entry<Integer, String>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            String value = it.next().getValue();
            LogUtil.b("AnswerQuestionUtil", "getLastScore() value = ", value);
            if ("A".equals(value)) {
                this.t.add(0);
            } else if ("B".equals(value)) {
                this.t.add(1);
            } else if (TypeParams.SEARCH_CODE.equals(value)) {
                this.t.add(2);
            } else if ("D".equals(value)) {
                this.t.add(3);
            } else {
                LogUtil.b("AnswerQuestionUtil", "getLastScore() value err ");
            }
        }
        return a(this.t);
    }

    private float a(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return (float) ((((double) iIntValue) * 2.722d) + 0.5d + 1.0d);
    }

    public void x() {
        LogUtil.b("AnswerQuestionUtil", " AnswerQuestionUtil reset()");
        c(this.t);
        d(this.b);
        c(this.q);
        c(1);
        a(false);
        d(false);
        f(true);
        i(false);
        c(false);
        e(false);
        a(0);
    }
}
