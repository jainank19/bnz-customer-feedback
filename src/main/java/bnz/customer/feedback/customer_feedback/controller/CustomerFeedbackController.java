package bnz.customer.feedback.customer_feedback.controller;

import bnz.customer.feedback.customer_feedback.dto.request.CustomerFeedbackRequest;
import bnz.customer.feedback.customer_feedback.dto.response.CustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.dto.response.FetchCustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.exception.CustomerFeedbackException;
import bnz.customer.feedback.customer_feedback.service.CustomerFeedbackService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Tag(name="Customer Feedback Controller", description = "CUstomer feedback APIs")
@RequiredArgsConstructor
@Slf4j
public class CustomerFeedbackController {

    @Autowired private CustomerFeedbackService customerFeedbackService;


    @PostMapping("/feedback")
    public ResponseEntity<CustomerFeedbackResponse> receiveCustomerFeedback
    (@RequestBody CustomerFeedbackRequest customerFeedbackRequest) throws CustomerFeedbackException {
        CustomerFeedbackResponse customerFeedbackResponse = null;
        customerFeedbackResponse = customerFeedbackService.receiveCustomerFeedback(customerFeedbackRequest);

        return new ResponseEntity<>(customerFeedbackResponse, HttpStatusCode.valueOf(201));
    }

    @GetMapping(value = "/{feedbackId}")
    public ResponseEntity<FetchCustomerFeedbackResponse> fetchCustomerFeedback
            (@PathVariable String feedbackId, WebRequest webRequest) throws CustomerFeedbackException {
        var fetchCustomerFeedbackResponse = customerFeedbackService.fetchCustomerFeedback(feedbackId);

        return new ResponseEntity<>(fetchCustomerFeedbackResponse, HttpStatusCode.valueOf(201));
    }



}
