package defpackage;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;

/* JADX INFO: loaded from: classes8.dex */
public class vpr extends HwPagerAdapter {
    private boolean c;
    private final HwPagerAdapter d;
    private boolean i;
    private int e = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18718a = 2;
    private SparseArray<a> b = new SparseArray<>();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18719a;
        ViewGroup c;
        Object d;

        a(ViewGroup viewGroup, int i, Object obj) {
            this.c = viewGroup;
            this.f18719a = i;
            this.d = obj;
        }
    }

    public vpr(HwPagerAdapter hwPagerAdapter, boolean z) {
        this.d = hwPagerAdapter;
        this.c = z;
    }

    private int b() {
        return this.f18718a;
    }

    private int d() {
        return (b() + a()) - 1;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void a(DataSetObserver dataSetObserver) {
        this.d.a(dataSetObserver);
    }

    public int b(int i) {
        return i + this.f18718a;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int iB = b();
        int iD = d();
        int iE = this.c ? e(i) : i;
        if (this.i && (i == iB || i == iD)) {
            this.b.put(i, new a(viewGroup, iE, obj));
        } else {
            this.d.destroyItem(viewGroup, iE, obj);
        }
    }

    public int e(int i) {
        int iA = a();
        if (iA == 0) {
            return 0;
        }
        int i2 = (i - this.f18718a) % iA;
        return i2 < 0 ? i2 + iA : i2;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.d.finishUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        return this.c ? this.d.getCount() + this.e : this.d.getCount();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getItemPosition(Object obj) {
        return this.d.getItemPosition(obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.c) {
            i = e(i);
        }
        return this.d.getPageTitle(i);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public float getPageWidth(int i) {
        if (this.c) {
            i = e(i);
        }
        return this.d.getPageWidth(i);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        int iE = this.c ? e(i) : i;
        if (!this.i || (aVar = this.b.get(i)) == null) {
            return this.d.instantiateItem(viewGroup, iE);
        }
        this.b.remove(i);
        return aVar.d;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.d.isViewFromObject(view, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void notifyDataSetChanged() {
        this.b = new SparseArray<>();
        this.d.notifyDataSetChanged();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.d.registerDataSetObserver(dataSetObserver);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.d.restoreState(parcelable, classLoader);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        return this.d.saveState();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.c) {
            i = e(i);
        }
        this.d.setPrimaryItem(viewGroup, i, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.d.startUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.d.unregisterDataSetObserver(dataSetObserver);
    }

    public void a(boolean z) {
        this.i = z;
    }

    public HwPagerAdapter e() {
        return this.d;
    }

    public void d(int i) {
        int i2 = i - 1;
        this.f18718a = i2;
        this.e = i + i2;
    }

    public int c() {
        return this.e;
    }

    public int a() {
        return this.d.getCount();
    }
}
