package com.baizhi.service;

import com.baizhi.dao.CounterDao;
import com.baizhi.entity.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CounterServiceImpl implements CounterService {
    @Autowired
    private CounterDao counterDao;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public  List<Counter> findAllConuters() {
        return counterDao.findAll();
    }

    @Override
    public void deleteCounter(String countId) {
        counterDao.delete(countId);
    }

    @Override
    public void updateCounter(Counter counter) {
        counterDao.update(counter);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Counter queryOneCounter(String countId) {
        return counterDao.queryOne(countId);
    }

    @Override
    public void addCounter(Counter counter) {
        counterDao.insert(counter);
    }
}