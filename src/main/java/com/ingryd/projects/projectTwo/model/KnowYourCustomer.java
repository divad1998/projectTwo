package com.ingryd.projects.projectTwo.model;

import jakarta.persistence.*;

@Entity
@Table(name="kyc")
public class KnowYourCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String address;
    private String bankVerificationNumber;
    private String nin_number;
    private String localGovtOfResidence;
    private String stateOfResidence;
    private String dateOfBirth;
    private String nextOfKin;

    @OneToOne
    @JoinColumn(name = "account_user_id")
    private  AccountUser accountUser;

    public KnowYourCustomer() {
    }

    public KnowYourCustomer(String address, String bankVerificationNumber, String nin_number, String localGovtOfResidence, String stateOfResidence, String dateOfBirth, String nextOfKin, AccountUser accountUser) {
        this.address = address;
        this.bankVerificationNumber = bankVerificationNumber;
        this.nin_number = nin_number;
        this.localGovtOfResidence = localGovtOfResidence;
        this.stateOfResidence = stateOfResidence;
        this.dateOfBirth = dateOfBirth;
        this.nextOfKin = nextOfKin;
        this.accountUser = accountUser;
    }
}
