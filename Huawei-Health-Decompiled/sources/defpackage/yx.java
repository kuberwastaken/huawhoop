package defpackage;

import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class yx implements Serializable {
    private static final long serialVersionUID = -1;
    protected final String c;
    protected Nulls e;
    protected final transient c f;
    protected final String g;
    protected final Integer h;
    protected Nulls i;
    protected final Boolean j;
    public static final yx d = new yx(Boolean.TRUE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yx f19371a = new yx(Boolean.FALSE, null, null, null, null, null, null);
    public static final yx b = new yx(null, null, null, null, null, null, null);

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnnotatedMember f19372a;
        public final boolean e;

        protected c(AnnotatedMember annotatedMember, boolean z) {
            this.f19372a = annotatedMember;
            this.e = z;
        }

        public static c e(AnnotatedMember annotatedMember) {
            return new c(annotatedMember, true);
        }

        public static c d(AnnotatedMember annotatedMember) {
            return new c(annotatedMember, false);
        }

        public static c c(AnnotatedMember annotatedMember) {
            return new c(annotatedMember, false);
        }
    }

    protected yx(Boolean bool, String str, Integer num, String str2, c cVar, Nulls nulls, Nulls nulls2) {
        this.j = bool;
        this.g = str;
        this.h = num;
        this.c = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f = cVar;
        this.i = nulls;
        this.e = nulls2;
    }

    public static yx c(Boolean bool, String str, Integer num, String str2) {
        if (str != null || num != null || str2 != null) {
            return new yx(bool, str, num, str2, null, null, null);
        }
        if (bool == null) {
            return b;
        }
        return bool.booleanValue() ? d : f19371a;
    }

    protected Object readResolve() {
        if (this.g != null || this.h != null || this.c != null || this.f != null || this.i != null || this.e != null) {
            return this;
        }
        Boolean bool = this.j;
        if (bool == null) {
            return b;
        }
        return bool.booleanValue() ? d : f19371a;
    }

    public yx c(String str) {
        return new yx(this.j, str, this.h, this.c, this.f, this.i, this.e);
    }

    public yx c(c cVar) {
        return new yx(this.j, this.g, this.h, this.c, cVar, this.i, this.e);
    }

    public yx c(Nulls nulls, Nulls nulls2) {
        return new yx(this.j, this.g, this.h, this.c, this.f, nulls, nulls2);
    }

    public boolean g() {
        Boolean bool = this.j;
        return bool != null && bool.booleanValue();
    }

    public Integer c() {
        return this.h;
    }

    public boolean b() {
        return this.h != null;
    }

    public c d() {
        return this.f;
    }

    public Nulls a() {
        return this.i;
    }

    public Nulls e() {
        return this.e;
    }
}
