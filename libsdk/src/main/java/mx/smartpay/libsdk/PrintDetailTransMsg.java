
package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Reprint transaction message struct
 */
public class PrintDetailTransMsg {

    private PrintDetailTransMsg(){
        //do nothing
    }

    public static class Request extends BaseRequest {

        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.PRINT_DET_TRANS;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
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
            return Constants.PRINT_DET_TRANS;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }


}
