package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.huawei.hwidauth.h.b;

/* JADX INFO: loaded from: classes6.dex */
public class mkv extends AsyncTask<Integer, Integer, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f15695a;
    private Context b;
    private b e;

    public mkv(Context context, Uri uri, b bVar) {
        this.b = context;
        this.f15695a = uri;
        this.e = bVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Integer... numArr) throws Throwable {
        mly.a("CompressPictureCase", "startCompressPic", true);
        if (this.f15695a == null) {
            this.e.b(new Bundle());
            return false;
        }
        mly.a("CompressPictureCase", "startCompressPic mFromUri = " + this.f15695a, false);
        Uri uriBXO_ = mmc.bXO_(this.b);
        if (uriBXO_ == null) {
            this.e.b(new Bundle());
            return false;
        }
        mly.a("CompressPictureCase", "startCompressPic tmpUri = " + uriBXO_, false);
        mmc.a(this.b, this.f15695a, uriBXO_, false);
        if (mmc.c(this.b, uriBXO_.getPath(), 4096, uriBXO_.getPath())) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("request_pic_uri_tag", uriBXO_);
            this.e.a(bundle);
            mly.a("CompressPictureCase", "startCompressPic onSuccess", true);
            return true;
        }
        this.e.b(new Bundle());
        mly.a("CompressPictureCase", "startCompressPic onError", true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        mly.a("CompressPictureCase", "onPostExecute", true);
        super.onPostExecute(bool);
    }
}
