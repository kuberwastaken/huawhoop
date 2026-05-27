package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class mmc {
    private static int b(int i) {
        if (i > 1000) {
            return 60;
        }
        if (i > 750) {
            return 40;
        }
        return i > 500 ? 20 : 10;
    }

    public static Uri bXO_(Context context) {
        String strD = d(context);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return Uri.fromFile(new File(strD));
    }

    private static String d(Context context) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        return strA + "/" + b();
    }

    private static String a(Context context) {
        if (context == null) {
            mly.b("PicUtil", "context is null.", true);
            return "";
        }
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted_ro".equals(externalStorageState)) {
                mly.a("PicUtil", "read only.", true);
                return "";
            }
            if (!"mounted".equals(externalStorageState)) {
                mly.a("PicUtil", "media mounted.", true);
                return "";
            }
            return g(context);
        } catch (RuntimeException unused) {
            mly.b("PicUtil", "getExternalStorageState failed", true);
            return "";
        }
    }

    private static String g(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            mly.b("PicUtil", "External cache dir not existence.", true);
            return "";
        }
        try {
            String str = externalCacheDir.getCanonicalPath() + "/tmpFiles";
            File file = new File(str);
            if (file.exists() || file.mkdir()) {
                return str;
            }
            mly.b("PicUtil", "External cache tmp dir not existence.", true);
            return "";
        } catch (IOException e) {
            mly.a("PicUtil", "IOException " + e.getClass().getSimpleName(), true);
            return "";
        }
    }

    private static String b() {
        Date date = new Date(System.currentTimeMillis());
        return "HwID_card_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(date) + ".jpg";
    }

    public static Point bXP_(Context context) {
        mly.a("PicUtil", "getRealScreenSize start.", true);
        Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i = point.y;
            i2 = point.x;
            mly.a("PicUtil", "heightPixels is " + i, false);
            mly.a("PicUtil", "widthPixels is " + i2, false);
        } catch (IllegalAccessException e) {
            mly.a("PicUtil", "IllegalAccessException " + e.getClass().getSimpleName(), true);
        } catch (IllegalArgumentException e2) {
            mly.a("PicUtil", "IllegalArgumentException " + e2.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e3) {
            mly.a("PicUtil", "getRealScreenSize NoSuchMethodException " + e3.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e4) {
            mly.a("PicUtil", "InvocationTargetException " + e4.getClass().getSimpleName(), true);
        } catch (Exception e5) {
            mly.a("PicUtil", "getRealScreenSize Exception " + e5.getClass().getSimpleName(), true);
        }
        return new Point(i2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.FileOutputStream] */
    public static boolean c(Context context, String str, int i, String str2) throws Throwable {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        Point pointBXP_ = bXP_(context);
        Bitmap bitmapA = a(str, pointBXP_.x > 0 ? pointBXP_.x : 1920, pointBXP_.y > 0 ? pointBXP_.y : 1080);
        if (bitmapA == null) {
            mly.a("PicUtil", "bitmap is null", true);
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmapA.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length;
        mly.a("PicUtil", "compressBitmap length = " + length, true);
        if (length > 20971520) {
            mly.a("PicUtil", "compressBitmap too large return false", true);
            return false;
        }
        while (byteArrayOutputStream.toByteArray().length > i * 1024) {
            int iB = b(byteArrayOutputStream.toByteArray().length / 1024);
            byteArrayOutputStream.reset();
            i2 -= iB;
            bitmapA.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        }
        ?? r10 = 0;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            mly.a("PicUtil", "compressBitmap final length = " + byteArray.length, true);
            fileOutputStream.write(byteArray);
            fileOutputStream.flush();
            fileOutputStream.close();
            try {
                fileOutputStream.close();
                r10 = byteArray;
            } catch (IOException e3) {
                e = e3;
                sb = new StringBuilder("error = ");
                sb.append(e.getClass().getSimpleName());
                mly.b("PicUtil", sb.toString(), true);
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            mly.b("PicUtil", "error = " + e.getClass().getSimpleName(), true);
            r10 = fileOutputStream2;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    r10 = fileOutputStream2;
                } catch (IOException e5) {
                    e = e5;
                    sb = new StringBuilder("error = ");
                    sb.append(e.getClass().getSimpleName());
                    mly.b("PicUtil", sb.toString(), true);
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream3 = fileOutputStream;
            mly.b("PicUtil", "error = " + e.getClass().getSimpleName(), true);
            r10 = fileOutputStream3;
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                    r10 = fileOutputStream3;
                } catch (IOException e7) {
                    e = e7;
                    sb = new StringBuilder("error = ");
                    sb.append(e.getClass().getSimpleName());
                    mly.b("PicUtil", sb.toString(), true);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            r10 = fileOutputStream;
            if (r10 != 0) {
                try {
                    r10.close();
                } catch (IOException e8) {
                    mly.b("PicUtil", "error = " + e8.getClass().getSimpleName(), true);
                }
            }
            throw th;
        }
        bitmapA.recycle();
        return true;
    }

    private static Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth / i;
            int i4 = options.outHeight / i2;
            if (i3 >= i4) {
                i3 = i4;
            }
            if (i3 < 1) {
                i3 = 1;
            }
            mly.a("PicUtil", "Picture resolution compression scale：" + i3, true);
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            int iC = c(str);
            mly.a("PicUtil", "Picture resolution degree：" + iC, true);
            return iC != 0 ? a(iC, bitmapDecodeFile) : bitmapDecodeFile;
        } catch (OutOfMemoryError unused) {
            mly.b("PicUtil", "compressByResolution OutOfMemoryError", true);
            return null;
        } catch (RuntimeException unused2) {
            mly.b("PicUtil", "compressByResolution RuntimeException", true);
            return null;
        } catch (Exception unused3) {
            mly.b("PicUtil", "compressByResolution Exception", true);
            return null;
        }
    }

    private static int c(String str) {
        int attributeInt;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            mly.b("PicUtil", "readImageDegree IOException" + e.getClass().getSimpleName(), true);
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    private static Bitmap a(int i, Bitmap bitmap) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        mly.a("PicUtil", "rotaingImageView", true);
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static boolean a(Context context, Uri uri, Uri uri2, boolean z) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStreamCreateOutputStream;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        InputStream inputStreamOpenInputStream = null;
        try {
            assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri2, "rw");
            if (assetFileDescriptorOpenAssetFileDescriptor == null || uri2 == null || uri == null) {
                fileOutputStreamCreateOutputStream = null;
            } else {
                try {
                    fileOutputStreamCreateOutputStream = assetFileDescriptorOpenAssetFileDescriptor.createOutputStream();
                } catch (IOException unused) {
                    fileOutputStreamCreateOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStreamCreateOutputStream = null;
                }
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    byte[] bArr = new byte[16384];
                    if (inputStreamOpenInputStream != null) {
                        while (true) {
                            int i = inputStreamOpenInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStreamCreateOutputStream.write(bArr, 0, i);
                        }
                    }
                } catch (IOException unused2) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            mly.a("PicUtil", "error e = " + e.getClass().getSimpleName(), true);
                            return false;
                        }
                    }
                    if (fileOutputStreamCreateOutputStream != null) {
                        fileOutputStreamCreateOutputStream.close();
                    }
                    if (z && uri != null) {
                        context.getContentResolver().delete(uri, "", new String[0]);
                    }
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e2) {
                            mly.a("PicUtil", "error e = " + e2.getClass().getSimpleName(), true);
                            throw th;
                        }
                    }
                    if (fileOutputStreamCreateOutputStream != null) {
                        fileOutputStreamCreateOutputStream.close();
                    }
                    if (z && uri != null) {
                        context.getContentResolver().delete(uri, "", new String[0]);
                    }
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                    }
                    throw th;
                }
            }
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    mly.a("PicUtil", "error e = " + e3.getClass().getSimpleName(), true);
                }
            }
            if (fileOutputStreamCreateOutputStream != null) {
                fileOutputStreamCreateOutputStream.close();
            }
            if (z && uri != null) {
                context.getContentResolver().delete(uri, "", new String[0]);
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                assetFileDescriptorOpenAssetFileDescriptor.close();
            }
            return true;
        } catch (IOException unused3) {
            fileOutputStreamCreateOutputStream = null;
            assetFileDescriptorOpenAssetFileDescriptor = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStreamCreateOutputStream = null;
            assetFileDescriptorOpenAssetFileDescriptor = null;
        }
    }

    public static void e(Context context) {
        mly.a("PicUtil", "deleteCachedFiles", true);
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            File file = new File(strA);
            if (file.exists() && file.isDirectory()) {
                a(file);
            }
        } catch (RuntimeException unused) {
            mly.b("PicUtil", "deleteCachedFiles RuntimeException", true);
        } catch (Exception unused2) {
            mly.b("PicUtil", "deleteCachedFiles Exception", true);
        }
    }

    private static void a(File file) {
        if (file == null) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            mly.a("PicUtil", "deleteDirInnerPicFile files == null", true);
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().startsWith("HwID_card_") && !file2.delete()) {
                mly.a("PicUtil", "delete file fail", true);
            }
        }
    }
}
