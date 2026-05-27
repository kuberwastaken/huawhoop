package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class caw {
    private ArrayList<caz> e = new ArrayList<>(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<cax> f560a = new ArrayList<>(16);
    private ArrayList<cba> b = new ArrayList<>(16);

    public void c(ArrayList<caz> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.e.add(i, arrayList.get(i));
        }
    }

    public void e(ArrayList<cax> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f560a.add(i, arrayList.get(i));
        }
    }

    public void b(ArrayList<cba> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.b.add(i, arrayList.get(i));
        }
    }

    public ArrayList<caz> b() {
        return this.e;
    }

    public ArrayList<cax> c() {
        return this.f560a;
    }

    public ArrayList<cba> a() {
        return this.b;
    }
}
