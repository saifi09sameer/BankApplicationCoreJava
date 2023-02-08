package com.StartApplication;
import com.AccountTask.MainTask;
import com.ConnectionToData.DataOperation;

public class MainApplication{
    static {
        DataOperation.UpdateAllAccountToMap();
    }
    public static void main(String[] args) {
        System.out.println("===================================================================================================");
        MainTask.MainTask();
        System.out.println("===================================================================================================");
    }

}
