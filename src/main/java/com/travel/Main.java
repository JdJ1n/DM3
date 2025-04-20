package com.travel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.travel.observer.*;
import com.travel.model.hub.Airport;
import com.travel.model.hub.Port;
import com.travel.model.hub.Station;
import com.travel.model.seat.FlightSeat;
import com.travel.model.seat.TrainSeat;
import com.travel.model.seat.CruiseCabin;
import com.travel.util.DataInitializer1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 启动程序：初始化数据 → 导出到 util/travelData.json → 再导入并验证。
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /* ---------- 1. 初始化单例模型 ---------- */
        SystemModel model = SystemModel.getInstance();
        DataInitializer1.initialize(model);
        System.out.println("模型填充完毕：Hub=" + model.getHubs().size()
                + ", Seat=" + model.getSeats().size());

        /* ---------- 2. 配置 Jackson ---------- */
        ObjectMapper mapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build()
                .registerModule(new JavaTimeModule());

        // 注册多态子类型（Hub + Seat 各叶子类）
        mapper.registerSubtypes(Airport.class, Port.class, Station.class,
                FlightSeat.class, TrainSeat.class, CruiseCabin.class);

        /* ---------- 3. 导出 JSON ---------- */
        Path utilDir  = Path.of(System.getProperty("user.dir"), "util");
        Files.createDirectories(utilDir);
        Path dataFile = utilDir.resolve("travelData.json");

        // 组合成一个对象写出：{ "hubs": [...], "seats": [...] }
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("hubs",  model.getHubs());
        wrapper.put("seats", model.getSeats());

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(dataFile.toFile(), wrapper);

        System.out.println("已导出到: " + dataFile.toAbsolutePath());

        /* ---------- 4. 导入并验证 ---------- */
        Map<String, Object> readBack = mapper.readValue(
                dataFile.toFile(),
                new TypeReference<Map<String, Object>>() {}
        );

        System.out.println("\n=== 导入验证 ===");
        System.out.println("hubs  数量: " + ((java.util.List<?>) readBack.get("hubs")).size());
        System.out.println("seats 数量: " + ((java.util.List<?>) readBack.get("seats")).size());
    }
}
