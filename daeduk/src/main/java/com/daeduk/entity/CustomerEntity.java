package com.daeduk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CUSTOMER")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  
    private Integer id;

    @Column(name = "cust_name", nullable = false)  
    private String custName;

    @Column(name = "company_registration_number", nullable = false)
    private String companyRegistrationNumber;

    @Column(name = "ceo")
    private String ceo;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "etc")
    private String etc;

}
