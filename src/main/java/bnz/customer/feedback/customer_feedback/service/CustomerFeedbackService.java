package bnz.customer.feedback.customer_feedback.service;

import bnz.customer.feedback.customer_feedback.dto.request.CustomerFeedbackRequest;
import bnz.customer.feedback.customer_feedback.dto.response.CustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.dto.response.FetchCustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.exception.CustomerFeedbackException;

public interface CustomerFeedbackService {

    /**
     * @param customerFeedbackRequest
     * @return
     * @throws Exception
     */
    CustomerFeedbackResponse receiveCustomerFeedback(CustomerFeedbackRequest customerFeedbackRequest) throws CustomerFeedbackException;
    FetchCustomerFeedbackResponse fetchCustomerFeedback(String feedbackId) throws CustomerFeedbackException;





}
