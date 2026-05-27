package defpackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class pcn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16622a = "";
    private String d = "";
    private ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();

    public void e(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                String[] strArrSplit = line.split("[ ]+");
                String strTrim = strArrSplit[0].trim();
                if (strTrim.equals("vertex_source_file")) {
                    this.f16622a = strArrSplit[1];
                } else if (strTrim.equals("fragment_source_file")) {
                    this.d = strArrSplit[1];
                } else if (strTrim.equals("attribute") || strTrim.equals("uniform")) {
                    this.b.put(strArrSplit[2], strTrim);
                }
            }
        } catch (Exception e) {
            pcj.b("MaterialParser", pcj.a() + " load error e=" + e.getMessage());
            e.printStackTrace();
        }
    }

    public ConcurrentHashMap<String, String> c() {
        return this.b;
    }

    public String a() {
        return this.f16622a;
    }

    public String b() {
        return this.d;
    }

    public void d() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.b = null;
        }
    }
}
