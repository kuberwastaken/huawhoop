package com.huawei.route;

/* JADX INFO: loaded from: classes7.dex */
public enum SceneType {
    OTHER(0, 3),
    WR(1, 0),
    BIKE(2, 1),
    EXP(3, 2);

    private final int mPosition;
    private final int mSceneType;

    SceneType(int i, int i2) {
        this.mSceneType = i;
        this.mPosition = i2;
    }

    public int sceneType() {
        return this.mSceneType;
    }

    public int position() {
        return this.mPosition;
    }

    public static SceneType getSceneType(int i) {
        for (SceneType sceneType : values()) {
            if (sceneType.sceneType() == i) {
                return sceneType;
            }
        }
        return OTHER;
    }

    public static SceneType getSceneTypeByPosition(int i) {
        for (SceneType sceneType : values()) {
            if (sceneType.position() == i) {
                return sceneType;
            }
        }
        return OTHER;
    }

    public static SceneType getSceneTypeBySportType(int i) {
        if (i == 219) {
            return OTHER;
        }
        if (i == 222) {
            return EXP;
        }
        if (i == 259) {
            return BIKE;
        }
        return WR;
    }
}
