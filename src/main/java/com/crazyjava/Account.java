package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/09/29 20:17
 * @Description:
 **/
public class Account {

    private String accountNo;

    private double balance;

    public Account(){

    }


    public Account(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == Account.class){
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }

        return false;
    }
}
