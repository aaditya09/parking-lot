package com.lld.parkinglot.exception;

/**
 * Created by Aaditya.t on 9/8/19.
 */
public class ChargesNotPaidException extends IllegalVehicleStateException {
    public ChargesNotPaidException(String message) {
        super(message);
    }
}
