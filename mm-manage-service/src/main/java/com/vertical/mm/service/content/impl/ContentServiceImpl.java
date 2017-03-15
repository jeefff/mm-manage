package com.vertical.mm.service.content.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vertical.mm.common.pojo.EUDataGridResult;
import com.vertical.mm.common.pojo.MMResult;
import com.vertical.mm.common.utils.HttpClientUtil;
import com.vertical.mm.mapper.TContentMapper;
import com.vertical.mm.pojo.TContent;
import com.vertical.mm.pojo.TContentExample;
import com.vertical.mm.pojo.TContentExample.Criteria;
import com.vertical.mm.service.content.ContentService;
@Service
public class ContentServiceImpl implements ContentService{
	Log log = LogFactory.getLog(ContentServiceImpl.class);
	@Autowired
	private TContentMapper contentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	
	@Override
	public TContent getContentById(long contentId) {
		//根据主键直接查找,是检索效率最高的查询
		TContent content = contentMapper.selectByPrimaryKey(contentId);
				return content;
	}

	@Override
	public EUDataGridResult getContentList(int page, int rows,long categoryId) {
		//查询内容列表
		TContentExample example = new TContentExample();
		
		if (categoryId>0) {
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(categoryId);
		}
		//分页处理
		PageHelper.startPage(page, rows);
		List<TContent> list = contentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MMResult createContent(TContent content) throws Exception {
		//创建一个pojo
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		
		//因为执行了新增的业务,因此需要同步mm-rest中的redis缓存
		//缓存同步逻辑
		try {
			log.info("执行redis缓存同步"+REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
			HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果
		return MMResult.ok(content);
	}

}
