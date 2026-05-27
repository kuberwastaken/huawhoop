package defpackage;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class ot {
    public static String a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static JSONObject b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    String string = sb.toString();
                    ov.d("mspl", "readFileToJSON result=" + string);
                    return new JSONObject(string);
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            ov.b(th);
            return null;
        }
    }

    public static WebResourceResponse bt_(String str) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a(str));
            HashMap map = new HashMap();
            map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeTypeFromExtension, "UTF-8", fileInputStream);
            try {
                webResourceResponse2.setResponseHeaders(map);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                ov.b(th);
                return webResourceResponse;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void c(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        c(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }
}
