package com.huawei.hwcloudjs.d.a;

import com.huawei.hwcloudjs.f.h;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6406a = "SerializedObject";
    private String b;

    public T b() throws Throwable {
        Throwable th;
        e eVar;
        FileInputStream fileInputStream;
        Closeable closeable = (T) null;
        try {
            try {
                fileInputStream = new FileInputStream(this.b);
            } catch (Throwable th2) {
                FileInputStream fileInputStream2 = fileInputStream;
                th = th2;
                closeable = (T) fileInputStream2;
            }
            try {
                eVar = new e(fileInputStream);
                try {
                    closeable = (T) eVar.readObject();
                } catch (IOException | Exception unused) {
                    com.huawei.hwcloudjs.f.d.b(f6406a, "read file error ", true);
                }
            } catch (IOException | Exception unused2) {
                eVar = null;
            } catch (Throwable th3) {
                eVar = null;
                closeable = (T) fileInputStream;
                th = th3;
                h.a(closeable);
                h.a(eVar);
                throw th;
            }
        } catch (IOException | Exception unused3) {
            fileInputStream = null;
            eVar = null;
        } catch (Throwable th4) {
            th = th4;
            eVar = null;
        }
        h.a(fileInputStream);
        h.a(eVar);
        return (T) closeable;
    }

    public boolean a(T t) throws Throwable {
        Closeable closeable;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        boolean z = true;
        Closeable closeable2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.b);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                closeable = closeable2;
                closeable2 = fileOutputStream;
            }
            try {
                objectOutputStream.writeObject(t);
                h.a(fileOutputStream);
                h.a(objectOutputStream);
            } catch (IOException unused2) {
                closeable2 = objectOutputStream;
                com.huawei.hwcloudjs.f.d.b(f6406a, "read file error ", true);
                h.a(fileOutputStream);
                h.a(closeable2);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                closeable2 = fileOutputStream;
                closeable = objectOutputStream;
                h.a(closeable2);
                h.a(closeable);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
        return z;
    }

    public long a() {
        return new File(this.b).lastModified();
    }

    public f(String str) {
        this.b = str;
    }
}
