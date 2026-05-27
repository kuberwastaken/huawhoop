package defpackage;

import android.util.JsonReader;
import com.huawei.multisimsdk.odsa.response.OdsaResponseParam;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class mzt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.multisimsdk.odsa.response.OdsaResponseParam e(java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzt.e(java.lang.String):com.huawei.multisimsdk.odsa.response.OdsaResponseParam");
    }

    private static void cff_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginArray();
        if (jsonReader.hasNext()) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("CompanionConfiguration")) {
                    cfe_(jsonReader, odsaResponseParam);
                } else {
                    mza.a("OdsaResolveJsonParser", "unexpected tag");
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void cfe_(android.util.JsonReader r6, com.huawei.multisimsdk.odsa.response.OdsaResponseParam r7) throws java.lang.IllegalStateException, java.io.IOException {
        /*
            r6.beginObject()
        L3:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto La0
            java.lang.String r0 = r6.nextName()
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 2
            r4 = 1
            r5 = 3
            switch(r1) {
                case -1267656985: goto L48;
                case -1196228216: goto L3d;
                case 69479748: goto L32;
                case 1273065846: goto L27;
                case 1434771443: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L53
        L1c:
            java.lang.String r1 = "CompanionDeviceService"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L25
            goto L53
        L25:
            r0 = r2
            goto L54
        L27:
            java.lang.String r1 = "DownloadInfo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L30
            goto L53
        L30:
            r0 = r5
            goto L54
        L32:
            java.lang.String r1 = "ICCID"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L53
        L3b:
            r0 = r3
            goto L54
        L3d:
            java.lang.String r1 = "PollingInterval"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
            goto L53
        L46:
            r0 = r4
            goto L54
        L48:
            java.lang.String r1 = "ServiceStatus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L51
            goto L53
        L51:
            r0 = 0
            goto L54
        L53:
            r0 = -1
        L54:
            if (r0 == 0) goto L97
            if (r0 == r4) goto L86
            if (r0 == r3) goto L76
            if (r0 == r5) goto L72
            if (r0 == r2) goto L6a
            java.lang.String r0 = "OdsaResolveJsonParser"
            java.lang.String r1 = "unexpected tag"
            defpackage.mza.a(r0, r1)
            r6.skipValue()
            goto L3
        L6a:
            java.lang.String r0 = r6.nextString()
            r7.setCompanionDeviceServices(r0)
            goto L3
        L72:
            cfh_(r6, r7)
            goto L3
        L76:
            java.lang.String r0 = r6.nextString()
            r7.setIccid(r0)
            java.lang.String[] r0 = defpackage.nao.e
            r0 = r0[r5]
            r7.setOperationType(r0)
            goto L3
        L86:
            int r0 = r6.nextInt()
            r7.setPollingInterval(r0)
            java.lang.String[] r0 = defpackage.nao.e
            r1 = 5
            r0 = r0[r1]
            r7.setOperationType(r0)
            goto L3
        L97:
            java.lang.String r0 = r6.nextString()
            r7.setServiceStatus(r0)
            goto L3
        La0:
            r6.endObject()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzt.cfe_(android.util.JsonReader, com.huawei.multisimsdk.odsa.response.OdsaResponseParam):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void cfh_(android.util.JsonReader r5, com.huawei.multisimsdk.odsa.response.OdsaResponseParam r6) throws java.lang.IllegalStateException, java.io.IOException {
        /*
            r5.beginObject()
        L3:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L71
            java.lang.String r0 = r5.nextName()
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1144770036(0xffffffffbbc4320c, float:-0.0059874114)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L3c
            r2 = 112594789(0x6b60f65, float:6.848341E-35)
            if (r1 == r2) goto L31
            r2 = 1367384411(0x5180a15b, float:6.905786E10)
            if (r1 == r2) goto L26
            goto L44
        L26:
            java.lang.String r1 = "ProfileIccid"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2f
            goto L44
        L2f:
            r0 = r3
            goto L47
        L31:
            java.lang.String r1 = "ProfileSmdpAddress"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3a
            goto L44
        L3a:
            r0 = r4
            goto L47
        L3c:
            java.lang.String r1 = "ProfileActivationCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
        L44:
            r0 = -1
            goto L47
        L46:
            r0 = 0
        L47:
            if (r0 == 0) goto L69
            if (r0 == r4) goto L61
            if (r0 == r3) goto L59
            java.lang.String r0 = "OdsaResolveJsonParser"
            java.lang.String r1 = "unexpected tag"
            defpackage.mza.a(r0, r1)
            r5.skipValue()
            goto L3
        L59:
            java.lang.String r0 = r5.nextString()
            r6.setProfileIccid(r0)
            goto L3
        L61:
            java.lang.String r0 = r5.nextString()
            r6.setProfileSmdpAddress(r0)
            goto L3
        L69:
            java.lang.String r0 = r5.nextString()
            r6.setProfileActivationCode(r0)
            goto L3
        L71:
            r5.endObject()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzt.cfh_(android.util.JsonReader, com.huawei.multisimsdk.odsa.response.OdsaResponseParam):void");
    }

    private static void cfk_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("validity")) {
                odsaResponseParam.setValidity(String.valueOf(jsonReader.nextInt()));
            } else if (strNextName.equals("version")) {
                odsaResponseParam.setVersion(String.valueOf(jsonReader.nextInt()));
            } else {
                mza.a("OdsaResolveJsonParser", "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void cfj_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("token")) {
                odsaResponseParam.setToken(jsonReader.nextString());
            } else {
                mza.a("OdsaResolveJsonParser", "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void cfi_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("es_token")) {
                odsaResponseParam.setToken(jsonReader.nextString());
            } else {
                mza.a("OdsaResolveJsonParser", "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void cfc_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("default")) {
                cfg_(jsonReader, odsaResponseParam);
            } else {
                mza.a("OdsaResolveJsonParser", "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void cfg_(JsonReader jsonReader, OdsaResponseParam odsaResponseParam) throws IllegalStateException, IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("appId")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    odsaResponseParam.setAppId(jsonReader.nextString());
                }
                jsonReader.endArray();
            } else {
                mza.a("OdsaResolveJsonParser", "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void cfd_(android.util.JsonReader r4, com.huawei.multisimsdk.odsa.response.OdsaResponseParam r5) throws java.lang.IllegalStateException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzt.cfd_(android.util.JsonReader, com.huawei.multisimsdk.odsa.response.OdsaResponseParam):void");
    }
}
