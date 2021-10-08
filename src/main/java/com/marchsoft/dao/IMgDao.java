package com.marchsoft.dao;

import com.marchsoft.domain.Mg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface IMgDao {

    @Insert("Insert into mg(mid,gid) values(#{mid},#{gid})")
    void addMg(Mg mg);

    @Delete("Delete From mg Where id = #{id}")
    void deleteById(int id);

    @Delete("Delete From mg Where mid = #{mid}")
    void deleteByMovieId(int mid);
}
