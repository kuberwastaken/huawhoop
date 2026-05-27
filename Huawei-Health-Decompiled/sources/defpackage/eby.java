package defpackage;

import android.text.TextUtils;
import com.huawei.profile.coordinator.ProfileRequestConstants;
import com.huawei.profile.profile.DeviceProfile;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class eby {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeviceProfile f12528a;
    private Map<String, Object> c;
    private Map<String, Object> e;

    private eby() {
    }

    public DeviceProfile a() {
        return this.f12528a;
    }

    public Map<String, Object> c() {
        return this.e;
    }

    public Map<String, Object> b() {
        return this.c;
    }

    public static class c {
        DeviceProfile c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Object> f12529a = null;
        private Map<String, Object> b = null;
        private Map<String, Object> e = null;

        public c b(String str) {
            if (this.c == null) {
                this.c = new DeviceProfile();
            }
            this.c.setId(str);
            return this;
        }

        public c o(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put(ProfileRequestConstants.SWV, str);
            return this;
        }

        public c e(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("model", str);
            return this;
        }

        public c g(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("devType", str);
            return this;
        }

        public c i(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("prodId", str);
            return this;
        }

        public c d(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put(ProfileRequestConstants.MANU, str);
            return this;
        }

        public c a(long j) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("timestamp", Long.valueOf(j));
            return this;
        }

        public c c(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put(ProfileRequestConstants.HIV, str);
            return this;
        }

        public c h(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("deviceName", str);
            return this;
        }

        public c f(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("udid", str);
            return this;
        }

        public c a(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put("mac", str);
            return this;
        }

        public c j(String str) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f12529a.put("sn", str);
            }
            return this;
        }

        public c e(int i) {
            if (this.f12529a == null) {
                this.f12529a = new HashMap(10);
            }
            this.f12529a.put(ProfileRequestConstants.PROT_TYPE, Integer.valueOf(i));
            return this;
        }

        public c b(int i) {
            if (this.b == null) {
                this.b = new HashMap(10);
            }
            this.b.put("characteristic.bt.connectionStatus", Integer.valueOf(i));
            return this;
        }

        public c k(String str) {
            if (this.e == null) {
                this.e = new HashMap(10);
            }
            this.e.put("type", str);
            return this;
        }

        public eby d() {
            if (this.c == null || this.f12529a == null || this.b == null || this.e == null) {
                return null;
            }
            eby ebyVar = new eby();
            ebyVar.f12528a = this.c;
            this.c.setIsNeedCloud(true);
            if (this.f12529a.get("devType") instanceof String) {
                this.c.setType((String) this.f12529a.get("devType"));
            }
            this.c.addEntities(this.f12529a);
            ebyVar.e = this.b;
            ebyVar.c = this.e;
            return ebyVar;
        }
    }
}
