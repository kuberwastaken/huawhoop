package ohos.ace.adapter.capability.bridge;

/* JADX INFO: loaded from: classes8.dex */
public class MethodData {
    private String methodName_;
    private Object[] parameters_;

    public MethodData(String str, Object[] objArr) {
        this.methodName_ = str;
        this.parameters_ = objArr;
    }

    public String getMethodName() {
        return this.methodName_;
    }

    public Object[] getMethodParameter() {
        return this.parameters_;
    }
}
