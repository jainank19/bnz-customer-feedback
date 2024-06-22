package bnz.customer.feedback.customer_feedback.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerFeedbackException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 1L;
    public CustomerFeedbackException(int statusCode, String message, String code)
    {
        super(message);
        ArrayList<CustomerFeedbackError> error = new ArrayList<CustomerFeedbackError>();
        error.add(CustomerFeedbackError.builder().code(code).message(message).build());

        this.errors = error;
        this.statusCode = statusCode;
        this.success = false;
    }

    public CustomerFeedbackException(List<CustomerFeedbackError> errors, int statusCode) {
        super(errors.toString());
        this.errors = errors;
        this.statusCode = statusCode;
        this.success = false;
    }

    @JsonProperty("errors")
    private final List<CustomerFeedbackError> errors;

    @JsonProperty("statusCode")
    private final int statusCode;

    private final Boolean success;
}
