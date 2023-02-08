package com.AccountTask;

import com.ConnectionToData.DataOperation;
import com.Formating.Account;

import java.util.Scanner;

public class MainTask {

    static {
        DataOperation.UpdateAllAccountToMap();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void MainTask(){
        AccountTask accountTask;
        System.out.println("Enter 1 for New Account      : ");
        System.out.println("Enter 2 for Existing Account : ");
        System.out.println("Enter 3 for Exit Application : ");
        System.out.println("Enter 4 for All Customer     : ");
        System.out.println("      Please Enter           : ");
        int input = scanner.nextInt();
        switch (input) {
            case 1: {
                System.out.println("Welcome to HDFC BANK");
                System.out.println("Enter 1 for Saving Account   : ");
                System.out.println("Enter 2 for Current Account  : ");
                System.out.println("Enter 3 for Exit Application : ");
                System.out.print("         Please Enter          : ");
                int input1 = scanner.nextInt();
                switch (input1) {
                    case 1: {
                        System.out.println("Welcome to Saving Account ");
                        accountTask=new AccountTask();
                        accountTask.startAccountCreate();
                        System.out.println("Login Your Saving Account : ");
                        break;
                    }
                    case 2: {
                        System.out.println("Welcome to Current Account ");
                        accountTask=new AccountTask();
                        accountTask.startAccountCreate();
                        System.out.println("Login Your Current Account ");
                        break;
                    }
                    case 3: {
                        System.out.println("Good Bye - >");
                        System.exit(0);
                    }
                }
            }
            break;
            case 2: {
                AccountTask.AlreadyAccount();
                break;
            }
            case 4: {
                DataOperation.ShowAllCustomerData();
                break;
            }
            case 3: {
                System.exit(0);
            }
        }
    }
}
