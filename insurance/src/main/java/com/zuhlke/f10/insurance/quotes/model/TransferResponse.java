package com.zuhlke.f10.insurance.quotes.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * TransferResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-20T15:48:46.656+08:00")

public class TransferResponse   {
  @JsonProperty("reference_id")
  private String referenceId = null;

  /**
   * Transaction Status
   */
  public enum StatusEnum {
    ACCEPTED("ACCEPTED"),

    REJECTED("REJECTED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("comment")
  private String comment = null;

  public TransferResponse referenceId(String referenceId) {
    this.referenceId = referenceId;
    return this;
  }

  /**
   * Transaction Id
   * @return referenceId
   **/
  @ApiModelProperty(value = "Transaction Id")


  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public TransferResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Transaction Status
   * @return status
   **/
  @ApiModelProperty(value = "Transaction Status")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TransferResponse comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Get comment
   * @return comment
   **/
  @ApiModelProperty(value = "")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferResponse transferResponse = (TransferResponse) o;
    return Objects.equals(this.referenceId, transferResponse.referenceId) &&
            Objects.equals(this.status, transferResponse.status) &&
            Objects.equals(this.comment, transferResponse.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceId, status, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferResponse {\n");

    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

