package defpackage;

import android.util.JsonReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class mzx {
    private static final String b = "TokenInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15971a = null;
    private int c = 0;

    public String d() {
        return this.f15971a;
    }

    private void b(String str) {
        this.f15971a = str;
    }

    private void e(String str) {
        try {
            this.c = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    public void d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (true) {
            xmlPullParser.next();
            if (nam.c(xmlPullParser) || xmlPullParser.getEventType() == 1) {
                return;
            }
            if (xmlPullParser.getEventType() == 2 && "parm".equals(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() >= 2) {
                String attributeValue = xmlPullParser.getAttributeValue(0);
                String attributeValue2 = xmlPullParser.getAttributeValue(1);
                if ("token".equals(attributeValue)) {
                    b(attributeValue2);
                } else if ("validity".equals(attributeValue)) {
                    e(attributeValue2);
                } else if (mza.e.booleanValue()) {
                    mza.a(b, "expected tag = " + attributeValue);
                }
            }
        }
    }

    public void cfn_(JsonReader jsonReader) throws IllegalStateException, IOException {
        if (jsonReader == null) {
            mza.c(b, "parserJsonItems reader == null");
            return;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("validity")) {
                e(String.valueOf(jsonReader.nextInt()));
            } else if (strNextName.equals("token")) {
                b(jsonReader.nextString());
            } else {
                mza.a(b, "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        mza.a(b, "token finish");
    }
}
