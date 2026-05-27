package com.huawei.harmonyos.interwork.base.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.harmonyos.interwork.base.utils.Uri;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Uri implements Parcelable, Comparable<Uri> {
    private static final int DEFAULT_PORT = -1;
    private static final int FIRST_POS = 0;
    private static final char FRAGMENT_SEPARATOR = '#';
    private static final int HEXADECIMAL = 16;
    private static final int HEXVALUE_BEGIN = 10;
    private static final int HIERARCHICAL_URI = 2;
    private static final int HIGH_MASK = 240;
    private static final String INVALID_INPUT_CHARACTER = "�";
    private static final char LOWER_CASE_BEGIN = 'a';
    private static final char LOWER_CASE_F = 'f';
    private static final int LOW_MASK = 15;
    private static final int NOT_FOUND = -1;
    private static final char NUMBER_BEGIN = '0';
    private static final char NUMBER_END = '9';
    private static final int OPAQUE_URI = 1;
    private static final String PATH_ALLOW = "/";
    private static final char PERCENT_SIGN = '%';
    private static final int POS_INC = 1;
    private static final int POS_INC_MORE = 2;
    private static final char QUERY_FLAG = '?';
    private static final char RIGHT_SEPARATOR = '\\';
    private static final char SCHEME_FRAGMENT = '#';
    private static final char SCHEME_SEPARATOR = ':';
    private static final int SECOND_POS = 1;
    private static final char SLASH_SEPARATOR = '/';
    private static final char UPPER_CASE_BEGIN = 'A';
    private static final char UPPER_CASE_F = 'F';
    String scheme;
    public static final Parcelable.Creator<Uri> CREATOR = new Parcelable.Creator<Uri>() { // from class: com.huawei.harmonyos.interwork.base.utils.Uri.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: BQ_, reason: merged with bridge method [inline-methods] */
        public final Uri createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            if (i == 1) {
                return OpaqueUri.makeFromParcel(parcel);
            }
            if (i == 2) {
                return HierarchicalUri.makeFromParcel(parcel);
            }
            throw new IllegalArgumentException("unsupported URI type.");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Uri[] newArray(int i) {
            return new Uri[i];
        }
    };
    private static final Pattern URI_SCHEME_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9|\\+|\\-|\\.]*$");
    private static final char[] HEXADECIMAL_DIGITS = "0123456789ABCDEF".toCharArray();

    private static int hexCharToValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - NUMBER_BEGIN;
        }
        int i = 97;
        if (c < 'a' || c > 'f') {
            i = 65;
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c + '\n') - i;
    }

    public abstract b buildUpon();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getDecodedAuthority();

    public abstract String getDecodedFragment();

    public abstract String getDecodedHost();

    public abstract String getDecodedPath();

    public abstract List<String> getDecodedPathList();

    public abstract String getDecodedQuery();

    public abstract Map<String, List<String>> getDecodedQueryParams();

    public abstract String getDecodedSchemeSpecificPart();

    public abstract String getDecodedUserInfo();

    public abstract String getEncodedAuthority();

    public abstract String getEncodedFragment();

    public abstract String getEncodedHost();

    public abstract String getEncodedPath();

    public abstract String getEncodedQuery();

    public abstract String getEncodedSchemeSpecificPart();

    public abstract String getEncodedUserInfo();

    public abstract int getPort();

    public abstract boolean isHierarchical();

    public abstract String toString();

    private Uri(String str) {
        this.scheme = str;
    }

    public boolean isOpaque() {
        return !isHierarchical();
    }

    public boolean isRelative() {
        return this.scheme == null;
    }

    public boolean isAbsolute() {
        return !isRelative();
    }

    public String getScheme() {
        return this.scheme;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2206a;
        private e b;
        private e c;
        private e d;
        private e e;
        private e g;

        public final b h(String str) {
            this.f2206a = str;
            return this;
        }

        final b c(e eVar) {
            this.g = eVar;
            return this;
        }

        public final b c(String str) {
            return c(e.b(null, str));
        }

        final b b(e eVar) {
            this.b = eVar;
            return this;
        }

        public final b e(String str) {
            return b(e.b(null, str));
        }

        final b a(e eVar) {
            this.d = eVar;
            return this;
        }

        public final b b(String str) {
            return a(e.b(null, str));
        }

        public final b d(String str) {
            e eVar = this.d;
            if (eVar == null) {
                return b("/".concat(String.valueOf(str)));
            }
            String strE = eVar.e("/");
            if (!strE.endsWith("/")) {
                strE = strE + "/";
            }
            return b(strE + str);
        }

        final b e(e eVar) {
            this.c = eVar;
            return this;
        }

        public final b i(String str) {
            return e(e.b(null, str));
        }

        final b d(e eVar) {
            this.e = eVar;
            return this;
        }

        public final b a(String str) {
            return d(e.b(null, str));
        }

        public final Uri d() {
            e eVar;
            if (this.g != null) {
                if (this.f2206a == null) {
                    throw new UnsupportedOperationException("The scheme part can't be null.");
                }
                return new OpaqueUri(this.f2206a, this.g, this.e);
            }
            if ((this.f2206a != null || this.b != null) && (eVar = this.d) != null) {
                eVar.e();
            }
            return new HierarchicalUri(this.f2206a, this.b, this.d, this.c, this.e);
        }
    }

    public static class HierarchicalUri extends Uri {
        private e authority;
        private e fragment;
        private e host;
        private final Object lock;
        private e path;
        private volatile List<String> pathList;
        private Integer port;
        private e query;
        private volatile Map<String, List<String>> queryParamMap;
        private e ssp;
        private String uriStrCache;
        private e userInfo;

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public boolean isHierarchical() {
            return true;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        private HierarchicalUri(String str, e eVar, e eVar2, e eVar3, e eVar4) {
            super(str);
            this.lock = new Object();
            this.authority = eVar;
            this.path = eVar2;
            this.query = eVar3;
            this.fragment = eVar4;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (parcel == null) {
                return;
            }
            parcel.writeInt(2);
            parcel.writeString(this.scheme);
            e.BS_(this.authority, parcel, null);
            e.BS_(this.path, parcel, "/");
            e.BS_(this.query, parcel, null);
            e.BS_(this.fragment, parcel, null);
        }

        public static HierarchicalUri makeFromParcel(Parcel parcel) {
            return new HierarchicalUri(parcel.readString(), e.BR_(parcel), e.BR_(parcel), e.BR_(parcel), e.BR_(parcel));
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedSchemeSpecificPart() {
            return e.c(generateSsp().orElse(null)).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedSchemeSpecificPart() {
            return e.a(generateSsp().orElse(null), "/").orElse(null);
        }

        private Optional<e> generateSsp() {
            e eVar = this.ssp;
            if (eVar != null) {
                return Optional.ofNullable(eVar);
            }
            final StringBuilder sb = new StringBuilder();
            Optional.ofNullable(this.authority).ifPresent(new Consumer() { // from class: csu
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Uri.HierarchicalUri.lambda$generateSsp$0(sb, (Uri.e) obj);
                }
            });
            Optional.ofNullable(this.path).ifPresent(new Consumer() { // from class: css
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Uri.HierarchicalUri.lambda$generateSsp$1(sb, (Uri.e) obj);
                }
            });
            Optional.ofNullable(this.query).ifPresent(new Consumer() { // from class: cst
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Uri.HierarchicalUri.lambda$generateSsp$2(sb, (Uri.e) obj);
                }
            });
            if (sb.length() == 0) {
                return Optional.empty();
            }
            e eVarB = e.b(null, sb.toString());
            this.ssp = eVarB;
            return Optional.ofNullable(eVarB);
        }

        public static /* synthetic */ void lambda$generateSsp$0(StringBuilder sb, e eVar) {
            String strE = eVar.e(null);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            sb.append("//");
            sb.append(strE);
        }

        public static /* synthetic */ void lambda$generateSsp$1(StringBuilder sb, e eVar) {
            String strE = eVar.e("/");
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            sb.append(strE);
        }

        public static /* synthetic */ void lambda$generateSsp$2(StringBuilder sb, e eVar) {
            String strE = eVar.e(null);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            sb.append("?");
            sb.append(strE);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedAuthority() {
            return e.c(this.authority).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedAuthority() {
            return e.a(this.authority, null).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedUserInfo() {
            return e.c(generateUserInfo(false)).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedUserInfo() {
            return e.a(generateUserInfo(true), null).orElse(null);
        }

        private e generateUserInfo(boolean z) {
            if (this.userInfo == null) {
                generateAuthority();
            }
            return this.userInfo;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedHost() {
            return e.c(generateHost()).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedHost() {
            return e.a(generateHost(), null).orElse(null);
        }

        private e generateHost() {
            if (this.host == null) {
                generateAuthority();
            }
            return this.host;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public int getPort() {
            return generatePort().intValue();
        }

        private Integer generatePort() {
            if (this.port == null) {
                generateAuthority();
            }
            return this.port;
        }

        private void generateAuthority() {
            String strSubstring;
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null) {
                this.port = -1;
                return;
            }
            int iLastIndexOf = encodedAuthority.lastIndexOf(64);
            this.userInfo = iLastIndexOf == -1 ? null : e.b(null, encodedAuthority.substring(0, iLastIndexOf));
            int iFindPortIndex = findPortIndex(encodedAuthority);
            int i = iLastIndexOf + 1;
            if (iFindPortIndex == -1) {
                strSubstring = encodedAuthority.substring(i);
            } else {
                strSubstring = encodedAuthority.substring(i, iFindPortIndex);
            }
            this.host = e.b(null, strSubstring);
            if (iFindPortIndex == -1) {
                this.port = -1;
            }
            try {
                this.port = Integer.valueOf(Integer.parseInt(decode(encodedAuthority.substring(iFindPortIndex + 1))));
            } catch (NumberFormatException unused) {
                this.port = -1;
            }
        }

        private int findPortIndex(String str) {
            if (str == null || str.isEmpty()) {
                return -1;
            }
            for (int length = str.length() - 1; length >= 0; length--) {
                char cCharAt = str.charAt(length);
                if (cCharAt == ':') {
                    return length;
                }
                if (cCharAt < '0' || cCharAt > '9') {
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedPath() {
            return e.c(this.path).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedPath() {
            return e.a(this.path, "/").orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedQuery() {
            return e.c(this.query).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedQuery() {
            return e.a(this.query, null).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public List<String> getDecodedPathList() {
            if (this.pathList != null) {
                return this.pathList;
            }
            String encodedPath = getEncodedPath();
            int i = 0;
            if (encodedPath == null) {
                ArrayList arrayList = new ArrayList(0);
                this.pathList = arrayList;
                return arrayList;
            }
            synchronized (this.lock) {
                if (this.pathList != null) {
                    return this.pathList;
                }
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int iIndexOf = encodedPath.indexOf(47, i);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if (i < iIndexOf) {
                        arrayList2.add(decode(encodedPath.substring(i, iIndexOf)));
                    }
                    i = iIndexOf + 1;
                }
                if (i < encodedPath.length()) {
                    arrayList2.add(decode(encodedPath.substring(i)));
                }
                this.pathList = arrayList2;
                return arrayList2;
            }
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public Map<String, List<String>> getDecodedQueryParams() {
            if (this.queryParamMap != null) {
                return this.queryParamMap;
            }
            String encodedQuery = getEncodedQuery();
            if (encodedQuery == null) {
                HashMap map = new HashMap();
                this.queryParamMap = map;
                return map;
            }
            synchronized (this.lock) {
                if (this.queryParamMap != null) {
                    return this.queryParamMap;
                }
                HashMap map2 = new HashMap();
                int i = 0;
                while (true) {
                    int iIndexOf = encodedQuery.indexOf(38, i);
                    int length = iIndexOf != -1 ? iIndexOf : encodedQuery.length();
                    int iIndexOf2 = encodedQuery.indexOf(61, i);
                    if (iIndexOf2 > length || iIndexOf2 == -1) {
                        iIndexOf2 = length;
                    }
                    String strDecode = decode(encodedQuery.substring(i, iIndexOf2));
                    String strDecode2 = iIndexOf2 != length ? decode(encodedQuery.substring(iIndexOf2 + 1, length)) : "";
                    if (!map2.containsKey(strDecode)) {
                        map2.put(strDecode, new ArrayList());
                    }
                    ((List) map2.get(strDecode)).add(strDecode2);
                    if (iIndexOf == -1) {
                        this.queryParamMap = map2;
                        return map2;
                    }
                    i = iIndexOf + 1;
                }
            }
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedFragment() {
            return e.c(this.fragment).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedFragment() {
            return e.a(this.fragment, null).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public b buildUpon() {
            return new b().h(this.scheme).b(this.authority).a(this.path).e(this.query).d(this.fragment);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String toString() {
            return (String) Optional.ofNullable(this.uriStrCache).orElseGet(new Supplier() { // from class: csn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.e.m384lambda$toString$3$comhuaweiharmonyosinterworkbaseutilsUri$HierarchicalUri();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: getUriStr, reason: merged with bridge method [inline-methods] */
        public String m384lambda$toString$3$comhuaweiharmonyosinterworkbaseutilsUri$HierarchicalUri() {
            StringBuilder sb = new StringBuilder();
            if (this.scheme != null) {
                sb.append(this.scheme);
                sb.append(Uri.SCHEME_SEPARATOR);
            }
            if (this.ssp == null) {
                generateSsp();
            }
            if (this.ssp != null) {
                String encodedSchemeSpecificPart = getEncodedSchemeSpecificPart();
                if (!TextUtils.isEmpty(encodedSchemeSpecificPart)) {
                    sb.append(encodedSchemeSpecificPart);
                }
            }
            if (this.fragment != null) {
                String encodedFragment = getEncodedFragment();
                if (!TextUtils.isEmpty(encodedFragment)) {
                    sb.append('#');
                    sb.append(encodedFragment);
                }
            }
            String string = sb.toString();
            this.uriStrCache = string;
            return string;
        }
    }

    public static class OpaqueUri extends Uri {
        private e fragment;
        private e opaqueSsp;
        private String uriStrCache;

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public int getPort() {
            return -1;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public boolean isHierarchical() {
            return false;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        private OpaqueUri(String str, e eVar, e eVar2) {
            super(str);
            this.opaqueSsp = (e) Optional.ofNullable(eVar).orElseThrow(new Supplier() { // from class: csq
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Uri.OpaqueUri.lambda$new$0();
                }
            });
            this.fragment = eVar2;
        }

        public static /* synthetic */ UnsupportedOperationException lambda$new$0() {
            return new UnsupportedOperationException("The ssp part can't be null.");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (parcel == null) {
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(this.scheme);
            e.BS_(this.opaqueSsp, parcel, null);
            e.BS_(this.fragment, parcel, null);
        }

        public static OpaqueUri makeFromParcel(Parcel parcel) {
            return new OpaqueUri(parcel.readString(), e.BR_(parcel), e.BR_(parcel));
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedSchemeSpecificPart() {
            return this.opaqueSsp.b();
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedSchemeSpecificPart() {
            return this.opaqueSsp.e(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public List<String> getDecodedPathList() {
            return new ArrayList(0);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public Map<String, List<String>> getDecodedQueryParams() {
            return new HashMap();
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedFragment() {
            return e.c(this.fragment).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedFragment() {
            return e.a(this.fragment, null).orElse(null);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public b buildUpon() {
            return new b().h(this.scheme).c(this.opaqueSsp).d(this.fragment);
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String toString() {
            return (String) Optional.ofNullable(this.uriStrCache).orElseGet(new Supplier() { // from class: csr
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.d.m385lambda$toString$1$comhuaweiharmonyosinterworkbaseutilsUri$OpaqueUri();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: getUriStr, reason: merged with bridge method [inline-methods] */
        public String m385lambda$toString$1$comhuaweiharmonyosinterworkbaseutilsUri$OpaqueUri() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append(Uri.SCHEME_SEPARATOR);
            sb.append(getEncodedSchemeSpecificPart());
            if (this.fragment != null) {
                sb.append('#');
                sb.append(getEncodedFragment());
            }
            String string = sb.toString();
            this.uriStrCache = string;
            return string;
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedUserInfo() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedQuery() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedPath() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedHost() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getEncodedAuthority() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedUserInfo() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedQuery() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedPath() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedHost() {
            return "";
        }

        @Override // com.huawei.harmonyos.interwork.base.utils.Uri
        public String getDecodedAuthority() {
            return "";
        }
    }

    public static class e {
        private volatile String c;
        private volatile String e;

        private e(String str, String str2) {
            this.c = str;
            this.e = str2;
        }

        static e b(String str, String str2) {
            if (str == null && str2 == null) {
                return null;
            }
            return new e(str, str2);
        }

        static e BR_(Parcel parcel) {
            return b(parcel.readString(), parcel.readString());
        }

        static void BS_(e eVar, Parcel parcel, String str) {
            if (eVar != null) {
                parcel.writeString(eVar.b());
                parcel.writeString(eVar.e(str));
            } else {
                parcel.writeString(null);
                parcel.writeString(null);
            }
        }

        static Optional<String> c(e eVar) {
            if (eVar != null) {
                return Optional.ofNullable(eVar.b());
            }
            return Optional.empty();
        }

        static Optional<String> a(e eVar, String str) {
            if (eVar != null) {
                return Optional.ofNullable(eVar.e(str));
            }
            return Optional.empty();
        }

        String b() {
            return (String) Optional.ofNullable(this.c).orElseGet(new Supplier() { // from class: csz
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f12025a.c();
                }
            });
        }

        public /* synthetic */ String c() {
            String strDecode = Uri.decode(this.e);
            this.c = strDecode;
            return strDecode;
        }

        public /* synthetic */ String d(String str) {
            String strOrElse = Uri.encode(this.c, str).orElse(null);
            this.e = strOrElse;
            return strOrElse;
        }

        String e(final String str) {
            return (String) Optional.ofNullable(this.e).orElseGet(new Supplier() { // from class: csw
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.c.d(str);
                }
            });
        }

        void e() {
            Optional.ofNullable(this.c).ifPresent(new Consumer() { // from class: csy
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f12024a.a((String) obj);
                }
            });
            Optional.ofNullable(this.e).ifPresent(new Consumer() { // from class: csx
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.e.b((String) obj);
                }
            });
        }

        public /* synthetic */ void a(String str) {
            if (str.startsWith("/")) {
                return;
            }
            this.c = "/".concat(String.valueOf(str));
        }

        public /* synthetic */ void b(String str) {
            if (str.startsWith("/")) {
                return;
            }
            this.e = "/".concat(String.valueOf(str));
        }
    }

    public static String encode(String str) {
        return encode(str, null).orElse(null);
    }

    public static Optional<String> encode(String str, String str2) {
        if (str == null) {
            return Optional.empty();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isAllowed(cCharAt, str2)) {
                sb.append(cCharAt);
            } else {
                for (byte b2 : String.valueOf(cCharAt).getBytes(StandardCharsets.UTF_8)) {
                    sb.append(PERCENT_SIGN);
                    char[] cArr = HEXADECIMAL_DIGITS;
                    sb.append(cArr[(b2 & 240) >> 4]);
                    sb.append(cArr[b2 & 15]);
                }
            }
        }
        return Optional.ofNullable(sb.toString());
    }

    private static boolean isAllowed(char c, String str) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if ((c < '0' || c > '9') && "_-!.~'()*".indexOf(c) == -1) {
            return (str == null || str.indexOf(c) == -1) ? false : true;
        }
        return true;
    }

    public static String decode(String str) {
        if (str == null || str.isEmpty() || str.indexOf(37) < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        CharsetDecoder charsetDecoderOnUnmappableCharacter = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).replaceWith(INVALID_INPUT_CHARACTER).onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(str.length());
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            if (cCharAt == '%') {
                int i2 = 0;
                byte b2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        break;
                    }
                    if (i >= str.length()) {
                        return sb.toString();
                    }
                    char cCharAt2 = str.charAt(i);
                    i++;
                    int iHexCharToValue = hexCharToValue(cCharAt2);
                    if (iHexCharToValue < 0) {
                        flushDecodingByteAccumulator(sb, charsetDecoderOnUnmappableCharacter, byteBufferAllocate);
                        sb.append(INVALID_INPUT_CHARACTER);
                        break;
                    }
                    b2 = (byte) ((b2 * 16) + iHexCharToValue);
                    i2++;
                }
                byteBufferAllocate.put(b2);
            } else {
                flushDecodingByteAccumulator(sb, charsetDecoderOnUnmappableCharacter, byteBufferAllocate);
                sb.append(cCharAt);
            }
        }
        flushDecodingByteAccumulator(sb, charsetDecoderOnUnmappableCharacter, byteBufferAllocate);
        return sb.toString();
    }

    private static void flushDecodingByteAccumulator(StringBuilder sb, CharsetDecoder charsetDecoder, ByteBuffer byteBuffer) {
        if (byteBuffer.position() == 0) {
            return;
        }
        byteBuffer.flip();
        try {
            try {
                sb.append((CharSequence) charsetDecoder.decode(byteBuffer));
            } catch (CharacterCodingException unused) {
                sb.append(INVALID_INPUT_CHARACTER);
            }
        } finally {
            byteBuffer.flip();
            byteBuffer.limit(byteBuffer.capacity());
        }
    }

    public static Uri getUriFromParts(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("scheme can't be null");
        }
        if (str2 == null) {
            throw new NullPointerException("ssp can't be null");
        }
        return new OpaqueUri(str, e.b(str2, null), e.b(str3, null));
    }

    public static Uri getUriFromFileCanonicalPath(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("file can't be null");
        }
        return new HierarchicalUri("file", e.b("", null), e.b(file.getCanonicalPath(), null), null, null);
    }

    public static Uri appendEncodedPathToUri(Uri uri, String str) {
        if (uri.isOpaque()) {
            throw new UnsupportedOperationException("opaque uri can't append path");
        }
        return uri.buildUpon().d(str).d();
    }

    public static Uri parse(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("uriStr is null or empty.");
        }
        b bVar = new b();
        String strOrElse = parseScheme(str).orElse(null);
        bVar.h(strOrElse);
        bVar.a(parseFragment(str).orElse(null));
        String strOrElse2 = parseSchemeSpecificPart(str).orElse(null);
        if (strOrElse != null && strOrElse2 != null && !strOrElse2.startsWith("/")) {
            bVar.c(strOrElse2);
            return bVar.d();
        }
        bVar.e(parseAuthority(strOrElse2).orElse(null));
        bVar.b(parsePath(str).orElse(null));
        bVar.i(parseQuery(strOrElse2).orElse(null));
        return bVar.d();
    }

    private static Optional<String> parseScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return Optional.empty();
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!URI_SCHEME_PATTERN.matcher(strSubstring).matches()) {
                throw new IllegalArgumentException("scheme is not illegal.");
            }
            return Optional.ofNullable(strSubstring);
        }
        return Optional.empty();
    }

    private static Optional<String> parseSchemeSpecificPart(String str) {
        if (TextUtils.isEmpty(str)) {
            return Optional.empty();
        }
        int iIndexOf = str.indexOf(58);
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 == -1) {
            return Optional.ofNullable(str.substring(iIndexOf + 1));
        }
        return Optional.ofNullable(str.substring(iIndexOf + 1, iIndexOf2));
    }

    private static Optional<String> parseFragment(String str) {
        if (TextUtils.isEmpty(str)) {
            return Optional.empty();
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            return Optional.ofNullable(str.substring(iIndexOf + 1));
        }
        return Optional.empty();
    }

    private static Optional<String> parseAuthority(String str) {
        if (TextUtils.isEmpty(str)) {
            return Optional.empty();
        }
        int length = str.length();
        if (length > 2 && str.charAt(0) == '/' && str.charAt(1) == '/') {
            int i = 2;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '/' || cCharAt == '\\' || cCharAt == '?' || cCharAt == '#') {
                    break;
                }
                i++;
            }
            return Optional.ofNullable(str.substring(2, i));
        }
        return Optional.empty();
    }

    private static Optional<String> parsePath(String str) {
        int iIndexOf = str.indexOf(58);
        int length = str.length();
        int i = iIndexOf == -1 ? 0 : iIndexOf + 1;
        int i2 = i + 1;
        if (length > i2 && str.charAt(i) == '/' && str.charAt(i2) == '/') {
            i += 2;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '?' || cCharAt == '#') {
                    return Optional.empty();
                }
                if (cCharAt == '/' || cCharAt == '\\') {
                    break;
                }
                i++;
            }
        }
        int i3 = i;
        while (i3 < length) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 == '?' || cCharAt2 == '#') {
                break;
            }
            i3++;
        }
        if (i3 == i) {
            return Optional.empty();
        }
        return Optional.ofNullable(str.substring(i, i3));
    }

    private static Optional<String> parseQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return Optional.empty();
        }
        int iIndexOf = str.indexOf(63);
        if (iIndexOf == -1) {
            return Optional.empty();
        }
        return Optional.ofNullable(str.substring(iIndexOf + 1));
    }

    public Optional<String> getLastPath() {
        List<String> decodedPathList = getDecodedPathList();
        if (decodedPathList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(decodedPathList.get(decodedPathList.size() - 1));
    }

    public List<String> getQueryParamsByKey(String str) {
        return getDecodedQueryParams().getOrDefault(str, new ArrayList(0));
    }

    public String getFirstQueryParamByKey(String str) {
        List<String> queryParamsByKey = getQueryParamsByKey(str);
        return queryParamsByKey.isEmpty() ? "" : queryParamsByKey.get(0);
    }

    public Set<String> getQueryParamNames() {
        return getDecodedQueryParams().keySet();
    }

    public boolean getBooleanQueryParam(String str, boolean z) {
        String firstQueryParamByKey = getFirstQueryParamByKey(str);
        if (firstQueryParamByKey == null) {
            return z;
        }
        String lowerCase = firstQueryParamByKey.toLowerCase(Locale.ROOT);
        return ("false".equals(lowerCase) || "0".equals(lowerCase)) ? false : true;
    }

    public Uri getLowerCaseScheme() {
        String scheme = getScheme();
        if (scheme == null) {
            return this;
        }
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        return scheme.equals(lowerCase) ? this : buildUpon().h(lowerCase).d();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Uri)) {
            return false;
        }
        return ((Uri) obj).toString().equals(toString());
    }

    public int hashCode() {
        return Objects.hashCode(toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(Uri uri) {
        return toString().compareTo(uri.toString());
    }
}
