package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class jpt extends jpv {
    private Map<Integer, Double> mMap;

    public jpt() {
        this(0, null, 0L, 0L);
    }

    public jpt(int i, Map map, long j, long j2) {
        setType(i);
        this.mMap = map;
        setStartTime(j);
        setEndTime(j2);
    }

    public Map getMap() {
        return this.mMap;
    }
}
