package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Sale message struct
 */
public class SaleMsg {
    private SaleMsg(){
        //do nothing
    }
    public static class Request extends BaseRequest{
        @IntRange(from=0L,to=9999999999L) private long amount;
        @IntRange(from=0L,to=9999999999L) private long tipAmount;
        private int msi;

        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.SALE;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.amount = IntentUtil.getLongExtra(bundle, Constants.Req.REQ_AMOUNT);
            this.tipAmount = IntentUtil.getLongExtra(bundle, Constants.Req.REQ_TIP_AMOUNT);
            this.msi = IntentUtil.getIntExtra(bundle, Constants.Req.REQ_MSI);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putLong(Constants.Req.REQ_AMOUNT, this.amount);
            bundle.putLong(Constants.Req.REQ_TIP_AMOUNT, this.tipAmount);
            bundle.putInt(Constants.Req.REQ_MSI, this.msi);
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

        public long getTipAmount() {
            return tipAmount;
        }

        public void setTipAmount(@IntRange(from=0L,to=9999999999L) long tipAmount) {
            this.tipAmount = tipAmount;
        }

        public int getMsi() {
            return msi;
        }

        public void setMsi(int msi) {
            this.msi = msi;
        }

        @Override
        public String toString() {
            return super.toString() + " " + amount + " " + tipAmount + " " + msi;
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
            return Constants.SALE;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }


}
