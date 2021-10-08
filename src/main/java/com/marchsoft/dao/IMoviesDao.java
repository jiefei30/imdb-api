package com.marchsoft.dao;

import com.marchsoft.domain.Movie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
/**
 *  电影的持久层接口
 */
public interface IMoviesDao {
    /**
     * 查询所有电影
     * @return
     */
    @Select("select * from movies ORDER BY rating DESC")
    @Results(id="movieMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "date",property = "date"),
            @Result(column = "country",property = "country"),
            @Result(column = "motto",property = "motto"),
            @Result(column = "rating",property = "rating"),
            @Result(property = "genres",column = "id",
            many = @Many(select = "com.marchsoft.dao.IGenreDao.findByMovieId",
                    fetchType = FetchType.LAZY))
    })
    List<Movie> findAll();

    /**
     * 根据电影id查询电影
     * @param id
     * @return
     */
    @Select("Select * from movies where id = #{id}")
    @ResultMap(value = {"movieMap"})
    Movie findById(Integer id);

    /**
     * 根据电影名称模糊查询电影
     * @param name
     * @return
     */
    @Select("Select * from movies where name LIKE CONCAT('%',#{0},'%')")
    @ResultMap(value = {"movieMap"})
    List<Movie> findByNameFuzzy(String name);

    @Select("Select id from movies where name = #{name}")
    int getId(String name);

    @Select("SELECT name FROM movies WHERE id = #{id}")
    String getName(Integer id);

    /**
     * 更新电影信息
     * @param movie
     */
    @Update("UPDATE movies set name  = #{name},date = #{date},rating = #{rating}," +
            "country = #{country},motto = #{motto} ")
    void updateMovie(Movie movie);

    /**
     * 删除电影
     * @param id
     */
    @Delete("DELETE FROM movies where id = #{id}")
    void deleteMovie(Integer id);

    @Insert("INSERT INTO movies(name,date,rating,country,motto) VALUES" +
            "(#{name},#{date},#{rating},#{country},#{motto})")
    void addMovie(Movie movie);
}
