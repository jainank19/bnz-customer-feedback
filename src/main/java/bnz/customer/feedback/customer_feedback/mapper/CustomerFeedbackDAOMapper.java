package bnz.customer.feedback.customer_feedback.mapper;

import bnz.customer.feedback.customer_feedback.dto.request.CustomerFeedbackRequest;
import bnz.customer.feedback.customer_feedback.repository.CustomerFeedbackDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CustomerFeedbackDAOMapper {

    public CustomerFeedbackDAO mapCustomerFeedbackDBRequest(CustomerFeedbackRequest request){
        return CustomerFeedbackDAO.builder()
                .id(UUID.randomUUID().toString())
                .emailAddress(request.getEmailAddress())
                .rating(request.getRatings())
                .comments(request.getComments()).build();

    }

}
