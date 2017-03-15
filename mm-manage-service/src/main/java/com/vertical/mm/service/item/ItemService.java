package com.vertical.mm.service.item;
import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.pojo.TItem;

/**
 * 商品的基础信息管理服务接口
 * @author Administrator
 *
 */
public interface ItemService {
	TItem getItemById(long itemId);
	/*
	 * EUDataGridResult 是返回给前端的显示在EasyUi空间dataGrid中的数据的一个封装
	 * 位于common-pojo中参数是分页
	 */
	EUDataGridResult getItemList(int page, int rows);
	/*
	 * MMResult 是对返回的结果的一个封装
	 * 相当于txl中写的JsonObject.put("success",true)
	 * 这里直接用一个结果输出对象来进行封装
	 */
	MMResult createItem(TItem item, String desc, String itemParam) throws Exception;
}
