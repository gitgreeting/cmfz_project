package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

public interface CounterService {
    List<Counter> findAllConuters();
    void deleteCounter(String countId);
    void updateCounter(Counter counter);
    Counter queryOneCounter(String countId);
    void addCounter(Counter counter);
}
