package com.ConnectionToData;

import com.Exceptions.AccountNotFoundException;
import com.Exceptions.InvalidPinException;
import com.Formating.Account;

import java.util.*;

public class DataOperation {
    static Map<Long, Account> AllAccount = new TreeMap<>();

    public static void ShowAllCustomerData() {
        for (Map.Entry<Long, Account> map : AllAccount.entrySet()) {
            System.out.println(map.getValue());
        }
    }

    public static void UpdateAllAccountToMap() {
        AllAccount = Connection.readFile();
    }

    public static void InsertAccount(Account account) {
        Long key = account.getAccountNumber();
        AllAccount.put(key, account);
    }

    public static void UpdateDataToFile() {
        Connection.writeFile(AllAccount);
    }

    static public Account getAccount(long accountNumber, int pin) {

        if(AllAccount.containsKey(accountNumber))
        {
            Account account = AllAccount.get(accountNumber);
            if(account.getPin() == pin)
            {
                return account;
            }
            throw new InvalidPinException("Invalid Pin");
        }

        throw new AccountNotFoundException("Account not found.");
    }

    public static boolean checkAccountNumberPresentOrNot(Long accountNumber) {
        for (Map.Entry<Long, Account> map : AllAccount.entrySet()) {
            if (map.getKey() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAccountCustomerIdPresentOrNot(Integer CustomerID) {
        for (Map.Entry<Long, Account> map : AllAccount.entrySet()) {
            if (map.getValue().getCustomerId() == CustomerID) {
                return true;
            }
        }
        return false;
    }
}
