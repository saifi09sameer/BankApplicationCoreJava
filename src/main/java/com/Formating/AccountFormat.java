package com.Formating;

public interface AccountFormat {
    int getAge();

    double getBalance();

    void withdrawAmount(double WithdrawBalance);

    void depositAmount(double depositAmount);

    void displayCustomerDetails();

    String getHolderName();

    String getMailId();

    String getGender();

    String getAddress();

    long getAccountNumber();

    long getMobileNumber();


    String getMobileBanking();

    void setMobileBanking(String mobileBanking);

    float getInterestRate();

    int getPin();

}
