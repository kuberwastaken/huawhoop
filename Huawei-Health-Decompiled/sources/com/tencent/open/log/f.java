package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public class f implements Iterable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f11895a;
    private AtomicInteger b;

    public f() {
        this.f11895a = null;
        this.b = null;
        this.f11895a = new ConcurrentLinkedQueue<>();
        this.b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f11895a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        int i = length;
        int i2 = 0;
        for (String str : this) {
            int length2 = str.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i > length2 ? length2 : i;
                int i5 = i3 + i4;
                str.getChars(i3, i5, cArr, i2);
                i -= i4;
                i2 += i4;
                length2 -= i4;
                if (i == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (Exception unused) {
                        }
                    }
                    i = length;
                    i2 = 0;
                }
                i3 = i5;
            }
        }
        if (i2 > 0 && writer != null) {
            try {
                writer.write(cArr, 0, i2);
            } catch (Exception unused2) {
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (Exception unused3) {
            }
        }
    }

    public int a() {
        return this.b.get();
    }

    public void b() {
        this.f11895a.clear();
        this.b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f11895a.iterator();
    }
}
