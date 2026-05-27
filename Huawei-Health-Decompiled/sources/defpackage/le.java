package defpackage;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class le implements FileFilter {
    public final /* synthetic */ ld d;

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }

    public le(ld ldVar) {
        this.d = ldVar;
    }
}
