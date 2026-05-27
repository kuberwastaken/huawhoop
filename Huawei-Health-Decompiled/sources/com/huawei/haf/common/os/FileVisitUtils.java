package com.huawei.haf.common.os;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FileVisitUtils {

    public interface VisitOperation {
        Path getRootPath();

        void visit(Path path, BasicFileAttributes basicFileAttributes, boolean z, int i, long j);

        void visitRootBegin();

        void visitRootEnd(long j);
    }

    private FileVisitUtils() {
    }

    public static long d(VisitOperation visitOperation) throws IOException {
        DirectoryInfoVisitor directoryInfoVisitor = new DirectoryInfoVisitor(visitOperation);
        Files.walkFileTree(visitOperation.getRootPath(), directoryInfoVisitor);
        return directoryInfoVisitor.d();
    }

    static long e(Path path) throws IOException {
        SizeDirectoryInfo sizeDirectoryInfo = new SizeDirectoryInfo();
        Files.walkFileTree(path, sizeDirectoryInfo);
        return sizeDirectoryInfo.e();
    }

    static class SizeDirectoryInfo extends SimpleFileVisitor<Path> {
        private long c;

        private SizeDirectoryInfo() {
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            super.visitFile(path, basicFileAttributes);
            if (!basicFileAttributes.isSymbolicLink()) {
                this.c += basicFileAttributes.size();
            }
            return FileVisitResult.CONTINUE;
        }

        public long e() {
            return this.c;
        }
    }

    static class DirectoryNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BasicFileAttributes f2138a;
        long c;

        DirectoryNode(BasicFileAttributes basicFileAttributes) {
            this.f2138a = basicFileAttributes;
        }
    }

    static class DirectoryInfoVisitor extends SimpleFileVisitor<Path> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque<DirectoryNode> f2137a = new ArrayDeque<>();
        private long b;
        private final VisitOperation c;

        DirectoryInfoVisitor(VisitOperation visitOperation) {
            this.c = visitOperation;
        }

        public long d() {
            return this.b;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            super.preVisitDirectory(path, basicFileAttributes);
            this.f2137a.push(new DirectoryNode(basicFileAttributes));
            return FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            super.visitFile(path, basicFileAttributes);
            if (!basicFileAttributes.isSymbolicLink()) {
                long size = basicFileAttributes.size();
                this.f2137a.peek().c += size;
                this.c.visit(path, basicFileAttributes, false, this.f2137a.size(), size);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
            DirectoryNode directoryNodePop = this.f2137a.pop();
            if (this.f2137a.isEmpty()) {
                this.b = directoryNodePop.c;
            } else {
                this.f2137a.peek().c += directoryNodePop.c;
                this.c.visit(path, directoryNodePop.f2138a, true, this.f2137a.size(), directoryNodePop.c);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static class PrintVisitOperation implements VisitOperation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2140a;
        private final boolean b;
        private final PrintStream c;
        private final Path d;
        private final int e;
        private final PrintWriter f;

        protected boolean c(String str, boolean z, int i, long j) {
            return true;
        }

        public PrintVisitOperation(File file, PrintStream printStream) {
            this(file.toPath(), Integer.MAX_VALUE, true, printStream, null);
        }

        private PrintVisitOperation(Path path, int i, boolean z, PrintStream printStream, PrintWriter printWriter) {
            this.d = path;
            this.e = path.getNameCount();
            this.f2140a = i;
            this.b = z;
            this.c = printStream;
            this.f = printWriter;
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public Path getRootPath() {
            return this.d;
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visitRootBegin() {
            c("Path, Depth, Type, Size");
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visit(Path path, BasicFileAttributes basicFileAttributes, boolean z, int i, long j) {
            if (!(this.c == null && this.f == null) && this.f2140a >= i) {
                if (z) {
                    if (!this.b && j <= 0) {
                        return;
                    }
                } else if (!this.b) {
                    return;
                }
                String string = path.subpath(this.e, path.getNameCount()).toString();
                if (c(string, z, i, j)) {
                    b(string);
                    b(", ");
                    b(String.valueOf(i));
                    b(z ? ", D, " : ", F, ");
                    b(String.valueOf(j));
                    e();
                }
            }
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visitRootEnd(long j) {
            c(this.d + ", 0, D, " + j);
        }

        private void e() {
            PrintStream printStream = this.c;
            if (printStream != null) {
                printStream.println();
            }
            PrintWriter printWriter = this.f;
            if (printWriter != null) {
                printWriter.println();
            }
        }

        private void c(String str) {
            PrintStream printStream = this.c;
            if (printStream != null) {
                printStream.println(str);
            }
            PrintWriter printWriter = this.f;
            if (printWriter != null) {
                printWriter.println(str);
            }
        }

        private void b(String str) {
            PrintStream printStream = this.c;
            if (printStream != null) {
                printStream.print(str);
            }
            PrintWriter printWriter = this.f;
            if (printWriter != null) {
                printWriter.print(str);
            }
        }
    }

    public static class MapVisitOperation implements VisitOperation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2139a;
        private final int b;
        private final Path c;
        private final Map<String, Long> d;
        private int e;

        protected boolean e(String str, boolean z, int i, long j) {
            return true;
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visitRootBegin() {
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visitRootEnd(long j) {
        }

        public MapVisitOperation(File file, Map<String, Long> map) {
            this(file.toPath(), 0, map);
        }

        public MapVisitOperation(Path path, int i, Map<String, Long> map) {
            this.c = path;
            this.f2139a = path.getNameCount();
            if (map == null) {
                this.b = 0;
                this.d = Collections.EMPTY_MAP;
            } else {
                this.b = i;
                this.d = map;
            }
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public Path getRootPath() {
            return this.c;
        }

        @Override // com.huawei.haf.common.os.FileVisitUtils.VisitOperation
        public void visit(Path path, BasicFileAttributes basicFileAttributes, boolean z, int i, long j) {
            if (z) {
                if (this.b > 0 || this.d.size() != this.e) {
                    String string = path.subpath(this.f2139a, path.getNameCount()).toString();
                    int i2 = this.b;
                    if ((i2 <= 0 || i > i2 || !e(string, z, i, j)) && !this.d.containsKey(string)) {
                        return;
                    }
                    this.d.put(string, Long.valueOf(j));
                    this.e++;
                }
            }
        }
    }
}
