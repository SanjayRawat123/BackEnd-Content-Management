/*
 * Author Name:
 * Date: 12/15/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.sanjay.example.contentmenagement.exception;

public class UserFoundException extends Exception{
    public UserFoundException(){

    super("User with this name is already is there in DB");

}
public UserFoundException(String msg){super(msg);}
}