package com.lld.parkinglot.service;

import com.lld.parkinglot.enums.InvoiceStatus;
import com.lld.parkinglot.exception.PaymentFaildExeption;
import com.lld.parkinglot.model.Invoice;
import org.springframework.stereotype.Service;

/**
 * Created by Aaditya.t on 9/8/19.
 */

@Service
public class PaymentService {
    public boolean pay(Invoice invoice) {
        boolean paidSuccessfully = true; // hardcode
        if (paidSuccessfully){
            invoice.setStatus(InvoiceStatus.PAID);
             return true;
        } else {
            throw new PaymentFaildExeption("Payment declined, Try again");
        }
    }
}
