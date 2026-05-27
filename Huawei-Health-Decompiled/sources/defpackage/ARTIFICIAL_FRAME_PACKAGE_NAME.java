package defpackage;

import kotlin.Metadata;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: renamed from: b, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"ARTIFICIAL_FRAME_PACKAGE_NAME", "", "getARTIFICIAL_FRAME_PACKAGE_NAME", "()Ljava/lang/String;", "artificialFrame", "Ljava/lang/StackTraceElement;", "", "name", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ARTIFICIAL_FRAME_PACKAGE_NAME {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f390a = "_COROUTINE";

    public static final String a() {
        return f390a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement a(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f390a + FilenameUtils.EXTENSION_SEPARATOR + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
