package com.pdstars.manager.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pdstars.common.vo.GeneralResVO;
import com.pdstars.common.vo.GeneralResult;
import com.pdstars.dal.daointerface.DetailMapper;
import com.pdstars.dal.daointerface.TypeMapper;
import com.pdstars.dal.dataobject.Detail;
import com.pdstars.dal.dataobject.Type;
import com.pdstars.dal.dataobject.TypeStatistics;

@Service
public class TestServiceImpl implements TestService {
	protected static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
	private TypeMapper typeMapper;

	@Autowired
	private DetailMapper detailMapper;

	@Override
	public GeneralResult getTypeList(HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		GeneralResult generalReslt = new GeneralResult();
		Integer page = 1;
		Integer limit = 10;
		PageHelper.startPage(page, limit);
		List<Type> typeList = typeMapper.selectAll();
		generalReslt.setList(typeList);
		return generalReslt;
	}

	@Override
	public GeneralResVO getTypeListByName(String typeName, HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<Type> typeList = typeMapper.selectByTypeName(typeName);
		return GeneralResVO.returnSuccessResult(typeList);
	}

	@Override
	public GeneralResVO getDetailByTypdId(Long typeId, HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<Detail> detailList = detailMapper.selectByTypeId(typeId);
		return GeneralResVO.returnSuccessResult(detailList);
	}

	@Override
	public GeneralResVO getTopN(Integer n, HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<Detail> detailList = detailMapper.selectTopN(n);
		return GeneralResVO.returnSuccessResult(detailList);
	}

	@Override
	public GeneralResVO getTypeStatistics(HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<TypeStatistics> typeStatisticList = typeMapper.selectGroupBy();
		return GeneralResVO.returnSuccessResult(typeStatisticList);
	}

}
