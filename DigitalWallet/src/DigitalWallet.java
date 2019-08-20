public class DigitalWallet {
    private String walletId;
    private String username;
    private String userAccessCode;
    private int walletBalance;

    public DigitalWallet(String walletId, String username) {
        this.walletId = walletId;
        this.username = username;
    }

    public DigitalWallet(String walletId, String username, String userAccessCode) {
        this.walletId = walletId;
        this.username = username;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }
}