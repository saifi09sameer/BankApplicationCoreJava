package com.AccountTask;

import com.Exceptions.InvalidAgeException;
import com.Exceptions.InvalidMailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condition {
    public static boolean checkMail(String mailID) {
        String mail[] = mailID.split("@");
        if (mail.length==2){
            if (mail[1].equalsIgnoreCase("gmail.com")) {
                return true;
            }
        }
        throw new InvalidMailException("Invalid Mail Exception ");
    }

    public static boolean checkMobileNumber(long mobileNumber) {
        long phone = mobileNumber;
        int length = 0;
        while (phone != 0) {
            phone = phone / 10;
            length++;
        }
        if (length == 10) {
            return true;
        }
        return false;
    }
    public static boolean checkAge(int age){
        if (age>=18 && age<=80){
            return true;
        } else if (age>80) {
            throw new InvalidAgeException("Your Can't Create Account Because You are Very Old : ");
        } else {
            throw new InvalidAgeException("Your Can't Create Account Because You are Child : ");
        }
    }
}
