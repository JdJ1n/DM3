package com.travel.observer;


/**
 * Subject interface in Observer pattern.
 * It allows observers to register and get notified of changes.
 */
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

