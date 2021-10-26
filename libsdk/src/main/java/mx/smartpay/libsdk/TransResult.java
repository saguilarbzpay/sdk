
package mx.smartpay.libsdk;

/**
 * Transaction result. will be attached as {@link BaseResponse#rspCode}
 */
public class TransResult {
    private TransResult() {
        //do nothing
    }
    /**
     * transaction success
     */
    public static final int SUCC = 0;
    /**
     * settlement succeeded without doing batch upload
     */
    public static final int SUCC_NOREQ_BATCH = 1;
    /**
     * timeout
     */
    public static final int ERR_TIMEOUT = -1;
    /**
     * fail to connect
     */
    public static final int ERR_CONNECT = -2;
    /**
     * fail to send message
     */
    public static final int ERR_SEND = -3;
    /**
     * fail to receive message
     */
    public static final int ERR_RECV = -4;
    /**
     * fail to generate package
     */
    public static final int ERR_PACK = -5;
    /**
     * fail to parse package
     */
    public static final int ERR_UNPACK = -6;
    /**
     * format of package is wrong
     */
    public static final int ERR_PACKET = -7;
    /**
     * MAC of package is wrong
     */
    public static final int ERR_MAC = -8;
    /**
     * process code is unmatched
     */
    public static final int ERR_PROC_CODE = -9;
    /**
     * message type is unmatched
     */
    public static final int ERR_MSG = -10;
    /**
     * transaction amount is unmatched
     */
    public static final int ERR_TRANS_AMT = -11;
    /**
     * trace no is unmatched
     */
    public static final int ERR_TRACE_NO = -12;
    /**
     * terminal is is unmatched
     */
    public static final int ERR_TERM_ID = -13;
    /**
     * merchant id is unmatched
     */
    public static final int ERR_MERCH_ID = -14;
    /**
     * no transaction
     */
    public static final int ERR_NO_TRANS = -15;
    /**
     * cannot find the original transaction
     */
    public static final int ERR_NO_ORIG_TRANS = -16;
    /**
     * transaction has been voided
     */
    public static final int ERR_HAS_VOIDED = -17;
    /**
     * transaction cannot be voided
     */
    public static final int ERR_VOID_UNSUPPORTED = -18;
    /**
     * comm channel error
     */
    public static final int ERR_COMM_CHANNEL = -19;
    /**
     * reject by host
     */
    public static final int ERR_HOST_REJECT = -20;
    /**
     * transaction aborted (without prompting any message)
     */
    public static final int ERR_ABORTED = -21;
    /**
     * transaction aborted（user cancel）
     */
    public static final int ERR_USER_CANCEL = -22;
    /**
     * need to settle before continue because of limits from the storage or currency change,etc.
     */
    public static final int ERR_NEED_SETTLE_NOW = -23;
    /**
     * need to settle before continue because of limits from the storage or currency change,etc.
     */
    public static final int ERR_NEED_SETTLE_LATER = -24;
    /**
     * need to settle before continue because of limits from the storage.
     */
    public static final int ERR_NO_FREE_SPACE = -25;
    /**
     * transaction is unsupported
     */
    public static final int ERR_NOT_SUPPORT_TRANS = -26;
    /**
     * card no is unmatched
     */
    public static final int ERR_CARD_NO = -27;
    /**
     * wrong password
     */
    public static final int ERR_PASSWORD = -28;
    /**
     * wrong parameter
     */
    public static final int ERR_PARAM = -29;

    /**
     * batch upload is not completed
     */
    public static final int ERR_BATCH_UP_NOT_COMPLETED = -31;
    /**
     * amount exceeded limit
     */
    public static final int ERR_AMOUNT = -33;
    /**
     * transaction is approved by host, but declined by card
     */
    public static final int ERR_CARD_DENIED = -34;
    /**
     * transaction cannot be adjusted
     */
    public static final int ERR_ADJUST_UNSUPPORTED = -36;
    /**
     * card is unsupported
     */
    public static final int ERR_CARD_UNSUPPORTED = -37;

    /**
     * expired card
     */
    public static final int ERR_CARD_EXPIRED = -38;

    /**
     * invalid card no
     */
    public static final int ERR_CARD_INVALID = -39;

    /**
     * Unsupported function
     */
    public static final int ERR_UNSUPPORTED_FUNC = -40;

    /**
     * fail to complete clss pre-process
     */
    public static final int ERR_CLSS_PRE_PROC = -41;

    /**
     * need to fall back
     */
    public static final int NEED_FALL_BACK = -42;

    /**
     * Invalid EMV QR code.
     */
    public static final int ERR_INVALID_EMV_QR = -43;

    /**
     * Invalid BtPrinter code.
     */
    public static final int ERR_INVALID_BT_PRINTER = -44;
}
