package com.zuhlke.f10.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @JsonProperty("bank_id")
    private String bankId;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_number")
    private String customerNumber;

    @JsonProperty("legal_name")
    private String legalName;

    @JsonProperty("mobile_phone_number")
    private String mobilePhoneNumber;

    private String email;

    @JsonProperty("face_image")
    private CustomerImage faceImage;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("relationship_status")
    private String relationshipStatus;

    private int dependants;

    private ArrayList<String> dobOfDependants;

    @JsonProperty("credit_rating")
    private CreditRating creditRating;

    @JsonProperty("credit_limit")
    private CreditLimit creditLimit;

    @JsonProperty("highest_education_attained")
    private String highestEducationAttained;

    @JsonProperty("employment_status")
    private String employmentStatus;

    @JsonProperty("kyc_status")
    private boolean kycStatus;

    @JsonProperty("last_ok_date")
    private String lastOkDate;


}
