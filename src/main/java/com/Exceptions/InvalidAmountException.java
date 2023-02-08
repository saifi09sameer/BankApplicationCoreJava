package com.Exceptions;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String msg){
        super(msg);
    }
}
