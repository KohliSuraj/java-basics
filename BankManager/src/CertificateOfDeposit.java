import java.util.Calendar;
import java.util.Date;

public class CertificateOfDeposit extends BankAccount {
    private int limit;
    private Date dateOfMaturity;

    public CertificateOfDeposit(String account, int balance, int limit) {
        super(account, balance);
        this.setLimit(limit);
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.add(Calendar.YEAR, 1);
        this.setDateOfMaturity(date.getTime());
    }

    @Override
    public void withdraw(int amount) {
        try {
            if (new Date().compareTo(this.getDateOfMaturity()) >= 0) {
                super.withdraw(amount);
            } else {
                throw new RuntimeException("Cannot withdraw before Date Of Maturity!!");
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

    public Date getDateOfMaturity() {
        return dateOfMaturity;
    }

    private void setDateOfMaturity(Date dateOfMaturity) {
        this.dateOfMaturity = dateOfMaturity;
    }
}
