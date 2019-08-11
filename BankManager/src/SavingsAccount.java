public class SavingsAccount extends BankAccount {
    private int limit;
    private int numOfWithdrawals;
    private final int NUMBER_OF_WITHDRAWALS = 4;

    public SavingsAccount(String account, int balance, int limit) {
        super(account, balance);
        this.setLimit(limit);
        this.setNumOfWithdrawals(NUMBER_OF_WITHDRAWALS);
    }

    @Override
    public void withdraw(int amount) {
        try {
            if (this.numOfWithdrawals > 0) {
                this.numOfWithdrawals--;
                super.withdraw(amount);
            } else {
                throw new RuntimeException("Quota for Number of Withdrawals For this Month already reached!");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public int getLimit() {
        return limit;
    }

    private void setLimit(int limit) {
        this.limit = limit;
    }

    public int getNumOfWithdrawals() {
        return numOfWithdrawals;
    }

    private void setNumOfWithdrawals(int numOfWithdrawals) {
        this.numOfWithdrawals = numOfWithdrawals;
    }
}
