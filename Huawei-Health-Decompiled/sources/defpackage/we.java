package defpackage;

import com.careforeyou.library.bean.RoleInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class we {
    private static byte a(byte b, byte b2) {
        return (byte) (((byte) (b << 4)) | b2);
    }

    private static byte d(byte b, byte b2) {
        return (byte) (b == 1 ? b2 | UnsignedBytes.MAX_POWER_OF_TWO : b2 & Ascii.DEL);
    }

    public static ArrayList<byte[]> a(ArrayList<vr> arrayList) {
        ArrayList<byte[]> arrayList2 = new ArrayList<>();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        char c = 3;
        if (arrayList.size() == 1) {
            vr vrVar = arrayList.get(0);
            byte[] bArr = new byte[20];
            bArr[0] = -54;
            bArr[1] = 17;
            bArr[2] = 16;
            bArr[3] = 16;
            bArr[4] = a((byte) 1, (byte) 1);
            wh.b(bArr, iCurrentTimeMillis, 5);
            bArr[9] = 0;
            bArr[10] = 0;
            wh.b(bArr, vrVar.c, 11);
            bArr[15] = d(vrVar.e, vrVar.d);
            bArr[16] = vrVar.b;
            wh.e(bArr, vrVar.f18763a, 17);
            bArr[19] = wh.c(bArr, 1, 18);
            arrayList2.add(bArr);
        } else {
            int i = 6;
            int size = (arrayList.size() * 8) + 6;
            byte[] bArr2 = new byte[size];
            wh.b(bArr2, iCurrentTimeMillis, 0);
            bArr2[4] = 0;
            bArr2[5] = 0;
            for (vr vrVar2 : arrayList) {
                wh.b(bArr2, vrVar2.c, i);
                bArr2[i + 4] = d(vrVar2.e, vrVar2.d);
                bArr2[i + 5] = vrVar2.b;
                wh.e(bArr2, vrVar2.f18763a, i + 6);
                i += 8;
            }
            int i2 = size / 14;
            int i3 = 14;
            int i4 = size % 14;
            if (i4 > 0) {
                i2++;
            }
            int i5 = 0;
            while (i5 < i2) {
                int i6 = (i5 != i2 + (-1) || i4 == 0) ? i3 : i4;
                byte[] bArr3 = new byte[i6 + 6];
                bArr3[0] = -54;
                bArr3[1] = 17;
                bArr3[2] = (byte) (i6 + 2);
                bArr3[c] = 16;
                int i7 = i5 + 1;
                bArr3[4] = a((byte) i7, (byte) i2);
                System.arraycopy(bArr2, i5 * 14, bArr3, 5, i6);
                bArr3[i6 + 5] = wh.c(bArr3, 1, i6 + 4);
                arrayList2.add(bArr3);
                i5 = i7;
                i3 = 14;
                c = 3;
            }
        }
        return arrayList2;
    }

    public static byte[] d(int i, byte b, byte b2, int i2) {
        byte[] bArr = new byte[20];
        String[] strArrSplit = new SimpleDateFormat("yy:MM:dd:HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())).split(":");
        bArr[0] = -54;
        bArr[1] = 16;
        bArr[2] = 14;
        bArr[3] = 1;
        bArr[4] = (byte) (Integer.parseInt(strArrSplit[0]) & 255);
        bArr[5] = (byte) (Integer.parseInt(strArrSplit[1]) & 255);
        bArr[6] = (byte) (Integer.parseInt(strArrSplit[2]) & 255);
        bArr[7] = (byte) (Integer.parseInt(strArrSplit[3]) & 255);
        bArr[8] = (byte) (Integer.parseInt(strArrSplit[4]) & 255);
        bArr[9] = (byte) (Integer.parseInt(strArrSplit[5]) & 255);
        wh.b(bArr, i, 10);
        bArr[14] = (byte) (b & UnsignedBytes.MAX_VALUE);
        bArr[15] = (byte) (i2 & 255);
        bArr[16] = (byte) (b2 & UnsignedBytes.MAX_VALUE);
        bArr[17] = wh.c(bArr, 1, 16);
        bArr[18] = 0;
        bArr[19] = 0;
        return bArr;
    }

    public static byte[] e(RoleInfo roleInfo) {
        byte[] bArr = new byte[9];
        byte age = (byte) (roleInfo.getAge() & 255);
        byte sex = (byte) roleInfo.getSex();
        bArr[0] = -96;
        wh.b(bArr, roleInfo.getId(), 1);
        bArr[5] = d(sex, age);
        bArr[6] = (byte) (roleInfo.getHeight() & 255);
        wh.e(bArr, (short) (roleInfo.getWeight() * 10.0f), 7);
        return bArr;
    }
}
