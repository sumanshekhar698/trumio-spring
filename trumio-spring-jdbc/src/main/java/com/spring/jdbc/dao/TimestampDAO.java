package com.spring.jdbc.dao;

import com.spring.jdbc.entities.TimestampEntity;

import java.util.List;
import java.util.Map;

public interface TimestampDAO {
    int insertAndReturnId(TimestampEntity entity);
    void insertInChunks(List<TimestampEntity> entities, int chunkSize);
    int insertWithTimestamp(TimestampEntity entity);
    int insertWithDbCurrentTime(String data);
    int insertWithMapParams(Map<Integer, Object> params);
}