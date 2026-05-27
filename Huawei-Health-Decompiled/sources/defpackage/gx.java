package defpackage;

import com.airbnb.lottie.network.LottieFetchResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class gx implements LottieFetchResult {
    private final HttpURLConnection b;

    public gx(HttpURLConnection httpURLConnection) {
        this.b = httpURLConnection;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        return this.b.getResponseCode() / 100 == 2;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public InputStream bodyByteStream() throws IOException {
        return this.b.getInputStream();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String contentType() {
        return this.b.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.b.getURL() + ". Failed with " + this.b.getResponseCode() + "\n" + a(this.b);
        } catch (IOException e) {
            iy.e("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.disconnect();
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
