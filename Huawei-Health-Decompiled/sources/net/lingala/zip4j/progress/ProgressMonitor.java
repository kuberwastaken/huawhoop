package net.lingala.zip4j.progress;

/* JADX INFO: loaded from: classes8.dex */
public class ProgressMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16023a;
    private boolean b;
    private String c;
    private Task d;
    private Exception e;
    private int f;
    private State g;
    private long h;
    private Result i;
    private long j;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        b();
    }

    public void e(long j) {
        long j2 = this.j + j;
        this.j = j2;
        long j3 = this.h;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.f = i;
            if (i > 100) {
                this.f = 100;
            }
        }
        while (this.f16023a) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void c() {
        this.i = Result.SUCCESS;
        this.f = 100;
        b();
    }

    public void d(Exception exc) {
        this.i = Result.ERROR;
        this.e = exc;
        b();
    }

    public void e() {
        b();
        this.c = null;
        this.h = 0L;
        this.j = 0L;
        this.f = 0;
    }

    private void b() {
        this.d = Task.NONE;
        this.g = State.READY;
    }

    public State d() {
        return this.g;
    }

    public void d(State state) {
        this.g = state;
    }

    public void b(long j) {
        this.h = j;
    }

    public void e(Task task) {
        this.d = task;
    }

    public void a(String str) {
        this.c = str;
    }

    public void e(Result result) {
        this.i = result;
    }

    public boolean a() {
        return this.b;
    }
}
