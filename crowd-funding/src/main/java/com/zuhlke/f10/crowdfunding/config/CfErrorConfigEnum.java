package com.zuhlke.f10.crowdfunding.config;

public enum CfErrorConfigEnum {

    CF_CAMPAIGN_NOT_FOUND("CF-CM-404", "Campaign not found"),

    CF_CONTRIBUTOR_NOT_FOUND("CF-CO-404", "Contributor not found"),

    CF_INTERNAL_ERROR("CF-500", "Internal Server Error");

    private String code;

    private String message;

    CfErrorConfigEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }


}
