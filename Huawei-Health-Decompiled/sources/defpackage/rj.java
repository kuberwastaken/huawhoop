package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class rj extends rf {
    private final String b;

    public rj(String str) {
        super(String.format("The Claim '%s' is not present in the JWT.", str));
        this.b = str;
    }
}
