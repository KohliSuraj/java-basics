public class BankAccount implements Comparable<BankAccount>, Withdrawing {
    private String account;
    private int balance;
    private static int numOfAccounts;

    public BankAccount(String account, int balance) {
        this.setAccount(account);
        this.setBalance(balance);
        numOfAccounts++;
    }

    @Override
    public void withdraw(int amount) {
        try {
            if (amount <= this.balance) {
                balance -= amount;
            } else {
                throw new RuntimeException("Not Enough Funds to Withdraw!!");
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    @Override
    public int compareTo(BankAccount acc) {
        if (this.balance > acc.balance) {
            return this.balance - acc.balance;
        } else if (this.balance < acc.balance) {
            return this.balance - acc.balance;
        } else {
            return 0;
        }
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public String getAccount() {
        return account;
    }

    private void setAccount(String account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

}
