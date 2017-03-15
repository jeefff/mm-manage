package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TOrderShipping;
import com.vertical.mm.pojo.TOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderShippingMapper {
    int countByExample(TOrderShippingExample example);

    int deleteByExample(TOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TOrderShipping record);

    int insertSelective(TOrderShipping record);

    List<TOrderShipping> selectByExample(TOrderShippingExample example);

    TOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TOrderShipping record, @Param("example") TOrderShippingExample example);

    int updateByExample(@Param("record") TOrderShipping record, @Param("example") TOrderShippingExample example);

    int updateByPrimaryKeySelective(TOrderShipping record);

    int updateByPrimaryKey(TOrderShipping record);
}