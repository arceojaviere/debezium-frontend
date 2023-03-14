package org.tests.debezium.debeziumfrontend.service;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;
import org.tests.debezium.debeziumfrontend.model.DBEvent;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class DBEventsService {

    private static final Logger LOGGER = Logger.getLogger(DBEventsService.class);
    @Inject
    @Channel("frontend-db-events")
    @OnOverflow(OnOverflow.Strategy.DROP)
    Emitter<DBEvent> stringDBEventEmmiter;


    @Incoming("db-events")
    public void process(DBEvent dbEvent){
        
        LOGGER.info("Got a new event: " + dbEvent);

        if(dbEvent != null && dbEvent.getPayload() != null && dbEvent.getPayload().getOp() != null){
            stringDBEventEmmiter.send(dbEvent);
        }
        
        
    }

    @Outgoing("frontend-db-events")
    public Multi<DBEvent> hearbeat(){
        return Multi.createFrom().ticks().
                    every(Duration.ofSeconds(10))
                    .onOverflow().drop()
                    .map((tick) -> {
                        DBEvent event = new DBEvent();
                        event.setHeartbeat(true);
                        return event;
                    });
    }
    
}
