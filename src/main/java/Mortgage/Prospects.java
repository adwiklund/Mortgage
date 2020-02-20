/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mortgage;

import java.text.DecimalFormat;

public class Prospects {
    private String customer;
    private float loan;
    private float interest;
    private int years;
    private static int count = 0;
    
    public Prospects(String customer, float loan, float interest, int years) {
        this.customer = customer;
        this.loan = loan;
        this.interest = interest;
        this.years = years;
    }
    
    public float calculatePowerOf(float monthlyInterest, float payments) {
        float result = 1;
        monthlyInterest = 1 + monthlyInterest;
        
        while(payments != 0) {
            result *= monthlyInterest;
            --payments;
        }

        return result;
    }
    
    public float getMonthlyPayment() {
        interest /= 100.0;
        float b = interest / 12;
        float p = years * 12;
        float U = loan;
        
        float calcPow = calculatePowerOf(b, p);
        
        return U*(b*calcPow)/(calcPow - 1);
    }
    
    public String toString() {
        count++;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        
        return "Prospect " + count + ": " + customer + " wants to borrow " + df.format(loan) + 
                " € for a period of " + years + " years and pay " + df.format(getMonthlyPayment())
                + " € each month";
    }
}
