package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes8.dex */
public class wzh {
    public static String b(InputStream inputStream, String str) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                a(inputStreamReader, stringWriter);
                String string = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return string;
            } finally {
            }
        } catch (Throwable th) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        int i = reader.read(cArr);
        long j = 0;
        while (-1 != i) {
            writer.write(cArr, 0, i);
            j += (long) i;
            i = reader.read(cArr);
        }
        return j;
    }

    public static long a(Reader reader, Writer writer) throws IOException {
        return a(reader, writer, new char[4096]);
    }
}
