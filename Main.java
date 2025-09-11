import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;
    String email;
    String phone;

    Account(int accountNumber, String name, double balance, String email, String phone) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    void updateContact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}

public class Main {
    static Account[] accounts = new Account[100];
    static int count = 0;
    static int nextAccNo = 1001;
    static Scanner sc = new Scanner(System.in);

    static int find(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber == accNo) return i;
        }
        return -1;
    }

    static void createAccount() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double bal = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        accounts[count++] = new Account(nextAccNo, name, bal, email, phone);
        System.out.println("Account Created. Number: " + nextAccNo);
        nextAccNo++;
    }

    static void deposit() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt(); sc.nextLine();
        int i = find(accNo);
        if (i != -1) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble(); sc.nextLine();
            accounts[i].deposit(amt);
            System.out.println("Deposited.");
        } else System.out.println("Not Found.");
    }

    static void withdraw() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt(); sc.nextLine();
        int i = find(accNo);
        if (i != -1) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble(); sc.nextLine();
            accounts[i].withdraw(amt);
            System.out.println("Withdrawn.");
        } else System.out.println("Not Found.");
    }

    static void show() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt(); sc.nextLine();
        int i = find(accNo);
        if (i != -1) accounts[i].display();
        else System.out.println("Not Found.");
    }

    static void update() {
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt(); sc.nextLine();
        int i = find(accNo);
        if (i != -1) {
            System.out.print("Enter New Email: ");
            String email = sc.nextLine();
            System.out.print("Enter New Phone: ");
            String phone = sc.nextLine();
            accounts[i].updateContact(email, phone);
            System.out.println("Updated.");
        } else System.out.println("Not Found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: show(); break;
                case 5: update(); break;
                case 6: return;
                default: System.out.println("Invalid Choice");
            }
        }
    }
}
