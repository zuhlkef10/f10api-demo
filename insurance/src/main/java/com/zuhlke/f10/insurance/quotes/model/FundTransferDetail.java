package com.zuhlke.f10.insurance.quotes.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class FundTransferDetail   {
    @JsonProperty("credit_account_number")
    private String creditAccountNumber = null;

    @JsonProperty("bank_code")
    private String bankCode = null;

    @JsonProperty("payee_name")
    private String payeeName = null;

    @JsonProperty("amount")
    private BigDecimal amount = null;

    @JsonProperty("source_currency")
    private String sourceCurrency = null;

    @JsonProperty("destination_currency")
    private String destinationCurrency = null;

    @JsonProperty("transfer_currency")
    private String transferCurrency = null;

    @JsonProperty("comments")
    private String comments = null;

    /**
     * Gets or Sets transferType
     */
    public enum TransferTypeEnum {
        INSTANT("INSTANT"),

        NON_INSTANT("NON-INSTANT");

        private String value;

        TransferTypeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TransferTypeEnum fromValue(String text) {
            for (TransferTypeEnum b : TransferTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("transfer_type")
    private TransferTypeEnum transferType = null;

    @JsonProperty("value_date")
    private LocalDate valueDate = null;

    @JsonProperty("reference_id")
    private String referenceId = null;

    public FundTransferDetail creditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
        return this;
    }

    /**
     * Get creditAccountNumber
     * @return creditAccountNumber
     **/
    @ApiModelProperty(value = "")


    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
    }

    public FundTransferDetail bankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    /**
     * Get bankCode
     * @return bankCode
     **/
    @ApiModelProperty(value = "")


    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public FundTransferDetail payeeName(String payeeName) {
        this.payeeName = payeeName;
        return this;
    }

    /**
     * Get payeeName
     * @return payeeName
     **/
    @ApiModelProperty(value = "")


    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public FundTransferDetail amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     * @return amount
     **/
    @ApiModelProperty(value = "")

    @Valid

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FundTransferDetail sourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
        return this;
    }

    /**
     * Get sourceCurrency
     * @return sourceCurrency
     **/
    @ApiModelProperty(value = "")


    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public FundTransferDetail destinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
        return this;
    }

    /**
     * Get destinationCurrency
     * @return destinationCurrency
     **/
    @ApiModelProperty(value = "")


    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public FundTransferDetail transferCurrency(String transferCurrency) {
        this.transferCurrency = transferCurrency;
        return this;
    }

    /**
     * Get transferCurrency
     * @return transferCurrency
     **/
    @ApiModelProperty(value = "")


    public String getTransferCurrency() {
        return transferCurrency;
    }

    public void setTransferCurrency(String transferCurrency) {
        this.transferCurrency = transferCurrency;
    }

    public FundTransferDetail comments(String comments) {
        this.comments = comments;
        return this;
    }

    /**
     * Get comments
     * @return comments
     **/
    @ApiModelProperty(value = "")


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public FundTransferDetail transferType(TransferTypeEnum transferType) {
        this.transferType = transferType;
        return this;
    }

    /**
     * Get transferType
     * @return transferType
     **/
    @ApiModelProperty(value = "")


    public TransferTypeEnum getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferTypeEnum transferType) {
        this.transferType = transferType;
    }

    public FundTransferDetail valueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
        return this;
    }

    /**
     * Get valueDate
     * @return valueDate
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public FundTransferDetail referenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    /**
     * Get referenceId
     * @return referenceId
     **/
    @ApiModelProperty(value = "")


    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FundTransferDetail fundTransferDetail = (FundTransferDetail) o;
        return Objects.equals(this.creditAccountNumber, fundTransferDetail.creditAccountNumber) &&
                Objects.equals(this.bankCode, fundTransferDetail.bankCode) &&
                Objects.equals(this.payeeName, fundTransferDetail.payeeName) &&
                Objects.equals(this.amount, fundTransferDetail.amount) &&
                Objects.equals(this.sourceCurrency, fundTransferDetail.sourceCurrency) &&
                Objects.equals(this.destinationCurrency, fundTransferDetail.destinationCurrency) &&
                Objects.equals(this.transferCurrency, fundTransferDetail.transferCurrency) &&
                Objects.equals(this.comments, fundTransferDetail.comments) &&
                Objects.equals(this.transferType, fundTransferDetail.transferType) &&
                Objects.equals(this.valueDate, fundTransferDetail.valueDate) &&
                Objects.equals(this.referenceId, fundTransferDetail.referenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditAccountNumber, bankCode, payeeName, amount, sourceCurrency, destinationCurrency, transferCurrency, comments, transferType, valueDate, referenceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FundTransferDetail {\n");

        sb.append("    creditAccountNumber: ").append(toIndentedString(creditAccountNumber)).append("\n");
        sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
        sb.append("    payeeName: ").append(toIndentedString(payeeName)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    sourceCurrency: ").append(toIndentedString(sourceCurrency)).append("\n");
        sb.append("    destinationCurrency: ").append(toIndentedString(destinationCurrency)).append("\n");
        sb.append("    transferCurrency: ").append(toIndentedString(transferCurrency)).append("\n");
        sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
        sb.append("    transferType: ").append(toIndentedString(transferType)).append("\n");
        sb.append("    valueDate: ").append(toIndentedString(valueDate)).append("\n");
        sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
