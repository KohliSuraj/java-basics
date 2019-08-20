public class DigitalWalletTransaction {
    void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        checkAccessCode(digitalWallet);
        checkAmount(amount);
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
    }

    void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        checkAccessCode(digitalWallet);
        checkBalance(digitalWallet, amount);
        checkAmount(amount);
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
    }

    private void checkAccessCode(DigitalWallet digitalWallet) throws TransactionException {
        if (digitalWallet.getUserAccessCode() == null || digitalWallet.getUserAccessCode().isEmpty()) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }
    }

    private void checkAmount(int amount) throws TransactionException {
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }
    }

    private void checkBalance(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if (digitalWallet.getWalletBalance() < amount) {
            throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
        }
    }
}
