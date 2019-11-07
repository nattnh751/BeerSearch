package com.beer.discover;

/**
 * Created with IntelliJ IDEA.
 * User: scottolson
 * Date: 5/17/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Event {

    String getType();
    Object getSource();
    void setSource(Object source);
}
