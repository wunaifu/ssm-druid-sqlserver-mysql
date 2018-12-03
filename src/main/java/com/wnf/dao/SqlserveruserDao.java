package com.wnf.dao;

import com.wnf.entity.Sqlserveruser;
import com.wnf.entity.SqlserveruserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlserveruserDao {
    int countByExample(SqlserveruserExample example);

    int deleteByExample(SqlserveruserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sqlserveruser record);

    int insertSelective(Sqlserveruser record);

    List<Sqlserveruser> selectByExample(SqlserveruserExample example);

    Sqlserveruser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sqlserveruser record, @Param("example") SqlserveruserExample example);

    int updateByExample(@Param("record") Sqlserveruser record, @Param("example") SqlserveruserExample example);

    int updateByPrimaryKeySelective(Sqlserveruser record);

    int updateByPrimaryKey(Sqlserveruser record);
}