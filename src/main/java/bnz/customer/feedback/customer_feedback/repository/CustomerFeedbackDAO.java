package bnz.customer.feedback.customer_feedback.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class CustomerFeedbackDAO {

    @Id
    private String id;
    @Column(name = "emailAddress")
    private String emailAddress;
    @Column(name = "rating")
    private String rating;
    @Column(name = "comments")
    private String comments;


    public CustomerFeedbackDAO() {

    }



    public CustomerFeedbackDAO(String id, String emailAddress, String rating, String comments) {
        super();
        this.id = id;
        this.emailAddress = emailAddress;
        this.rating = rating;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRating() {
        return rating;
    }
    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "CustomerFeedbackDAO{" +
                "id='" + id + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", rating='" + rating + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
