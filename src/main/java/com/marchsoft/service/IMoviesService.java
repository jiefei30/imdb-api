package com.marchsoft.service;

import com.marchsoft.domain.Movie;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMoviesService {

    /**
     * 查询所有电影
     * @return
     */
    List<Movie> findAll();

    /**
     * 新增一个电影
     * @param movie
     */
    void addMovie(Movie movie);

    Movie makeMovie(HttpServletRequest request);

    void deleteMovie(Integer id);

    void updateMovie(Movie movie);

    void deleteImg(String path);

    String getName(Integer id);

    Movie findById(Integer id);
}
