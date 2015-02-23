package com.twu.biblioteca;

/**
 * Created by Administrator on 2015/2/23.
 */
public class User {
    private String name;
    private int timesOfCheckout;
    private String email;
    private String phone;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTimesOfCheckout() {
        return timesOfCheckout;
    }

    public void setTimesOfCheckout(int timesOfCheckout) {
        this.timesOfCheckout = timesOfCheckout;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
