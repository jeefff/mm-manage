package com.vertical.mm.service.item.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vertical.mm.common.pojo.EUTreeNode;
import com.vertical.mm.mapper.TItemCatMapper;
import com.vertical.mm.pojo.TItemCat;
import com.vertical.mm.pojo.TItemCatExample;
import com.vertical.mm.pojo.TItemCatExample.Criteria;
import com.vertical.mm.service.item.ItemCatService;

/**
 * 商品分类管理服务接口实现类
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TItemCatMapper itemCatMapper;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		
		//创建查询条件
		TItemCatExample example = new TItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//根据条件查询
		List<TItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodelist
		for (TItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		//返回结果
		return resultList;
	}

}
