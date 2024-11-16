package org.micwir.exception;

public class WrongTimeFormatException extends RuntimeException{


    public WrongTimeFormatException(String s){
        super(s);
    }

    public WrongTimeFormatException(){}
}
