package com.grisaf.mqttSample;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mqtt")
public class MqttService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<Map<String, Object>> messages = new LinkedList<>();
        while (MqttUtils.peek() != null) {
            MyMqttMessage message = MqttUtils.remove();
            messages.add(message.publicMap());
        }
        if (messages.size() == 0) {
            return Response.status(400).entity("{\"message\":\"empty queue.\"}").build();
        }
        return Response.ok(messages).build();
    }
    
}
