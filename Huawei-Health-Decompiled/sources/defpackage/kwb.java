package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kwb {
    private int c;
    private List<e> e = new ArrayList(16);

    public static class e {
        private int c;
        private int d;
        private int e;

        public int c() {
            return this.e;
        }

        public void e(int i) {
            this.e = i;
        }

        public int a() {
            return this.c;
        }

        public void c(int i) {
            this.c = i;
        }

        public int d() {
            return this.d;
        }

        public void d(int i) {
            this.d = i;
        }

        public String toString() {
            return "DesFrame{, startTime=" + this.e + ", endTime=" + this.c + ", sportType=" + this.d + '}';
        }
    }

    public List<e> e() {
        return this.e;
    }

    public void c(int i) {
        this.c = i;
    }

    public String toString() {
        return "DesFrame{index=" + this.c + ", datas=" + this.e + '}';
    }
}
