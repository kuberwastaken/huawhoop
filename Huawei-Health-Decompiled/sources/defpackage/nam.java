package defpackage;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class nam {
    private static final String d = "XmlUtils";

    public static boolean c(XmlPullParser xmlPullParser) {
        try {
            if (xmlPullParser.getEventType() == 3) {
                return "characteristic".equals(xmlPullParser.getName());
            }
            return false;
        } catch (XmlPullParserException unused) {
            mza.c(d, "parse xml error");
            return false;
        }
    }
}
