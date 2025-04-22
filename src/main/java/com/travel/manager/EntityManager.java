// com/travel/manager/EntityManager.java
package com.travel.manager;

import java.util.List;

public interface EntityManager<T> {
    void add(T e);
    void edit(T e);
    void delete(T e);
    List<T> getAll();
}