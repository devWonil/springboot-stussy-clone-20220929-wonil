package com.stussy.stussyclone20220929wonil.exception;

public class CustomInternalServerErrorException extends RuntimeException{

    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
