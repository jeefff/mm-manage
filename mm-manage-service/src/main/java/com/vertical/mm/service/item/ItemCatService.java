package com.vertical.mm.service.item;

import java.util.List;

import com.vertical.mm.common.pojo.EUTreeNode;
/**
 * 商品类目管理服务接口
 * 商品都需要由所分类
 * @author Administrator
 *
 */
public interface ItemCatService {
	/*
	 * 该接口返回的结果在前端展示效果为树形结构
	 * EUTreeNode是对EasyUI树形结构json数据格式的一个封装
	 * 位于common-pojo
	 */
	List<EUTreeNode> getCatList(long parentId);
}
