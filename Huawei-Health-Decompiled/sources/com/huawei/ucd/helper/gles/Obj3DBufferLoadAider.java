package com.huawei.ucd.helper.gles;

import android.content.Context;
import defpackage.pcf;
import defpackage.pcj;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes11.dex */
public class Obj3DBufferLoadAider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f9094a;
    private float[] b;
    private float[] c;
    private ExecutorService e = Executors.newFixedThreadPool(3);
    private int d = 0;
    private int i = 0;
    private String f = "";

    public interface OnLoadListener {
        void onLoadFailed(String str);

        void onLoadOK(b bVar);
    }

    public void c(Context context, InputStream inputStream, InputStream inputStream2, InputStream inputStream3, OnLoadListener onLoadListener) {
        long jCurrentTimeMillis;
        StringBuilder sb;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(inputStream3, 0, onLoadListener));
        arrayList.add(new d(inputStream2, 1, onLoadListener));
        arrayList.add(new d(inputStream, 2, onLoadListener));
        try {
            try {
                this.e.invokeAll(arrayList);
                pcf.b(inputStream, inputStream2, inputStream3);
                jCurrentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder();
            } catch (InterruptedException e) {
                e.printStackTrace();
                pcj.b("Obj3DBufferLoadAider", pcj.a() + " e=" + e.getMessage());
                d(-1, e.getMessage(), onLoadListener);
                onLoadListener.onLoadFailed(e.getMessage());
                pcf.b(inputStream, inputStream2, inputStream3);
                jCurrentTimeMillis = System.currentTimeMillis();
                sb = new StringBuilder();
            }
            sb.append(pcj.a());
            sb.append(" Load Time=");
            sb.append(jCurrentTimeMillis - jCurrentTimeMillis2);
            pcj.b("Obj3DBufferLoadAider", sb.toString());
        } catch (Throwable th) {
            pcf.b(inputStream, inputStream2, inputStream3);
            pcj.b("Obj3DBufferLoadAider", pcj.a() + " Load Time=" + (System.currentTimeMillis() - jCurrentTimeMillis2));
            throw th;
        }
    }

    public class d implements Callable<float[]> {
        private int c;
        private OnLoadListener d;
        private InputStream e;

        public d(InputStream inputStream, int i, OnLoadListener onLoadListener) {
            if (inputStream == null) {
                pcj.b("Obj3DBufferLoadAider", " InputStream can not be null dataType=" + i);
                throw new RuntimeException(" InputStream can not be null dataType=" + i);
            }
            this.e = inputStream;
            this.c = i;
            this.d = onLoadListener;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] call() throws Exception {
            byte[] bArrE = e(this.e);
            int length = bArrE.length;
            pcj.b("Obj3DBufferLoadAider", pcj.a() + " onLoadThread mDataType=" + this.c + " size=" + length);
            this.e.read(bArrE, 0, length);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrE);
            byteBufferWrap.clear();
            float[] fArr = new float[byteBufferWrap.capacity() / 4];
            byteBufferWrap.asFloatBuffer().get(fArr);
            int i = this.c;
            if (i == 0) {
                Obj3DBufferLoadAider.this.c = fArr;
            } else if (i == 1) {
                Obj3DBufferLoadAider.this.f9094a = fArr;
            } else if (i == 2) {
                Obj3DBufferLoadAider.this.b = fArr;
            }
            Obj3DBufferLoadAider.this.d(1, "", this.d);
            return fArr;
        }

        private byte[] e(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[4096];
            if (inputStream == null) {
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStream.read(bArr);
                if (-1 != i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, OnLoadListener onLoadListener) {
        synchronized (this) {
            if (onLoadListener == null) {
                return;
            }
            this.i += i;
            this.d++;
            this.f += str;
            pcj.b("Obj3DBufferLoadAider", pcj.a() + " onLoadThreadFinishedCount=" + this.d + " onLoadThreadSucceedCount=" + this.i);
            int i2 = this.d;
            if (i2 == 3 && this.i == 3) {
                onLoadListener.onLoadOK(new b());
                this.i = 0;
                this.d = 0;
            } else if (i2 == 3 && this.i != 3) {
                onLoadListener.onLoadFailed(this.f);
                this.i = 0;
                this.d = 0;
                this.f = "";
            }
        }
    }

    public class b {
        public b() {
        }

        public float[] b() {
            return Obj3DBufferLoadAider.this.c;
        }

        public float[] c() {
            return Obj3DBufferLoadAider.this.f9094a;
        }

        public float[] e() {
            return Obj3DBufferLoadAider.this.b;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("LoadResult{VertexXYZ=null? ");
            sb.append(Obj3DBufferLoadAider.this.c == null);
            sb.append(", NormalVectorXYZ=null? ");
            sb.append(Obj3DBufferLoadAider.this.f9094a == null);
            sb.append(", TextureVertexST=null? ");
            sb.append(Obj3DBufferLoadAider.this.b == null);
            sb.append('}');
            return sb.toString();
        }
    }
}
