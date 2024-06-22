package bnz.customer.feedback.customer_feedback.service;

import bnz.customer.feedback.customer_feedback.dto.request.CustomerFeedbackRequest;
import bnz.customer.feedback.customer_feedback.dto.response.CustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.dto.response.FetchCustomerFeedbackResponse;
import bnz.customer.feedback.customer_feedback.exception.CustomerFeedbackException;
import bnz.customer.feedback.customer_feedback.mapper.CustomerFeedbackDAOMapper;
import bnz.customer.feedback.customer_feedback.repository.CustomerFeedbackDAO;
import bnz.customer.feedback.customer_feedback.repository.CustomerFeedbackRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerFeedbackServiceImpl implements CustomerFeedbackService{

    @Autowired
    private CustomerFeedbackRepoJPA customerFeedbackRepo;
    @Autowired private CustomerFeedbackDAOMapper customerFeedbackDAOMapper;

    @Override
    public CustomerFeedbackResponse receiveCustomerFeedback(CustomerFeedbackRequest customerFeedbackRequest) {

        try {
            var customerFeedbackDAO = customerFeedbackDAOMapper.mapCustomerFeedbackDBRequest(customerFeedbackRequest);
            customerFeedbackRepo.insert(customerFeedbackDAO);

            return CustomerFeedbackResponse.builder()
                    .statusCode(HttpStatus.valueOf(201).toString())
                    .success(true)
                    .build();
        }
        catch (Exception exception){

            throw new CustomerFeedbackException(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failure while processing feedback",
                    "500"
            );

        }
    }

    @Override
    public FetchCustomerFeedbackResponse fetchCustomerFeedback (String feedbackId) {

        try {
            var fetchCustomerFeedbackResponse = customerFeedbackRepo.findById(feedbackId);

            if(Objects.nonNull(fetchCustomerFeedbackResponse)) {
                return FetchCustomerFeedbackResponse.builder()
                        .statusCode(HttpStatus.valueOf(200).toString())
                        .success(true)
                        .comments(fetchCustomerFeedbackResponse.getComments() == null ? "" : fetchCustomerFeedbackResponse.getComments())
                        .ratings(fetchCustomerFeedbackResponse.getRating())
                        .emailAddress(fetchCustomerFeedbackResponse.getEmailAddress())
                        .build();
            }
            else {
                throw new CustomerFeedbackException(
                        HttpStatus.BAD_REQUEST.value(),
                        "Failure while fetching customer feedback details",
                        "400"
                );
            }
        }
        catch (Exception exception){

            throw new CustomerFeedbackException(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failure while fetching customer feedback details",
                    "500"
            );

        }
    }
}
