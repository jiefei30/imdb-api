package com.marchsoft.service.impl;

import com.marchsoft.dao.IGenreDao;
import com.marchsoft.domain.Genre;
import com.marchsoft.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService implements IGenreService {

    @Autowired
    IGenreDao iGenreDao;

    @Override
    public List<Genre> findAll() {
        return iGenreDao.findAll();
    }
}
