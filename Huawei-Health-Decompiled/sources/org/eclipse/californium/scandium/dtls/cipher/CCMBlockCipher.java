package org.eclipse.californium.scandium.dtls.cipher;

import androidx.media3.extractor.WavUtil;
import com.huawei.openalliance.ad.constant.Constants;
import defpackage.yjf;
import defpackage.yjj;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes8.dex */
public class CCMBlockCipher {
    private static final yjj d = new yjj("AES/ECB/NoPadding");

    static abstract class Block {
        protected final byte[] block;
        protected final int blockSize;

        protected Block(int i) {
            this.blockSize = i;
            this.block = new byte[i];
        }

        protected int setIntAtEnd(int i, int i2) {
            int i3 = this.blockSize;
            while (i3 > i) {
                i3--;
                this.block[i3] = (byte) i2;
                i2 >>>= 8;
            }
            return i2;
        }
    }

    static class a extends Block {
        private final int b;
        private final byte[] c;
        private final Cipher d;

        private a(Cipher cipher, byte[] bArr) {
            super(cipher.getBlockSize());
            this.d = cipher;
            int length = bArr.length;
            this.b = length;
            int i = (this.blockSize - 1) - length;
            if (i < 2 || i > 8) {
                StringBuilder sb = new StringBuilder("Nonce length ");
                sb.append(length);
                sb.append(" invalid for blocksize ");
                sb.append(this.blockSize);
                sb.append(" (valid length [");
                sb.append(this.blockSize - 9);
                sb.append(Constants.LINK);
                sb.append(this.blockSize - 3);
                sb.append("])");
                throw new IllegalArgumentException(sb.toString());
            }
            this.c = new byte[this.blockSize];
            this.block[0] = (byte) (i - 1);
            System.arraycopy(bArr, 0, this.block, 1, length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] c(int i) throws ShortBufferException {
            if (setIntAtEnd(this.b + 1, i) != 0) {
                throw new IllegalArgumentException("Index " + i + " too large for nonce " + this.b + " and blocksize " + this.blockSize + " bytes.");
            }
            this.d.update(this.block, 0, this.blockSize, this.c);
            return this.c;
        }
    }

    static class d extends Block {
        private final byte[] b;
        private final Cipher e;

        private d(Cipher cipher, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws ShortBufferException {
            int i2;
            super(cipher.getBlockSize());
            this.e = cipher;
            int length = bArr3.length;
            int length2 = bArr2.length;
            int length3 = bArr.length;
            int i3 = (this.blockSize - 1) - length3;
            if (i3 < 2 || i3 > 8) {
                StringBuilder sb = new StringBuilder("Nonce length ");
                sb.append(length3);
                sb.append(" invalid for blocksize ");
                sb.append(this.blockSize);
                sb.append(" (valid length [");
                sb.append(this.blockSize - 9);
                sb.append(Constants.LINK);
                sb.append(this.blockSize - 3);
                sb.append("])");
                throw new IllegalArgumentException(sb.toString());
            }
            this.block[0] = (byte) (((length2 > 0 ? 1 : 0) * 64) + (((i - 2) / 2) * 8) + (i3 - 1));
            System.arraycopy(bArr, 0, this.block, 1, length3);
            if (setIntAtEnd(length3 + 1, length) != 0) {
                throw new IllegalArgumentException("Length " + length + " too large for nonce " + length3 + " and blocksize " + this.blockSize + " bytes.");
            }
            cipher.update(this.block, 0, this.blockSize, this.block);
            if (length2 > 0) {
                if (length2 < 65280) {
                    b(0, 2, length2);
                    i2 = 2;
                } else {
                    b(0, 2, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                    b(2, 6, length2);
                    i2 = 6;
                }
                c(bArr2, i2);
            }
            c(bArr3, 0);
            this.b = Arrays.copyOf(this.block, i);
        }

        private void c(byte[] bArr, int i) throws ShortBufferException {
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = (this.blockSize + i2) - i;
                if (i3 > length) {
                    i3 = length;
                }
                while (i2 < i3) {
                    byte[] bArr2 = this.block;
                    bArr2[i] = (byte) (bArr2[i] ^ bArr[i2]);
                    i2++;
                    i++;
                }
                this.e.update(this.block, 0, this.blockSize, this.block);
                i = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] a() {
            return this.b;
        }

        protected int b(int i, int i2, int i3) {
            while (i2 > i) {
                byte[] bArr = this.block;
                i2--;
                bArr[i2] = (byte) (bArr[i2] ^ ((byte) i3));
                i3 >>>= 8;
            }
            return i3;
        }
    }

    public static final byte[] c(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3) throws GeneralSecurityException {
        Cipher cipherE = d.e();
        cipherE.init(1, secretKey);
        int i4 = i2 - i3;
        int blockSize = cipherE.getBlockSize();
        byte[] bArr4 = new byte[i4];
        byte[] bArr5 = new byte[i3];
        a aVar = new a(cipherE, bArr);
        byte[] bArrC = aVar.c(0);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr5[i5] = (byte) (bArr3[(i + i4) + i5] ^ bArrC[i5]);
        }
        int i6 = 1;
        int i7 = 0;
        while (i7 < i4) {
            byte[] bArrC2 = aVar.c(i6);
            int i8 = i7 + blockSize;
            if (i8 > i4) {
                i8 = i4;
            }
            int i9 = 0;
            while (i7 < i8) {
                bArr4[i7] = (byte) (bArr3[i + i7] ^ bArrC2[i9]);
                i7++;
                i9++;
            }
            i6++;
        }
        byte[] bArrA = new d(cipherE, bArr, bArr2, bArr4, i3).a();
        if (MessageDigest.isEqual(bArr5, bArrA)) {
            return bArr4;
        }
        throw new yjf(bArrA, bArr5);
    }

    public static final byte[] e(int i, SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) throws GeneralSecurityException {
        Cipher cipherE = d.e();
        cipherE.init(1, secretKey);
        int blockSize = cipherE.getBlockSize();
        int length = bArr3.length;
        byte[] bArrA = new d(cipherE, bArr, bArr2, bArr3, i2).a();
        int i3 = i + length;
        byte[] bArr4 = new byte[i3 + i2];
        a aVar = new a(cipherE, bArr);
        byte[] bArrC = aVar.c(0);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4[i4 + i3] = (byte) (bArrA[i4] ^ bArrC[i4]);
        }
        int i5 = 0;
        int i6 = 1;
        while (i5 < length) {
            byte[] bArrC2 = aVar.c(i6);
            int i7 = i5 + blockSize;
            if (i7 > length) {
                i7 = length;
            }
            int i8 = 0;
            while (i5 < i7) {
                bArr4[i5 + i] = (byte) (bArr3[i5] ^ bArrC2[i8]);
                i5++;
                i8++;
            }
            i6++;
        }
        return bArr4;
    }
}
