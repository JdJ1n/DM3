package com.travel.util;

import com.travel.observer.*;
import com.travel.model.hub.Airport;
import com.travel.model.hub.Port;
import com.travel.model.hub.Station;
import com.travel.model.seat.CruiseCabin;
import com.travel.model.seat.FlightSeat;
import com.travel.model.seat.TrainSeat;

/**
 * 用于在应用启动时快速生成演示用的 Hub / Seat 数据。
 */
public final class DataInitializer1 {

    private DataInitializer1() { }       // 工具类，禁止实例化

    public static void initialize(SystemModel model) {

        /* ---------- Hubs ---------- */
        model.addHub(new Airport("YUL"));     // Montréal‑Trudeau
        model.addHub(new Airport("YYZ"));     // Toronto‑Pearson
        model.addHub(new Port("MIA"));        // PortMiami
        model.addHub(new Station("NYC"));     // Penn Station ‑ NYC

        /* ---------- Seats ---------- */
        model.addSeat(new FlightSeat('A', 1));           // 头等舱 1A
        model.addSeat(new FlightSeat('C', 12));          // 经济舱 12C

        CruiseCabin cabin = new CruiseCabin(4,1);          // 4‑berth cabin
        cabin.book(); cabin.pay();
        model.addSeat(cabin);

        TrainSeat tSeat = new TrainSeat( 'B',5,5);         // 5B
        tSeat.book();
        model.addSeat(tSeat);
    }
}

