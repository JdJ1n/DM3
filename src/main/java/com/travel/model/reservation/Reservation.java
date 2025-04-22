// com/travel/model/reservation/Reservation.java
package com.travel.model.reservation;

import com.travel.model.journey.Journey;
import com.travel.model.reservation.state.InitialState;
import com.travel.model.reservation.state.ReservationState;

import java.time.LocalDateTime;

public abstract class Reservation {
    private final String referenceNumber;
    private final Journey journey;
    private final LocalDateTime creationDate;
    private final LocalDateTime expirationDate;
    private ReservationState state;

    public Reservation(String referenceNumber,
                       Journey journey,
                       LocalDateTime creationDate,
                       LocalDateTime expirationDate) {
        this.referenceNumber = referenceNumber;
        this.journey = journey;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        // 初始状态：尚未预订
        this.state = new InitialState();
    }

    /** 发起预订 */
    public void book() {
        state.book(this);
    }

    /** 支付预订 */
    public void pay() {
        state.pay(this);
    }

    /** 取消预订（或过期） */
    public void cancel() {
        state.cancel(this);
    }

    /** 返回当前状态名称 */
    public String getStatus() {
        return state.name();
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public Journey getJourney() {
        return journey;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /** 状态类通过此方法切换上下文的状态 */
    public void setState(ReservationState newState) {
        this.state = newState;
    }
}
