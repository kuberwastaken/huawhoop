package org.eclipse.californium.scandium.util;

import defpackage.ygp;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.eclipse.californium.elements.util.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public class ServerName {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f16535a = StandardCharsets.US_ASCII;
    private final int b;
    private final byte[] d;
    private final NameType e;

    private ServerName(NameType nameType, byte[] bArr) {
        this.e = nameType;
        this.d = bArr;
        this.b = (Arrays.hashCode(bArr) * 31) + nameType.hashCode();
    }

    public static ServerName a(NameType nameType, byte[] bArr) {
        if (nameType == null) {
            throw new NullPointerException("type must not be null");
        }
        if (bArr == null) {
            throw new NullPointerException("name must not be null");
        }
        if (nameType == NameType.HOST_NAME) {
            return d(new String(bArr, f16535a));
        }
        return new ServerName(nameType, bArr);
    }

    public static ServerName d(String str) {
        if (str == null) {
            throw new NullPointerException("host name must not be null");
        }
        if (ygp.a(str)) {
            return new ServerName(NameType.HOST_NAME, str.toLowerCase().getBytes(f16535a));
        }
        throw new IllegalArgumentException("not a valid host name");
    }

    public int c() {
        return this.d.length;
    }

    public byte[] a() {
        return this.d;
    }

    public String b() {
        return new String(this.d, f16535a);
    }

    public NameType d() {
        return this.e;
    }

    public int hashCode() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerName serverName = (ServerName) obj;
        if (this.e != serverName.e) {
            return false;
        }
        return Arrays.equals(this.d, serverName.d);
    }

    public enum NameType {
        HOST_NAME((byte) 0),
        UNDEFINED((byte) -1);

        private final byte code;

        NameType(byte b) {
            this.code = b;
        }

        public byte getCode() {
            return this.code;
        }

        public static NameType fromCode(byte b) {
            for (NameType nameType : values()) {
                if (nameType.code == b) {
                    return nameType;
                }
            }
            return UNDEFINED;
        }
    }
}
