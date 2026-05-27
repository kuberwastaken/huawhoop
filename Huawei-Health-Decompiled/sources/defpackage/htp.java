package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class htp implements Serializable {
    private static final long serialVersionUID = 1552433626961149315L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("allergies")
    private String f13969a;

    @SerializedName("blood_type")
    private int b;

    @SerializedName("emergency_contacts")
    private ArrayList<e> c;

    @SerializedName("medications")
    private String d;

    @SerializedName("medical_conditions")
    private String e;

    @SerializedName("address")
    private String f;

    @SerializedName("organ_donor")
    private int g;

    @SerializedName("name")
    private String j;

    public void a(String str) {
        this.j = str;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public int e() {
        return this.b;
    }

    public String d() {
        return this.f13969a;
    }

    public void d(String str) {
        this.f13969a = str;
    }

    public String b() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public void a(int i) {
        this.b = i;
    }

    public int j() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public String c() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public ArrayList<e> a() {
        return this.c;
    }

    public void b(ArrayList<e> arrayList) {
        this.c = arrayList;
    }

    public String toString() {
        return "EmergencyInfo{personalName='" + this.j + "', personalAddress='" + this.f + "', bloodType=" + this.b + ", allergies='" + this.f13969a + "', medications='" + this.d + "', organDonor=" + this.g + ", medicalConditionsAndAdditionalInfo='" + this.e + "', contactList=" + this.c + '}';
    }

    public static class e implements Serializable {
        private static final long serialVersionUID = -1676005475288730958L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("contactName")
        private String f13970a;

        @SerializedName("contactIndex")
        private int c;

        @SerializedName("phoneNumber")
        private String d;

        @SerializedName("contactPhoto")
        private byte[] e;

        public int a() {
            return this.c;
        }

        public void b(int i) {
            this.c = i;
        }

        public String d() {
            return this.f13970a;
        }

        public void b(String str) {
            this.f13970a = str;
        }

        public String e() {
            return this.d;
        }

        public void a(String str) {
            this.d = str;
        }

        public byte[] b() {
            byte[] bArr = this.e;
            return bArr == null ? new byte[0] : (byte[]) bArr.clone();
        }

        public void a(byte[] bArr) {
            if (bArr == null) {
                this.e = new byte[0];
            } else {
                this.e = (byte[]) bArr.clone();
            }
        }

        public String toString() {
            return "Contact{contactIndex=" + this.c + ", contactName='" + this.f13970a + "', phoneNumber='" + this.d + "', contactPhoto=" + Arrays.toString(this.e) + '}';
        }
    }
}
