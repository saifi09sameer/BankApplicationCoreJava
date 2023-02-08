package com.Formating;

import com.ConnectionToData.DataOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateThings {
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
        String todayDate = simpleDateFormat.format(date);
        return todayDate;
    }
    public static long generateAccountNumber() {
        Random random = new Random();
        int index=0;
        long accountNumber = 0;
        while (index<=10){
             accountNumber= random.nextLong(999999999999l);
            boolean check = DataOperation.checkAccountNumberPresentOrNot(accountNumber);
            if (check==false){
                return accountNumber;
            }
            index++;
        }
        return -1;
    }

    public static int generateCustomerID() {
        Random random = new Random();
        int index =0;
        int CustomerId=0;
        while (index<=10){
            CustomerId = random.nextInt(99999);
            boolean check = DataOperation.checkAccountCustomerIdPresentOrNot(CustomerId);
            if (check==false){
                return CustomerId;
            }
            index++;
        }

        return CustomerId;
    }
}
