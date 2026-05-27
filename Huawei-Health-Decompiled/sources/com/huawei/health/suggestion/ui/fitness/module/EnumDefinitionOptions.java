package com.huawei.health.suggestion.ui.fitness.module;

/* JADX INFO: loaded from: classes4.dex */
public enum EnumDefinitionOptions {
    FHD(0, 1080),
    HD(1, 720),
    SD(2, 480);

    private final int height;
    private final int index;

    EnumDefinitionOptions(int i, int i2) {
        this.index = i;
        this.height = i2;
    }

    public int getIndex() {
        return this.index;
    }

    public int getHeight() {
        return this.height;
    }
}
