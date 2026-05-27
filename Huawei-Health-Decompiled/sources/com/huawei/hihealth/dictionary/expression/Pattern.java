package com.huawei.hihealth.dictionary.expression;

import com.huawei.hihealth.HiDataFilter;
import com.huawei.hihealth.dictionary.utils.DictUtils;
import com.huawei.operation.utils.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class Pattern {
    private static final Map<String, Integer> d;
    private static final java.util.regex.Pattern e;

    private static boolean d(char c) {
        return c >= '0' && c <= '9';
    }

    static {
        HashMap map = new HashMap(13);
        d = map;
        e = java.util.regex.Pattern.compile("^[-\\+]?[.\\d]*$");
        map.put(Constants.LEFT_BRACKET_ONLY, Integer.MAX_VALUE);
        map.put(Constants.RIGHT_BRACKET_ONLY, Integer.MAX_VALUE);
        map.put(Marker.ANY_NON_NULL_MARKER, 4);
        map.put(com.huawei.openalliance.ad.constant.Constants.LINK, 4);
        map.put("*", 5);
        map.put("/", 5);
        map.put(HiDataFilter.DataFilterExpression.BIGGER_THAN, 3);
        map.put(HiDataFilter.DataFilterExpression.LESS_THAN, 3);
        map.put(HiDataFilter.DataFilterExpression.BIGGER_EQUAL, 3);
        map.put(HiDataFilter.DataFilterExpression.LESS_EQUAL, 3);
        map.put("&&", 1);
        map.put("&", 4);
        map.put("||", 0);
        map.put("|", 4);
        map.put("=", 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hihealth.dictionary.expression.Expression d(java.lang.String r10) {
        /*
            if (r10 == 0) goto L9d
            java.lang.String r0 = r10.trim()
            java.lang.String r1 = ""
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L9d
            java.lang.String r10 = f(r10)
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r4 = 0
            r5 = r4
            r6 = r5
            r7 = r6
        L25:
            int r8 = r10.length()
            if (r5 >= r8) goto L87
            if (r6 == 0) goto L2f
            r6 = r4
            goto L84
        L2f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            char r9 = r10.charAt(r5)
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            boolean r9 = e(r8, r10, r5)
            if (r9 == 0) goto L4a
            r7 = r5
            goto L84
        L4a:
            boolean r9 = a(r8)
            if (r9 == 0) goto L5c
            boolean r6 = b(r10, r8, r5, r2, r0)
            if (r6 == 0) goto L59
            int r7 = r5 + 2
            goto L84
        L59:
            int r7 = r5 + 1
            goto L84
        L5c:
            int r8 = r10.length()
            int r8 = r8 + (-1)
            if (r5 == r8) goto L7f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = r5 + 1
            char r9 = r10.charAt(r9)
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            boolean r8 = a(r8)
            if (r8 == 0) goto L84
        L7f:
            int r8 = r5 + 1
            c(r10, r7, r8, r2, r3)
        L84:
            int r5 = r5 + 1
            goto L25
        L87:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L97
            java.lang.Object r10 = r0.pop()
            com.huawei.hihealth.dictionary.expression.Token r10 = (com.huawei.hihealth.dictionary.expression.Token) r10
            r2.add(r10)
            goto L87
        L97:
            com.huawei.hihealth.dictionary.expression.Expression r10 = new com.huawei.hihealth.dictionary.expression.Expression
            r10.<init>(r2, r3)
            return r10
        L9d:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "data is empty"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.dictionary.expression.Pattern.d(java.lang.String):com.huawei.hihealth.dictionary.expression.Expression");
    }

    private static boolean b(String str, String str2, int i, List<Token> list, Stack<Token> stack) {
        String str3;
        boolean z;
        boolean z2 = true;
        if ((HiDataFilter.DataFilterExpression.LESS_THAN.equals(str2) || HiDataFilter.DataFilterExpression.BIGGER_THAN.equals(str2)) && i < str.length() - 1 && "=".charAt(0) == str.charAt(i + 1)) {
            str3 = str2 + "=";
            z = true;
        } else {
            str3 = str2;
            z = false;
        }
        if (!"&".equals(str2) && !"|".equals(str2)) {
            z2 = z;
        } else {
            if (i == str.length() - 1) {
                throw new IllegalArgumentException("illegal expression: " + str);
            }
            if (!str3.equals(str.charAt(i + 1) + "")) {
                throw new IllegalArgumentException("illegal expression: " + str);
            }
            str3 = str2 + str2;
        }
        if (Constants.RIGHT_BRACKET_ONLY.equals(str3)) {
            while (!stack.isEmpty()) {
                if (Constants.LEFT_BRACKET_ONLY.equals(stack.peek().c())) {
                    stack.pop();
                    return z2;
                }
                list.add(stack.pop());
            }
            throw new IllegalArgumentException("There is no left bracket for right bracket.");
        }
        if (stack.isEmpty() || Constants.LEFT_BRACKET_ONLY.equals(str3) || c(str3) > c(stack.peek().c())) {
            stack.push(new Token(0, str3));
            return z2;
        }
        if (c(str3) <= c(stack.peek().c())) {
            while (!stack.isEmpty() && c(str3) <= c(stack.peek().c()) && c(stack.peek().c()) != Integer.MAX_VALUE) {
                list.add(stack.pop());
            }
            stack.push(new Token(0, str3));
        }
        return z2;
    }

    private static void c(String str, int i, int i2, List<Token> list, Set<String> set) {
        String strSubstring = str.substring(i, i2);
        if (e(strSubstring) && !b(strSubstring)) {
            set.add(strSubstring);
            list.add(new Token(1, strSubstring));
        } else {
            if (b(strSubstring)) {
                list.add(new Token(2, strSubstring));
                return;
            }
            throw new IllegalArgumentException("data not match number or param");
        }
    }

    private static String f(String str) {
        return str.replaceAll("\\s+", "");
    }

    private static boolean b(String str) {
        return e.matcher(str).matches();
    }

    private static boolean e(String str) {
        return DictUtils.e(str);
    }

    private static boolean a(String str) {
        return d.containsKey(str);
    }

    private static boolean e(String str, String str2, int i) {
        if (!str.equals(Marker.ANY_NON_NULL_MARKER) && !str.equals(com.huawei.openalliance.ad.constant.Constants.LINK)) {
            return false;
        }
        if (str2.length() <= 1 || i == str2.length() - 1) {
            throw new IllegalArgumentException("expressiong is illegal. : " + str2);
        }
        if (i == 0) {
            return d(str2.charAt(i + 1));
        }
        char cCharAt = str2.charAt(i - 1);
        if (!d(str2.charAt(i + 1)) || Constants.RIGHT_BRACKET_ONLY.charAt(0) == cCharAt) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cCharAt);
        sb.append("");
        return a(sb.toString());
    }

    private static int c(String str) {
        Integer num = d.get(str);
        if (num == null) {
            return Integer.MAX_VALUE;
        }
        return num.intValue();
    }
}
