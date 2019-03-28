package com.example.customermanagement.entity;

public class Customer {

    private long id;

    private String firstName;

    private String lastName;

    private String emailId;

    private long createdTime;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String emailId, long createdTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.createdTime = createdTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
                + ", createdTime=" + createdTime + "]";
    }

}
