package defpackage;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskContextImpl;", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskMode", "", "(I)V", "getTaskMode", "()I", "afterTask", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class xug implements TaskContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19138a;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    public xug(int i) {
        this.f19138a = i;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    /* JADX INFO: renamed from: getTaskMode, reason: from getter */
    public int getF19138a() {
        return this.f19138a;
    }
}
