package defpackage;

import com.huawei.wearengine.channel.ChannelState;

/* JADX INFO: loaded from: classes8.dex */
public class wrb implements ChannelState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18865a;
    private String b;

    public void b(int i) {
        this.f18865a = i;
    }

    public String e() {
        String str = this.b;
        return str == null ? "" : str;
    }

    public void d(String str) {
        this.b = str;
    }

    @Override // com.huawei.wearengine.channel.ChannelState
    public boolean isChannelOpen() {
        return this.f18865a == 1;
    }
}
