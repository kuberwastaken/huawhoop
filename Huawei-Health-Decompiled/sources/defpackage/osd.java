package defpackage;

import com.huawei.multisimsdk.multidevicemanager.common.AuthParam;

/* JADX INFO: loaded from: classes7.dex */
public class osd extends AuthParam {
    private int c;
    private int i = 0;
    private String d = "";
    private String b = "";
    private String g = "";
    private String j = "";
    private String e = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16541a = "";

    public osd(int i) {
        this.c = 3;
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public int getAuthType() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public void setSlotId(int i) {
        this.i = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public int getSlotId() {
        return ((Integer) kqt.e(Integer.valueOf(this.i))).intValue();
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public void setImsi(String str) {
        this.d = (String) kqt.e(str);
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public String getImsi() {
        return (String) kqt.e(this.d);
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public String getCiphertext() {
        return this.e;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public void setCiphertext(String str) {
        this.e = str;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public String getCiphertextSign() {
        return this.f16541a;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public void setCiphertextSign(String str) {
        this.f16541a = str;
    }

    @Override // com.huawei.multisimsdk.multidevicemanager.common.AuthParam
    public String getPhoneNumber() {
        return (String) kqt.e(this.j);
    }
}
