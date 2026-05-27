package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: loaded from: classes2.dex */
public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        Assertions.checkArgument((bArr2 == null) ^ (i == 0));
        this.isEncrypted = z;
        this.schemeType = str;
        this.perSampleIvSize = i;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i2, i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int schemeToCryptoMode(java.lang.String r4) {
        /*
            r0 = 1
            if (r4 != 0) goto L4
            return r0
        L4:
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = 3
            r3 = 2
            switch(r1) {
                case 3046605: goto L32;
                case 3046671: goto L27;
                case 3049879: goto L1c;
                case 3049895: goto L11;
                default: goto L10;
            }
        L10:
            goto L3d
        L11:
            java.lang.String r1 = "cens"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L1a
            goto L3d
        L1a:
            r1 = r2
            goto L3e
        L1c:
            java.lang.String r1 = "cenc"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L25
            goto L3d
        L25:
            r1 = r3
            goto L3e
        L27:
            java.lang.String r1 = "cbcs"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L30
            goto L3d
        L30:
            r1 = r0
            goto L3e
        L32:
            java.lang.String r1 = "cbc1"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L3b
            goto L3d
        L3b:
            r1 = 0
            goto L3e
        L3d:
            r1 = -1
        L3e:
            if (r1 == 0) goto L5f
            if (r1 == r0) goto L5f
            if (r1 == r3) goto L5e
            if (r1 == r2) goto L5e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported protection scheme type '"
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = "'. Assuming AES-CTR crypto mode."
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r1 = "TrackEncryptionBox"
            androidx.media3.common.util.Log.w(r1, r4)
        L5e:
            return r0
        L5f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.TrackEncryptionBox.schemeToCryptoMode(java.lang.String):int");
    }
}
