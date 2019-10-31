package com.pdstars.web.controller.test;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdstars.common.enums.SystemCodeEnum;
import com.pdstars.common.vo.GeneralResVO;
import com.pdstars.common.vo.GeneralResult;
import com.pdstars.manager.test.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "测试接口", tags = { "测试接口" })
@RestController
public class TestController {

	protected static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService testService;

	/**
	 * 分页测试接口
	 * 
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 9:58:42 AM
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/pagehelperTest", method = RequestMethod.POST)
	@ApiOperation(value = "分页测试《问题1》", notes = "用于测试分页时不使用order by的异常")
	public @ResponseBody GeneralResVO<Object> pagehelperTest(HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		GeneralResult dataList = testService.getTypeList(request);
		if (dataList == null) {
			GeneralResVO errorResult = GeneralResVO.returnErrorResult(SystemCodeEnum.SYSTEM_ERROR, null);
			return errorResult;
		}
		GeneralResVO result = GeneralResVO.returnSuccessResult(dataList);
		return result;
	}

	/**
	 * 连接字符串测试接口
	 * 
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:29:05 AM
	 * @param typeName
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/connectStringTest", method = RequestMethod.POST)
	@ApiOperation(value = "连接字符串测试《问题2》", notes = "用于测试连接字串")
	public @ResponseBody GeneralResVO<Object> connectStringTest(@RequestParam String typeName,
			HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		return testService.getTypeListByName(typeName, request);
	}

	/**
	 * 子查询测试接口
	 * 
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:30:17 AM
	 * @param typeName
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/subQueryTest", method = RequestMethod.POST)
	@ApiOperation(value = "子查询测试《问题3》", notes = "用于测试子查询")
	public @ResponseBody GeneralResVO<Object> subQueryTest(@RequestParam Long typeId, HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		return testService.getDetailByTypdId(typeId, request);
	}

	/**
	 * 获取前N条数据测试接口
	 * 
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 10:50:35 AM
	 * @param n
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/topFewTest", method = RequestMethod.POST)
	@ApiOperation(value = "前几条数据测试《问题4》", notes = "用于测试获取前几条")
	public @ResponseBody GeneralResVO<Object> topFewTest(@RequestParam Integer n, HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		return testService.getTopN(n, request);
	}

	/**
	 * 用于测试groupBy接口
	 * 
	 * @author:Yanfa-0509
	 * @date:Oct 24, 2019 5:28:36 PM
	 * @param n
	 * @param request
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/dateformatTest", method = RequestMethod.POST)
	@ApiOperation(value = "日期格式化测试《问题5》", notes = "用于测试日期格式化")
	public @ResponseBody GeneralResVO<Object> dateformatTest(HttpServletRequest request)
			throws InstantiationException, IllegalAccessException {
		return testService.getTypeStatistics(request);
	}

}
