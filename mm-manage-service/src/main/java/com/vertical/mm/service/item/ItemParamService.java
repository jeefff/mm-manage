package com.vertical.mm.service.item;

import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.pojo.TItemParam;

public interface ItemParamService {
	MMResult getItemParamByCid(long cid);
	MMResult insertItemParam(TItemParam itemParam);
	public EUDataGridResult getItemParamList(Integer page, Integer rows) throws Exception ;
}
