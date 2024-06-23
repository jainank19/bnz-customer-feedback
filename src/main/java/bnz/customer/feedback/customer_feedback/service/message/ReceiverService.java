package bnz.customer.feedback.customer_feedback.service.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    Logger log = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination = "${jms.queue}")
    public void receiveMessage(String message) {
        log.info("Receive message", message);
    }

}
