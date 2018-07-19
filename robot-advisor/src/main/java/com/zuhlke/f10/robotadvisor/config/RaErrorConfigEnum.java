package com.zuhlke.f10.robotadvisor.config;

public enum RaErrorConfigEnum {

    RA_PORTFOLIO_NOT_FOUND("RA-PO-404","Portfolio not found"),

    RA_INVESTMENT_GOAL_NOT_FOUND("RA-IG-404","Investment goal not found"),

    RA_CUSTOMER_NOT_FOUND("RA-CU-404","Customer not found"),

    RA_INTERNAL_ERROR("RA-500","Internal Server Error");

    private String code;

    private String message;

    RaErrorConfigEnum(String code, String message) {
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
