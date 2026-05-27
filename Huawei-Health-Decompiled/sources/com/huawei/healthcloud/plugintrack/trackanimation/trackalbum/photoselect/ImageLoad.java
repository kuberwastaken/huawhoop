package com.huawei.healthcloud.plugintrack.trackanimation.trackalbum.photoselect;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.huawei.healthcloud.plugintrack.trackanimation.trackalbum.utils.PhotoModel;
import com.huawei.openalliance.ad.constant.MimeType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ImageLoad extends AsyncTaskLoader<List<PhotoModel>> {
    private static final String[] d = {"_id", "_data", "mime_type", "width", "height", "_size"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Loader<List<PhotoModel>>.ForceLoadContentObserver f3737a;
    private boolean b;
    private List<PhotoModel> c;

    public ImageLoad(Context context) {
        super(context);
        this.c = null;
        this.b = false;
        this.f3737a = new Loader.ForceLoadContentObserver();
    }

    @Override // androidx.loader.content.Loader
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void deliverResult(List<PhotoModel> list) {
        if (isReset() || !isStarted()) {
            return;
        }
        super.deliverResult(list);
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        List<PhotoModel> list = this.c;
        if (list != null) {
            deliverResult(list);
        }
        if (takeContentChanged() || this.c == null) {
            forceLoad();
        }
        e();
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        this.c = null;
        a();
    }

    @Override // androidx.loader.content.Loader
    public void onAbandon() {
        super.onAbandon();
        a();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<PhotoModel> loadInBackground() {
        return c();
    }

    private List<PhotoModel> c() {
        List<PhotoModel> listB = b();
        this.c = listB;
        return listB;
    }

    private boolean d(String str) {
        return str != null && (MimeType.GIF.equals(str) || "image/GIF".equals(str));
    }

    private List<PhotoModel> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = getContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, d, null, null, "_id DESC");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                int columnIndex = cursorQuery.getColumnIndex("mime_type");
                int columnIndex2 = cursorQuery.getColumnIndex("width");
                int columnIndex3 = cursorQuery.getColumnIndex("height");
                do {
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    String string2 = cursorQuery.getString(columnIndex);
                    int i = cursorQuery.getInt(columnIndex2);
                    int i2 = cursorQuery.getInt(columnIndex3);
                    if (!TextUtils.isEmpty(string) && new File(string).exists() && !TextUtils.isEmpty(string2) && i2 <= i * 3 && i <= i2 * 3 && !d(string2) && !string.toLowerCase(Locale.ENGLISH).contains(".dng")) {
                        int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("_id");
                        int columnIndex4 = cursorQuery.getColumnIndex("_size");
                        long j = cursorQuery.getLong(columnIndexOrThrow2);
                        arrayList.add(new PhotoModel(j, string, string2).setWidth(i).setHeight(i2).setSize(cursorQuery.getLong(columnIndex4)).setTime(0L));
                    }
                } while (cursorQuery.moveToNext());
                return arrayList;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private void e() {
        if (this.b) {
            return;
        }
        getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f3737a);
        this.b = true;
    }

    private void a() {
        if (this.b) {
            this.b = false;
            getContext().getContentResolver().unregisterContentObserver(this.f3737a);
        }
    }
}
