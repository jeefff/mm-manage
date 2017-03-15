package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TItemParamItem;
import com.vertical.mm.pojo.TItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemParamItemMapper {
    int countByExample(TItemParamItemExample example);

    int deleteByExample(TItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TItemParamItem record);

    int insertSelective(TItemParamItem record);

    List<TItemParamItem> selectByExampleWithBLOBs(TItemParamItemExample example);

    List<TItemParamItem> selectByExample(TItemParamItemExample example);

    TItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TItemParamItem record, @Param("example") TItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") TItemParamItem record, @Param("example") TItemParamItemExample example);

    int updateByExample(@Param("record") TItemParamItem record, @Param("example") TItemParamItemExample example);

    int updateByPrimaryKeySelective(TItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TItemParamItem record);

    int updateByPrimaryKey(TItemParamItem record);
}