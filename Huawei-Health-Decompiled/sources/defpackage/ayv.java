package defpackage;

import android.graphics.Color;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class ayv {
    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("", str) != null;
    }

    public static float c(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        return attributeValue == null ? f : Float.parseFloat(attributeValue);
    }

    public static boolean d(XmlPullParser xmlPullParser, String str, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        return attributeValue == null ? z : Boolean.parseBoolean(attributeValue);
    }

    public static int d(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    public static ayp b(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue != null) {
            return ayp.e(Color.parseColor(attributeValue));
        }
        return ayp.e(i);
    }

    public static String e(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return attributeValue;
    }

    public static float b(XmlPullParser xmlPullParser, String str, float f) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return f;
        }
        if (attributeValue.contains("px")) {
            attributeValue = attributeValue.substring(0, attributeValue.indexOf("px"));
        } else if (attributeValue.contains("dp")) {
            attributeValue = attributeValue.substring(0, attributeValue.indexOf("dp"));
        }
        return Float.parseFloat(attributeValue);
    }

    public static String c(XmlPullParser xmlPullParser) {
        return "XML file line #" + xmlPullParser.getLineNumber();
    }
}
