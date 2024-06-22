package bnz.customer.feedback.customer_feedback.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerFeedbackRepoJPA {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(CustomerFeedbackDAO customerFeedback) {
        entityManager.merge(customerFeedback);
    }

    public CustomerFeedbackDAO findById(String id) {
        return entityManager.find(CustomerFeedbackDAO.class, id);
    }
}
