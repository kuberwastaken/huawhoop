package ohos.ace.adapter;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public final class DumpHelper {
    private static final String LOG_TAG = "DumpHelper";
    private static final HashSet<String> PARAMETERS = new HashSet<String>() { // from class: ohos.ace.adapter.DumpHelper.1
        {
            add("-h");
            add("-element");
            add("-render");
            add("-focus");
            add("-memory");
            add("-layer");
            add("-frontend");
            add("-accessibility");
            add("-rotation");
            add("-pipeline");
        }
    };

    private static native void nativeDump(int i, String str, FileDescriptor fileDescriptor, String[] strArr);

    private DumpHelper() {
    }

    public static void dump(int i, String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (fileDescriptor == null || strArr == null) {
            ALog.w(LOG_TAG, "dump failed, fd pr args is null");
            return;
        }
        if (strArr.length == 0) {
            printString(fileDescriptor, "Param length is null" + System.lineSeparator());
            return;
        }
        if ("-h".equals(strArr[0])) {
            str2 = "Usage:" + System.lineSeparator() + "    -element                       dump information of Element tree." + System.lineSeparator() + "    -render                        dump information of Render tree." + System.lineSeparator() + "    -layer                         dump information of Layer tree." + System.lineSeparator() + "    -foucs                         dump information of Focus tree." + System.lineSeparator() + "    -frontend                      dump information of Frontend." + System.lineSeparator() + "    -pipeline                      dump information of Pipeline context." + System.lineSeparator() + "    -memory                        dump information of Memory usage." + System.lineSeparator() + "    -accessibility                 dump information of accessibility tree." + System.lineSeparator() + "    -accessibility <ID>            dump the property of accessibility node with <ID>." + System.lineSeparator() + "    -accessibility <ID> <action>   dispatch the accessibility event to node with <ID>, <action> as below:." + System.lineSeparator() + "                                     2  --- custom event" + System.lineSeparator() + "                                     10 --- click event" + System.lineSeparator() + "                                     11 --- long click event" + System.lineSeparator() + "                                     12 --- scroll forward" + System.lineSeparator() + "                                     13 --- scroll backward" + System.lineSeparator() + "                                     14 --- focus event" + System.lineSeparator() + "    -rotation <value>              dispatch the rotation event." + System.lineSeparator();
        } else {
            str2 = "";
        }
        if (!PARAMETERS.contains(strArr[0])) {
            str2 = "'" + strArr[0] + "' is not a vaild parameter, See '-h'." + System.lineSeparator();
        }
        if (!str2.isEmpty()) {
            printString(fileDescriptor, str2);
        } else {
            nativeDump(i, str, fileDescriptor, strArr);
        }
    }

    private static void printString(FileDescriptor fileDescriptor, String str) {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
                try {
                    fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (FileNotFoundException unused) {
                ALog.e(LOG_TAG, "Dump failed, file not found");
            }
        } catch (IOException | SecurityException unused2) {
            ALog.e(LOG_TAG, "Dump failed, security or io exception");
        }
    }
}
