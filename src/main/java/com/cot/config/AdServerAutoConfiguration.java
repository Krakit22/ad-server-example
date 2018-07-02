package com.cot.config;

import com.cot.properties.AppProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "com.cot")
@EnableConfigurationProperties(AppProperties.class)
@EntityScan(basePackages = "com.cot.domain")
@EnableJpaRepositories(basePackages = "com.cot.repository")
@EnableScheduling
public class AdServerAutoConfiguration {

}
