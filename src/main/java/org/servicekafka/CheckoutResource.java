package org.servicekafka;


import org.servicekafka.model.CheckoutEvent;
import org.servicekafka.producer.CheckoutProducer;
import org.servicekafka.response.ApiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/checkout")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckoutResource {

    @Inject
    CheckoutProducer producer;
    
    ObjectMapper mapper = new ObjectMapper();
    
    @POST
    public Response initiateChecout(CheckoutEvent event){
        
        try{
            String payload = mapper.writeValueAsString(event);
            producer.send(payload);
            return Response.accepted().entity(new ApiResponse(200, "Checkout event set to kafka")).build();

        }catch(Exception e){
            return Response.serverError().entity(new ApiResponse(500, "Error: "+e.getMessage())).build();
        }

    }
    
}
