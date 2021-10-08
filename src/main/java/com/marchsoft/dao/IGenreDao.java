package com.marchsoft.dao;

import com.marchsoft.domain.Genre;
import com.marchsoft.domain.Movie;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  类别的持久层接口
 */
public interface IGenreDao {

    /**
     * 查询所有类别
     */
    @Select("select * from genre")
    List<Genre> findAll();

    /**
     * 根据类别id查询类别
     * @param id
     * @return
     */
    @Select("select * from genre where id = #{id}")
    Genre findById(Integer id);

    /**
     * 根据电影id查询类别
     * @param id
     * @return
     */
    @Select("select * from genre g where g.id in " +
            "(select gid from mg where mid = #{id}) ")
    List<Genre> findByMovieId(Integer id);

    /**
     * 获取类别的总个数
     * @return
     */
    @Select("select count(*) from genre")
    Integer findTotal();


}
