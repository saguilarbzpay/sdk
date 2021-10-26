
package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Void message struct
 */
public class VoidMsg {

    private VoidMsg(){
        //do nothing
    }

    public static class Request extends BaseRequest {
        @IntRange(from=0,to=999999) private int voucherNo;
        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.VOID;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.voucherNo = IntentUtil.getIntExtra(bundle, Constants.Req.REQ_VOUCHER_NO);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt(Constants.Req.REQ_VOUCHER_NO, this.voucherNo);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
        }

        /**
         * @return voucher no, from 0 to 999999, 0 means the last last transaction
         */
        public int getVoucherNo() {
            return voucherNo;
        }

        /**
         *
         * @param voucherNo from 0 to 999999, 0 means the last last transaction
         */
        public void setVoucherNo(@IntRange(from=0,to=999999) int voucherNo) {
            this.voucherNo = voucherNo;
        }

        @Override
        public String toString() {
            return super.toString() + " " + voucherNo;
        }
    }

    public static class Response extends TransResponse {
        public Response() {
        }

        Response(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.VOID;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }


}
