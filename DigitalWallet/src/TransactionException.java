public class TransactionException extends Exception {
    private String errorMessage;
    private String errorCode;

    public TransactionException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}
