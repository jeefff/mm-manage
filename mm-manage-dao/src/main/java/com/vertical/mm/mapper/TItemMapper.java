package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TItem;
import com.vertical.mm.pojo.TItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemMapper {
    int countByExample(TItemExample example);

    int deleteByExample(TItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TItem record);

    int insertSelective(TItem record);

    List<TItem> selectByExample(TItemExample example);

    TItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TItem record, @Param("example") TItemExample example);

    int updateByExample(@Param("record") TItem record, @Param("example") TItemExample example);

    int updateByPrimaryKeySelective(TItem record);

    int updateByPrimaryKey(TItem record);
}