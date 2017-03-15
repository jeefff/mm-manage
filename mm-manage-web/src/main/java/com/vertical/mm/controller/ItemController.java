package com.vertical.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.pojo.TItem;
import com.vertical.mm.service.item.ItemService;

/**
 * 商品管理的Controller
 * @author Administrator
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/*@RequestMapping("/item/{itemId}") 该方法响应的请求路径格式要满足/item/
	 * {itemId}表示第二个/后面跟的是一个参数,参数内容可以过获得request中的itemId得到
	 * @ResponseBody 表示这个方法执行的结果不需要路径跳转而是直接以输出流的形式返回
	 * 并且输出流的格式是json...spring容器会调用实现了相关convert接口的
	 * jackson-databind包里的类来处理返回的对象,并将对象转换为json格式的数据
	 * @PathVariable  表示请求该方法需要传入一个参数itemId
	 * 如果传入的参数名不是itemId。那么可以通过配置可以进行修改
	 * 例如:@PathVariable(name="id",value="0")表示传入的参数名叫id
	 * 这个时候，spring容器会取出参数id的值赋给形参itemId
	 * value="0"表示如果没有传入参数,默认赋值0
	 */
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TItem getItemById(@PathVariable Long itemId){
		TItem item = itemService.getItemById(itemId);
		return item;
	}
	
	/**
	 * 商品列表查询
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	/**
	 * 商品新增、修改等
	 * @param item
	 * @param desc
	 * @param itemParams
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private MMResult createItem(TItem item, String desc, String itemParams) throws Exception {
		MMResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
 
}
