package com.rapid.core.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.rapid.core.base.mybatis.dao.BaseDAO;
import com.rapid.core.base.mybatis.model.BaseModel;
import com.rapid.core.exception.BaseException;
import com.rapid.core.utils.BeanUtil;

@SuppressWarnings("rawtypes")
public class BaseServiceImpl<T extends BaseModel, ID extends Serializable> implements BaseService<T, ID> {
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired(required=true)
	private BaseDAO<T, ID> baseDAO;

	public long selectCount() {
		try {
			return baseDAO.selectCount();
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public long selectCount(Map params) {
		try {
			return baseDAO.selectCount(params);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public long selectCount(T model) {
		try {
			return baseDAO.selectCount(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectCount]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select() {
		try {
			return baseDAO.select();
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select(Map params) {
		try {
			return baseDAO.select(params);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}

	public List<T> select(T model) {
		try {
			return baseDAO.select(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.select]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(PageBounds pageBounds) {
		try {
			return baseDAO.select(null, pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(Map params, PageBounds pageBounds) {
		try {
			return baseDAO.select(params, pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}
	
	public PageList<T> selectPage(T model, PageBounds pageBounds) {
		try {
			return baseDAO.select(BeanUtil.beanToMap(model), pageBounds);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectPage]错误：%s", e.getMessage()), e);
		}
	}

	public T selectById(ID id) {
		try {
			return baseDAO.selectById(id);
		} catch (Exception e) {
			throw new BaseException(String.format("查询[BaseService.selectById]错误：%s", e.getMessage()), e);
		}
	}

	public int delete() {
		try {
			return baseDAO.delete();
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int delete(Map params) {
		try {
			return baseDAO.delete(params);
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int delete(T model) {
		try {
			return baseDAO.delete(BeanUtil.beanToMap(model));
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.delete]错误：%s", e.getMessage()), e);
		}
	}

	public int deleteById(ID id) {
		try {
			return baseDAO.deleteById(id);
		} catch (Exception e) {
			throw new BaseException(String.format("删除[BaseService.deleteById]错误：%s", e.getMessage()), e);
		}
	}
	
	public int insertSelective(T model) {
		try {
			return baseDAO.insertSelective(model);
		} catch (Exception e) {
			throw new BaseException(String.format("新增[BaseService.insertSelective]错误：%s", e.getMessage()), e);
		}
	}

	public int insert(T model) {
		try {
			return baseDAO.insert(model);
		} catch (Exception e) {
			throw new BaseException(String.format("新增[BaseService.insert]错误：%s", e.getMessage()), e);
		}
	}

	public int updateByIdSelective(T model) {
		try {
			return baseDAO.updateByIdSelective(model);
		} catch (Exception e) {
			throw new BaseException(String.format("修改[BaseService.updateByIdSelective]错误：%s", e.getMessage()), e);
		}
	}
    
	public int updateById(T model) {
		try {
			return baseDAO.updateById(model);
		} catch (Exception e) {
			throw new BaseException(String.format("修改[BaseService.updateById]错误：%s", e.getMessage()), e);
		}
	}
	
	
}
