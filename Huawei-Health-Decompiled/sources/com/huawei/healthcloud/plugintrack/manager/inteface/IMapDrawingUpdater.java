package com.huawei.healthcloud.plugintrack.manager.inteface;

import defpackage.irs;
import defpackage.irt;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IMapDrawingUpdater {
    void addEndMarker(irt irtVar);

    void addStartMarker(irt irtVar);

    void drawFirstLocation(irt irtVar);

    void drawLineToMap(List<irs> list);

    void drawPauseLine(irt irtVar, irt irtVar2);

    void drawRecoveryLine(irt irtVar, irt irtVar2);

    void forceDrawLineToMap();

    void pauseSportClear();

    void releaseMap();

    void updateCpMarker(int[] iArr);
}
