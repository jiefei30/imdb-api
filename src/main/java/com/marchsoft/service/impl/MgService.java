package com.marchsoft.service.impl;

import com.marchsoft.dao.IMgDao;
import com.marchsoft.domain.Mg;
import com.marchsoft.service.IMgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MgService implements IMgService {

    @Autowired
    IMgDao iMgDao;

    @Override
    public void deleteByMovieId(int mid) {
        iMgDao.deleteByMovieId(mid);
    }

    @Override
    public void addMg(Mg mg) {
        iMgDao.addMg(mg);
    }
}
