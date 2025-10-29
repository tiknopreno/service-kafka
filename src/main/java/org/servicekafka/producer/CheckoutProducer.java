package org.servicekafka.producer;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CheckoutProducer {
    
   @Inject
   @Channel("checkout-out")
   Emitter<String> emitter;

   public void send(String message){
        emitter.send(message);

        System.out.println("Procedur : "+message);
       
   }

}
