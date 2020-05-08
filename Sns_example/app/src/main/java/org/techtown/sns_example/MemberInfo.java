package org.techtown.sns_example;

import android.widget.EditText;

public class MemberInfo {
    String name;
    String phonenumber;
    String birthday;
    String address;

    public MemberInfo(String name,String phonenumber, String birthday,String address)
    {
        this.name=name;
        this.phonenumber=phonenumber;
        this.birthday=birthday;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
