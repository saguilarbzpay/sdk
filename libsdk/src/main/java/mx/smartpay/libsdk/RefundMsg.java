
package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Refund message struct
 */
public class RefundMsg {

    private RefundMsg() {
        //do nothing
    }

    public static class Request extends BaseRequest {
        @IntRange(from = 0L, to = 9999999999L)
        private long amount;
        private String orgRefNo;
        private String orgDate;

        private String orgAdjust;

        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.REFUND;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.amount = IntentUtil.getLongExtra(bundle, Constants.Req.REQ_AMOUNT);
            this.orgRefNo = IntentUtil.getStringExtra(bundle, Constants.Req.REQ_ORIGINAL_REF_NO);
            this.orgDate = IntentUtil.getStringExtra(bundle, Constants.Req.REQ_ORIGINAL_DATE);
            this.orgAdjust = IntentUtil.getStringExtra(bundle, Constants.Req.REQ_ORIGINAL_ADJUST);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putLong(Constants.Req.REQ_AMOUNT, this.amount);
            bundle.putString(Constants.Req.REQ_ORIGINAL_REF_NO, this.orgRefNo);
            bundle.putString(Constants.Req.REQ_ORIGINAL_DATE, this.orgDate);
            bundle.putString(Constants.Req.REQ_ORIGINAL_ADJUST, this.orgAdjust);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(@IntRange(from = 0L, to = 9999999999L) long amount) {
            this.amount = amount;
        }

        /**
         * optional
         *
         * @return original ref no
         */
        public String getOrgAdjust() {
            return orgAdjust;
        }

        public void setOrgAdjust(String adjust) {
            this.orgAdjust = adjust;
        }

        public String getOrgRefNo() {
            return orgRefNo;
        }

        public void setOrgRefNo(String orgRefNo) {
            this.orgRefNo = orgRefNo;
        }

        /**
         * optional
         * format: MMDD
         *
         * @return date
         */
        public String getOrgDate() {
            return orgDate;
        }

        public void setOrgDate(String orgDate) {
            this.orgDate = orgDate;
        }

        @Override
        public String toString() {
            return super.toString() + " " + amount + " " + orgRefNo + " " + orgDate + " " + orgAdjust;
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
            return Constants.REFUND;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }
}
