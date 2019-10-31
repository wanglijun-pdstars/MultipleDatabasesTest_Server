/**
 * 
 */
package com.pdstars.config;

import java.nio.charset.Charset;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * 其他配置.
 * 
 * @ClassName: OtherConfig
 * @Description: 其他配置
 * @author yujunnan
 * @date 2017年4月30日 下午4:02:09
 *
 */
@SpringBootConfiguration
public class OtherConfig {

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

}
