package com.travel.observer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.model.hub.Hub;
import com.travel.model.seat.Seat;
import com.travel.observer.Observer;
import com.travel.observer.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 应用核心模型（单例），保存 Hub / Seat 数据并负责通知观察者。
 */
public class SystemModel implements Subject {

    /* ---------- 单例实现 ---------- */
    private static final SystemModel INSTANCE = new SystemModel();
    private SystemModel() { }                       // 私有构造

    public static SystemModel getInstance() {
        return INSTANCE;
    }

    /* ---------- 领域数据 ---------- */
    private final List<Hub>  hubs  = new ArrayList<>();
    private final List<Seat> seats = new ArrayList<>();

    /* ---------- 观察者列表 ---------- */
    @JsonIgnore                      // 不序列化到 JSON
    private final List<Observer> observers = new ArrayList<>();

    /* ---------- 对外只读视图 ---------- */
    public List<Hub>  getHubs()  { return Collections.unmodifiableList(hubs); }
    public List<Seat> getSeats() { return Collections.unmodifiableList(seats); }

    /* ---------- 向模型添加数据 ---------- */
    public void addHub(Hub hub) {
        hubs.add(hub);
        notifyObservers();
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
        notifyObservers();
    }

    /* ---------- Subject 实现 ---------- */
    @Override public void attach(Observer o)  { observers.add(o); }
    @Override public void detach(Observer o)  { observers.remove(o); }
    @Override public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}

