package com.vertical.mm.service.item.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.mapper.TItemParamMapper;
import com.vertical.mm.pojo.TItemParam;
import com.vertical.mm.pojo.TItemParamExample;
import com.vertical.mm.pojo.TItemParamExample.Criteria;
import com.vertical.mm.service.item.ItemParamService;

/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamServiceImpl</p>
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TItemParamMapper itemParamMapper;
	
	@Override
	public MMResult getItemParamByCid(long cid) {
		TItemParamExample example = new TItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return MMResult.ok(list.get(0));
		}
		
		return MMResult.ok();
	}

	@Override
	public MMResult insertItemParam(TItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return MMResult.ok();
	}
	
	@Override
	public EUDataGridResult getItemParamList(Integer page, Integer rows) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		//查询规格列表
		List<TItemParam> list = itemParamMapper.selectByExampleWithBLOBs(new TItemParamExample());
		//取分页信息
		PageInfo<TItemParam> pageInfo = new PageInfo<>(list);
		//返回结果
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
