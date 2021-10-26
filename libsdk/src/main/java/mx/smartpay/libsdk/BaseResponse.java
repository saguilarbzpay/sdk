package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Common Response
 */
public abstract class BaseResponse implements Serializable {
    private String appId;
    private int rspCode;
    private String rspMsg;

    BaseResponse(){
        //do nothing
    }

    abstract int getType();

    @NonNull
    Bundle toBundle(@NonNull Bundle bundle) {
        bundle.putInt(Constants.COMMAND_TYPE, this.getType());
        bundle.putInt(Constants.Resp.RSP_CODE, this.rspCode);
        bundle.putString(Constants.Resp.RSP_MSG, this.rspMsg);
        bundle.putString(Constants.APP_ID, this.appId);
        return bundle;
    }

    void fromBundle(Bundle bundle) {
        this.rspCode = IntentUtil.getIntExtra(bundle, Constants.Resp.RSP_CODE);
        this.rspMsg = IntentUtil.getStringExtra(bundle, Constants.Resp.RSP_MSG);
        this.appId = IntentUtil.getStringExtra(bundle, Constants.APP_ID);
    }

    abstract boolean checkArgs();

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getRspCode() {
        return rspCode;
    }

    public void setRspCode(int rspCode) {
        this.rspCode = rspCode;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    @Override
    public String toString() {
        return appId + " " + rspCode + " " + rspMsg;
    }
}
