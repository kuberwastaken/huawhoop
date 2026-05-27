package org.apache.commons.io.file;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes8.dex */
@FunctionalInterface
public interface PathFilter {
    FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes);
}
