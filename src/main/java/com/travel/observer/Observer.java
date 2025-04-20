package com.travel.observer;

/**
 * Observer interface in Observer pattern.
 * Implementations define how to update on subject changes.
 */
public interface Observer {
    void update(Subject subject);
}

