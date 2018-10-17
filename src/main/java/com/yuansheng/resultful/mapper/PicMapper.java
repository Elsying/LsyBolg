package com.yuansheng.resultful.mapper;

import com.yuansheng.resultful.domain.Pic;
import com.yuansheng.resultful.domain.PicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PicMapper {
    long countByExample(PicExample example);

    int deleteByExample(PicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pic record);

    int insertSelective(Pic record);

    List<Pic> selectByExample(PicExample example);

    Pic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pic record, @Param("example") PicExample example);

    int updateByExample(@Param("record") Pic record, @Param("example") PicExample example);

    int updateByPrimaryKeySelective(Pic record);

    int updateByPrimaryKey(Pic record);
}