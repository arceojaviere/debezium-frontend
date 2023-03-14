package org.tests.debezium.debeziumfrontend.serdes;

import org.tests.debezium.debeziumfrontend.model.DBEvent;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class DBEventsDeserializer extends ObjectMapperDeserializer<DBEvent>{

    public DBEventsDeserializer() {
        super(DBEvent.class);
    }
    
}
