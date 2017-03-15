package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TOrderItem;
import com.vertical.mm.pojo.TOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderItemMapper {
    int countByExample(TOrderItemExample example);

    int deleteByExample(TOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    List<TOrderItem> selectByExample(TOrderItemExample example);

    TOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByExample(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}