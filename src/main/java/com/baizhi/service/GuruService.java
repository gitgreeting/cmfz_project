package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    void insertGuru(Guru guru);
    void deleteGuru(String id);
    void updateGuru(Guru guru);
    Guru queryOneGuru(String id);
    List<Guru> findAllGuru();

}
