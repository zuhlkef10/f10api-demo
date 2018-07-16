package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Transaction {

    private String id;

    @JsonProperty("this_account")
    private Account account;

    @JsonProperty("other_account")
    private OtherAccount otherAccount;


    private TransactionDetails details;

    private TransactionMetadata metadata;

    @Data
    @NoArgsConstructor
    public static class Account {

        private String id;
        private ArrayList<AccountHolder> holders;

        private String number;
        private String kind;

        @JsonProperty("IBAN")
        private String iban;

        @JsonProperty("swift_bic")
        private String swiftBic;

        private Bank bank;


        @Data
        @NoArgsConstructor
        public static class AccountHolder {
            private String name;

            @JsonProperty("is_alias")
            private boolean isAlias;
        }

        @Data
        @NoArgsConstructor
        public static class Bank {

            @JsonProperty("national_identifier")
            private String nationalIdentifier;
            private String name;

        }

    }

    @Data
    @NoArgsConstructor
    public static class OtherAccount {

        private String id;
        private Account.AccountHolder holder;

        private String number;
        private String kind;

        @JsonProperty("IBAN")
        private String iban;

        @JsonProperty("swift_bic")
        private String swiftBic;

        private Account.Bank bank;

        private AccountMetadata metadata;

        @Data
        @NoArgsConstructor
        public static class AccountMetadata {

            @JsonProperty("public_alias")
            private String publicAlias;

            @JsonProperty("private_alias")
            private String privateAlias;

            @JsonProperty("more_info")
            private String moreInfo;

            @JsonProperty("URL")
            private String url;

            @JsonProperty("image_URL")
            private String imageUrl;

            @JsonProperty("open_corporates_URL")
            private String openCorporatesUrl;

            @JsonProperty("corporate_location")
            private Location corporateLocation;

            @JsonProperty("physical_location")
            private Location physicalLocation;



        }

    }

    @Data
    @NoArgsConstructor
    public static class Location {

        private double latitude;
        private double longitude;

        private String date;
        private User user;

    }

    @Data
    @NoArgsConstructor
    public static class TransactionDetails {

        private String type;
        private String description;
        private String posted;
        private String completed;

        @JsonProperty("new_balance")
        private Money newBalance;

        private Money value;

    }

    @Data
    @NoArgsConstructor
    public static class Money {

        private String currency;
        private double amount;
    }


    @Data
    @NoArgsConstructor
    public static class TransactionMetadata {

        private String narrative;
        private ArrayList<TransactionComment> comments;
        private ArrayList<TransactionComment> tags;

        private ArrayList<TransactionImage> images;
        private Location where;


        @Data
        @NoArgsConstructor
        public static class TransactionComment {

            private String id;
            private String value;
            private String date;
            private User user;

        }

        @Data
        @NoArgsConstructor
        public static class TransactionImage {

            private String id;
            private String label;

            @JsonProperty("URL")
            private String url;

            private String date;
            private User user;

        }

    }

}
