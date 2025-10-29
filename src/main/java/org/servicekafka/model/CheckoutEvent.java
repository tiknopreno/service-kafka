package org.servicekafka.model;

import java.util.List;

public class CheckoutEvent {

    public String userId;
    public List<Item> cartItems;
    public double total;
    public String timestamp;
    public boolean validated;
    public boolean stockAvailable;
    
}
