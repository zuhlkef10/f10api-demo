package com.zuhlke.f10.crowdlending.config;

public enum ClErrorConfigEnum {

    CL_BORROWER_NOT_FOUND("CL-BO-404","Borrower not found"),

    CL_INVESTOR_NOT_FOUND("CL-IN-404","Investor not found"),

    CL_LOAN_NOT_FOUND("CL-LO-404","Loan not found"),

    CL_INTERNAL_ERROR("CL-500","Internal Server Error");

    private String code;

    private String message;

    ClErrorConfigEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
