package com.vertical.mm.service.item.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.common.utils.IDUtils;
import com.vertical.mm.mapper.TItemDescMapper;
import com.vertical.mm.mapper.TItemMapper;
import com.vertical.mm.mapper.TItemParamItemMapper;
import com.vertical.mm.pojo.TItem;
import com.vertical.mm.pojo.TItemDesc;
import com.vertical.mm.pojo.TItemExample;
import com.vertical.mm.pojo.TItemExample.Criteria;
import com.vertical.mm.pojo.TItemParamItem;
import com.vertical.mm.service.item.ItemService;

/**
 * 这个是一个商品管理的service
 * 是业务服务组件
 * @author Administrator
 *
 */
@Service//表示是一个服务
public class ItemServiceImpl implements ItemService{

	@Autowired//自动注入TItemMapper接口的实现类
	private TItemMapper itemMapper;
	
	@Autowired//该接口是对商品描述信息的映射实现
	private TItemDescMapper itemDescMapper;
	
	@Autowired//该接口是对商品参数信息的映射实现
	private TItemParamItemMapper itemParamItemMapper;

	@Override
	public TItem getItemById(long itemId) {
		//根据主键直接查找,是检索效率最高的查询
		TItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
		//构造查询条件
//		TItemExample example = new TItemExample();
//		Criteria itemCriteria = example.createCriteria();
//		itemCriteria.andIdEqualTo(itemId);
//		
//		List<TItem> list = itemMapper.selectByExample(example);
//		
//		if (list != null && list.size() > 0) {
//			return list.get(0);
//		}
//		return null;
	}
	

	/**
	 * 商品列表查询
	 * <p>Title: getItemList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TItemExample example = new TItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MMResult createItem(TItem item, String desc, String itemParam) throws Exception {
		//item补全
		//生成商品ID
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// '商品状态，1-正常，2-下架，3-删除',
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		MMResult result = insertItemDesc(itemId, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		//添加规格参数
		result = insertItemParamItem(itemId, itemParam);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return MMResult.ok();
	}
	/**
	 * 添加商品描述
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param desc
	 */
	private MMResult insertItemDesc(Long itemId, String desc) {
		TItemDesc itemDesc = new TItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return MMResult.ok();
	}
	
	/**
	 * 添加规格参数
	 * <p>Title: insertItemParamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	private MMResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		TItemParamItem itemParamItem = new TItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);
		
		return MMResult.ok();
		
	}
	
}
