package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class sqa {
    private final List<sqe> b;
    private final String c;
    private final int d;

    public sqa(int i, String str, List<sqe> list) {
        this.d = i;
        this.c = str;
        this.b = list;
    }

    public int e() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public List<sqe> a() {
        return this.b;
    }

    public String toString() {
        return "QuestionBean [questionId=" + this.d + ", description=" + this.c + ", questionOptions=" + this.b + "]";
    }
}
