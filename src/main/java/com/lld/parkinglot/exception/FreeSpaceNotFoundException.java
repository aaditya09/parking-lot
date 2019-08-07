package com.lld.parkinglot.exception;

/**
 * Created by Aaditya.t on 7/8/19.
 */
public class FreeSpaceNotFoundException extends ObjectNotFoundException {
    public FreeSpaceNotFoundException(String message) {
        super(message);
    }
}
