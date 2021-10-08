package com.marchsoft.service;

import com.marchsoft.domain.Mg;
import org.springframework.stereotype.Service;

public interface IMgService {

    void addMg(Mg mg);


    void deleteByMovieId(int mid);
}
