package com.vertical.mm.mapper;

import com.vertical.mm.pojo.TItemParam;
import com.vertical.mm.pojo.TItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemParamMapper {
    int countByExample(TItemParamExample example);

    int deleteByExample(TItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TItemParam record);

    int insertSelective(TItemParam record);

    List<TItemParam> selectByExampleWithBLOBs(TItemParamExample example);

    List<TItemParam> selectByExample(TItemParamExample example);

    TItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TItemParam record, @Param("example") TItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") TItemParam record, @Param("example") TItemParamExample example);

    int updateByExample(@Param("record") TItemParam record, @Param("example") TItemParamExample example);

    int updateByPrimaryKeySelective(TItemParam record);

    int updateByPrimaryKeyWithBLOBs(TItemParam record);

    int updateByPrimaryKey(TItemParam record);
}