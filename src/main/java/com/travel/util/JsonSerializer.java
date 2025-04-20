//package com.travel.util;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import java.io.File;
//import java.io.IOException;
//
//import com.travel.Main;
//import com.travel.observer.TravelModel;
//
//public class JsonSerializer {
//    private static final ObjectMapper mapper = new ObjectMapper()
//            .registerModule(new JavaTimeModule())
//            .enable(SerializationFeature.INDENT_OUTPUT);
//
//    public static void serializeToFile(Main data, String filePath) throws IOException {
//        mapper.writeValue(new File(filePath), data);
//    }
//
//    public static TravelModel deserializeFromFile(String filePath) throws IOException {
//        return mapper.readValue(new File(filePath), Main.class);
//    }
//}
