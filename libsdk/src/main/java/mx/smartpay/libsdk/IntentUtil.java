package mx.smartpay.libsdk;

import android.os.Bundle;
import android.util.Log;

/**
 * Package-private, hide from Javadoc
 */
class IntentUtil {

    private static final String TAG = "IntentUtil";

    private IntentUtil(){
        //do nothing
    }

    static String getStringExtra(Bundle bundle, String key){
        String str = null;
        if(bundle != null) {
            try {
                str = bundle.getString(key);
            } catch (Exception e) {
                Log.e(TAG, "getStringExtra exception:" + e.getMessage());
            }
        }
        return str;
    }

    static int getIntExtra(Bundle bundle, String key){
        int value = -1;
        if(bundle != null) {
            try {
                value = bundle.getInt(key, -1);
            } catch (Exception e) {
                Log.e(TAG, "getIntExtra exception:" + e.getMessage());
            }
        }
        return value;
    }

    static long getLongExtra(Bundle bundle, String key){
        long value = -1L;
        if(bundle != null) {
            try {
                value = bundle.getLong(key, -1L);
            } catch (Exception e) {
                Log.e(TAG, "getLongExtra exception:" + e.getMessage());
            }
        }
        return value;
    }

    static byte[] getByteArrayExtra(Bundle bundle, String key){
        byte[] value = null;
        if(bundle != null) {
            try {
                value = bundle.getByteArray(key);
            } catch (Exception e) {
                Log.e(TAG, "getByteArrayExtra exception:" + e.getMessage());
            }
        }
        return value;
    }
}
