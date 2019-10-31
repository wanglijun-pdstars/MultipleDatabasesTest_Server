package com.pdstars.manager.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;

import com.pdstars.common.vo.GeneralResVO;
import com.pdstars.common.vo.GeneralResult;

public interface TestService {

	/**
	 * 获取类型列表
	 * 
	 * @author:Yanfa-0509
	 * @DateTime:2018年2月28日 下午5:48:00
	 * @param logReqVO
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	GeneralResult getTypeList(HttpServletRequest request) throws InstantiationException, IllegalAccessException;
	
	/**
	 * 根据类型名称模糊匹配数据
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:17:11 AM
	 * @param typeName
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	GeneralResVO getTypeListByName(String typeName,HttpServletRequest request) throws InstantiationException, IllegalAccessException;

	/**
	 * 根据typeId获取详情
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:32:14 AM
	 * @param typeId
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	GeneralResVO getDetailByTypdId(Long typeId,HttpServletRequest request) throws InstantiationException, IllegalAccessException;
	
	/**
	 * 获取前n条数据
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:48:29 AM
	 * @param n
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	GeneralResVO getTopN(Integer n,HttpServletRequest request) throws InstantiationException, IllegalAccessException;
	
	/**
	 * 获取type统计
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 5:29:20 PM
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	GeneralResVO getTypeStatistics(HttpServletRequest request) throws InstantiationException, IllegalAccessException;
}
