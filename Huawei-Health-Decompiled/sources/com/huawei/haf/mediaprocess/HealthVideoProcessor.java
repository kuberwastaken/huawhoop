package com.huawei.haf.mediaprocess;

import android.content.Context;
import android.media.MediaExtractor;
import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HealthVideoProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f2168a = 20;

    private HealthVideoProcessor() {
    }

    public static class Processor {
        private Context d;
        private boolean e = true;

        public Processor(Context context) {
            this.d = context;
        }
    }

    public static class MediaSource {
        private Uri b;
        private Context d;
        private String e;

        public void AI_(MediaExtractor mediaExtractor) throws IOException {
            String str = this.e;
            if (str != null) {
                mediaExtractor.setDataSource(str);
            } else {
                mediaExtractor.setDataSource(this.d, this.b, (Map<String, String>) null);
            }
        }
    }
}
