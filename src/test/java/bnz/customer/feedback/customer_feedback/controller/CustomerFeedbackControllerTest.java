package bnz.customer.feedback.customer_feedback.controller;

import bnz.customer.feedback.customer_feedback.dto.request.CustomerFeedbackRequest;
import bnz.customer.feedback.customer_feedback.dto.response.CustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.dto.response.FetchCustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.service.CustomerFeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CustomerFeedbackControllerTest {

    @InjectMocks CustomerFeedbackController customerFeedbackController;
    @Mock
    private CustomerFeedbackService customerFeedbackService;

    private CustomerFeedbackRequest customerFeedbackRequest;
    private CustomerFeedbackResponse customerFeedbackResponse;
    private FetchCustomerFeedbackResponse fetchCustomerFeedbackResponse;
    String feedbackId;

    @BeforeEach
    public void setup(){
        feedbackId = "123";
        customerFeedbackResponse.builder().statusCode("201").success(true).build();
        customerFeedbackRequest.builder().comments("Positive").ratings("5").emailAddress("abc@gmail.com").build();
        fetchCustomerFeedbackResponse.builder().emailAddress("abc@gmail.com").ratings("5").comments("Positive").build();

    }



    @Test
    public void test_receiveCustomerFeedback() throws Exception {

        Mockito.when(customerFeedbackService.receiveCustomerFeedback(customerFeedbackRequest)).thenReturn(customerFeedbackResponse);

        ResponseEntity<CustomerFeedbackResponse> customerFeedbackResponse = customerFeedbackController.receiveCustomerFeedback(customerFeedbackRequest);

        Assert.notNull(customerFeedbackResponse, "customerFeedbackResponse is null");
    }

    @Test
    public void test_fetchCustomerFeedback() throws Exception {

        Mockito.when(customerFeedbackService.fetchCustomerFeedback(feedbackId)).thenReturn(fetchCustomerFeedbackResponse);

        ResponseEntity<FetchCustomerFeedbackResponse> fetchCustomerFeedback = customerFeedbackController.fetchCustomerFeedback(feedbackId,any());

        Assert.notNull(fetchCustomerFeedback, "customerFeedbackResponse is null");
    }
}
