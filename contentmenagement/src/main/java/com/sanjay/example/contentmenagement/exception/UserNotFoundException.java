package com.sanjay.example.contentmenagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,reason = "User with this name is note found in data base")
public class UserNotFoundException extends Exception
{
}
