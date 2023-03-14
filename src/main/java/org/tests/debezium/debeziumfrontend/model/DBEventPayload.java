package org.tests.debezium.debeziumfrontend.model;

import java.util.Map;

public class DBEventPayload {
    private Map<String,String> before;
    private Map<String,String> after;
    private String op;
    
    public Map<String, String> getBefore() {
        return before;
    }
    public void setBefore(Map<String, String> before) {
        this.before = before;
    }
    public Map<String, String> getAfter() {
        return after;
    }
    public void setAfter(Map<String, String> after) {
        this.after = after;
    }
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }
}