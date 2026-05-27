package defpackage;

import android.content.ContentValues;
import com.huawei.hihealthservice.db.table.DBPointCommon;
import health.compact.a.HiCommonUtil;
import health.compact.a.HiDateUtil;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class jsp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14440a;
    private int b;
    private int c;
    private int d;
    private long e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private double n;

    public int a() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public int b() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public void c(long j) {
        this.c = HiDateUtil.b(j);
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int h() {
        return this.h;
    }

    public void c(int i) {
        this.h = i;
    }

    public double l() {
        return this.n;
    }

    public void c(double d) {
        this.n = d;
    }

    public int g() {
        return this.i;
    }

    public void h(int i) {
        this.i = i;
    }

    public int c() {
        return this.f14440a;
    }

    public void b(int i) {
        this.f14440a = i;
    }

    public String j() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    public int f() {
        return this.j;
    }

    public void g(int i) {
        this.j = i;
    }

    public int i() {
        return this.f;
    }

    public void f(int i) {
        this.f = i;
    }

    public long d() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
    }

    public String toString() {
        return "DayStatTable{id=" + this.b + ",dt=" + this.c + ",hiHlhTp=" + this.d + ",statTp=" + this.h + ",val=" + HiCommonUtil.a(Double.valueOf(this.n)) + ",who=" + this.i + ",ClntId=" + this.f14440a + ",TZ='" + this.g + "',sync=" + this.f + ",mTm=" + this.e + '}';
    }

    public static ContentValues bDa_(jsp jspVar) {
        if (jspVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(10);
        contentValues.put("date", Integer.valueOf(jspVar.b()));
        contentValues.put("hihealth_type", Integer.valueOf(jspVar.e()));
        contentValues.put("stat_type", Integer.valueOf(jspVar.h()));
        contentValues.put("value", Double.valueOf(jspVar.l()));
        contentValues.put("client_id", Integer.valueOf(jspVar.c()));
        contentValues.put(DBPointCommon.COLUMN_UNIT_ID, Integer.valueOf(jspVar.f()));
        contentValues.put("user_id", Integer.valueOf(jspVar.g()));
        contentValues.put("timeZone", HiDateUtil.a(jspVar.j()));
        contentValues.put("sync_status", Integer.valueOf(jspVar.i()));
        contentValues.put("modified_time", Long.valueOf(jspVar.d() <= 0 ? System.currentTimeMillis() : jspVar.d()));
        return contentValues;
    }

    public static ContentValues bDb_(jsp jspVar) {
        ContentValues contentValues = new ContentValues(6);
        contentValues.put("value", Double.valueOf(jspVar.l()));
        contentValues.put(DBPointCommon.COLUMN_UNIT_ID, Integer.valueOf(jspVar.f()));
        contentValues.put("user_id", Integer.valueOf(jspVar.g()));
        contentValues.put("sync_status", Integer.valueOf(jspVar.i()));
        contentValues.put("modified_time", Long.valueOf(jspVar.d()));
        return contentValues;
    }

    public void d(jsp jspVar, int i, int i2, boolean z) {
        jspVar.b(i2);
        jspVar.h(i);
        if (z) {
            return;
        }
        jspVar.f(0);
    }

    public List<jsp> d(List<jsp> list, String str, int i, int i2) {
        for (jsp jspVar : list) {
            jspVar.b(i);
            jspVar.d(str);
            jspVar.e(i2);
            jspVar.f(1);
            jspVar.a(20001);
        }
        return list;
    }

    public jsp d(int i, double d, int i2) {
        jsp jspVar = new jsp();
        jspVar.c(i);
        jspVar.c(d);
        jspVar.g(i2);
        return jspVar;
    }
}
