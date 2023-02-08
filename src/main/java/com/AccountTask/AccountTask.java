package com.AccountTask;
import com.ConnectionToData.DataOperation;
import com.Exceptions.InvalidAgeException;
import com.Formating.Account;
import com.Formating.GenerateThings;
import java.util.Scanner;
public class AccountTask {
    static Scanner scanner = new Scanner(System.in);
    Account account;
    public void startAccountCreate() {
        System.out.print("Please Enter Full Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Your Mail Id : ");
        String mail = scanner.nextLine();
        System.out.print("Enter Your Address : ");
        String address = scanner.nextLine();
        System.out.print("Enter Your Gender ");
        String gender = scanner.nextLine();
        System.out.println("Do You Want to Active MobileBanking -> Press YES/NO : ");
        String option1 = scanner.nextLine();
        System.out.print("Enter Your Age : ");
        int age = scanner.nextInt();
        System.out.print("Enter Your Mobile Number : ");
        long mobileNumber = scanner.nextLong();
        System.out.print("Please Enter Your Security Pin : ");
        int pin = scanner.nextInt();
        System.out.println("Please Deposit some Amount ");
        double amount = scanner.nextDouble();
        if (Condition.checkAge(age) && Condition.checkMobileNumber(mobileNumber) && Condition.checkMail(mail)) {
            account = new Account(GenerateThings.getCurrentDate(), GenerateThings.generateCustomerID(), name.trim(), mail.trim(), mobileNumber, gender.trim(), address.trim(), age,
                    GenerateThings.generateAccountNumber(), pin,amount,"NULL","( ");
            account.setMobileBanking(option1);
            DataOperation.InsertAccount(account);
            account.displayCustomerDetails();
            DataOperation.UpdateDataToFile();
        }

    }
    public static void AlreadyAccount() {
        try {
            System.out.print("Enter Your Account Number : ");
            long accountNumber = scanner.nextLong();
            System.out.print("Enter Your Pin          : ");
            int pin = scanner.nextInt();
            Account account = DataOperation.getAccount(accountNumber, pin);
            startTask(account);
            DataOperation.UpdateDataToFile();
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }
    public static Account startTask(Account account) {
        account.displayCustomerDetails();
            System.out.println("Do You Want to perform some task like Deposit and Withdraw ");
            System.out.println("Press - 1 for Yes && Press - 2 for No ");
            int input = scanner.nextInt();
            while (input == 1) {
                System.out.println("Welcome To Bank    : " + account.getHolderName());
                System.out.println("Choose 1. for Withdraw                       : ");
                System.out.println("Choose 2. for Deposit                        : ");
                System.out.println("Choose 3. for Check Balance                  : ");
                System.out.println("Choose 4. for View Passbook                  : ");
                System.out.println("Choose 5. for Update Mobile , Mail , Address : ");
                System.out.println("Choose 6. Show AllTransaction                :");
                System.out.println("Choose 7. for Exit Application               : ");
                System.out.print("Choose the Operation you want to perform from above : ");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1: {
                        System.out.println("Enter the Amount to be Withdraw      : ");
                        double amount = scanner.nextDouble();
                        account.withdrawAmount(amount);
                        account.setAllTransaction(amount,"Withdraw");
                        System.out.println("Your Balance is " + account.getBalance());
                        DataOperation.UpdateDataToFile();
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the Amount to be Deposit       : ");
                        double amount = scanner.nextDouble();
                        account.depositAmount(amount);
                        account.setAllTransaction(amount,"Deposit");
                        System.out.println("Your Balance is " + account.getBalance());
                        DataOperation.UpdateDataToFile();
                        break;
                    }
                    case 3: {
                        System.out.println("Your Balance is : " + account.getBalance());
                        break;
                    }
                    case 4: {
                        account.displayCustomerDetails();
                        break;
                    }
                    case 5: {
                        account=UpdatesDetails(account);
                    }
                    case 6:{
                        System.out.println(account.getAllTransaction());
                        break;
                    }
                    default: {

                        break;
                    }
                }
                System.out.println("Do You Want to Continue : Press 1 for YES , Press 0 for NO ");
                DataOperation.UpdateDataToFile();
                input = scanner.nextInt();
                if (input==0){
                    DataOperation.UpdateDataToFile();
                    return account;
                }
            }
        return account;
    }
    public static Account  UpdatesDetails(Account account){
        System.out.println("Enter 1 for Update Mobile Number : ");
        System.out.println("Enter 2 for Update Mail ID       : ");
        System.out.println("Enter 3 for Update All Details   : ");
        System.out.println("Enter 4 for Back                 : ");
        int input = scanner.nextInt();
        switch (input){
            case 1:{
                System.out.println("Your Current Mobile Number is       : "+account.getMobileNumber());
                System.out.println("Please Enter Your New Mobile Number : ");
                long newMobileNumber = scanner.nextLong();
                account.setMobileNumber(newMobileNumber);
                System.out.println("Successfully Update Your Mobile Number ");
                break;
            }
            case 2:{
                System.out.println("Your Current Mail ID              : "+account.getMailId());
                System.out.println("Please Enter Your New Mail ID : ");
                String newMail = scanner.nextLine();
                account.setMailId(newMail);
                System.out.println("Successfully Update Your Mail ID ");
                break;
            }
            case 3:{
                System.out.println("Your Current Mobile Number is       : "+account.getMobileNumber());
                System.out.println("Your Current Mail ID                : "+account.getMailId());
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Please Enter Your New Mobile Number : ");
                long newMobileNumber = scanner.nextLong();
                System.out.println("Please Enter Your New Mail ID       : ");
                String newMail = scanner.next();
                account.setMobileNumber(newMobileNumber);
                account.setMailId(newMail);
                System.out.println("Successfully Update Your All Details ");
                break;
            }
            case 4:{
                break;
            }
        }
        DataOperation.UpdateDataToFile();
        return account;
    }
}