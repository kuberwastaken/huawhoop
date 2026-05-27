package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;

/* JADX INFO: loaded from: classes11.dex */
public class WXJointPay {

    public static class JointPayResp extends PayResp {
        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayResp, com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return super.checkArgs();
        }

        public JointPayResp(Bundle bundle) {
            fromBundle(bundle);
        }

        public JointPayResp() {
        }
    }

    public static class JointPayReq extends PayReq {
        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 27;
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelpay.PayReq, com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return super.checkArgs();
        }
    }
}
