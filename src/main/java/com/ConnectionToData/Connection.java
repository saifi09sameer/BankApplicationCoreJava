package com.ConnectionToData;

import com.Formating.Account;

import java.io.*;
import java.util.*;

public class Connection {
    public static Map<Long, Account> readFile() {
        String path = "E:\\IntelliJ IDEA\\HDFC-Bank-Anupshahr\\src\\main\\resources\\CustomerData.csv";
        Map<Long, Account> map = new HashMap<>();
        Account account;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String value[] = line.split(",");
                account = new Account(value[0], Integer.valueOf(value[1]), value[2], value[3], Long.parseLong(value[4]),
                        value[5], value[9], Integer.valueOf(value[6]), Long.parseLong(value[7]), Integer.valueOf(value[8]),
                        Double.valueOf(value[10]), value[11], value[12]);
                Long AccountNumber = account.getAccountNumber();
                map.put(AccountNumber, account);
                account = null;
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException();
        }
        return map;
    }//readLogicDone

    public static void writeFile(Map<Long, Account> accountMap) {

        String data = "";
        for (Map.Entry<Long, Account> map : accountMap.entrySet()) {
            Account account = map.getValue();
            data = data.concat(account.getDate() + "," + account.getCustomerId() + "," + account.getHolderName() + "," + account.getMailId() + "," +
                    account.getMobileNumber() + "," + account.getGender() + "," + account.getAge() + "," + account.getAccountNumber() + "," +
                    account.getPin() + "," + account.getAddress() + "," + account.getBalance() +
                    "," + account.getMobileBanking() + "," + account.getAllTransaction() + "\n");
            try {
                String path = "E:\\IntelliJ IDEA\\HDFC-Bank-Anupshahr\\src\\main\\resources\\CustomerData.csv";
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                byte bytedata[] = data.getBytes();
                fileOutputStream.write(bytedata);
                fileOutputStream.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//WriteLogicDone

}