package defpackage;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class uvf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18478a;
    private float[] b;
    private float c;
    private List<c> d = new LinkedList();
    private int e;

    public uvf(float f, float f2, int i, List<c> list, float[] fArr) {
        this.b = null;
        this.f18478a = f;
        this.c = f2;
        this.e = i;
        if (fArr != null) {
            this.b = (float[]) fArr.clone();
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.addAll(list);
    }

    public boolean h() {
        List<c> list = this.d;
        return (list == null || list.size() == 0) ? false : true;
    }

    public float d() {
        return this.f18478a;
    }

    public float c() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public List<c> a() {
        return this.d;
    }

    public float[] e() {
        float[] fArr = this.b;
        return fArr == null ? new float[0] : (float[]) fArr.clone();
    }

    public static class c {
        private int b;
        private float c;
        private float e;

        public c(float f, float f2, int i) {
            this.e = f;
            this.c = f2;
            this.b = i;
        }

        public float e() {
            return this.e;
        }

        public float a() {
            return this.c;
        }

        public int b() {
            return this.b;
        }
    }
}
