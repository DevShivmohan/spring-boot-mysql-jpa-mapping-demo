package com.mapping.example.exception;

import lombok.Data;

@Data
public class GenericException extends Exception{
    private String message;
    private int statusCode;
    public GenericException(int statusCode,String message){
        super(message);
        this.statusCode=statusCode;
        this.message=message;
    }
}
