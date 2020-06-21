package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:17
 * @Description:
 */
public class Address {
    private final String detail;
    private final String postCode;

    public Address(String detail, String postCode){
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == Address.class){
            Address ad = (Address) obj;
            if (this.getDetail().equals(ad.getDetail()) && this.getPostCode().equals(ad.getPostCode())){
                return true;
            }
        }
        return false;
    }

    public int hashcode(){
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}
