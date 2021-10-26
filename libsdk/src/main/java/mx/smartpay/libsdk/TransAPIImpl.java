
package mx.smartpay.libsdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Package-private, implementation of {@link ITransAPI}
 */
class TransAPIImpl implements ITransAPI {
    private Activity mActivity;

    TransAPIImpl(Activity activity) {
        mActivity = activity;
    }

    @Override
    public boolean doTrans(BaseRequest request) {

        if(!request.checkArgs()){
            Log.e("EDC API", "checkArgs fail");
            return false;
        }
        Uri uri = Uri.parse(Constants.URI);
        Intent intent = new Intent(Constants.ACTION);
        intent.setData(uri);
        intent.putExtras(request.toBundle(new Bundle()));
        intent.putExtra(Constants.SDK_VERSION, Constants.SDK_VERSION_VALUE);
        intent.putExtra(Constants.APP_PACKAGE, mActivity.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mActivity.startActivityForResult(intent, Constants.REQUEST_CODE);
        return true;
    }

    @Override
    public BaseResponse onResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_CODE && data != null) {
            return handleResponse(data);
        }
        return null;
    }


    private BaseResponse handleResponse(@NonNull Intent data){
        int commandType =  data.getIntExtra(Constants.COMMAND_TYPE, 0);
        switch(commandType) {
            case Constants.PRE_AUTH:
                return new PreAuthMsg.Response(data.getExtras());
            case Constants.SALE:
                return new SaleMsg.Response(data.getExtras());
            case Constants.VOID:
                return new VoidMsg.Response(data.getExtras());
            case Constants.REFUND:
                return new RefundMsg.Response(data.getExtras());
            case Constants.SETTLE:
                return new SettleMsg.Response(data.getExtras());
            case Constants.REPRINT_TRANS:
                return new ReprintTransMsg.Response(data.getExtras());
            case Constants.REPRINT_TOTAL:
                return new ReprintTotalMsg.Response(data.getExtras());
            case Constants.PRINT_BITMAP:
                return new PrintBitmap.Response(data.getExtras());
            default:
                return null;
        }
    }
}
