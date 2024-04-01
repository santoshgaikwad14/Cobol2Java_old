package com.exlservice.cobol2java.dto;

public class SuppAdd {
    private String type;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private int zipCode;


    public SuppAdd(String dataLine, int i) {
        if(i == 1) {
            this.type = dataLine.substring(131,132);
            this.address1 = dataLine.substring(132,147);
            this.address2 = dataLine.substring(147,162);
            this.address3 = dataLine.substring(162,177);
            this.city = dataLine.substring(177,192);
            this.state = dataLine.substring(192,194);
            this.zipCode = Integer.parseInt(dataLine.substring(194,203));
        } else if(i == 2) {
            this.type = dataLine.substring(203,204);
            this.address1 = dataLine.substring(204,219);
            this.address2 = dataLine.substring(219,234);
            this.address3 = dataLine.substring(234,249);
            this.city = dataLine.substring(249,264);
            this.state = dataLine.substring(264,266);
            this.zipCode = Integer.parseInt(dataLine.substring(266,275));
        } else if(i == 3) {
            this.type = dataLine.substring(275,276);
            this.address1 = dataLine.substring(276,291);
            this.address2 = dataLine.substring(291,306);
            this.address3 = dataLine.substring(306,321);
            this.city = dataLine.substring(321,336);
            this.state = dataLine.substring(336,338);
            this.zipCode = Integer.parseInt(dataLine.substring(338,347));
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
