package bnz.customer.feedback.customer_feedback.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerFeedbackResponse {

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("success")
    private Boolean success;

}
