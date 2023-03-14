package org.tests.debezium.debeziumfrontend.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;
import org.reactivestreams.Publisher;
import org.tests.debezium.debeziumfrontend.model.DBEvent;


@Path("/dbEvents")
public class DBEventsResource {


    @Inject
    @Channel("frontend-db-events")
    Publisher<DBEvent> dbEventsChannel;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Publisher<DBEvent> streamDBEvents() {
        return this.dbEventsChannel;
    }
}