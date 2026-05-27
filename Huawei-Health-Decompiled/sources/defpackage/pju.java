package defpackage;

import com.huawei.ui.commonui.tablewidget.model.ItemData;
import com.huawei.ui.commonui.tablewidget.model.TableDataSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class pju<T0 extends ItemData, T1 extends ItemData, T2 extends ItemData, T3 extends ItemData, T4 extends ItemData, T5 extends ItemData> implements TableDataSet<T0, T1, T2, T3, T4, T5> {
    private pjp<T0> e = new pjp<>();
    private pjp<T1> j = new pjp<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pjp<T2> f16733a = new pjp<>();
    private pjp<T3> c = new pjp<>();
    private pjp<T4> h = new pjp<>();
    private pjp<T5> g = new pjp<>();
    private Set<Integer> d = new HashSet();
    private Set<Integer> f = new HashSet();
    private Set<Integer> n = new HashSet();
    private int i = 0;
    private int b = 0;

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T0 getColumnHeaderData(int i, int i2) {
        return this.e.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putColumnHeaderData(int i, int i2, T0 t0) {
        d(i, i2);
        this.d.add(Integer.valueOf(i));
        this.e.b(i, i2, t0);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T1 getRowHeaderData(int i, int i2) {
        return this.j.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putRowHeaderData(int i, int i2, T1 t1) {
        d(i, i2);
        this.f.add(Integer.valueOf(i2));
        this.j.b(i, i2, t1);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T2 getRowColumnHeaderData(int i, int i2) {
        return this.f16733a.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putRowColumnHeaderData(int i, int i2, T2 t2) {
        d(i, i2);
        this.f16733a.b(i, i2, t2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T3 getContentData(int i, int i2) {
        return this.c.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putContentData(int i, int i2, T3 t3) {
        d(i, i2);
        this.c.b(i, i2, t3);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T4 getStatisticHeaderData(int i, int i2) {
        return this.h.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putStatisticHeaderData(int i, int i2, T4 t4) {
        d(i, i2);
        this.n.add(Integer.valueOf(i));
        this.h.b(i, i2, t4);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public T5 getStatisticData(int i, int i2) {
        return this.g.a(i, i2);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void putStatisticData(int i, int i2, T5 t5) {
        d(i, i2);
        this.n.add(Integer.valueOf(i));
        this.g.b(i, i2, t5);
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public void clearAll() {
        this.j.c();
        this.e.c();
        this.f16733a.c();
        this.c.c();
        this.h.c();
        this.g.c();
        this.f.clear();
        this.d.clear();
        this.n.clear();
        this.i = 0;
        this.b = 0;
    }

    private void d(int i, int i2) {
        if (i > this.i - 1) {
            this.i = i + 1;
        }
        if (i2 > this.b - 1) {
            this.b = i2 + 1;
        }
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public int getRowsCount() {
        return this.i;
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.TableDataSet
    public int getColumnsCount() {
        return this.b;
    }

    public int a() {
        return this.d.size();
    }

    public int e() {
        return this.f.size();
    }

    public int c() {
        return this.n.size();
    }
}
