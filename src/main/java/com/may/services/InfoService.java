package com.may.services;

import com.may.dao.InfoDao;
import com.may.entities.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoDao infoDao;

    public void save(Info info) {
        infoDao.save(info);
    }

    public List<Info> fetchAllPersons() {
        return infoDao.selectAll();
    }

}
