package com.huawei.health.h5pro.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLConnection;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralUtil {
    public static final Pattern b = Pattern.compile("^[-\\+]?[\\d]*$");

    public static boolean isShouldSelfProtection(Context context, String str, String[] strArr, boolean z) {
        if (TextUtils.isEmpty(str) || context == null || strArr == null || strArr.length == 0) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return z;
    }

    public static boolean isSafePath(String str) {
        return (TextUtils.isEmpty(str) || str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) ? false : true;
    }

    public static boolean isNumbers(String str) {
        return !TextUtils.isEmpty(str) && b.matcher(str).matches();
    }

    public static <T> T getReferent(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String getMimeType(String str) {
        String contentTypeFor;
        if (TextUtils.isEmpty(str)) {
            LogUtil.w("H5PRO_GeneralUtil", "getMimeType: url is empty");
            return "";
        }
        if (str.contains("#")) {
            str = str.replace("#", "%23");
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            contentTypeFor = "";
        } else {
            contentTypeFor = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            if (!TextUtils.isEmpty(contentTypeFor)) {
                return contentTypeFor;
            }
        }
        LogUtil.w("H5PRO_GeneralUtil", "getMimeType: extension failed -> " + str);
        try {
            contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        } catch (StringIndexOutOfBoundsException e) {
            LogUtil.e("H5PRO_GeneralUtil", "getMimeType: exception -> " + e.getMessage());
        }
        if (!TextUtils.isEmpty(contentTypeFor)) {
            return contentTypeFor;
        }
        LogUtil.w("H5PRO_GeneralUtil", "getMimeType: mimeType is empty -> " + str);
        return "";
    }

    public static String getFileSafePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String path = Uri.parse(str).getPath();
        return TextUtils.isEmpty(path) ? "" : getFileSafePath(new File(path));
    }

    public static String getFileSafePath(File file) {
        if (file == null) {
            return "";
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            LogUtil.e("H5PRO_GeneralUtil", "getFileSafePath: ioException-> " + e.getMessage());
            return "";
        }
    }
}
