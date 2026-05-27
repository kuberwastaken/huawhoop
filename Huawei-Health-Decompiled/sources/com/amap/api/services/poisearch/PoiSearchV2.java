package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.p0003sl.fu;
import com.amap.api.col.p0003sl.hw;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPoiSearchV2 f1487a;

    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i);

        void onPoiSearched(PoiResultV2 poiResultV2, int i);
    }

    /* JADX INFO: loaded from: classes9.dex */
    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1488a;

        PremiumType(String str) {
            this.f1488a = str;
        }

        final String a() {
            return this.f1488a;
        }

        static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (str.equals(premiumType.a())) {
                return premiumType;
            }
            PremiumType premiumType2 = ENTIRETY;
            return str.equals(premiumType2.a()) ? premiumType2 : premiumType;
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f1487a = null;
        try {
            this.f1487a = new hw(context, query);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof AMapException) {
                throw ((AMapException) e);
            }
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public SearchBound getBound() {
        IPoiSearchV2 iPoiSearchV2 = this.f1487a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        ShowFields() {
            this.value = 0;
        }

        public ShowFields(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class Query implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1489a;
        private String b;
        private String c;
        private int d;
        private int e;
        private String f;
        private boolean g;
        private String h;
        private boolean i;
        private LatLonPoint j;
        private boolean k;
        private String l;
        private String m;
        private Map<String, String> n;
        private ShowFields o;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.d = 1;
            this.e = 20;
            this.f = "zh-CN";
            this.g = false;
            this.i = true;
            this.k = true;
            this.m = PremiumType.DEFAULT.a();
            this.n = new HashMap();
            this.o = new ShowFields();
            this.f1489a = str;
            this.b = str2;
            this.c = str3;
        }

        public String getBuilding() {
            return this.h;
        }

        public void setBuilding(String str) {
            this.h = str;
        }

        public String getQueryString() {
            return this.f1489a;
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f = "en";
            } else {
                this.f = "zh-CN";
            }
        }

        protected String getQueryLanguage() {
            return this.f;
        }

        public String getCategory() {
            String str = this.b;
            if (str == null || str.equals("00") || this.b.equals("00|")) {
                return a();
            }
            return this.b;
        }

        public String getCity() {
            return this.c;
        }

        public int getPageNum() {
            return this.d;
        }

        public void setPageNum(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.d = i;
        }

        public void setPageSize(int i) {
            if (i <= 0) {
                this.e = 20;
            } else if (i > 30) {
                this.e = 30;
            } else {
                this.e = i;
            }
        }

        public int getPageSize() {
            return this.e;
        }

        public void setCityLimit(boolean z) {
            this.g = z;
        }

        public boolean getCityLimit() {
            return this.g;
        }

        public boolean isDistanceSort() {
            return this.i;
        }

        public void setDistanceSort(boolean z) {
            this.i = z;
        }

        public LatLonPoint getLocation() {
            return this.j;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.j = latLonPoint;
        }

        public boolean isSpecial() {
            return this.k;
        }

        public void setSpecial(boolean z) {
            this.k = z;
        }

        public ShowFields getShowFields() {
            return this.o;
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.o = new ShowFields();
            } else {
                this.o = showFields;
            }
        }

        public void setChannel(String str) {
            this.l = str;
        }

        public String getChannel() {
            return this.l;
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.m = premiumType.a();
        }

        public String getPremium() {
            return this.m;
        }

        public void setCustomParams(Map<String, String> map) {
            this.n = map;
        }

        public Map<String, String> getCustomParams() {
            return this.n;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.b(query.f1489a, this.f1489a) && PoiSearchV2.b(query.b, this.b) && PoiSearchV2.b(query.f, this.f) && PoiSearchV2.b(query.c, this.c) && PoiSearchV2.b(query.h, this.h) && PoiSearchV2.b(query.l, this.l) && PoiSearchV2.b(query.m, this.m) && query.g == this.g && query.e == this.e && query.i == this.i && query.k == this.k && query.n.equals(this.n) && query.o.value == this.o.value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            if (this.d == query.d && this.e == query.e && this.g == query.g && this.i == query.i && this.k == query.k && Objects.equals(this.f1489a, query.f1489a) && Objects.equals(this.b, query.b) && Objects.equals(this.c, query.c) && Objects.equals(this.f, query.f) && Objects.equals(this.h, query.h) && Objects.equals(this.j, query.j) && Objects.equals(this.l, query.l) && Objects.equals(this.m, query.m) && Objects.equals(this.n, query.n)) {
                return Objects.equals(this.o, query.o);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f1489a;
            int iHashCode = str != null ? str.hashCode() : 0;
            String str2 = this.b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = this.c;
            int iHashCode3 = str3 != null ? str3.hashCode() : 0;
            int i = this.d;
            int i2 = this.e;
            String str4 = this.f;
            int iHashCode4 = str4 != null ? str4.hashCode() : 0;
            boolean z = this.g;
            String str5 = this.h;
            int iHashCode5 = str5 != null ? str5.hashCode() : 0;
            boolean z2 = this.i;
            LatLonPoint latLonPoint = this.j;
            int iHashCode6 = latLonPoint != null ? latLonPoint.hashCode() : 0;
            boolean z3 = this.k;
            String str6 = this.l;
            int iHashCode7 = str6 != null ? str6.hashCode() : 0;
            String str7 = this.m;
            int iHashCode8 = str7 != null ? str7.hashCode() : 0;
            Map<String, String> map = this.n;
            int iHashCode9 = map != null ? map.hashCode() : 0;
            ShowFields showFields = this.o;
            return (((((((((((((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + i) * 31) + i2) * 31) + iHashCode4) * 31) + (z ? 1 : 0)) * 31) + iHashCode5) * 31) + (z2 ? 1 : 0)) * 31) + iHashCode6) * 31) + (z3 ? 1 : 0)) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + iHashCode9) * 31) + (showFields != null ? showFields.hashCode() : 0);
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m324clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fu.a(e, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f1489a, this.b, this.c);
            query.setPageNum(this.d);
            query.setPageSize(this.e);
            query.setQueryLanguage(this.f);
            query.setCityLimit(this.g);
            query.setBuilding(this.h);
            query.setLocation(this.j);
            query.setDistanceSort(this.i);
            query.setSpecial(this.k);
            query.setChannel(this.l);
            query.setPremium(PremiumType.a(this.m));
            query.setCustomParams(this.n);
            query.setShowFields(new ShowFields(this.o.value));
            return query;
        }

        private static String a() {
            return "";
        }
    }

    /* JADX INFO: loaded from: classes9.dex */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f1490a;
        private LatLonPoint b;
        private int c;
        private LatLonPoint d;
        private String e;
        private boolean f;
        private List<LatLonPoint> g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f = true;
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.e = "Bound";
            this.c = i;
            this.d = latLonPoint;
            this.f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.c = 1500;
            this.f = true;
            this.e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.c = 1500;
            this.f = true;
            this.e = "Polygon";
            this.g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f1490a = latLonPoint;
            this.b = latLonPoint2;
            this.c = i;
            this.d = latLonPoint3;
            this.e = str;
            this.g = list;
            this.f = z;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f1490a = latLonPoint;
            this.b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.b.getLatitude() || this.f1490a.getLongitude() >= this.b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.d = new LatLonPoint((this.f1490a.getLatitude() + this.b.getLatitude()) / 2.0d, (this.f1490a.getLongitude() + this.b.getLongitude()) / 2.0d);
        }

        public LatLonPoint getLowerLeft() {
            return this.f1490a;
        }

        public LatLonPoint getUpperRight() {
            return this.b;
        }

        public LatLonPoint getCenter() {
            return this.d;
        }

        public int getRange() {
            return this.c;
        }

        public String getShape() {
            return this.e;
        }

        public boolean isDistanceSort() {
            return this.f;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.g;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.d;
            int iHashCode = latLonPoint == null ? 0 : latLonPoint.hashCode();
            int i = this.f ? 1231 : 1237;
            LatLonPoint latLonPoint2 = this.f1490a;
            int iHashCode2 = latLonPoint2 == null ? 0 : latLonPoint2.hashCode();
            LatLonPoint latLonPoint3 = this.b;
            int iHashCode3 = latLonPoint3 == null ? 0 : latLonPoint3.hashCode();
            List<LatLonPoint> list = this.g;
            int iHashCode4 = list == null ? 0 : list.hashCode();
            int i2 = this.c;
            String str = this.e;
            return ((((((((((((iHashCode + 31) * 31) + i) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + i2) * 31) + (str != null ? str.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.d;
            if (latLonPoint == null) {
                if (searchBound.d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.d)) {
                return false;
            }
            if (this.f != searchBound.f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f1490a;
            if (latLonPoint2 == null) {
                if (searchBound.f1490a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f1490a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.b;
            if (latLonPoint3 == null) {
                if (searchBound.b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.b)) {
                return false;
            }
            List<LatLonPoint> list = this.g;
            if (list == null) {
                if (searchBound.g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.g)) {
                return false;
            }
            if (this.c != searchBound.c) {
                return false;
            }
            String str = this.e;
            if (str == null) {
                if (searchBound.e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.e)) {
                return false;
            }
            return true;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m325clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fu.a(e, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f1490a, this.b, this.c, this.d, this.e, this.g, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
