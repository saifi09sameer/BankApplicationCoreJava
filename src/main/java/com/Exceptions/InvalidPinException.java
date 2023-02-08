package com.Exceptions;

public class InvalidPinException extends RuntimeException{
    public InvalidPinException(String msg){
        super(msg);
    }
}
