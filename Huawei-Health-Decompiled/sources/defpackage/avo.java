package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class avo {
    private static avo c;
    private Context b;
    private SharedPreferences d;

    private avo(Context context) {
        this(context, 0);
    }

    public static avo c(Context context) {
        avo avoVar;
        synchronized (avo.class) {
            if (c == null) {
                c = new avo(context);
            }
            avoVar = c;
        }
        return avoVar;
    }

    private boolean g(String str) {
        return str.endsWith("_last_report_num") || str.endsWith("_last_report_time") || str.endsWith("_first_prepare_time") || str.endsWith("_latest_prepare_traceId") || str.endsWith("_call_prepare_sync_times") || str.endsWith("_each_period_call_prepare_sync_times");
    }

    public void a() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.remove("syncType").commit();
        editorEdit.remove("dataType").commit();
        editorEdit.remove("service_disconnected_time").commit();
        editorEdit.remove("trace_id").commit();
    }

    public long b(String str, String str2) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return 0L;
            }
            return sharedPreferences.getLong(str + "_" + str2 + "_last_get_service_exceedlimits_time", 0L);
        }
    }

    public boolean b() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            return sharedPreferences.getBoolean("updated_support_recycle", false);
        }
    }

    public String c() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("dataType", "");
        }
    }

    public String f() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("syncType", "");
        }
    }

    public long h(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return 0L;
            }
            return sharedPreferences.getLong(str + "_first_prepare_time", 0L);
        }
    }

    public String h() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("service_disconnected_time", "");
        }
    }

    public String i() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("trace_id", "");
        }
    }

    private avo(Context context, int i) {
        this.b = context;
        this.d = avq.gC_(context, "SharedPreferencesUtil", i);
    }

    public boolean a(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_last_report_time");
            return editorEdit.commit();
        }
    }

    public boolean b(String str, String str2, long j) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.putLong(str + "_" + str2 + "_last_get_service_exceedlimits_time", j);
            return editorEdit.commit();
        }
    }

    public boolean c(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_latest_prepare_traceId");
            return editorEdit.commit();
        }
    }

    public int f(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return 0;
            }
            return sharedPreferences.getInt(str + "_each_period_call_prepare_sync_times", 0);
        }
    }

    public boolean i(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_last_report_num");
            return editorEdit.commit();
        }
    }

    public int j(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return 0;
            }
            return sharedPreferences.getInt(str + "_call_prepare_sync_times", 0);
        }
    }

    public boolean d(boolean z) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.putBoolean("updated_support_recycle", z);
            return editorEdit.commit();
        }
    }

    public boolean b(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_first_prepare_time");
            return editorEdit.commit();
        }
    }

    public boolean e(String str, List<String> list) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                editorEdit.remove(str + "_" + it.next() + "_upperlimits").commit();
            }
            return true;
        }
    }

    public boolean e(String str, String str2, String str3, String str4) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            if (str == null) {
                str = "";
            }
            editorEdit.putString("syncType", str);
            if (str2 == null) {
                str2 = "";
            }
            editorEdit.putString("dataType", str2);
            if (str3 == null) {
                str3 = "";
            }
            editorEdit.putString("service_disconnected_time", str3);
            if (str4 == null) {
                str4 = "";
            }
            editorEdit.putString("trace_id", str4);
            return editorEdit.commit();
        }
    }

    public long c(String str, String str2) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return -1L;
            }
            return sharedPreferences.getLong(str + "_" + str2 + "_upperlimits", -1L);
        }
    }

    public boolean d(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_each_period_call_prepare_sync_times");
            return editorEdit.commit();
        }
    }

    public boolean a(String str, String str2, long j) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.putLong(str + "_" + str2 + "_upperlimits", j);
            return editorEdit.commit();
        }
    }

    public void e() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return;
            }
            Iterator<Map.Entry<String, ?>> it = sharedPreferences.getAll().entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && g(key)) {
                    SharedPreferences.Editor editorEdit = this.d.edit();
                    if (editorEdit == null) {
                        return;
                    } else {
                        editorEdit.remove(key).commit();
                    }
                }
            }
        }
    }

    public boolean a(String str, List<String> list) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                editorEdit.remove(str + "_" + it.next() + "_last_get_service_exceedlimits_time").commit();
            }
            return true;
        }
    }

    public boolean e(String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return false;
            }
            editorEdit.remove(str + "_call_prepare_sync_times");
            return editorEdit.commit();
        }
    }

    public void d() {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.d;
            if (sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }
}
