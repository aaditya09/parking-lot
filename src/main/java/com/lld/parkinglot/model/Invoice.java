package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.InvoiceStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {
    private Vehicle vehicle;
    private String amount;
    private InvoiceStatus status;

    @Override
    public String toString(){
        return this.vehicle.toString() + " ,amt: " +  this.amount +", status:  " +this.status;
    }
}
