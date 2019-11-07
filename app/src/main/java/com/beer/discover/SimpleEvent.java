package com.beer.discover;

/**
 * Created with IntelliJ IDEA.
 * User: scottolson
 * Date: 5/17/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */

public class SimpleEvent implements Event {

    private String type;
    @Override public String getType() { return type; }
    public void setType(String type) {
        this.type = type;
    }

    protected Object source;
    @Override public Object getSource() {
        return source;
    }
    @Override public void setSource(Object source) {
        this.source = source;
    }

    public SimpleEvent(String type) {
        this.type = type;
    }

}
