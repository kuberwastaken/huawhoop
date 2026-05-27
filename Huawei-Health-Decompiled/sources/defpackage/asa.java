package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.haf.bundle.InstallSessionState;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class asa implements InstallSessionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f293a;
    private final List<String> b;
    private final int c;
    private final List<String> d;
    private final int e;
    private final long f;
    private final int g;
    private final PendingIntent h;
    private final List<Intent> j;

    private asa(Bundle bundle) {
        this.c = bundle.getInt("session_id");
        this.g = bundle.getInt("status");
        this.e = bundle.getInt("error_code");
        this.f293a = bundle.getLong("bytes_downloaded");
        this.f = bundle.getLong("total_bytes_to_download");
        this.b = bundle.getStringArrayList("module_names");
        this.d = bundle.getStringArrayList("download_module_names");
        this.h = (PendingIntent) bundle.getParcelable("user_confirmation_intent");
        this.j = bundle.getParcelableArrayList("split_file_intents");
    }

    private asa(int i, int i2, asa asaVar) {
        this.c = asaVar.c;
        this.g = i;
        this.e = i2;
        this.f293a = asaVar.f293a;
        this.f = asaVar.f;
        this.b = asaVar.b;
        this.d = asaVar.d;
        this.h = asaVar.h;
        this.j = asaVar.j;
    }

    final asa d(int i) {
        return e(i, errorCode());
    }

    final asa e(int i, int i2) {
        return new asa(i, i2, this);
    }

    static asa fx_(Bundle bundle) {
        return new asa(bundle);
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public int sessionId() {
        return this.c;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public int status() {
        return this.g;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public int errorCode() {
        return this.e;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public long bytesDownloaded() {
        return this.f293a;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public long totalBytesToDownload() {
        return this.f;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public List<String> moduleNames() {
        return this.b;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public List<String> downloadModuleNames() {
        return this.d;
    }

    @Override // com.huawei.haf.bundle.InstallSessionState
    public final PendingIntent resolutionIntent() {
        return this.h;
    }

    final List<Intent> e() {
        return this.j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("InstallSessionState{taskId=");
        sb.append(this.c);
        sb.append(", status=");
        sb.append(this.g);
        sb.append(", errorCode=");
        sb.append(this.e);
        sb.append(", bytes=");
        sb.append(this.f293a);
        sb.append(", totalBytes=");
        sb.append(this.f);
        sb.append(", moduleNames=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
