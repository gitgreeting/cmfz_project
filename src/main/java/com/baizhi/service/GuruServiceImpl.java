package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDao guruDao;
    @Override
    public void insertGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }
    @Override
    public void deleteGuru(String id) {
        guruDao.delete(id);
    }
    @Override
    public void updateGuru(Guru guru) {
        guruDao.update(guru);
    }
    @Override
    public Guru queryOneGuru(String id) {
        return guruDao.queryOne(id);
    }
    @Override
    public List<Guru> findAllGuru() {
        return guruDao.findAll();
    }



}
