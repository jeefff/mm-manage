package com.vertical.mm.service.content.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vertical.mm.common.pojo.EUTreeNode;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.mapper.TContentCategoryMapper;
import com.vertical.mm.pojo.TContentCategory;
import com.vertical.mm.pojo.TContentCategoryExample;
import com.vertical.mm.pojo.TContentCategoryExample.Criteria;
import com.vertical.mm.service.content.ContentCategoryService;

/**
 * 内容分类管理
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		//根据parentid查询节点列表
		TContentCategoryExample example = new TContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}
	@Override
	public MMResult insertContentCategory(long parentId, String name) {
		
		//创建一个pojo
		TContentCategory contentCategory = new TContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return MMResult.ok(contentCategory);
	}
	
}
