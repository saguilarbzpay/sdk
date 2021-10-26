package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by laiyi on 2018/7/12.
 */

public class PrintBitmap {
    private PrintBitmap(){
        //do nothing
    }

    public static class Request extends BaseRequest {
        private String bitmap;

        public Request() {
        }

        Request(Bundle bundle) {
            this.fromBundle(bundle);
        }

        @Override
        int getType() {
            return Constants.PRINT_BITMAP;
        }

        @Override
        void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bitmap = IntentUtil.getStringExtra(bundle, Constants.Req.REQ_PRINT_BITMAP);
        }

        @Override
        @NonNull
        Bundle toBundle(@NonNull Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(Constants.Req.REQ_PRINT_BITMAP, bitmap);
            return bundle;
        }

        @Override
        boolean checkArgs() {
            return true;
        }

        public String getBitmap() {
            return bitmap;
        }

        public void setBitmap(String bitmap) {
            this.bitmap = bitmap;
        }

        @Override
        public String toString() {
            return super.toString() + " " + bitmap;
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
            return Constants.PRINT_BITMAP;
        }

        @Override
        boolean checkArgs() {
            return true;
        }
    }
}
