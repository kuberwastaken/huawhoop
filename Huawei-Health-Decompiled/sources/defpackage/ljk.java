package defpackage;

import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import com.huawei.openalliance.ad.constant.Constants;
import health.compact.a.util.LogUtil;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: classes6.dex */
public class ljk {
    private final SimpleArrayMap<SocketChannel, ljo> e = new SimpleArrayMap<>(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap<String, ljo> f15239a = new SimpleArrayMap<>(8);
    private final Object b = new Object();

    public void a(ljo ljoVar) {
        if (ljoVar == null) {
            LogUtil.c("DistributionNetworkProxyStreamsMap", "stream is null");
            return;
        }
        synchronized (this.b) {
            this.e.put(ljoVar.h(), ljoVar);
            this.f15239a.put(b(ljoVar.f(), ljoVar.j()), ljoVar);
        }
    }

    public ljo d(SocketChannel socketChannel) {
        ljo ljoVar;
        if (socketChannel == null) {
            LogUtil.c("DistributionNetworkProxyStreamsMap", "removeStream() channel is null");
            return new ljo(false);
        }
        synchronized (this.b) {
            ljoVar = this.e.get(socketChannel);
            if (ljoVar != null) {
                this.e.remove(ljoVar.h());
                this.f15239a.remove(b(ljoVar.f(), ljoVar.j()));
                LogUtil.a("DistributionNetworkProxyStreamsMap", "had removed from map");
            }
        }
        return ljoVar;
    }

    public void a() {
        synchronized (this.b) {
            this.e.clear();
            this.f15239a.clear();
        }
    }

    public ljo e(SocketChannel socketChannel) {
        ljo ljoVar;
        if (socketChannel == null) {
            LogUtil.c("DistributionNetworkProxyStreamsMap", "getStream() channel is null");
            return new ljo(false);
        }
        synchronized (this.b) {
            ljoVar = this.e.get(socketChannel);
        }
        return ljoVar;
    }

    public ljo c(String str, int i) {
        ljo ljoVar;
        if (TextUtils.isEmpty(str) || i < 0) {
            LogUtil.c("DistributionNetworkProxyStreamsMap", "nodeId: ", str, "streamId: ", Integer.valueOf(i));
            return new ljo(false);
        }
        synchronized (this.b) {
            ljoVar = this.f15239a.get(b(str, i));
        }
        return ljoVar;
    }

    private static String b(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 0) {
            LogUtil.c("DistributionNetworkProxyStreamsMap", "nodeId: ", str, "streamId: ", Integer.valueOf(i));
            return "";
        }
        return str + Constants.LINK + i;
    }
}
