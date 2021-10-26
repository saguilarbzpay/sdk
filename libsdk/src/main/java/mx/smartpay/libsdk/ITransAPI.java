package mx.smartpay.libsdk;

import android.content.Intent;

public interface ITransAPI {
    boolean doTrans(BaseRequest request);
    BaseResponse onResult(int requestCode, int resultCode, Intent data);
}
