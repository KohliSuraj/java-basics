import java.util.List;

public class Main {
    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount("CheckingAccount", 10500, 100);
        System.out.println("====> " + ca.getAccount());
        System.out.println(ca.getBalance());
        System.out.println("withdrawing");
        ca.withdraw(500);
        System.out.println(ca.getBalance());
        System.out.println("withdrawing");
        ca.withdraw(100000);
        System.out.println(ca.getBalance());
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 900, 100);
        System.out.println("====> " + sa.getAccount());
        System.out.println(sa.getBalance());
        System.out.println("withdrawing");
        sa.withdraw(10);
        System.out.println("withdrawing");
        sa.withdraw(10);
        System.out.println("withdrawing");
        sa.withdraw(10);
        System.out.println("withdrawing");
        sa.withdraw(10);
        System.out.println("withdrawing");
        sa.withdraw(10);
        CertificateOfDeposit cod = new CertificateOfDeposit("Certificate Of Deposit", 10000, 100);
        System.out.println("====> " + cod.getAccount());
        System.out.println(cod.getBalance());
        System.out.println(ca.compareTo(cod));
        System.out.println(cod.getDateOfMaturity());
        System.out.println("withdrawing");
        cod.withdraw(100);
        System.out.println(cod.getBalance());
        System.out.println(cod.getNumOfAccounts());
        List<BankAccount> allAccounts = cod.getAllAccounts();
        CertificateOfDeposit myAccount = (CertificateOfDeposit) allAccounts.get(2);
        System.out.println(myAccount.getDateOfMaturity());
        }
}
