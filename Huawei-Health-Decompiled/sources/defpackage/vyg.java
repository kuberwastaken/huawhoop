package defpackage;

import android.content.Context;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes8.dex */
public class vyg {
    private String e = null;
    private String d = null;
    private String c = null;
    private vxv b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<vxv> f18840a = null;
    private Map<String, List<vxv>> j = new HashMap();

    public void e(Context context, Map<String, List<vxv>> map, int i) {
        try {
            fwv_(context, map, context.getResources().getXml(i));
        } catch (Exception unused) {
            vwc.a("AddressNameMgr", "XmlParseUtil,parseXml-xmlRes exception", false);
        }
    }

    private void fwv_(Context context, Map<String, List<vxv>> map, XmlResourceParser xmlResourceParser) {
        this.j = map;
        if (xmlResourceParser == null) {
            return;
        }
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    b(xmlResourceParser);
                } else if (eventType == 3) {
                    fwu_(xmlResourceParser);
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | IndexOutOfBoundsException | XmlPullParserException unused) {
            vwc.c("AddressNameMgr", " Process address mapping xml file failed.", null, false);
        }
    }

    private void fwu_(XmlResourceParser xmlResourceParser) {
        vxv vxvVar;
        if ("Module".equals(xmlResourceParser.getName())) {
            this.j.put(this.e, this.f18840a);
            this.f18840a = null;
        }
        if ("Param".equals(xmlResourceParser.getName()) && (vxvVar = this.b) != null) {
            vxvVar.c(this.d, this.c);
        }
        if ("Address".equals(xmlResourceParser.getName())) {
            List<vxv> list = this.f18840a;
            if (list != null) {
                list.add(this.b);
            }
            this.b = null;
        }
    }

    private void b(XmlPullParser xmlPullParser) {
        if ("Module".equals(xmlPullParser.getName())) {
            this.e = xmlPullParser.getAttributeValue(null, "name");
            this.f18840a = new ArrayList();
        } else if (this.f18840a != null) {
            if ("Address".equals(xmlPullParser.getName())) {
                this.b = new vxv(xmlPullParser.getAttributeValue(null, "name"), xmlPullParser.getAttributeValue(null, "serverAddressName"));
            }
        } else {
            if (this.b == null || !"Param".equals(xmlPullParser.getName())) {
                return;
            }
            this.d = xmlPullParser.getAttributeValue(null, "name");
            this.c = xmlPullParser.getAttributeValue(null, "value");
        }
    }
}
