package com.huawei.ui.commonui.utils;

/* JADX INFO: loaded from: classes7.dex */
public class ResInfo {

    public enum Location {
        HOME("home_page");

        private String mLocation;

        Location(String str) {
            this.mLocation = str;
        }

        public String getLocation() {
            return this.mLocation;
        }
    }
}
