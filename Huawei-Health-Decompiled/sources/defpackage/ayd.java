package defpackage;

import com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ayd {
    private static final Map<String, List<VectorAnimation>> e;

    static {
        HashMap map = new HashMap();
        e = map;
        map.put("rotate", Collections.singletonList(new d(true)));
        map.put("translateX", Collections.singletonList(new h(true)));
        map.put("translateY", Collections.singletonList(new f(true)));
        map.put("translateXY", Collections.singletonList(new j(true)));
        map.put("scale", Collections.singletonList(new i(true)));
        map.put("breath", Collections.singletonList(new b(0L, true)));
        map.put("-rotate", Collections.singletonList(new d(false)));
        map.put("-translateX", Collections.singletonList(new h(false)));
        map.put("-translateY", Collections.singletonList(new f(false)));
        map.put("-translateXY", Collections.singletonList(new j(false)));
        map.put("-scale", Collections.singletonList(new i(false)));
        map.put("-breath", Collections.singletonList(new b(0L, false)));
        map.put("0", Collections.singletonList(new e()));
        map.put("1", Collections.singletonList(new c()));
        map.put("2", Collections.singletonList(new a()));
    }

    public static List<VectorAnimation> c(String str) {
        return e.get(str);
    }

    public static class d implements VectorAnimation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f374a;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public d(boolean z) {
            this.f374a = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 1.6f));
            arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getRotateKeyFrame() {
            ArrayList arrayList = new ArrayList();
            if (this.f374a) {
                arrayList.add(new VectorAnimation.a(0.0f, -45.0f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, 45.0f));
            }
            arrayList.add(new VectorAnimation.a(1.0f, 0.0f));
            return arrayList;
        }
    }

    public static class i implements VectorAnimation {
        private final boolean b;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public i(boolean z) {
            this.b = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.b) {
                arrayList.add(new VectorAnimation.a(0.0f, 1.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, 1.0f));
                arrayList.add(new VectorAnimation.a(1.0f, 1.5f));
            }
            return arrayList;
        }
    }

    public static class h implements VectorAnimation {
        private final boolean e;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public h(boolean z) {
            this.e = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getTranslateXKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.e) {
                arrayList.add(new VectorAnimation.a(0.0f, 0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, -0.5f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, -0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 0.5f));
            }
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 2.0f));
            arrayList.add(new VectorAnimation.a(1.0f, 2.0f));
            return arrayList;
        }
    }

    public static class f implements VectorAnimation {
        private final boolean d;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public f(boolean z) {
            this.d = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getTranslateYKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.d) {
                arrayList.add(new VectorAnimation.a(0.0f, -0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 0.5f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, 0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, -0.5f));
            }
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 2.0f));
            arrayList.add(new VectorAnimation.a(1.0f, 2.0f));
            return arrayList;
        }
    }

    public static class j implements VectorAnimation {
        private final boolean c;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public j(boolean z) {
            this.c = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getTranslateXKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.c) {
                arrayList.add(new VectorAnimation.a(0.0f, 0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, -0.5f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, -0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 0.5f));
            }
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getTranslateYKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.c) {
                arrayList.add(new VectorAnimation.a(0.0f, -0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 0.5f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, 0.5f));
                arrayList.add(new VectorAnimation.a(1.0f, -0.5f));
            }
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 2.0f));
            arrayList.add(new VectorAnimation.a(1.0f, 2.0f));
            return arrayList;
        }
    }

    public static class b implements VectorAnimation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f373a;
        private final long d;

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 5000;
        }

        public b(long j, boolean z) {
            this.d = j;
            this.f373a = z;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            if (this.f373a) {
                arrayList.add(new VectorAnimation.a(0.0f, 1.0f));
                arrayList.add(new VectorAnimation.a(0.5f, 1.5f));
                arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            } else {
                arrayList.add(new VectorAnimation.a(0.0f, 1.5f));
                arrayList.add(new VectorAnimation.a(0.5f, 1.0f));
                arrayList.add(new VectorAnimation.a(1.0f, 1.5f));
            }
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public long getStartDelay() {
            return this.d;
        }
    }

    public static class e implements VectorAnimation {
        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 1000;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 1.6f));
            arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getRotateKeyFrame() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, -30.0f));
            arrayList.add(new VectorAnimation.a(1.0f, 0.0f));
            return arrayList;
        }
    }

    public static class c implements VectorAnimation {
        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 1000;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 2.0f));
            arrayList.add(new VectorAnimation.a(0.6f, 1.0f));
            arrayList.add(new VectorAnimation.a(0.8f, 1.02f));
            arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            return arrayList;
        }
    }

    public static class a implements VectorAnimation {
        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public int getDuration() {
            return 2000;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getTranslateXKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 0.5f));
            arrayList.add(new VectorAnimation.a(1.0f, 0.0f));
            return arrayList;
        }

        @Override // com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl.VectorAnimation
        public List<VectorAnimation.a> getScaleKeyFrames() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VectorAnimation.a(0.0f, 2.0f));
            arrayList.add(new VectorAnimation.a(0.25f, 2.0f));
            arrayList.add(new VectorAnimation.a(1.0f, 1.0f));
            return arrayList;
        }
    }
}
