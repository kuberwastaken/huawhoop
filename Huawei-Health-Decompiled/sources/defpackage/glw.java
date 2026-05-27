package defpackage;

import com.huawei.health.sportservice.utils.SmoothDataParser;

/* JADX INFO: loaded from: classes10.dex */
public class glw {
    private static SmoothDataParser d = new glu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SmoothDataParser f13525a = new gly();

    public static float a(float f, int i) {
        SmoothDataParser smoothDataParser;
        if (i == 0) {
            smoothDataParser = d;
        } else {
            smoothDataParser = f13525a;
        }
        return smoothDataParser.getAverage(f);
    }

    public static void c(int i) {
        if (i == 0) {
            d.clear();
        } else {
            f13525a.clear();
        }
    }
}
