package defpackage;

import com.huawei.pluginachievement.report.constant.EnumAnnualType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class nsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final nsj f16155a;
    private static final nsj b;
    private static final nsj c;
    private static final nsj d;
    private static final nsj e;
    private static final nsj f;
    private static final nsj g;
    private static final nsj h;
    private static final nsj i;
    private static final nsj j;
    private static final nsj k;
    private static final nsj l;
    private static final nsj m;
    private static final nsj n;
    private static final nsj o;
    private static final List<String> q;
    private static final nsj r;
    private static final Map<String, nsj> s;
    private static final nsj t;

    static {
        HashMap map = new HashMap();
        s = map;
        ArrayList arrayList = new ArrayList();
        q = arrayList;
        nsj nsjVar = new nsj(EnumAnnualType.REPORT_INITAL.value(), Arrays.asList(nsf.an, nsf.dq, nsf.eg, nsf.du, nsf.dt, nsf.ab, nsf.f, nsf.aw, nsf.bq));
        h = nsjVar;
        nsj nsjVar2 = new nsj(EnumAnnualType.REPORT_STEP.value(), Arrays.asList(nsf.dv, nsf.eb, nsf.di, nsf.dg, nsf.bs, nsf.bt, nsf.ac, nsf.by, nsf.bx, nsf.bn, nsf.bv, nsf.ee));
        m = nsjVar2;
        nsj nsjVar3 = new nsj(EnumAnnualType.REPORT_SLEEP.value(), Arrays.asList(nsf.cx, nsf.da, nsf.cz, nsf.cy, nsf.ct, nsf.de, nsf.cr, nsf.df, nsf.db, nsf.dc, nsf.cw, nsf.cf));
        o = nsjVar3;
        nsj nsjVar4 = new nsj(EnumAnnualType.REPORT_RUN.value(), Arrays.asList(nsf.dw, nsf.co, nsf.cv, nsf.cq, nsf.cn, nsf.cu, nsf.ay, nsf.ao, nsf.av, nsf.bc, nsf.bi, nsf.bm, nsf.cs, nsf.cm, nsf.cj, nsf.cp));
        k = nsjVar4;
        nsj nsjVar5 = new nsj(EnumAnnualType.REPORT_CYCLE.value(), Arrays.asList(nsf.dr, nsf.y, nsf.z, nsf.u, nsf.v, nsf.bo));
        e = nsjVar5;
        nsj nsjVar6 = new nsj(EnumAnnualType.REPORT_FITNESS.value(), Arrays.asList(nsf.dz, nsf.ap, nsf.ak, nsf.ar, nsf.bp, nsf.af, nsf.al, nsf.ag, nsf.dn, nsf.f126do, nsf.bw, nsf.bu, nsf.dm, nsf.dp, nsf.dy, nsf.ds, nsf.am, nsf.ae, nsf.dh, nsf.aq, nsf.cc, nsf.dd, nsf.at, nsf.ax, nsf.au));
        j = nsjVar6;
        nsj nsjVar7 = new nsj(EnumAnnualType.REPORT_REWARD.value(), Arrays.asList(nsf.cb, nsf.as, nsf.ci));
        l = nsjVar7;
        nsj nsjVar8 = new nsj(EnumAnnualType.REPORT_ACTIVITY.value(), Arrays.asList(nsf.bd, nsf.bf, nsf.ai));
        b = nsjVar8;
        nsj nsjVar9 = new nsj(EnumAnnualType.REPORT_SUMARY.value(), Arrays.asList(nsf.dt, nsf.dk, nsf.du));
        r = nsjVar9;
        nsj nsjVar10 = new nsj(EnumAnnualType.REPORT_HEALTH.value(), Arrays.asList(nsf.e, nsf.b, nsf.d, nsf.f16156a, nsf.g, nsf.j, nsf.i, nsf.h, nsf.c, nsf.ec, nsf.ea, nsf.ed, nsf.ca, nsf.cg, nsf.ad, nsf.dj, nsf.bz, nsf.w));
        g = nsjVar10;
        nsj nsjVar11 = new nsj(EnumAnnualType.REPORT_DIET.value(), Arrays.asList(nsf.aa));
        d = nsjVar11;
        nsj nsjVar12 = new nsj(EnumAnnualType.REPORT_MUSIC.value(), Arrays.asList(nsf.ba, nsf.p, nsf.az, nsf.bb, nsf.ah, nsf.dx));
        n = nsjVar12;
        nsj nsjVar13 = new nsj(EnumAnnualType.REPORT_VIP.value(), Arrays.asList(nsf.aj, nsf.x));
        t = nsjVar13;
        nsj nsjVar14 = new nsj(EnumAnnualType.REPORT_LIVING.value(), Arrays.asList(nsf.dl, nsf.br, nsf.ce, nsf.bk, nsf.s));
        i = nsjVar14;
        nsj nsjVar15 = new nsj(EnumAnnualType.REPORT_CLIMB_HILL.value(), Arrays.asList(nsf.m, nsf.k, nsf.n, nsf.l, nsf.q, nsf.r, nsf.t, nsf.o));
        f16155a = nsjVar15;
        nsj nsjVar16 = new nsj(EnumAnnualType.REPORT_BADMINTON.value(), Arrays.asList(nsf.cd, nsf.ck, nsf.cl, nsf.ch));
        c = nsjVar16;
        nsj nsjVar17 = new nsj(EnumAnnualType.REPORT_JUMP_ROPE.value(), Arrays.asList(nsf.bh, nsf.bj, nsf.be, nsf.bl, nsf.bg));
        f = nsjVar17;
        arrayList.add(EnumAnnualType.REPORT_INITAL.value());
        arrayList.add(EnumAnnualType.REPORT_STEP.value());
        arrayList.add(EnumAnnualType.REPORT_SLEEP.value());
        arrayList.add(EnumAnnualType.REPORT_RUN.value());
        arrayList.add(EnumAnnualType.REPORT_CYCLE.value());
        arrayList.add(EnumAnnualType.REPORT_FITNESS.value());
        arrayList.add(EnumAnnualType.REPORT_REWARD.value());
        arrayList.add(EnumAnnualType.REPORT_ACTIVITY.value());
        arrayList.add(EnumAnnualType.REPORT_SUMARY.value());
        arrayList.add(EnumAnnualType.REPORT_HEALTH.value());
        arrayList.add(EnumAnnualType.REPORT_DIET.value());
        arrayList.add(EnumAnnualType.REPORT_MUSIC.value());
        arrayList.add(EnumAnnualType.REPORT_VIP.value());
        arrayList.add(EnumAnnualType.REPORT_LIVING.value());
        arrayList.add(EnumAnnualType.REPORT_CLIMB_HILL.value());
        arrayList.add(EnumAnnualType.REPORT_BADMINTON.value());
        arrayList.add(EnumAnnualType.REPORT_JUMP_ROPE.value());
        map.put(EnumAnnualType.REPORT_INITAL.value(), nsjVar);
        map.put(EnumAnnualType.REPORT_STEP.value(), nsjVar2);
        map.put(EnumAnnualType.REPORT_SLEEP.value(), nsjVar3);
        map.put(EnumAnnualType.REPORT_RUN.value(), nsjVar4);
        map.put(EnumAnnualType.REPORT_CYCLE.value(), nsjVar5);
        map.put(EnumAnnualType.REPORT_FITNESS.value(), nsjVar6);
        map.put(EnumAnnualType.REPORT_REWARD.value(), nsjVar7);
        map.put(EnumAnnualType.REPORT_ACTIVITY.value(), nsjVar8);
        map.put(EnumAnnualType.REPORT_SUMARY.value(), nsjVar9);
        map.put(EnumAnnualType.REPORT_HEALTH.value(), nsjVar10);
        map.put(EnumAnnualType.REPORT_DIET.value(), nsjVar11);
        map.put(EnumAnnualType.REPORT_MUSIC.value(), nsjVar12);
        map.put(EnumAnnualType.REPORT_VIP.value(), nsjVar13);
        map.put(EnumAnnualType.REPORT_LIVING.value(), nsjVar14);
        map.put(EnumAnnualType.REPORT_CLIMB_HILL.value(), nsjVar15);
        map.put(EnumAnnualType.REPORT_BADMINTON.value(), nsjVar16);
        map.put(EnumAnnualType.REPORT_JUMP_ROPE.value(), nsjVar17);
    }

    public static nsj e(String str) {
        return s.get(str);
    }

    public static List<nsf> c(String str) {
        nsj nsjVarE = e(str);
        if (nsjVarE == null) {
            return new ArrayList();
        }
        return nsjVarE.c();
    }

    public static List<String> a() {
        return Collections.unmodifiableList(q);
    }
}
