package com.huawei.openalliance.ad;

import com.google.flatbuffers.Table;
import com.huawei.openalliance.ad.xf;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class xn extends Table {
    public String d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public xf.a c() {
        return a(new xf.a());
    }

    public String b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public xn b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public void a(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public String a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public xf.a a(xf.a aVar) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return aVar.a(__vector(i__offset), 4, this.bb);
        }
        return null;
    }
}
