import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name, Balance, Password to create Account:");
        // Create a new User
        String name = sc.next();
        double balance = sc.nextDouble();
        String password = sc.next();
        SBIUser user = new SBIUser(name,balance,password);

        //Adding Money to account
        System.out.println("Enter amount u want to Add:");
        System.out.println(user.addMoney(sc.nextInt()));

        // Withdraw Money from account
        System.out.println("Enter amount u want to withdraw");
        int money = sc.nextInt();
        System.out.println("Enter Account Password");
        String pass = sc.next();
        System.out.println(user.withdrawMoney(money,pass));

        //Check Balance
        System.out.println("Your Current Account Balance is:"+user.checkBalance());
        System.out.println("Your Current Account Balance is:"+user.calculateInterest(20));

    }
}