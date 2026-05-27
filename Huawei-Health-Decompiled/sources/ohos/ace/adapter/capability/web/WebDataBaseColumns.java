package ohos.ace.adapter.capability.web;

import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes11.dex */
public class WebDataBaseColumns {

    public static class EntryColumns implements BaseColumns {
        public static final String COLUMN_NAME_HOST = "host";
        public static final String COLUMN_NAME_HTTP_AUTH_ID = "http_auth_id";
        public static final String COLUMN_NAME_ORIGIN = "origin";
        public static final String COLUMN_NAME_REALM = "realm";
        public static final String COLUMN_NAME_RESULT = "result";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_USERPASS = "password";
        public static final String TABLE_NAME_CREDENTIAL = "credential";
        public static final String TABLE_NAME_GEOLOCATION = "geolocation";
        public static final String TABLE_NAME_HTTPAUTH = "http_auth";
    }

    private WebDataBaseColumns() {
    }
}
