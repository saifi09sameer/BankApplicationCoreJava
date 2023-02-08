package com.Exceptions;

public class InvalidMailException extends RuntimeException{
    public InvalidMailException(String msg){
        super(msg);
    }
}
