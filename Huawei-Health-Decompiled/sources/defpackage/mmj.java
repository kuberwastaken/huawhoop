package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mmj {
    private static final c[] e = {new c(49.2204d, 79.4462d, 42.8899d, 96.33d), new c(54.1415d, 109.6872d, 39.3742d, 135.0002d), new c(42.8899d, 73.1246d, 29.5297d, 124.143255d), new c(29.5297d, 82.9684d, 26.7186d, 97.0352d), new c(29.5297d, 97.0253d, 20.414096d, 124.367395d), new c(20.414096d, 107.975793d, 17.871542d, 111.744104d), new c(40.167271d, 124.158707d, 39.964563d, 124.430575d)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c[] f15713a = {new c(25.398623d, 119.921265d, 21.785006d, 122.497559d), new c(22.284d, 101.8652d, 20.0988d, 106.665d), new c(21.5422d, 106.4525d, 20.4878d, 108.051d), new c(55.8175d, 109.0323d, 50.3257d, 119.127d), new c(55.8175d, 127.4568d, 49.587876d, 137.0227d), new c(44.8922d, 131.2662d, 42.5692d, 137.0227d), new c(40.106277d, 124.379711d, 39.964563d, 124.430575d), new c(27.7367d, 82.9684d, 26.7186d, 88.702d), new c(29.1146d, 82.9684d, 27.7367d, 84.1503d), new c(28.5753d, 84.1503d, 27.7367d, 85.0573d), new c(28.2349d, 85.0573d, 27.7367d, 85.746d)};
    private static final c[] b = {new c(50.26252d, 127.44838d, 50.222656d, 127.55693d), new c(21.561273d, 107.948502d, 21.537023d, 107.969624d), new c(21.560673d, 107.969334d, 21.540219d, 107.978721d), new c(21.56157d, 107.978041d, 21.545004d, 107.996404d), new c(22.158318d, 113.538441d, 22.162086d, 113.540142d)};
    private static final c[] d = {new c(22.109d, 113.549d, 22.2166d, 113.6d), new c(22.2135d, 113.543d, 22.2166d, 113.549d), new c(22.194d, 113.5348d, 22.2135d, 113.549d), new c(22.188d, 113.53d, 22.194d, 113.549d), new c(22.172d, 113.528d, 22.188d, 113.549d), new c(22.161d, 113.536d, 22.172d, 113.549d), new c(22.155d, 113.5398d, 22.161d, 113.549d), new c(22.153d, 113.542d, 22.155d, 113.549d), new c(22.1485d, 113.546d, 22.153d, 113.549d), new c(22.151d, 113.544d, 22.153d, 113.546d), new c(22.2135d, 113.542d, 22.2145d, 113.543d), new c(22.2077d, 113.5344d, 22.2133d, 113.5348d), new c(22.2093d, 113.5339d, 22.213d, 113.5344d), new c(22.2104d, 113.5336d, 22.2127d, 113.5339d), new c(22.154752d, 113.834609d, 22.444842d, 114.407653d), new c(22.444842d, 113.955365d, 22.502398d, 114.407653d)};

    public static int b(double d2, double d3) {
        for (c cVar : d) {
            if (cVar.e(d2, d3) && !a(d2, d3)) {
                return 3;
            }
        }
        for (c cVar2 : e) {
            if (cVar2.e(d2, d3)) {
                return (!e(d2, d3) || a(d2, d3)) ? 1 : 2;
            }
        }
        return 2;
    }

    private static boolean e(double d2, double d3) {
        for (c cVar : f15713a) {
            if (cVar.e(d2, d3)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(double d2, double d3) {
        for (c cVar : b) {
            if (cVar.e(d2, d3)) {
                return true;
            }
        }
        return false;
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f15714a;
        private double b;
        private double c;
        private double e;

        c(double d, double d2, double d3, double d4) {
            this.b = Math.min(d2, d4);
            this.c = Math.max(d, d3);
            this.f15714a = Math.max(d2, d4);
            this.e = Math.min(d, d3);
        }

        boolean e(double d, double d2) {
            return this.b <= d2 && this.f15714a >= d2 && this.c >= d && this.e <= d;
        }
    }
}
