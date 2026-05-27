package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import defpackage.xkd;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        xkd.d(bitmap, "");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        xkd.a(iconCreateWithAdaptiveBitmap, "");
        return iconCreateWithAdaptiveBitmap;
    }

    public static final Icon toIcon(Bitmap bitmap) {
        xkd.d(bitmap, "");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        xkd.a(iconCreateWithBitmap, "");
        return iconCreateWithBitmap;
    }

    public static final Icon toIcon(Uri uri) {
        xkd.d(uri, "");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        xkd.a(iconCreateWithContentUri, "");
        return iconCreateWithContentUri;
    }

    public static final Icon toIcon(byte[] bArr) {
        xkd.d(bArr, "");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        xkd.a(iconCreateWithData, "");
        return iconCreateWithData;
    }
}
