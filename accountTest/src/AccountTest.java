import java.util.Scanner;

public class AccountTest {

    Scanner obj = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the program of withdrawing money");
        AccountTest val = new AccountTest();
        val.operation();
    }

    public int menu(){
        System.out.println("Press " +
                " \n 1) Add Balance " +
                " \n 2) Withdraw amount " +
                " \n 3) Quit " );

        return  obj.nextInt();
    }

    public void operation(){
        Account objec = new Account();
        int option = 0;
        while( option != 3 ){
            option = menu();
            switch ( option ){
                case 1:
                    System.out.println("Please enter balance to add to account");
                    objec.setBalance(obj.nextFloat());
                    break;

                case 2:
                    System.out.println(" Please enter amount to withdraw");
                    float debit = obj.nextFloat();
                    if ( ( objec.getBalance() - debit ) > 0 ){
                        objec.setBalance(( objec.getBalance() - debit ));
                        System.out.println(" Succesfully Withdrawn amount " + debit + " new balance is " + objec.getBalance());
                    }else{
                        System.out.println("Please enter amount less than the balance of the account");
                        System.out.println("Account balance is " + objec.getBalance());
                    }
                    break;

                default:
                    System.out.println("Choose from above");

            }

        }
    }

}

class Account{

    private float balance;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
