package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.common.dfx.DfxUtils;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.ReleaseLogUtil;
import java.util.IllegalFormatConversionException;
import java.util.Locale;
import java.util.MissingFormatArgumentException;

/* JADX INFO: loaded from: classes.dex */
public class pla {
    private static Context c(Context context) {
        return context == null ? BaseApplication.a() : context;
    }

    public static int a(String str, String str2, Class cls) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtil.j("ResourcesUtils", "getStringResourcesId name ", str, " resourceType ", str2);
            return -1;
        }
        Context contextA = BaseApplication.a();
        int identifier = contextA.getResources().getIdentifier(str, str2, contextA.getPackageName());
        if (identifier > 0) {
            return identifier;
        }
        if (cls == null) {
            LogUtil.j("ResourcesUtils", "getStringResourcesId clazz is null resourceType ", str2);
            return -1;
        }
        try {
            try {
                return cls.getDeclaredField(str).getInt(cls);
            } catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException e) {
                LogUtil.a("ResourcesUtils", "getStringResourcesId getInt exception ", ExceptionUtils.a(e));
                return -1;
            }
        } catch (NoSuchFieldException | SecurityException e2) {
            LogUtil.a("ResourcesUtils", "getStringResourcesId getDeclaredField exception ", ExceptionUtils.a(e2));
            return -1;
        }
    }

    public static View cVJ_(Context context, int i, ViewGroup viewGroup) {
        if (context == null) {
            LogUtil.j("ResourcesUtils", "inflate context is null");
            return null;
        }
        try {
            return View.inflate(context, i, viewGroup);
        } catch (Resources.NotFoundException | InflateException e) {
            LogUtil.a("ResourcesUtils", "inflate exception ", ExceptionUtils.a(e));
            return null;
        }
    }

    public static View cVK_(Context context, int i, ViewGroup viewGroup, boolean z) {
        if (context == null) {
            LogUtil.j("ResourcesUtils", "inflate context is null");
            return null;
        }
        try {
            return LayoutInflater.from(context).inflate(i, viewGroup, z);
        } catch (Resources.NotFoundException | InflateException e) {
            LogUtil.a("ResourcesUtils", "inflate exception ", ExceptionUtils.a(e));
            return null;
        }
    }

    public static float b(int i) {
        try {
            return BaseApplication.a().getResources().getDimension(i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getDimension exception ", ExceptionUtils.a(e));
            return 0.0f;
        }
    }

    public static int a(int i) {
        try {
            return BaseApplication.a().getResources().getDimensionPixelSize(i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getDimensionPixelSize exception ", ExceptionUtils.a(e));
            return 0;
        }
    }

    public static int c(int i) {
        try {
            return BaseApplication.a().getResources().getDimensionPixelOffset(i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getDimensionPixelOffset exception ", ExceptionUtils.a(e));
            return 0;
        }
    }

    public static int d(int i) {
        return c(BaseApplication.a(), i);
    }

    public static int c(Context context, int i) {
        try {
            return ContextCompat.getColor(c(context), i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getColor exception ", ExceptionUtils.a(e));
            return 0;
        }
    }

    public static Drawable cVH_(int i) {
        return cVI_(BaseApplication.a(), i);
    }

    public static Drawable cVI_(Context context, int i) {
        try {
            return ContextCompat.getDrawable(c(context), i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getDrawable exception ", ExceptionUtils.a(e));
            return null;
        }
    }

    public static String j(int i) {
        try {
            return BaseApplication.a().getResources().getResourceName(i);
        } catch (Resources.NotFoundException e) {
            ReleaseLogUtil.a("ResourcesUtils", "getResourceName exception ", DfxUtils.b(Thread.currentThread(), e));
            return "";
        }
    }

    public static CharSequence f(int i) {
        try {
            return BaseApplication.a().getResources().getText(i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getText exception ", ExceptionUtils.a(e));
            return "";
        }
    }

    public static String h(int i) {
        return e(BaseApplication.a(), i);
    }

    public static String e(Context context, int i) {
        try {
            return c(context).getResources().getString(i);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("ResourcesUtils", "getString exception ", ExceptionUtils.a(e));
            return "";
        }
    }

    public static String d(int i, Object... objArr) {
        return d(BaseApplication.a(), i, objArr);
    }

    public static String d(Context context, int i, Object... objArr) {
        try {
            return c(context).getResources().getString(i, objArr);
        } catch (Resources.NotFoundException | IllegalFormatConversionException | MissingFormatArgumentException e) {
            LogUtil.a("ResourcesUtils", "getString exception ", ExceptionUtils.a(e));
            return "";
        }
    }

    public static String a(int i, int i2, Object... objArr) {
        try {
            return BaseApplication.a().getResources().getQuantityString(i, i2, objArr);
        } catch (Resources.NotFoundException | IllegalFormatConversionException | MissingFormatArgumentException e) {
            LogUtil.a("ResourcesUtils", "getQuantityString exception ", ExceptionUtils.a(e));
            return "";
        }
    }

    public static String[] i(int i) {
        try {
            return BaseApplication.a().getResources().getStringArray(i);
        } catch (Resources.NotFoundException | IllegalFormatConversionException | MissingFormatArgumentException e) {
            LogUtil.a("ResourcesUtils", "getStringArray exception ", ExceptionUtils.a(e));
            return new String[0];
        }
    }

    public static int[] g(int i) {
        try {
            return BaseApplication.a().getResources().getIntArray(i);
        } catch (Resources.NotFoundException | IllegalFormatConversionException | MissingFormatArgumentException e) {
            LogUtil.a("ResourcesUtils", "getIntArray exception ", ExceptionUtils.a(e));
            return new int[0];
        }
    }

    public static Resources cVG_(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(Locale.ENGLISH);
        return context.createConfigurationContext(configuration).getResources();
    }
}
