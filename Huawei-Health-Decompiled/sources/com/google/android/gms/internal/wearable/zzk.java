package com.google.android.gms.internal.wearable;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.haf.router.AppRouterExtras;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzk {
    private final byte[] buffer;
    private final int zzgr;
    private final int zzgs;
    private int zzgt;
    private int zzgu;
    private int zzgv;
    private int zzgw;
    private int zzgy;
    private int zzgx = Integer.MAX_VALUE;
    private int zzgz = 64;
    private int zzha = AppRouterExtras.COLDSTART;

    public static zzk zza(byte[] bArr, int i, int i2) {
        return new zzk(bArr, 0, i2);
    }

    public final int zzj() throws IOException {
        if (this.zzgv == this.zzgt) {
            this.zzgw = 0;
            return 0;
        }
        int iZzk = zzk();
        this.zzgw = iZzk;
        if (iZzk != 0) {
            return iZzk;
        }
        throw new zzs("Protocol message contained an invalid tag (zero).");
    }

    public final void zzc(int i) throws zzs {
        if (this.zzgw != i) {
            throw new zzs("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzd(int i) throws IOException {
        int iZzj;
        int i2 = i & 7;
        if (i2 == 0) {
            zzk();
            return true;
        }
        if (i2 == 1) {
            zzn();
            return true;
        }
        if (i2 == 2) {
            zzh(zzk());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzm();
                return true;
            }
            throw new zzs("Protocol message tag had invalid wire type.");
        }
        do {
            iZzj = zzj();
            if (iZzj == 0) {
                break;
            }
        } while (zzd(iZzj));
        zzc(((i >>> 3) << 3) | 4);
        return true;
    }

    public final String readString() throws IOException {
        int iZzk = zzk();
        if (iZzk < 0) {
            throw zzs.zzv();
        }
        int i = this.zzgt;
        int i2 = this.zzgv;
        if (iZzk > i - i2) {
            throw zzs.zzu();
        }
        String str = new String(this.buffer, i2, iZzk, zzr.UTF_8);
        this.zzgv += iZzk;
        return str;
    }

    public final void zza(zzt zztVar) throws IOException {
        int iZzk = zzk();
        if (this.zzgy >= this.zzgz) {
            throw new zzs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZze = zze(iZzk);
        this.zzgy++;
        zztVar.zza(this);
        zzc(0);
        this.zzgy--;
        zzf(iZze);
    }

    public final byte[] readBytes() throws IOException {
        int iZzk = zzk();
        if (iZzk < 0) {
            throw zzs.zzv();
        }
        if (iZzk == 0) {
            return zzw.zzhy;
        }
        int i = this.zzgt;
        int i2 = this.zzgv;
        if (iZzk > i - i2) {
            throw zzs.zzu();
        }
        byte[] bArr = new byte[iZzk];
        System.arraycopy(this.buffer, i2, bArr, 0, iZzk);
        this.zzgv += iZzk;
        return bArr;
    }

    public final int zzk() throws IOException {
        int i;
        byte bZzq = zzq();
        if (bZzq >= 0) {
            return bZzq;
        }
        int i2 = bZzq & Ascii.DEL;
        byte bZzq2 = zzq();
        if (bZzq2 >= 0) {
            i = bZzq2 << 7;
        } else {
            i2 |= (bZzq2 & Ascii.DEL) << 7;
            byte bZzq3 = zzq();
            if (bZzq3 >= 0) {
                i = bZzq3 << 14;
            } else {
                i2 |= (bZzq3 & Ascii.DEL) << 14;
                byte bZzq4 = zzq();
                if (bZzq4 < 0) {
                    byte bZzq5 = zzq();
                    int i3 = i2 | ((bZzq4 & Ascii.DEL) << 21) | (bZzq5 << Ascii.FS);
                    if (bZzq5 >= 0) {
                        return i3;
                    }
                    for (int i4 = 0; i4 < 5; i4++) {
                        if (zzq() >= 0) {
                            return i3;
                        }
                    }
                    throw zzs.zzw();
                }
                i = bZzq4 << Ascii.NAK;
            }
        }
        return i2 | i;
    }

    public final long zzl() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzq = zzq();
            j |= ((long) (bZzq & Ascii.DEL)) << i;
            if ((bZzq & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw zzs.zzw();
    }

    public final int zzm() throws IOException {
        return (zzq() & UnsignedBytes.MAX_VALUE) | ((zzq() & UnsignedBytes.MAX_VALUE) << 8) | ((zzq() & UnsignedBytes.MAX_VALUE) << 16) | ((zzq() & UnsignedBytes.MAX_VALUE) << 24);
    }

    public final long zzn() throws IOException {
        byte bZzq = zzq();
        return ((((long) zzq()) & 255) << 8) | (((long) bZzq) & 255) | ((((long) zzq()) & 255) << 16) | ((((long) zzq()) & 255) << 24) | ((((long) zzq()) & 255) << 32) | ((((long) zzq()) & 255) << 40) | ((((long) zzq()) & 255) << 48) | ((((long) zzq()) & 255) << 56);
    }

    private zzk(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzgr = i;
        int i3 = i2 + i;
        this.zzgt = i3;
        this.zzgs = i3;
        this.zzgv = i;
    }

    public final int zze(int i) throws zzs {
        if (i < 0) {
            throw zzs.zzv();
        }
        int i2 = i + this.zzgv;
        int i3 = this.zzgx;
        if (i2 > i3) {
            throw zzs.zzu();
        }
        this.zzgx = i2;
        zzo();
        return i3;
    }

    private final void zzo() {
        int i = this.zzgt + this.zzgu;
        this.zzgt = i;
        int i2 = this.zzgx;
        if (i > i2) {
            int i3 = i - i2;
            this.zzgu = i3;
            this.zzgt = i - i3;
            return;
        }
        this.zzgu = 0;
    }

    public final void zzf(int i) {
        this.zzgx = i;
        zzo();
    }

    public final int zzp() {
        int i = this.zzgx;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzgv;
    }

    public final int getPosition() {
        return this.zzgv - this.zzgr;
    }

    public final byte[] zzb(int i, int i2) {
        if (i2 == 0) {
            return zzw.zzhy;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzgr + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzg(int i) {
        zzc(i, this.zzgw);
    }

    final void zzc(int i, int i2) {
        int i3 = this.zzgv;
        int i4 = this.zzgr;
        if (i > i3 - i4) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3 - i4);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i < 0) {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.zzgv = i4 + i;
        this.zzgw = i2;
    }

    private final byte zzq() throws IOException {
        int i = this.zzgv;
        if (i == this.zzgt) {
            throw zzs.zzu();
        }
        byte[] bArr = this.buffer;
        this.zzgv = i + 1;
        return bArr[i];
    }

    private final void zzh(int i) throws IOException {
        if (i < 0) {
            throw zzs.zzv();
        }
        int i2 = this.zzgv;
        int i3 = this.zzgx;
        int i4 = i2 + i;
        if (i4 > i3) {
            zzh(i3 - i2);
            throw zzs.zzu();
        }
        if (i <= this.zzgt - i2) {
            this.zzgv = i4;
            return;
        }
        throw zzs.zzu();
    }
}
