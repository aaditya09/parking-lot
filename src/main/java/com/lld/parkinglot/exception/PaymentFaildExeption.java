package com.lld.parkinglot.exception;

/**
 * Created by Aaditya.t on 9/8/19.
 */
public class PaymentFaildExeption extends RuntimeException {
    public PaymentFaildExeption(String msg){
        super(msg);
    }
}
