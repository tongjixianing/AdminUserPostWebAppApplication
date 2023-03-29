package com.example.adminuserpostwebapp;


public class UserInfo {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

    }

    static class Geo {
        private String lat;
        private String lng;


    }

    static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }


}
