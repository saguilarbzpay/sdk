
package mx.smartpay.libsdk;

import android.app.Activity;

/**
 * Factory for create a Transaction instance
 */
public class TransAPIFactory {

    private TransAPIFactory() {
    }

    public static ITransAPI createTransAPI(Activity activity) {
        return new TransAPIImpl(activity);
    }

}
