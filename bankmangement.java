package bank;
import java.util.*;
public class bankmangement {
    public static void main(String[] args) {
        bank b1=new bank();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to xyz Bank");;
       while(true){
           System.out.println("Bank Menu list--");
           System.out.println("1.create account");
           System.out.println("2.deposit money");
           System.out.println("3.wihtdrow money");
           System.out.println("4.check balnace");
           System.out.println("5.delte your account");
           System.out.println("6.exit");
           System.out.println("enter your choice");
           int n= sc.nextInt();
           switch (n){
               case 1:
                   b1.create_account();
                   break;
               case 2:
                   b1.deposit();
                   break;
               case 3:
                   b1.withdrow();
                   break;
               case 4:
                   b1.balance();
                   break;
               case 5:
                   b1.delete();
                   break;
               case 6:
                   System.out.println("Thank You");
                   System.out.println("Visit Again");
                   System.exit(0);
               default:
                   System.out.println("invalid choise");
           }
       }

    }
}
    class ACCOUNT{
        int accountNumber;
        String account_holder_name= new String();
        int balance ;
        int pin;

        ACCOUNT(int accountNumber, String account_holder_name, int balance, int pin){
        this.account_holder_name=account_holder_name;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.pin= pin;
        }
        void deposit(double ammount){
            balance+= ammount;
            System.out.println("amount is deposit");
            System.out.println("your current balance = " + balance);
        }
        void withdrow(double amount){
            if(amount<=balance){
                balance-=amount;
                System.out.println("wihdrow amount = " + amount);
                System.out.println("remaning balance = "+ balance);
            }else{
                System.out.println("insufficent balance");
            }
        }

        void checkbalance(){

            System.out.println(balance);
        }

        boolean pin(int inputpin) {
            if (inputpin == pin) {
                return true;
            }
            return false;
        }

    }
class bank{
    ACCOUNT[] accounts= new ACCOUNT[100];
    int count=0;
    Scanner sc= new Scanner(System.in);
    void create_account(){
        if (count >= accounts.length) {
            System.out.println("Bank is Full! Cannot create more accounts.");
            return;
        }

        System.out.print("Enter Account Number: ");
        int accountNumber= sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Account Holder Name");
        String account_holder_name=sc.nextLine();


        System.out.print("Enter Initial Balance: ");
        int balance = sc.nextInt();

        System.out.println("Set Pin");
        int pin= sc.nextInt();

        accounts[count]=new ACCOUNT(accountNumber,account_holder_name,balance,pin);
        count++;
        System.out.println("account create successfully");
    }
ACCOUNT find_account(int ac){
        for (int i=0;i<count;i++){
            if (accounts[i].accountNumber==ac){
                return accounts[i];
            }
        }
    return null;
}
void deposit(){
    System.out.println("Enter your account number");
    int accnum=sc.nextInt();
    ACCOUNT ac= find_account(accnum);
    if (ac == null) {
        System.out.println("account not found");
        return;
    }
    System.out.print("enter pin-> ");
    int pin = sc.nextInt();

    if (ac.pin(pin)) {
        System.out.print("enter amount to deposit: ");
        int amount = sc.nextInt();
        ac.deposit(amount);
    } else {
        System.out.println("incorrect pin");
    }
}
void withdrow(){
    System.out.println("Enter your account number");
    int accnum=sc.nextInt();
    ACCOUNT ac=find_account(accnum);
    if(ac==null){
        System.out.println("account not found");
        return;
    }
    System.out.println("enter pin ->");
    int pin=sc.nextInt();
    if(ac.pin(pin)){
        System.out.println("enter withdrow amount");
        int amount=sc.nextInt();
        ac.withdrow(amount);
    }
    else{
        System.out.println("incorrect pin");
}
    }


    void balance(){
        System.out.println(" enter your account number");
        int accnum=sc.nextInt();
        ACCOUNT ac= find_account(accnum);
        if (ac==null){
            System.out.println("account not found");
        }
        System.out.println("enter pin->");
        int pin=sc.nextInt();
        if (ac.pin(pin)){
            ac.checkbalance();
        }
        else
            System.out.println("incorrect pin");
    }
    void delete(){
        System.out.println("Enter your account number");
        int accnum=sc.nextInt();
        ACCOUNT ac= find_account(accnum);
        if(ac==null){
            System.out.println("account not found");
            return;
        }
        System.out.println("enter your pin");
        int pin=sc.nextInt();
        if(ac.pin(pin)){
            int index = 0;
            for (int i = 0; i < count; i++) {
                if (accounts[i].accountNumber == accnum) {
                    index = i;
                    break;
                }}
                for (int j = index; j < count - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }

                accounts[count - 1] = null;
                count--;

                System.out.println("Your account has been deleted successfully.");

        }
        else {
            System.out.println("incorrect pin");
        }

    }
}

