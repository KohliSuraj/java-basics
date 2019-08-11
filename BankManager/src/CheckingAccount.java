public class CheckingAccount extends BankAccount {
    private int limit;

    public CheckingAccount(String account, int balance, int limit) {
        super(account, balance);
        this.setLimit(limit);
    }

    public int getLimit() {
        return limit;
    }

    private void setLimit(int limit) {
        this.limit = limit;
    }
}
