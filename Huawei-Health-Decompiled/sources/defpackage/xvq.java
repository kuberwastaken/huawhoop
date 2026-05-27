package defpackage;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.crypto.PBKDF2.PRF;

/* JADX INFO: loaded from: classes8.dex */
public class xvq implements PRF {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19162a;
    private Mac c;
    private ByteArrayOutputStream d = new ByteArrayOutputStream(4096);
    private int e;

    public xvq(String str) {
        this.f19162a = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.c = mac;
            this.e = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public byte[] doFinal(byte[] bArr) {
        if (this.d.size() > 0) {
            e(0);
        }
        return this.c.doFinal(bArr);
    }

    public byte[] e() {
        return a(0);
    }

    public byte[] a(int i) {
        if (this.d.size() > 0) {
            e(i);
        }
        return this.c.doFinal();
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public int getHLen() {
        return this.e;
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public void init(byte[] bArr) {
        try {
            this.c.init(new SecretKeySpec(bArr, this.f19162a));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void b(byte[] bArr, int i, int i2) {
        try {
            if (this.d.size() + i2 > 4096) {
                e(0);
            }
            this.d.write(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    private void e(int i) {
        byte[] byteArray = this.d.toByteArray();
        int length = byteArray.length - i;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 16;
            this.c.update(byteArray, i2, i3 <= length ? 16 : length - i2);
            i2 = i3;
        }
        this.d.reset();
    }
}
