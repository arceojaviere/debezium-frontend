package org.tests.debezium.debeziumfrontend.model;

public class DBEvent {
    
    private boolean heartbeat;
    private DBEventPayload payload;

    public DBEventPayload getPayload() {
        return payload;
    }
    public void setPayload(DBEventPayload payload) {
        this.payload = payload;
    }
    public boolean isHeartbeat() {
        return heartbeat;
    }
    public void setHeartbeat(boolean heartbeat) {
        this.heartbeat = heartbeat;
    }

    
}