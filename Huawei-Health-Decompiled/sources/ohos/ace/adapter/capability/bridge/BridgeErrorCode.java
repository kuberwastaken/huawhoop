package ohos.ace.adapter.capability.bridge;

/* JADX INFO: loaded from: classes8.dex */
public enum BridgeErrorCode {
    BRIDGE_ERROR_NO(0, "Correct!!"),
    BRIDGE_NAME_ERROR(1, "Bridge name error!"),
    BRIDGE_CREATE_ERROR(2, "Bridge creation failure!"),
    BRIDGE_INVALID(3, "Bridge unavailable!"),
    BRIDGE_METHOD_NAME_ERROR(4, "Method name error!"),
    BRIDGE_METHOD_RUNNING(5, "Method is running..."),
    BRIDGE_METHOD_UNIMPL(6, "Method not implemented!"),
    BRIDGE_METHOD_PARAM_ERROR(7, "Method parameter error!"),
    BRIDGE_METHOD_EXISTS(8, "Method already exists!"),
    BRIDGE_DATA_ERROR(9, "Data error"),
    BRIDGE_EXCEEDS_SAFE_INTEGER(10, "Data exceeds safe integer"),
    BRIDGE_CODEC_TYPE_MISMATCH(11, "Bridge codec type mismatch"),
    BRIDGE_CODEC_INVALID(12, "Bridge codec is invalid");

    private String errorMessage;
    private int id;

    BridgeErrorCode(int i, String str) {
        this.id = i;
        this.errorMessage = str;
    }

    public int getId() {
        return this.id;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
