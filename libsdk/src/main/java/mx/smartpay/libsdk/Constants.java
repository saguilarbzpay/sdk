/*
 * ============================================================================
 * COPYRIGHT
 *              Pax CORPORATION PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with Pax Corporation and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *      Copyright (C) 2017 - ? Pax Corporation. All rights reserved.
 * Module Date: 2017-9-18
 * Module Author: Kim.L
 * Description:
 *
 * ============================================================================
 */
package mx.smartpay.libsdk;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Hide from Javadoc
 */
public class Constants {
    @IntDef({PRE_AUTH, SALE, VOID, REFUND, ADJUST, SETTLE, REPRINT_TRANS, REPRINT_TOTAL,
            PRINT_BITMAP, PRINT_DET_TRANS, CHECKIN, CHECKOUT, REAUTH})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CommandType {
    }

    public static final int PRE_AUTH = 1; //default
    public static final int SALE = 2;
    public static final int VOID = 3;
    public static final int REFUND = 4;
    public static final int ADJUST = 14;
    public static final int SETTLE = 5;
    public static final int REPRINT_TRANS = 6;
    public static final int REPRINT_TOTAL = 7;
    public static final int PRINT_BITMAP = 8;
    public static final int PRINT_DET_TRANS = 9;
    public static final int CHECKIN = 10;
    public static final int CHECKOUT = 11;
    public static final int REAUTH = 12;
    public static final int POST_AUTH = 13;

    public static final int REQUEST_CODE = 100;

    static final String SDK_VERSION = "_edc_sdk_version";
    static final int SDK_VERSION_VALUE = 1;
    public static final String COMMAND_TYPE = "_edc_command_type";
    public static final String APP_ID = "_edc_app_id";
    static final String URI = "smartpay://mx.smartpay.entry";
    static final String ACTION = "mx.smartpay.entry";
    public static final String APP_PACKAGE = "_edc_app_package";
    public static final String LOGO_IMAGE = "_edc_logo_image";

    static class Req {
        static final String REQ_AMOUNT = "_edc_request_amount";
        static final String REQ_TIP_AMOUNT = "_edc_request_tip_amount";
        static final String REQ_MSI = "_edc_request_msi";
        static final String REQ_REFERENCE = "_edc_request_reference";
        static final String REQ_ORIGINAL_REF_NO = "_edc_request_org_ref_no";
        static final String REQ_ORIGINAL_DATE = "_edc_request_org_date";

        static final String REQ_ORIGINAL_ADJUST = "_edc_request_org_adjust";
        static final String REQ_VOUCHER_NO = "_edc_request_voucher_no";
        static final String REQ_REFERENCE_NO = "_edc_request_reference_no";

        static final String REQ_REPRINT_TYPE = "_edc_request_reprint_type";
        static final String REQ_PRINT_BITMAP = "_edc_request_print_bitmap";

        private Req(){
            //do nothing
        }
    }

    public static class Resp {
        public static final String RSP_CODE = "_edc_response_code";
        public static final String RSP_MSG = "_edc_response_message";

        public static final String RSP_MERCHANT_NAME = "_edc_response_merchant_name";
        public static final String RSP_MERCHANT_ID = "_edc_response_merchant_id";
        public static final String RSP_TERMINAL_ID = "_edc_response_terminal_id";
        public static final String RSP_CARD_NO = "_edc_response_card_no";
        public static final String RSP_CARD_TYPE = "_edc_response_card_type";
        public static final String RSP_VOUCHER_NO = "_edc_response_voucher_no";
        public static final String RSP_BATCH_NO = "_edc_response_batch_no";
        public static final String RSP_ISSUER_NAME = "_edc_response_issuer_name";
        public static final String RSP_ACQUIRER_NAME = "_edc_response_acquirer_name";
        public static final String RSP_REF_NO = "_edc_response_ref_no";
        public static final String RSP_TRANS_TIME = "_edc_response_trans_time";
        public static final String RSP_AMOUNT = "_edc_response_amount";
        public static final String RSP_AUTH_CODE = "_edc_response_auth_code";
        public static final String RSP_CH_SIGNATURE = "_edc_response_cardholder_signature";
        public static final String RSP_CH_SIGNATURE_PATH = "_edc_response_cardholder_signature_path";
        public static final String RSP_REFERENCE = "_edc_response_reference";

        private Resp(){
            //do nothing
        }
    }
}
