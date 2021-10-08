package com.marchsoft.service.impl;

import com.marchsoft.config.ParamConfig;
import com.marchsoft.dao.IMgDao;
import com.marchsoft.dao.IMoviesDao;
import com.marchsoft.domain.Genre;
import com.marchsoft.domain.Mg;
import com.marchsoft.domain.Movie;
import com.marchsoft.service.IMgService;
import com.marchsoft.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private IMoviesDao iMoviesDao;

    @Autowired
    private IMgDao iMgDao;

    @Autowired
    private ParamConfig  paramConfig;

    @Override
    public List<Movie> findAll() {
        List<Movie> moives = iMoviesDao.findAll();
        return moives;

    }

    @Override
    public Movie findById(Integer id) {
        return iMoviesDao.findById(id);
    }

    @Override
    public void updateMovie(Movie movie) {

        try{
            iMoviesDao.updateMovie(movie);
            int mid = iMoviesDao.getId(movie.getName());
            iMgDao.deleteByMovieId(mid);
            for(Genre g : movie.getGenres()){
                Mg mg = new Mg(mid,g.getId());
                iMgDao.addMg(mg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String getName(Integer id) {
        return iMoviesDao.getName(id);
    }

    @Override
    public void deleteMovie(Integer id) {
        try{
            String name = getName(id).replaceAll(" ","");
            String path = paramConfig.getImgPath() +name+".jpg";
            iMoviesDao.deleteMovie(id);
            iMgDao.deleteByMovieId(id);
            deleteImg(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addMovie(Movie movie) {
        try {
            iMoviesDao.addMovie(movie);
            int mid = iMoviesDao.getId(movie.getName());
            for(Genre g : movie.getGenres()){
                Mg mg = new Mg(mid,g.getId());
                iMgDao.addMg(mg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteImg(String path) {
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    public Movie makeMovie(HttpServletRequest request){
        Movie movie = new Movie();
        movie.setName(request.getParameter("name"));
        movie.setDate(Long.parseLong(request.getParameter("date")));
        movie.setCountry(request.getParameter("country"));
        movie.setMotto(request.getParameter("motto"));
        movie.setRating(Float.parseFloat(request.getParameter("rating")));
        String genre  = request.getParameter("genres");

        String[] s = genre.split(" ");
        List<Genre> genres = new ArrayList<Genre>() ;

        for(String a : s){
            Genre g = new Genre();
            g.setId(Integer.parseInt(a));
            genres.add(g);
        }

        movie.setGenres(genres);
        return movie;
    }


}
