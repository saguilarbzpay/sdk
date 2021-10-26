
package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Reprint total message struct
 */
public class ReprintTotalMsg {
    private ReprintTotalMsg(){
        //do nothing
    }

    public static class Request extends BaseRequest {
        /**
         * reprint type
         * @see Request#SUMMARY
         * @see Request#DETAIL
         * @see Request#LAST_SETTLE
         */
        @IntDef({SUMMARY, DETAIL, LAST_SETTLE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        /**
         * reprint transaction summary of the current batch, default
         */
        public static final int SUMMARY = 1;
        /**
         * reprint transaction detail of the current batch.
         */
        public static final int DETAIL = 2;
        /**
         * reprint the last settlement.
         */
        public static final int LAST_SETTLE = 3;

        private int reprintType = SUMMARY;

        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.REPRINT_TOTAL;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.reprintType = IntentUtil.getIntExtra(bundle, Constants.Req.REQ_REPRINT_TYPE);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt(Constants.Req.REQ_REPRINT_TYPE, this.reprintType);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
        }

        /**
         * @return reprint type {@link Type}
         */
        public int getReprintType() {
            return reprintType;
        }

        /**
         * @param type {@link Type}
         */
        public void setReprintType(@Type int type) {
            this.reprintType = type;
        }

        @Override
        public String toString() {
            return super.toString() + " " + reprintType;
        }
    }

    public static class Response extends BaseResponse {
        public Response() {
        }

        Response(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.REPRINT_TOTAL;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }
}
