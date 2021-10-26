package mx.smartpay.libsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class MessageUtils {
    private MessageUtils(){
        //do nothing
    }

    public static BaseRequest generateRequest(Intent intent) {
        int commandType = intent.getIntExtra(Constants.COMMAND_TYPE, 0);
        switch(commandType) {
            case Constants.PRE_AUTH:
                return new PreAuthMsg.Request(intent.getExtras());
            case Constants.SALE:
                return new SaleMsg.Request(intent.getExtras());
            case Constants.VOID:
                return new VoidMsg.Request(intent.getExtras());
            case Constants.REFUND:
                return new RefundMsg.Request(intent.getExtras());
            case Constants.SETTLE:
                return new SettleMsg.Request(intent.getExtras());
            case Constants.REPRINT_TRANS:
                return new ReprintTransMsg.Request(intent.getExtras());
            case Constants.REPRINT_TOTAL:
                return new ReprintTotalMsg.Request(intent.getExtras());
            case Constants.PRINT_BITMAP:
                return new PrintBitmap.Request(intent.getExtras());
            default:
                return null;
        }
    }

    public static int getType(@NonNull BaseRequest request){
        return request.getType();
    }

    @NonNull
    public static Bundle toBundle(@NonNull BaseRequest request, @NonNull Bundle bundle) {
        return request.toBundle(bundle);
    }

    public static void fromBundle(@NonNull BaseRequest request, Bundle bundle) {
        request.fromBundle(bundle);
    }

    public static boolean checkArgs(@NonNull BaseRequest request){
        return request.checkArgs();
    }

    public static int getType(@NonNull BaseResponse response){
        return response.getType();
    }

    @NonNull
    public static Bundle toBundle(@NonNull BaseResponse response, @NonNull Bundle bundle) {
        return response.toBundle(bundle);
    }

    public static void fromBundle(@NonNull BaseResponse response, Bundle bundle) {
        response.fromBundle(bundle);
    }

    public static boolean checkArgs(@NonNull BaseResponse response){
        return response.checkArgs();
    }
}
