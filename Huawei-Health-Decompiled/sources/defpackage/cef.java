package defpackage;

import com.huawei.devicesdk.entity.CharacterOperationType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f607a;
    private String b;
    private List<ceh> e = new ArrayList(16);
    private CharacterOperationType d = CharacterOperationType.WRITE;
    private int c = 0;
    private int g = 0;

    public CharacterOperationType c() {
        return this.d;
    }

    public void c(CharacterOperationType characterOperationType) {
        this.d = characterOperationType;
    }

    public List<ceh> d() {
        return this.e;
    }

    public void b(List<ceh> list) {
        this.e = list;
    }

    public String e() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String a() {
        return this.f607a;
    }

    public void e(String str) {
        this.f607a = str;
    }

    public int b() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public int g() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }
}
