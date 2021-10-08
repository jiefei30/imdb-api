package com.marchsoft.service;

import com.marchsoft.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IGenreService {
    List<Genre> findAll();
}
