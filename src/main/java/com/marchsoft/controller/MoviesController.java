package com.marchsoft.controller;

import com.marchsoft.config.ParamConfig;
import com.marchsoft.dao.IMoviesDao;
import com.marchsoft.domain.Genre;
import com.marchsoft.domain.Movie;
import com.marchsoft.service.IGenreService;
import com.marchsoft.service.IMgService;
import com.marchsoft.service.IMoviesService;
import com.marchsoft.service.impl.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private IMoviesService iMoviesService;

    @Autowired
    private IGenreService iGenreService;

    @Autowired
    private IMgService iMgService;

    @Autowired
    private ParamConfig paramConfig;

    @RequestMapping("/findAll")
    public @ResponseBody List<Movie> findAll(){
        return iMoviesService.findAll();
    }

    @RequestMapping("/findAllGenre")
    public @ResponseBody List<Genre> findAllGenre(){
        return iGenreService.findAll();
    }

    @RequestMapping("/findById")
    public @ResponseBody Movie findById(HttpServletRequest request){
        System.out.println(1);
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(2);
            Movie movie = iMoviesService.findById(id);
            System.out.println(3);
            return movie;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("deleteMovie")
    public @ResponseBody Boolean deleteMovie(HttpServletRequest request){
            int id = Integer.parseInt(request.getParameter("id"));
            iMoviesService.deleteMovie(id);
            return true;
    }

    @RequestMapping("updateMovie")
    public @ResponseBody Boolean updateMovie(HttpServletRequest request){
        Movie movie = iMoviesService.makeMovie(request);
        iMoviesService.updateMovie(movie);
        return true;
    }

    @RequestMapping("fileupload")
    public @ResponseBody Boolean fileupload(HttpServletRequest request,@RequestParam("file") MultipartFile upload){

        Movie movie = iMoviesService.makeMovie(request);
        System.out.println(movie);
        try{
            iMoviesService.addMovie(movie);
        }catch (Exception e){
            return false;
        }
        try {
        String path = paramConfig.getImgPath();
        File file = new File(path);
        if(!file.exists())file.mkdirs();
        String origin = upload.getOriginalFilename();
        String filename = movie.getName().replaceAll(" ", "")+"."+origin.substring(origin.length()-3);
        System.out.println(filename);

            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            iMoviesService.deleteMovie(movie.getId());
            iMgService.deleteByMovieId(movie.getId());
        }
        return true;
    }

}
