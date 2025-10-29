package org.servicekafka.service;

import java.time.Instant;

import org.servicekafka.model.CheckoutEvent;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CheckoutProcess {
    
    public CheckoutEvent process(CheckoutEvent event){
        event.validated = true;
        event.stockAvailable = true;
        event.timestamp = Instant.now().toString();
        return event;
    }

}
