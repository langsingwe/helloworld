package ch05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className RootConfig
 * @date 2021.04.15
 */
@Configuration
@ComponentScan(basePackages = {"ch05"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
