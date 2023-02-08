package com.Formating;
import com.Exceptions.InvalidAmountException;
public class Account implements AccountFormat{
    String holderName;
    String mailId;
    String gender;
    String address;
    String mobileBanking;
    String AllTransaction;
    final private float interestRate=11.5f;
    static String STATUS = "Active";
    static String BANKNAME = "HDFC Bank";
    private double accountBalance;
    private String date;
    private int customerId;
    private int age;
    private int orignalPin;
    private long accountNumber;
    private long mobileNumber;
    public void setAddress(String address) {
        this.address = address;
    }
    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getDate() {
        return date;
    }

    public int getCustomerId() {
        return customerId;
    }
    public String getAllTransaction() {
        return AllTransaction;
    }

    public void setAllTransaction(double allTransaction,String type) {
        String Transaction = String.valueOf(allTransaction);
        this.AllTransaction=this.AllTransaction.concat(type+"-"+Transaction+"_");
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getHolderName() {
        return this.holderName;
    }

    @Override
    public String getMailId() {
        return this.mailId;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public long getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public long getMobileNumber() {
        return this.mobileNumber;
    }


    @Override
    public String getMobileBanking() {
        return this.mobileBanking;
    }

    @Override
    public void setMobileBanking(String mobileBanking) {
        if (mobileBanking.equalsIgnoreCase("yes")) {
            this.mobileBanking = "Active";
        } else {
            this.mobileBanking = "InActive";
        }

    }

    @Override
    public float getInterestRate() {
        return this.interestRate;
    }



    @Override
    public int getPin() {
        return this.orignalPin;
    }

    public Account(String date, int customerId, String holderName, String mailId,
            long mobileNumber, String gender, String address, int age,
            long accountNumber, int pin,double accountBalance,String mobileBanking,String AllTransaction) {
        this.date = date;
        this.customerId = customerId;
        this.holderName = holderName;
        this.mailId = mailId;
        this.gender = gender;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.accountNumber = accountNumber;
        this.orignalPin = pin;
        this.accountBalance=accountBalance;
        this.mobileBanking=mobileBanking;
        this.AllTransaction=AllTransaction;
    }

    @Override
    public double getBalance() {
        return this.accountBalance;
    }

    @Override
    public void withdrawAmount(double WithdrawBalance)  {
        try {
            if (WithdrawBalance <= this.accountBalance && WithdrawBalance > 0) {
                this.accountBalance = this.accountBalance - WithdrawBalance;
                System.out.println("Your Money Successfully Withdraw : ");
            } else {
                throw new InvalidAmountException("Invalid Amount : ");
            }
        }catch (InvalidAmountException invalidAmountException){
            System.out.println(invalidAmountException.getMessage());
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        try {
            if (depositAmount > 0) {
                this.accountBalance = this.accountBalance + depositAmount;
                System.out.println("Your Money Successfully Deposit : ");
            } else {
                throw new InvalidAmountException("Invalid Amount : ");
            }
        }catch (InvalidAmountException invalidAmountException){
            System.out.println(invalidAmountException.getMessage());
        }

    }





    public void displayCustomerDetails() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Customer ID             : "+getCustomerId()+"\t\t\t\t\t\t"+"Your Status is : " + STATUS);
        System.out.println("Bank Name is            : " + BANKNAME + "\t\t\t\t\tAccount Opening Date: "+date );
        System.out.println("Your Full Name          : " + getHolderName() + "\t\t\t\t" + "Your Account Number : " + accountNumber);
        System.out.println("Your Mobile No          : " + getMobileNumber() + "\t\t\t\t" + "Your Mail id : " + getMailId());
        System.out.println("Your Address            : " + getAddress() + "\t\t\t\t\t" + "Your Age is : " + getAge());
        System.out.println("Your Gender is          : " + getGender() + "\t\t\t\t\t\t");
        System.out.println("Your MobileBanking      : " + getMobileBanking());
        System.out.println("Your InterestName       : " + getInterestRate());
        System.out.println("Your Current Balance is : " + this.accountBalance);
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Account{" +
                "holderName='" + holderName + '\'' +
                ", mailId='" + mailId + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mobileBanking='" + mobileBanking + '\'' +
                ", interestRate=" + interestRate +
                ", accountBalance=" + accountBalance +
                ", date='" + date + '\'' +
                ", customerId=" + customerId +
                ", age=" + age +
                ", orignalPin=" + orignalPin +
                ", accountNumber=" + accountNumber +
                ", mobileNumber=" + mobileNumber +
                '}';
    }

    Account() {

    }

}
