package com.marchsoft.test;

import com.marchsoft.dao.IMoviesDao;
import com.marchsoft.domain.Genre;
import com.marchsoft.domain.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

    @Autowired
    private IMoviesDao iMoviesDao;

    @Test
    public void test1(){
        List<Movie> movies = iMoviesDao.findAll();
        for(Movie m : movies){
            System.out.println(m);
            for(Genre g :m.getGenres()){
                System.out.println(g);
            }
        }
    }

    @Test
    public void test2(){
        Movie movie = iMoviesDao.findById(2);
        System.out.println(movie);
        for(Genre g :movie.getGenres()){
            System.out.println(g);
        }
    }

    @Test
    public void test3(){
        List<Movie> movies = iMoviesDao.findByNameFuzzy("教");
        for(Movie m : movies){
            System.out.println(m);
            for(Genre g :m.getGenres()){
                System.out.println(g);
            }
        }
    }
}
