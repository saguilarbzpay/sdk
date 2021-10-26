package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Sale message struct
 */
public class CheckOutMsg {
    private CheckOutMsg(){
        //do nothing
    }
    public static class Request extends BaseRequest{
        @IntRange(from=0L,to=9999999999L) private long amount;
        @IntRange(from=0,to=999999) private int voucherNo;
        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.CHECKOUT;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.amount = IntentUtil.getLongExtra(bundle, Constants.Req.REQ_AMOUNT);
            this.voucherNo = IntentUtil.getIntExtra(bundle, Constants.Req.REQ_VOUCHER_NO);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putLong(Constants.Req.REQ_AMOUNT, this.amount);
            bundle.putInt(Constants.Req.REQ_VOUCHER_NO, this.voucherNo);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(@IntRange(from=0L,to=9999999999L) long amount) {
            this.amount = amount;
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
            return super.toString() + " " + amount + " " + voucherNo;
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
            return Constants.CHECKOUT;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }


}
