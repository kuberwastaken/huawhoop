package defpackage;

import android.util.JsonReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class nae {
    private static final String e = "VersInfo";
    private int d = 0;
    private int c = 0;

    private void e(String str) {
        try {
            this.d = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    private void d(String str) {
        try {
            this.c = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    public void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        while (true) {
            xmlPullParser.next();
            if (nam.c(xmlPullParser) || xmlPullParser.getEventType() == 1) {
                return;
            }
            if (xmlPullParser.getEventType() == 2 && "parm".equals(xmlPullParser.getName()) && xmlPullParser.getAttributeCount() >= 2) {
                String attributeValue = xmlPullParser.getAttributeValue(0);
                String attributeValue2 = xmlPullParser.getAttributeValue(1);
                if ("version".equals(attributeValue)) {
                    e(attributeValue2);
                } else if ("validity".equals(attributeValue)) {
                    d(attributeValue2);
                } else {
                    mza.a(e, "unexpected tag");
                }
            }
        }
    }

    public void cfo_(JsonReader jsonReader) throws IllegalStateException, IOException {
        if (jsonReader == null) {
            mza.c(e, "parserJsonItems reader == null");
            return;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("validity")) {
                d(String.valueOf(jsonReader.nextInt()));
            } else if (strNextName.equals("version")) {
                e(String.valueOf(jsonReader.nextInt()));
            } else {
                mza.a(e, "unexpected tag");
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        mza.a(e, "vers finish");
    }
}
