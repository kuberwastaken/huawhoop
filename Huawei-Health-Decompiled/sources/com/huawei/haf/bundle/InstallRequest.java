package com.huawei.haf.bundle;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class InstallRequest {
    private final List<String> d;

    private InstallRequest(Builder builder) {
        this.d = builder.c;
    }

    public static Builder d() {
        return new Builder();
    }

    public List<String> a() {
        return this.d;
    }

    public static class Builder {
        private final List<String> c;

        private Builder() {
            this.c = new ArrayList();
        }

        public Builder d(String str) {
            if (!TextUtils.isEmpty(str) && !this.c.contains(str)) {
                this.c.add(str);
            }
            return this;
        }

        public InstallRequest c() {
            return new InstallRequest(this);
        }
    }
}
