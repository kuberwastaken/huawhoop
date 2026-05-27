package defpackage;

import com.huawei.featureuserprofile.media.UserInfoMedia;
import com.huawei.up.model.UserInfomation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class csa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f12017a = new Object();
    private List<UserInfoMedia.UserInfoReader.Callback> b = new ArrayList();

    public void d(UserInfoMedia.UserInfoReader.Callback callback) {
        synchronized (f12017a) {
            this.b.add(callback);
        }
    }

    private void a(int i, UserInfomation userInfomation) {
        synchronized (f12017a) {
            for (UserInfoMedia.UserInfoReader.Callback callback : this.b) {
                if (i == 0) {
                    callback.onSuccess(userInfomation);
                } else {
                    callback.onFail(i);
                }
            }
            this.b.clear();
        }
    }

    public void a() {
        synchronized (f12017a) {
            Iterator<UserInfoMedia.UserInfoReader.Callback> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onFail(-1);
            }
            this.b.clear();
        }
    }

    public void c(int i, UserInfomation userInfomation) {
        synchronized (f12017a) {
            a(i, userInfomation);
        }
    }
}
