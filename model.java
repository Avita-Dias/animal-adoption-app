package com.example.madproj;

public class model {
    String aaname,age,details,dtype,purl;

    public model() {
    }

    public model(String aaname,String age,String details,String dtype,String purl) {
        this.aaname = aaname;
        this.age = age;
        this.details=details;
        this.dtype = dtype;
        this.purl = purl;
    }

    public String getAaname() {
        return aaname;
    }

    public void setAaname(String aaname) {
        this.aaname = aaname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
