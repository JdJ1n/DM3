package com.travel.model.passenger;

import java.time.LocalDate;

public class Passenger {
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phone;
    protected String passportNumber;
    protected LocalDate dateOfBirth;
    protected LocalDate passportExpDate;

    public Passenger(String email,
                     String firstName,
                     String lastName,
                     String address,
                     String phone,
                     String passportNumber,
                     LocalDate dateOfBirth,
                     LocalDate passportExpDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
        this.passportExpDate = passportExpDate;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getPassportExpDate() {
        return passportExpDate;
    }

    public void setPassportExpDate(LocalDate passportExpDate) {
        this.passportExpDate = passportExpDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportExpDate=" + passportExpDate +
                '}';
    }
}
