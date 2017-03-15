package com.vertical.mm.service.content;

import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.pojo.TContent;

public interface ContentService {

	TContent getContentById(long contentId);
	EUDataGridResult getContentList(int page, int rows,long categoryId);
	MMResult createContent(TContent content) throws Exception;
}
