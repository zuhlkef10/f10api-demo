package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class TransactionResponse {
    private String id;
    private String type;
    private TransactionRequest.Account from;
    private TransactionResponseDetails details;
    private ArrayList <String> transaction_ids = new ArrayList<>();
    private String status;
    private String start_date;
    private String end_date;
    private TransactionResponseChallenge challenge;
    private TransactionResponseCharge charge;

    @Data
    @NoArgsConstructor
    public static class TransactionResponseCharge {
        private String summary;
        private Transaction.Money value;
    }


    @Data
    @NoArgsConstructor
    public static class TransactionResponseChallenge{

    }

    @Data
    @NoArgsConstructor
    public static class TransactionResponseDetails{

        @JsonProperty("to_sanbox_tan")
        private TransactionRequest.Account toSandbaoxTan;

        @JsonProperty("to_sepa")
        private Sepa toSepa;

        @JsonProperty("to_counterparty")
        private Counterparty toCounterparty;

        @JsonProperty("to_transfer_to_phone")
        private PhoneTransfer toTransferToPhone;

        private AtmTransfer toTransferToAtm;


        @Data
        @NoArgsConstructor
        public static class Sepa {
            private String iban;
        }

        @Data
        @NoArgsConstructor
        public static class Counterparty{
            @JsonProperty("counterparty_id")
            private String counterpartyId;
        }

        public static class PhoneTransfer{
            private Transaction.Money value;
            private String description;
            private String message;
            private Phone from;
            private Phone to;


        }

        @Data
        @NoArgsConstructor
        public static class Phone{
            @JsonProperty("mobile_phone_number")
            private String mobilPhoneNumber;

            private String nickname;
        }


        @Data
        @NoArgsConstructor
        public static class AtmTransfer{
            private Transaction.Money value;
            private String description;
            private String message;
            private Phone from;

        }
    }

}





