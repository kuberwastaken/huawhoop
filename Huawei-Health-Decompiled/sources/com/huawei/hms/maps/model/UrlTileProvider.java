package com.huawei.hms.maps.model;

import com.huawei.hms.maps.utils.LogM;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes10.dex */
public abstract class UrlTileProvider implements TileProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5204a;
    private final int b;

    public abstract URL getTileUrl(int i, int i2, int i3);

    @Override // com.huawei.hms.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamOpenStream;
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        InputStream inputStream = null;
        try {
            inputStreamOpenStream = tileUrl.openStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException unused) {
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                inputStream = inputStreamOpenStream;
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (IOException unused2) {
            inputStreamOpenStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i4 = inputStreamOpenStream.read(bArr);
                if (i4 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i4);
            }
            Tile tile = new Tile(this.b, this.f5204a, byteArrayOutputStream.toByteArray());
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (IOException e) {
                    LogM.e("UrlTileProvider", "Input stream close IOException" + e.getMessage());
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                LogM.e("UrlTileProvider", "Output stream close IOException" + e2.getMessage());
            }
            return tile;
        } catch (IOException unused3) {
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (IOException e3) {
                    LogM.e("UrlTileProvider", "Input stream close IOException" + e3.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    LogM.e("UrlTileProvider", "Output stream close IOException" + e4.getMessage());
                }
            }
            return null;
        } catch (Throwable th3) {
            inputStream = inputStreamOpenStream;
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    LogM.e("UrlTileProvider", "Input stream close IOException" + e5.getMessage());
                }
            }
            if (byteArrayOutputStream == null) {
                throw th;
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e6) {
                LogM.e("UrlTileProvider", "Output stream close IOException" + e6.getMessage());
                throw th;
            }
        }
    }

    public UrlTileProvider(int i, int i2) {
        this.b = i;
        this.f5204a = i2;
    }
}
