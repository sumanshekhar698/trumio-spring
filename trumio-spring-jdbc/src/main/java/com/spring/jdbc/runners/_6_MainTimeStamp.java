package com.spring.jdbc.runners;

import com.spring.jdbc.config.JavaAutowiredConfig;
import com.spring.jdbc.dao.TimestampDAO;
import com.spring.jdbc.entities.TimestampEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _6_MainTimeStamp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaAutowiredConfig.class);
        TimestampDAO dao = context.getBean("timestampDao", TimestampDAO.class);

//        // Scenario 1: Manual Timestamp from Java
//        TimestampEntity et = new TimestampEntity("Java Time Test", new Timestamp(System.currentTimeMillis()));
//        System.out.println("Rows Updated Q1: " + dao.insertWithTimestamp(et));
//        System.out.println();

//        // Scenario 2: DB Generated Timestamp
//        System.out.println("Rows Updated Q2: " + dao.insertWithDbCurrentTime("DB Time Test"));
//        System.out.println();
//
//        // Scenario 3: Map-based Params
//        Map<Integer, Object> params = new HashMap<>();
//        params.put(1, "Map Parameter Test");
//        System.out.println("Rows Updated Q3: " + dao.insertWithMapParams(params));
//        System.out.println();


        // Single Insert: Get back the ID
//        TimestampEntity et1 = new TimestampEntity("Key Test", new Timestamp(System.currentTimeMillis()));
//        int newId = dao.insertAndReturnId(et1);
//        System.out.println("New Auto-Gen ID: " + newId);
//        System.out.println();

        // Chunked Batch Insert: 10 records, processed 3 at a time
        List<TimestampEntity> list = List.of(
                new TimestampEntity("Data 1", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 2", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 3", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 4", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 5", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 6", new Timestamp(System.currentTimeMillis())),
                new TimestampEntity("Data 7", new Timestamp(System.currentTimeMillis()))
                // ... add more
        );
        dao.insertInChunks(list, 3);

    }
}