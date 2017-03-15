package com.vertical.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vertical.mm.common.pojo.EUTreeNode;
import com.vertical.mm.service.item.ItemCatService;

/**
 * 商品分类管理controller
 * Item Category
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	//该方法需要传入父节点的id
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}
}
