package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.av;

/* JADX INFO: loaded from: classes3.dex */
public final class aw extends av {

    public static abstract class a implements av.a {
        public abstract boolean a(aw awVar);

        public abstract boolean b(aw awVar);

        public abstract void c(aw awVar);

        @Override // com.amap.api.col.3sl.av.a
        public final boolean a(av avVar) {
            return a((aw) avVar);
        }

        @Override // com.amap.api.col.3sl.av.a
        public final boolean b(av avVar) {
            return b((aw) avVar);
        }

        @Override // com.amap.api.col.3sl.av.a
        public final void c(av avVar) {
            c((aw) avVar);
        }
    }

    public aw(Context context, a aVar) {
        super(context, aVar);
    }

    public final float j() {
        return (float) (((Math.atan2(g(), f()) - Math.atan2(e(), d())) * 180.0d) / 3.141592653589793d);
    }
}
