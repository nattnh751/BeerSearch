package com.beer.discover;

/**
 * Created with IntelliJ IDEA.
 * User: scottolson
 * Date: 6/18/13
 * Time: 8:53 AM
 * Base class for common model properties
 */
public class BaseModel extends EventDispatcher {
    protected static final String TAG = "appdataroom";

    public static class ChangeEvent extends SimpleEvent {

        public ChangeEvent(String type) {
            super(type);
        }
    }

    protected void notifyChange(String type) {
        dispatchEvent(new ChangeEvent(type));
    }
}
