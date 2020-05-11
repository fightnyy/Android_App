package org.techtown.sns_example;

public class MemberInfo {
    String name;
    String phonenumber;
    String birthday;
    String address;
    String photourl;

    public MemberInfo(String name,String phonenumber, String birthday,String address,String photourl)
    {
        this.name=name;
        this.phonenumber=phonenumber;
        this.birthday=birthday;
        this.address=address;
        this.photourl=photourl;
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

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}
