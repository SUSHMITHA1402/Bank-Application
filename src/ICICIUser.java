import java.util.Objects;
import java.util.UUID;

public class ICICIUser implements Bank_Interface{
    private String name;
    private String accountNo;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        ICICIUser.rateOfInterest = rateOfInterest;
    }

    private String password;
    private static double rateOfInterest;

    public ICICIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        // Bank is initializing these
        this.rateOfInterest= 11;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance+=amount;
        return "Successfully Added Money in ICICI account";
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)){
            if(balance>=amount){
                balance-=amount;
                return "Money Debited from ICICI Account";
            }
            else{
                return "Insufficient Balance";
            }
        }
        else{
            return "Wrong Password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*rateOfInterest*years)/100;
    }
}
