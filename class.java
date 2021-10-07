import java.util.*;

class ATM_Transaction
{
    private int pin, balance;
    private String name;

    ATM_Transaction()
    {
        pin = 4590;
        balance = 15000;
        name = "Jessie Apac";
    }

    public void getInformation()
    {   
        Scanner scan = new Scanner(System.in);
        int error = 0, apin;
        erase();
        System.out.print("Enter PIN: ");
        apin = scan.nextInt(); 
        create(1, 50);
        while(apin != pin)
        {
            erase();
            scan.nextLine();
            error++;
            create(1, 50);
            System.out.println("Invalid PIN, failed " +error +" times");
            create(1, 50);
            System.out.print("Enter PIN: ");
            apin = scan.nextInt();
            create(1, 50);
            if(error >= 2){break;}
            if(apin != pin){continue;}
            
    
        }
        erase();
        if(apin == pin){bank_account();}
        else{
            create(1, 50);   
            System.out.println("Invalid PIN, failed 3 times");
            create(1, 50);
        }
        
        scan.close();
    }

    public void bank_account()
    {
        erase();
        Scanner scan = new Scanner(System.in);
        int answer;

        create(1, 50);
        System.out.println("               Welcome " + name+"!          ");
        System.out.println("Transactions:");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdraw Cash");
        System.out.println("3.Deposit  Cash");
        System.out.println("4.Logout");
        create(1, 50);
        System.out.print("Enter Number: ");
        answer = scan.nextInt();
        if(answer == 1){getBalance();}
        else if(answer == 2){getWithdrawTran();}
        else if(answer == 3){getDepositTran();}
        else{logout();}
        scan.close();
    }

    public void getBalance()
    {
        Scanner scan = new Scanner(System.in);
        int answer;
        erase();
        create(1, 50);
        System.out.println("Your balance is PHP " + balance);
        create(1, 50);
        System.out.println("Return?:");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Enter number: ");
        answer = scan.nextInt();
        if(answer == 1){bank_account();}
        else{getBalance();}
        scan.close();
    }

    public void getWithdrawTran()
    {
        int amount, answer;
        erase();
        Scanner scan = new Scanner(System.in);
        create(1, 50);
        System.out.println("                    Withdraw");
        create(1, 50);
        System.out.print("Amount: ");
        amount = scan.nextInt();
        scan.nextLine();
        while(amount > balance || amount <= 0)
        {
            erase();
            create(1, 50);
            System.out.println("                    Withdraw");
            System.out.println("Invalid, please enter valid amount");
            create(1, 50);
            System.out.print("Amount: ");
            amount = scan.nextInt();

            if(amount > balance || amount <= 0){continue;}
            else{break;}
        }
        erase();
        balance = balance - amount;
        create(1, 50);
        System.out.println("                    Success");
        System.out.println("Your remaining balance: " + balance);
        create(1, 50);
        System.out.println("Return?:");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Enter number: ");
        answer = scan.nextInt();
        if(answer == 1){bank_account();}
        else{getWithdrawTran();}
        scan.close();
    }
    
    public void getDepositTran()
    {
        int amount, answer;
        erase();
        Scanner scan = new Scanner(System.in);
        create(1, 50);
        System.out.println("                     Deposit");
        create(1, 50);
        System.out.print("Amount: ");
        amount = scan.nextInt();
        scan.nextLine();

        erase();
        balance = balance + amount;
        create(1, 50);
        System.out.println("                    Success");
        System.out.println("Your balance: " + balance);
        create(1, 50);
        System.out.println("Return?:");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.print("Enter number: ");
        answer = scan.nextInt();
        if(answer == 1){bank_account();}
        else{getDepositTran();}
        scan.close();
    }

    public void logout()
    {
        erase();
        System.out.println("Thank you for using ATM");
    }

    public void create(int row, int column)
    {
        for(int i = 1; i <= row; i++)
        {
            for(int j = 1; j <= column; j++)
            {
                System.out.print("=");
            }
            System.out.println("");
        }
    }

    public void erase()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}