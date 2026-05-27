package com.fasterxml.jackson.core.format;

import com.huawei.operation.utils.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes9.dex */
public interface InputAccessor {
    boolean hasMoreBytes() throws IOException;

    byte nextByte() throws IOException;

    void reset();

    public static class c implements InputAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f1660a;
        protected final byte[] b;
        protected final InputStream c = null;
        protected int d;
        protected final int e;

        public c(byte[] bArr, int i, int i2) {
            this.b = bArr;
            this.d = i;
            this.e = i;
            this.f1660a = i + i2;
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public boolean hasMoreBytes() throws IOException {
            int i;
            int i2 = this.d;
            if (i2 < this.f1660a) {
                return true;
            }
            InputStream inputStream = this.c;
            if (inputStream == null) {
                return false;
            }
            byte[] bArr = this.b;
            int length = bArr.length - i2;
            if (length < 1 || (i = inputStream.read(bArr, i2, length)) <= 0) {
                return false;
            }
            this.f1660a += i;
            return true;
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public byte nextByte() throws IOException {
            if (this.d >= this.f1660a && !hasMoreBytes()) {
                throw new EOFException("Failed auto-detect: could not read more than " + this.d + " bytes (max buffer size: " + this.b.length + Constants.RIGHT_BRACKET_ONLY);
            }
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            return bArr[i];
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public void reset() {
            this.d = this.e;
        }
    }
}
