package com.beer.discover;
/**
 * Created with IntelliJ IDEA.
 * User: scottolson
 * Date: 5/17/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Dispatcher {
    void addListener(String type, EventListener listener);
    void removeListener(String type, EventListener listener);
    boolean hasListener(String type, EventListener listener);
    void dispatchEvent(Event event);
}
