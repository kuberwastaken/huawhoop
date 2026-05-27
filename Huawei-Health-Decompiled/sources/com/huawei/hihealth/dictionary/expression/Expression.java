package com.huawei.hihealth.dictionary.expression;

import health.compact.a.util.LogUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class Expression {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Token> f4288a;
    private Set<String> c;

    public Expression(List<Token> list, Set<String> set) {
        this.f4288a = list;
        this.c = set;
    }

    public Set<String> d() {
        return this.c;
    }

    public double a(Map<String, Double> map) {
        Set<String> set = this.c;
        if (set != null && !set.isEmpty() && (map == null || !map.keySet().containsAll(this.c))) {
            throw new IllegalArgumentException("paramMap does not contain all params.");
        }
        return e(this.f4288a, map);
    }

    public boolean d(Map<String, Double> map) {
        try {
            return a(map) > 0.0d;
        } catch (IllegalArgumentException e) {
            LogUtil.c("HiH_Expression", "illegal argument：", e.getMessage());
            return false;
        } catch (Exception unused) {
            LogUtil.c("HiH_Expression", "unknown error.");
            return false;
        }
    }

    private double e(List<Token> list, Map<String, Double> map) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("expressStack is null or empty.");
        }
        if (list.size() == 1) {
            return Double.valueOf(this.f4288a.get(0).c()).doubleValue();
        }
        Stack stack = new Stack();
        double d = 0.0d;
        for (int i = 0; i < list.size(); i++) {
            Token token = list.get(i);
            stack.push(token);
            if (token.a() == 0) {
                if (stack.size() < 3) {
                    throw new IllegalArgumentException("expression is illegal.");
                }
                d = d((Token) stack.pop(), (Token) stack.pop(), (Token) stack.pop(), map);
                stack.push(new Token(2, d + ""));
            }
        }
        return d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double d(com.huawei.hihealth.dictionary.expression.Token r6, com.huawei.hihealth.dictionary.expression.Token r7, com.huawei.hihealth.dictionary.expression.Token r8, java.util.Map<java.lang.String, java.lang.Double> r9) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.dictionary.expression.Expression.d(com.huawei.hihealth.dictionary.expression.Token, com.huawei.hihealth.dictionary.expression.Token, com.huawei.hihealth.dictionary.expression.Token, java.util.Map):double");
    }
}
