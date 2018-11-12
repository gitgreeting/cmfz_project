package com.baizhi.entity;

import java.util.Date;

public class User {
    private String id;
    private String phoneNum;
    private String nickName;
    private String userName;
    private String password;
    private String salt;
    private String headPic;
    private String province;
    private String city;
    private String gender;
    private String sign;
    private String status;
    private Date date;

    public User(String id, String phoneNum, String nickName, String userName, String password, String salt, String headPic, String province, String city, String gender, String sign, String status, Date date) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.nickName = nickName;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.headPic = headPic;
        this.province = province;
        this.city = city;
        this.gender = gender;
        this.sign = sign;
        this.status = status;
        this.date = date;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", headPic='" + headPic + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", sign='" + sign + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
