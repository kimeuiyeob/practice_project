package com.daeduk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    
    private Integer id;
    private String custName;
    private String companyRegistrationNumber;
    private String ceo;
    private String companyName;
    private String address;
    private String phoneNumber;
    private String faxNumber;
    private String etc;
    
}
