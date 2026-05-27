package defpackage;

import android.text.TextUtils;
import android.util.JsonReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class mzw {
    private static final String d = "ApplicationInfo";
    private String c = null;
    private String h = null;
    private int b = -1;
    private String g = null;
    private String j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15970a = null;
    private int f = -1;
    private int e = -1;
    private int i = -1;

    public void a(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.h = str;
    }

    private void e(String str) {
        try {
            this.b = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    private void h(String str) {
        this.g = str;
    }

    private void j(String str) {
        this.j = str;
    }

    private void b(String str) {
        this.f15970a = str;
    }

    private void f(String str) {
        try {
            this.f = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            mza.a(d, "empty addrstatus, set to 2");
            this.e = 2;
        } else {
            try {
                this.e = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
    }

    private void i(String str) {
        try {
            this.i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    public void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (true) {
            xmlPullParser.next();
            if (nam.c(xmlPullParser) || xmlPullParser.getEventType() == 1) {
                return;
            }
            if (xmlPullParser.getEventType() == 2 && "parm".equals(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() >= 2) {
                String attributeValue = xmlPullParser.getAttributeValue(0);
                String attributeValue2 = xmlPullParser.getAttributeValue(1);
                if (mza.e.booleanValue()) {
                    mza.a(d, "name =" + attributeValue + " value =" + attributeValue2);
                }
                if ("AppID".equals(attributeValue)) {
                    a(attributeValue2);
                } else if ("Name".equals(attributeValue)) {
                    d(attributeValue2);
                } else if ("EntitlementStatus".equals(attributeValue)) {
                    e(attributeValue2);
                } else if ("AddrUpdate_URL".equals(attributeValue) || "ServiceFlow_URL".equals(attributeValue)) {
                    h(attributeValue2);
                } else if ("AddrUpdate_POST_Data".equals(attributeValue) || "ServiceFlow_POST_Data".equals(attributeValue)) {
                    j(attributeValue2);
                } else if ("AddrStatus".equals(attributeValue)) {
                    c(attributeValue2);
                } else if ("TC_Status".equals(attributeValue)) {
                    f(attributeValue2);
                } else if ("ProvStatus".equals(attributeValue)) {
                    i(attributeValue2);
                } else if ("MessageForIncompatible".equals(attributeValue)) {
                    b(attributeValue2);
                } else {
                    mza.a(d, "unexpected type = " + attributeValue);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cfm_(android.util.JsonReader r3) throws java.lang.IllegalStateException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mzw.cfm_(android.util.JsonReader):void");
    }

    private void cfl_(JsonReader jsonReader) throws IllegalStateException, IOException {
        if (jsonReader == null) {
            mza.c(d, "parserJsonDefaultItems reader == null");
            return;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("appId")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    a(jsonReader.nextString());
                }
                jsonReader.endArray();
            } else {
                mza.a(d, "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
