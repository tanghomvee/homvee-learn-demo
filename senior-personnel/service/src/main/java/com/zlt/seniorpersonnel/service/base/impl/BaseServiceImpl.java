package com.zlt.seniorpersonnel.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zlt.seniorpersonnel.dao.base.BaseDao;
import com.zlt.seniorpersonnel.service.base.BaseService;

public abstract class BaseServiceImpl<T,KEY extends Serializable> implements BaseService<T, KEY> {
	protected   Logger LOGGER = null;
	public BaseServiceImpl(){
		LOGGER = LoggerFactory.getLogger(this.getClass());
	}
	@Transactional(rollbackFor = Exception.class,propagation=Propagation.REQUIRES_NEW)
	public int saveEntry(T... t) {
		return getBaseDao().saveEntry(t);
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
		if(list != null ){
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

	public abstract BaseDao<T, KEY> getBaseDao();
}
