package com.pdstars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类.
 * 
 * @ClassName: BootApplication
 * @Description: 用于启动项目
 * @author yujunnan
 * @date 2017年4月30日 下午3:13:37
 *
 */
@SpringBootApplication (scanBasePackages = {"com.pdstars"})
// 配置扫描包
@MapperScan(basePackages = {"com.pdstars.dal"})
public class BootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootApplication.class);
	}

}
