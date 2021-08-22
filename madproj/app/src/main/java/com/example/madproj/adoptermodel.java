package com.example.madproj;

public class adoptermodel {

    String name,phone,email,address,response,mode;

    public adoptermodel(String name,String phone, String email, String address, String response, String mode) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.response = response;
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getResponse() {
        return response;
    }

    public String getMode() {
        return mode;
    }
}
