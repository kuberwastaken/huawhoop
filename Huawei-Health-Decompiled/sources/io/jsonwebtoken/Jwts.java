package io.jsonwebtoken;

import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.security.X509Builder;

/* JADX INFO: loaded from: classes11.dex */
public final class Jwts {

    public interface HeaderBuilder extends JweHeaderMutator<HeaderBuilder>, X509Builder<HeaderBuilder>, Builder<Header> {
    }
}
