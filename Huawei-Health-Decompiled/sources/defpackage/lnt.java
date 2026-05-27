package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lnt {
    private int b;
    private List<c> e = new ArrayList(16);

    public static class c {
        private int b;
        private int c;
        private int d;

        public int c() {
            return this.d;
        }

        public void c(int i) {
            this.d = i;
        }

        public int a() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }

        public int e() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public String toString() {
            return "DesFrame{, startTime=" + this.d + ", endTime=" + this.c + ", sportType=" + this.b + '}';
        }
    }

    public List<c> b() {
        return this.e;
    }

    public void a(int i) {
        this.b = i;
    }

    public String toString() {
        return "DesFrame{index=" + this.b + ", datas=" + this.e + '}';
    }
}
