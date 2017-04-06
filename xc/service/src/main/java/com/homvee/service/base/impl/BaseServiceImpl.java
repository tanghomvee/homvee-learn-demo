package com.homvee.service.base.impl;

import com.homvee.dao.base.BaseDao;
import com.homvee.dao.domain.common.Page;
import com.homvee.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T,KEY extends Serializable> implements BaseService<T, KEY> {
	protected   Logger LOGGER = null;
	public BaseServiceImpl(){
		LOGGER = LoggerFactory.getLogger(this.getClass());
	}
	@Transactional(rollbackFor = Exception.class,propagation=Propagation.REQUIRES_NEW)
	public int saveEntry(T... ts) {
		if(ts == null || ts.length < 1){
			return -1;
		}
		int rs = 0;
		for (T t : ts){
			rs = rs + getBaseDao().saveEntry(t);
		}
		return rs;
	}
	@Transactional(rollbackFor = Exception.class)
	public int deleteByKey(KEY... keys) {
		return getBaseDao().deleteByKey(keys);
	}

	public int deleteByCondition(T condtion) {
		return getBaseDao().deleteByCondition(condtion);
	}

	public int modifyByKey(T t) {
		return getBaseDao().modifyByKey(t);
	}

	public T queryEntryByKey(KEY key) {
		@SuppressWarnings("unchecked")
		List<T> list = this.queryEntryListByKeys(key);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public List<T> queryEntryListByKeys(KEY... keys) {
		return getBaseDao().queryEntryListByKey(keys);
	}

	public List<T> queryEntryListByCondition(T condtion) {
		return getBaseDao().queryEntryListByCondition(condtion);
	}

	public Integer queryEntryListCntByCondition(T condtion) {
		return getBaseDao().queryEntryListCntByCondition(condtion);
	}

	public int logicDelByKey(KEY... keys) {
		return getBaseDao().logicDelByKey(keys);
	}

	public int logicDelByCondition(T condtion) {
		return getBaseDao().logicDelByCondition(condtion);
	}

	public Page<T> queryPageByCondition(T condition, Page<T> page) throws Exception {
		try {
			Class<?> clz = condition.getClass();
			clz.getMethod("setStartIndex", Integer.class).invoke(condition, page.getStartIndex());
			clz.getMethod("setEndIndex", Integer.class).invoke(condition, page.getEndIndex());
		} catch (Exception e) {
			throw new Exception("设置分页参数失败", e);
		}
		Integer size = this.queryEntryListCntByCondition(condition);
		if(size == null || size <= 0) {
			return page;
		}
		page.setTotalCount(size);
		page.setResult(this.queryEntryListByCondition(condition));
		return page;
	}

	public abstract BaseDao<T, KEY> getBaseDao();
}
