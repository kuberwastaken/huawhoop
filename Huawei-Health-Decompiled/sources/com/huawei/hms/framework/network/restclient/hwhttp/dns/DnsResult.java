package com.huawei.hms.framework.network.restclient.hwhttp.dns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DnsResult {
    public static final int INVALID = 2;
    public static final String KEY_ADDRESSLIST = "addressList";
    public static final String KEY_ATN_CODE = "atnCode";
    public static final String KEY_CREATE_TIME = "createTime";
    public static final String KEY_TTL = "ttl";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final int NEED_UPDATE = 1;
    public static final long TIME_TO_LIVE = 600000;
    public static final long TIME_TO_UPDATE = 86400000;
    public static final String TYPE_A = "A";
    public static final String TYPE_AAAA = "AAAA";
    public static final String TYPE_ALL = "ALL";
    public static final String TYPE_CNAME = "CNAME";
    public static final int VALID = 0;
    private int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4758a = "A";
    private List<Address> b = new ArrayList();
    private long c = System.currentTimeMillis();
    private int e = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder("DnsResult{type='");
        sb.append(this.f4758a);
        sb.append('\'');
        sb.append(isEmpty() ? ", addressList isEmpty" : ", addressList is not Empty");
        sb.append(", createTime=");
        sb.append(this.c);
        sb.append(", source=");
        sb.append(this.d);
        sb.append(", cache=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }

    public void setType(String str) {
        this.f4758a = str;
    }

    public void setSource(int i) {
        this.d = i;
    }

    public void setCreateTime(long j) {
        this.c = j;
    }

    public void setCache(int i) {
        this.e = i;
    }

    public void setAddressList(List<Address> list) {
        if (list == null) {
            this.b = new ArrayList();
        } else {
            this.b = list;
        }
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public static class Address {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4759a;
        private String b;
        private long c;

        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f4760a;
            private String b;
            private long c = 2147483647L;

            public Builder value(String str) {
                this.b = str;
                return this;
            }

            public Builder type(String str) {
                this.f4760a = str;
                return this;
            }

            public Builder ttl(long j) {
                this.c = j;
                return this;
            }

            public Address build() {
                return new Address(this);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Address{type='");
            sb.append(this.f4759a);
            sb.append("', value is null='");
            sb.append(this.b == null);
            sb.append("', ttl=");
            sb.append(this.c);
            sb.append('}');
            return sb.toString();
        }

        public String getValue() {
            return this.b;
        }

        public String getType() {
            return this.f4759a;
        }

        public long getTtl() {
            return this.c;
        }

        private Address(Builder builder) {
            this.f4759a = builder.f4760a;
            this.b = builder.b;
            this.c = builder.c;
        }
    }

    public String getType() {
        return this.f4758a;
    }

    public int getStatus() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.c);
        if (jAbs < 600000) {
            return 0;
        }
        return jAbs < 86400000 ? 1 : 2;
    }

    public int getSource() {
        return this.d;
    }

    public List<String> getIpList() {
        ArrayList arrayList = new ArrayList(this.b.size());
        Iterator<Address> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public long getCreateTime() {
        return this.c;
    }

    public int getCache() {
        return this.e;
    }

    public List<Address> getAddressList() {
        return this.b;
    }

    public void addAddress(List<Address> list) {
        this.b.addAll(list);
    }

    public void addAddress(Address address) {
        this.b.add(address);
    }
}
