
package mx.smartpay.libsdk;

import android.os.Bundle;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Common Request
 */
public abstract class BaseRequest implements Serializable {
    private String appId; // TODO: 9/19/2017 keep it since it can be used to do function limit(using white list, black list)
    private String packageName;

    BaseRequest(){
        //do nothing
    }

    abstract int getType();

    @NonNull
    Bundle toBundle(@NonNull Bundle bundle) {
        bundle.putInt(Constants.COMMAND_TYPE, this.getType());
        bundle.putString(Constants.APP_ID, this.appId);
        bundle.putString(Constants.APP_PACKAGE, this.packageName);
        return bundle;
    }

    void fromBundle(Bundle bundle) {
        this.appId = IntentUtil.getStringExtra(bundle, Constants.APP_ID);
        this.packageName = IntentUtil.getStringExtra(bundle, Constants.APP_PACKAGE);
    }

    abstract boolean checkArgs();

    /**
     * @return app ID
     */
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return appId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
