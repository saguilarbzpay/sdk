
package mx.smartpay.libsdk;

import android.os.Bundle;

/**
 * Settlement message struct
 */
public class SettleMsg {

    private SettleMsg(){
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
            return Constants.SETTLE;
        }

        @Override
        boolean checkArgs() {
            return true;
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
            return Constants.SETTLE;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }
}
