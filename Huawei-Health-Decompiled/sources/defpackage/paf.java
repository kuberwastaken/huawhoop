package defpackage;

import android.content.Context;
import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Marker;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes7.dex */
public class paf {
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[EXC_TOP_SPLITTER, PHI: r3
      0x004c: PHI (r3v3 java.io.InputStream) = (r3v2 java.io.InputStream), (r3v4 java.io.InputStream) binds: [B:11:0x004a, B:6:0x0040] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.lang.String, java.lang.String> c(java.lang.String r7, android.content.Context r8) {
        /*
            r6 = this;
            java.lang.String r0 = "close inputstream error"
            java.lang.String r1 = "AarParseXml"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            javax.xml.parsers.DocumentBuilderFactory r4 = javax.xml.parsers.DocumentBuilderFactory.newInstance()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            e(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            javax.xml.parsers.DocumentBuilder r4 = r4.newDocumentBuilder()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.lang.String r7 = b(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            android.content.res.AssetManager r5 = r8.getAssets()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.lang.String[] r5 = r5.list(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            int r5 = r5.length     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            if (r5 == 0) goto L40
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            r5.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            r5.append(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.lang.String r7 = "/taboo-data.xml"
            r5.append(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            java.io.InputStream r3 = r8.open(r7)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
            d(r2, r4, r3)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L45
        L40:
            if (r3 == 0) goto L53
            goto L4c
        L43:
            r7 = move-exception
            goto L54
        L45:
            java.lang.String r7 = "parse error"
            android.util.Log.e(r1, r7)     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto L53
        L4c:
            r3.close()     // Catch: java.io.IOException -> L50
            goto L53
        L50:
            android.util.Log.e(r1, r0)
        L53:
            return r2
        L54:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.io.IOException -> L5a
            goto L5d
        L5a:
            android.util.Log.e(r1, r0)
        L5d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.paf.c(java.lang.String, android.content.Context):java.util.HashMap");
    }

    private static void e(DocumentBuilderFactory documentBuilderFactory) {
        if (documentBuilderFactory == null) {
            Log.e("AarParseXml", "setXmlEntityPolicy failed,builderFactory is null.");
            return;
        }
        c(documentBuilderFactory, "http://apache.org/xml/features/disallow-doctype-decl", true);
        c(documentBuilderFactory, "http://xml.org/sax/features/external-general-entities", false);
        c(documentBuilderFactory, "http://xml.org/sax/features/external-parameter-entities", false);
        c(documentBuilderFactory, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        documentBuilderFactory.setExpandEntityReferences(false);
    }

    private static void c(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) {
        if (documentBuilderFactory == null || str == null) {
            Log.e("AarParseXml", "setXmlSecurityFeature failed, builderFactory = " + documentBuilderFactory + ", featureName = " + str);
            return;
        }
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (ParserConfigurationException unused) {
            Log.e("AarParseXml", "setXmlSecurityFeature occur ParserConfigurationException: set " + str + " to " + z + " failed.");
        }
    }

    public static ArrayList<String> e(Context context) {
        String strSubstring;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (String str : context.getAssets().list("tabooxml")) {
                if (str.startsWith("xml")) {
                    int iIndexOf = str.indexOf(Constants.LINK);
                    if (iIndexOf != -1) {
                        strSubstring = str.substring(iIndexOf + 1);
                        if (strSubstring.contains(Marker.ANY_NON_NULL_MARKER)) {
                            strSubstring = strSubstring.replace("b+", "").replace(Marker.ANY_NON_NULL_MARKER, Constants.LINK);
                        } else if (strSubstring.contains(Constants.LINK)) {
                            strSubstring = strSubstring.replace("-r", Constants.LINK);
                        }
                    } else {
                        strSubstring = "en";
                    }
                    arrayList.add(strSubstring);
                }
            }
        } catch (IOException unused) {
            Log.e("AarParseXml", "getXmlLanguageList error");
        }
        return arrayList;
    }

    private static String b(String str) {
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        String script = localeForLanguageTag.getScript();
        String language = localeForLanguageTag.getLanguage();
        String country = localeForLanguageTag.getCountry();
        String strReplaceAll = str.replaceAll(Constants.LINK, Marker.ANY_NON_NULL_MARKER);
        if ("".equals(language)) {
            return "";
        }
        if (!script.isEmpty() || country.length() > 2) {
            return "tabooxml/xml-b+" + strReplaceAll;
        }
        if (script.isEmpty() && country.isEmpty() && language.equals("en")) {
            return "tabooxml/xml";
        }
        String str2 = "tabooxml/xml-" + language;
        if (country.isEmpty()) {
            return str2;
        }
        return str2 + "-r" + country;
    }

    private static void d(HashMap<String, String> map, DocumentBuilder documentBuilder, InputStream inputStream) throws SAXException, IOException {
        NodeList elementsByTagName;
        Document document = documentBuilder.parse(inputStream);
        if (document == null || (elementsByTagName = document.getElementsByTagName("item")) == null) {
            return;
        }
        int length = elementsByTagName.getLength();
        for (int i = 0; i < length; i++) {
            NamedNodeMap attributes = elementsByTagName.item(i).getAttributes();
            map.put(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("value").getNodeValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002e A[EXC_TOP_SPLITTER, PHI: r3
      0x002e: PHI (r3v3 java.io.InputStream) = (r3v2 java.io.InputStream), (r3v4 java.io.InputStream) binds: [B:9:0x002c, B:4:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> b(android.content.Context r6) {
        /*
            java.lang.String r0 = "close inputstream error"
            java.lang.String r1 = "AarParseXml"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            javax.xml.parsers.DocumentBuilderFactory r4 = javax.xml.parsers.DocumentBuilderFactory.newInstance()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            e(r4)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            javax.xml.parsers.DocumentBuilder r4 = r4.newDocumentBuilder()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            java.lang.String r5 = "tabooxml/taboo-config.xml"
            java.io.InputStream r3 = r6.open(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            d(r2, r4, r3)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            if (r3 == 0) goto L35
            goto L2e
        L25:
            r6 = move-exception
            goto L36
        L27:
            java.lang.String r6 = "parseConfigXml: error"
            android.util.Log.e(r1, r6)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L35
        L2e:
            r3.close()     // Catch: java.io.IOException -> L32
            goto L35
        L32:
            android.util.Log.e(r1, r0)
        L35:
            return r2
        L36:
            if (r3 == 0) goto L3f
            r3.close()     // Catch: java.io.IOException -> L3c
            goto L3f
        L3c:
            android.util.Log.e(r1, r0)
        L3f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.paf.b(android.content.Context):java.util.HashMap");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002e A[EXC_TOP_SPLITTER, PHI: r3
      0x002e: PHI (r3v3 java.io.InputStream) = (r3v2 java.io.InputStream), (r3v4 java.io.InputStream) binds: [B:9:0x002c, B:4:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> c(android.content.Context r6) {
        /*
            java.lang.String r0 = "close inputstream error"
            java.lang.String r1 = "AarParseXml"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            javax.xml.parsers.DocumentBuilderFactory r4 = javax.xml.parsers.DocumentBuilderFactory.newInstance()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            e(r4)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            javax.xml.parsers.DocumentBuilder r4 = r4.newDocumentBuilder()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            java.lang.String r5 = "tabooxml/taboo-region.xml"
            java.io.InputStream r3 = r6.open(r5)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            d(r2, r4, r3)     // Catch: java.lang.Throwable -> L25 java.lang.Throwable -> L27
            if (r3 == 0) goto L35
            goto L2e
        L25:
            r6 = move-exception
            goto L36
        L27:
            java.lang.String r6 = "parseConfigXml error"
            android.util.Log.e(r1, r6)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L35
        L2e:
            r3.close()     // Catch: java.io.IOException -> L32
            goto L35
        L32:
            android.util.Log.e(r1, r0)
        L35:
            return r2
        L36:
            if (r3 == 0) goto L3f
            r3.close()     // Catch: java.io.IOException -> L3c
            goto L3f
        L3c:
            android.util.Log.e(r1, r0)
        L3f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.paf.c(android.content.Context):java.util.HashMap");
    }
}
