package com.huawei.health.sport.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes10.dex */
public class CalorieConsumptionViewModel extends ViewModel {
    private MutableLiveData<b> d = new MutableLiveData<>();

    public static class b {
        public int b;
        public int d;
        public int e;

        public int b() {
            return this.b;
        }

        public int e() {
            return this.d;
        }

        public int c() {
            return this.e;
        }
    }
}
