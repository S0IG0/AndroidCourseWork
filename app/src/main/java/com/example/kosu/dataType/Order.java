package com.example.kosu.dataType;

public class Order {
    private String telephone = "";
    private String name = "";
    private String email = "";
    private String message = "";

    public Order(String telephone, String name, String email, String message) {
        this.telephone = telephone;
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Order{" +
                "telephone='" + telephone + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
