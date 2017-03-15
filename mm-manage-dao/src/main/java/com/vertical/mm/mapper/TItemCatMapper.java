package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TItemCat;
import com.vertical.mm.pojo.TItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemCatMapper {
    int countByExample(TItemCatExample example);

    int deleteByExample(TItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TItemCat record);

    int insertSelective(TItemCat record);

    List<TItemCat> selectByExample(TItemCatExample example);

    TItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TItemCat record, @Param("example") TItemCatExample example);

    int updateByExample(@Param("record") TItemCat record, @Param("example") TItemCatExample example);

    int updateByPrimaryKeySelective(TItemCat record);

    int updateByPrimaryKey(TItemCat record);
}