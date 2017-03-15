package com.vertical.mm.service.content;

import java.util.List;

import com.vertical.mm.common.pojo.EUTreeNode;
import com.vertical.mm.common.pojo.MMResult;

public interface ContentCategoryService {
	List<EUTreeNode> getCategoryList(long parentId);
	MMResult insertContentCategory(long parentId, String name);

}
