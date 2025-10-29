package org.servicekafka.consumer;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.servicekafka.model.CheckoutEvent;
import org.servicekafka.producer.CheckoutProducer;
import org.servicekafka.service.CheckoutProcess;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CheckoutConsumer {
    
    @Inject
    CheckoutProcess checkoutProcess;

    @Inject
    CheckoutProducer checkoutProducer;

    ObjectMapper mapper = new ObjectMapper();

    @Incoming("checkout-in")
    @Blocking
    public void consume(String message) throws Exception{
        CheckoutEvent event = mapper.readValue(message, CheckoutEvent.class);
        CheckoutEvent processed = checkoutProcess.process(event);
        String output = mapper.writeValueAsString(processed);
        checkoutProducer.send(output);

        System.out.println("Consumer : "+output);
    }

}
