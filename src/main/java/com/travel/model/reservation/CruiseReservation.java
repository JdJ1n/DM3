// com/travel/model/reservation/CruiseReservation.java
package com.travel.model.reservation;

import com.travel.model.journey.Journey;

import java.time.LocalDateTime;

public class CruiseReservation extends Reservation {

    public CruiseReservation(String referenceNumber,
                             Journey journey,
                             LocalDateTime creationDate,
                             LocalDateTime expirationDate) {
        super(referenceNumber, journey, creationDate, expirationDate);
    }

    /** 获取邮轮预订专用的支付信息 */
    public void getPayInfo() {
        // TODO
    }
}
