package org.techtown.doit13;

public class Customer {
    String phothUrl;
    String name;
    String birthDay;
    String phoneNum;


    public Customer(String name,String birthDay,String phoneNum)
    {
        this.name=name;
        this.birthDay=birthDay;
        this.phoneNum=phoneNum;
    }

    public String getPhothUrl() {
        return phothUrl;
    }

    public void setPhothUrl(String phothUrl) {
        this.phothUrl = phothUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
