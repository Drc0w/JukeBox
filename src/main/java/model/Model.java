package model;

import java.util.Observable;

/**
 * Created by php on 06/07/16.
 *
 * This class is used in order to implement the MVC design pattern.
 * All models will extend this class.
 */
public abstract class Model extends Observable {

    /**
     * Perform an action and notifies observers
     *
     * @param o Object used in order to update the model
     */
    public abstract void performAction(Object o);
}
